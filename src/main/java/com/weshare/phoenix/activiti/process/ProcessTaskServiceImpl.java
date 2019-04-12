package com.weshare.phoenix.activiti.process;

import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: MCC
 * @Date: 2019/2/2 11:36
 * @Description:
 */
@Service
public class ProcessTaskServiceImpl {
    @Autowired
    private ProcessCfgServiceImpl processCfgService;
    @Autowired
    private ProcessServiceImpl processService;

    /**
     * 根据用户Id 获取任务列表
     *
     * @param AssigneeId
     * @return
     */
    public List<Task> getTasksByAssigneeId(String AssigneeId) {
        List<Task> tasks = processCfgService.getTaskService().createTaskQuery().
                taskAssignee(AssigneeId).list();
        return tasks;
    }

    /**
     * 根据用户Id 获取历史任务列表
     *
     * @return
     */
    public List<HistoricTaskInstance> getHistoricTasksByAssigneeId(String assigneeId) {
        List<HistoricTaskInstance> list = processCfgService.getHistoryService()//与历史数据（历史表）相关的Service
                .createHistoricTaskInstanceQuery()//创建历史任务实例查询
                .taskAssignee(assigneeId)//指定历史任务的办理人
                .list();
        return list;
    }

    /**
     * 执行任务
     *
     * @param task
     */
    public void executeTask(Task task, Map<String, Object> map) {

        Assert.notNull(task, "执行任务为空");
        String assigneeId = map.get("assigneeId").toString();
        Assert.notNull(assigneeId, "任务归属ID为空");

        processCfgService.getTaskService().claim(task.getId(), assigneeId);
        map.remove("assigneeId");
        Map<String, Object> variables = new HashMap<>();
        variables.putAll(map);
        processCfgService.getTaskService().complete(task.getId(), variables);
    }


    /**
     * 结束流程
     *
     * @param task
     */
    public void finishProcess(Task task, String reason) {
        processService.finishProcessInstance(task.getProcessInstanceId(), reason);
    }

}
