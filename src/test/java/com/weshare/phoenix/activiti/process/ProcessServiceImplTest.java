package com.weshare.phoenix.activiti.process;

import com.weshare.phoenix.SpringBootTestEnvironmental;
import org.activiti.engine.repository.ProcessDefinition;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ProcessServiceImplTest extends SpringBootTestEnvironmental {
    @Autowired
    ProcessServiceImpl processService;

    String fileName = "feastfulProcess_V_1.1";

    @Before
    public void Init() {
        processService.deployFlowChartByFileName(fileName);
    }

    @Test
    public void deployFlowChartByFileName() throws Exception {
        Assert.assertTrue(processService.isAlreadyDeployFlowChart(fileName));
    }

    @Test
    public void getLastProcessDefinitions() throws Exception {
        ProcessDefinition definition = processService.getLastProcessDefinitions();
        Assert.assertEquals(fileName,definition.getKey());
    }

    @Test
    public void getProcessDefinition() throws Exception {
    }

    @Test
    public void startProcessByProcessName() throws Exception {
    }

    @Test
    public void finishProcessInstance() throws Exception {
    }

    @Test
    public void deleteFlowChart() throws Exception {
        ProcessDefinition definition = processService.getLastProcessDefinitions();
        processService.deleteFlowChart(definition,true);
        Assert.assertFalse(processService.isAlreadyDeployFlowChart(fileName));

    }


}