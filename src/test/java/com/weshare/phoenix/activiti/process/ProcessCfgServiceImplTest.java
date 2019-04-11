package com.weshare.phoenix.activiti.process;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProcessCfgServiceImplTest {

    @Autowired
    ProcessCfgServiceImpl processCfgService;

    @Test
    public void getProcessEngine() throws Exception {
        Assert.assertNotNull(processCfgService.getProcessEngine());;
    }

    @Test
    public void getRepositoryService() throws Exception {
    }

    @Test
    public void getRuntimeService() throws Exception {
    }

    @Test
    public void getTaskService() throws Exception {
    }

    @Test
    public void getHistoryService() throws Exception {
    }

}