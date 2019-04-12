package com.weshare.phoenix.activiti.process;


import com.weshare.phoenix.properties.WeShareProcessProperties;
import com.weshare.phoenix.util.EmptyUtils;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
     * @param
     * @return
     */
    public void initProcess(String fileName) {
        boolean flag = this.isDeployProcessCode(fileName);
        if (flag){
           //String resourcesPath="processcfg/bpmn/"+fileName+".bpmn";
            String resourcesPath=weShareProcessProperties.toString();
            log.info("流程开始部署,文件路径[{}]",resourcesPath);
            processCfgService.getRepositoryService().createDeployment()
                    .addClasspathResource(resourcesPath).deploy();
        }
    }

    /**
     * 校验是否部署流程图
     *
     * @return
     */
    public boolean isDeployProcessCode(String ProcessCode) {
        List<ProcessDefinition> processDefinitions = getProcessDefinitions();
        if (EmptyUtils.isEmpty(processDefinitions)) {
            return true;
        }
        for (ProcessDefinition processDefinition : processDefinitions) {
            if (ProcessCode.equals(processDefinition.getKey())){
                log.info("[{}]流程部署重复",processDefinition.getKey());
                return false;
            }
        }

        return true;
    }

    /**
     * 删除流程图
     * @param deploymentId
     * @return
     */
    public void deleteProcess(String deploymentId,boolean flag) {
        processCfgService.
                getRepositoryService().deleteDeployment(deploymentId,flag);
    }


    /**
     * 获取所有部署流程定义
     *
     * @return
     */
    public List<ProcessDefinition> getProcessDefinitions() {
        return processCfgService.getRepositoryService().createProcessDefinitionQuery().list();
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
                startProcessInstanceByKey(processDefinitionKey,map);

    }


    /**
     * 结束流程
     * @param reason
     */
    public void finishProcessInstance(String processInstanceId,String reason){
        processCfgService.getRuntimeService().deleteProcessInstance(processInstanceId,reason);//删除流程
    }





}
