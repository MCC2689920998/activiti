package com.weshare.phoenix.server.activiti.process;

import com.weshare.phoenix.SpringBootTestEnvironmental;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ProcessCfgServiceImplTest extends SpringBootTestEnvironmental {

    @Autowired
    ProcessCfgServiceImpl processCfgService;


    @Test
    public void getRepositoryService() throws Exception {
        Assert.assertNotNull(processCfgService.getRepositoryService());;

    }

    @Test
    public void getRuntimeService() throws Exception {
        Assert.assertNotNull(processCfgService.getRuntimeService());;

    }

    @Test
    public void getTaskService() throws Exception {
        Assert.assertNotNull(processCfgService.getTaskService());;
    }

    @Test
    public void getHistoryService() throws Exception {
        Assert.assertNotNull(processCfgService.getHistoryService());;

    }

}