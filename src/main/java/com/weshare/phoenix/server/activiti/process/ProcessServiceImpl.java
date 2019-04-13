package com.weshare.phoenix.server.activiti.process;


import com.weshare.phoenix.properties.WeShareProcessProperties;
import com.weshare.phoenix.server.util.CollectionsUtils;
import com.weshare.phoenix.server.util.EmptyUtils;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author: MCC
 * @Date: 2019/2/1 10:50
 * @Description:
 */
@Service
@Slf4j
public class ProcessServiceImpl {

    @Autowired
    private ProcessCfgServiceImpl processCfgService;

    @Autowired
    private ProcessTaskServiceImpl processTaskServiceImpl;

    @Autowired
    private WeShareProcessProperties weShareProcessProperties;

    /**
     * 部署流程图
     *
     * @param
     * @return
     */
    public void deployFlowChartByFileName(String fileName) {
        boolean flag = this.isAlreadyDeployFlowChart(fileName);
        if (!flag) {
            String resourcesPath = weShareProcessProperties.toString();
            log.info("流程开始部署,文件路径[{}]", resourcesPath);
            processCfgService.getRepositoryService().createDeployment()
                    .addClasspathResource(resourcesPath).deploy();
        }
    }

    public Map<String, ProcessDefinition> processDefinitions;

    /**
     * 获取所有部署流程定义
     * processDefinitions 最好配置在缓存中，方便刷新
     *
     * @return
     */
    private void initProcessDefinitions() {
        if (!EmptyUtils.isEmpty(processDefinitions)) {
            log.debug("process definition already deploy name {}", CollectionsUtils.toSetString(processDefinitions.keySet()));
            return;
        }
        List<ProcessDefinition> processDefinitionList = processCfgService.getRepositoryService()
                .createProcessDefinitionQuery().list();
        log.info("process definition already deploy {} size", processDefinitionList.size());
        if (processDefinitionList.size() > 0) {
            processDefinitions = new HashMap<>();
            for (ProcessDefinition processDefinition : processDefinitionList) {
                processDefinitions.put(processDefinition.getKey(), processDefinition);
            }
        }
    }

    /**
     * 校验是否部署流程图
     *
     * @return
     */
    public boolean isAlreadyDeployFlowChart(String fileName) {
        initProcessDefinitions();
        if (EmptyUtils.isEmpty(processDefinitions) || EmptyUtils.isEmpty(processDefinitions.get(fileName))) {
            return false;
        }
        log.info("[{}]流程部署重复", fileName);
        return true;
    }

    /**
     * 获取最新部署流程定义
     *
     * @return
     */
    public ProcessDefinition getLastProcessDefinitions() {
        List<Deployment> processDefinition =
                processCfgService.getRepositoryService().
                        createDeploymentQuery().orderByDeploymenTime().desc().list();
        Deployment deployment = processDefinition.get(0);
        return getProcessDefinition(deployment.getId());
    }

    /**
     * 获取流程定义
     *
     * @param deploymentId
     * @return
     */
    public ProcessDefinition getProcessDefinition(String deploymentId) {
        ProcessDefinition processDefinition = processCfgService.getRepositoryService()
                .createProcessDefinitionQuery().deploymentId(deploymentId)
                .singleResult();
        return processDefinition;
    }

    /**
     * 创建流程实例
     *
     * @param processDefinitionKey
     * @return
     */
    public void startProcessByProcessName
    (String processDefinitionKey, Map<String, Object> map) {
        //使用流程定义的key启动流程实例，
        ProcessInstance pi = processCfgService.getRuntimeService().
                startProcessInstanceByKey(processDefinitionKey, map);

    }


    /**
     * 结束流程
     *
     * @param reason
     */
    public void finishProcessInstance(String processInstanceId, String reason) {
        //删除流程
        processCfgService.getRuntimeService().deleteProcessInstance(processInstanceId, reason);
    }


    /**
     * 删除流程图
     *
     * @param
     * @return
     */
    public void deleteFlowChart(ProcessDefinition processDefinition, boolean flag) {
        String deploymentId = processDefinition.getDeploymentId();
        log.warn("delete flow chart, name is {}", processDefinition.getKey());
        processCfgService.
                getRepositoryService().deleteDeployment(deploymentId, flag);
    }


}
