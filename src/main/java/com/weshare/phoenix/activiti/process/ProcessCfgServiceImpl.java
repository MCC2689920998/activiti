package com.weshare.phoenix.activiti.process;

import com.weshare.phoenix.properties.WeShareProcessDataSourceProperties;
import com.weshare.phoenix.util.EmptyUtils;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @Author: MCC
 * @Date: 2019/2/26 11:54
 * @Description:
 */
@Service
@Slf4j
public class ProcessCfgServiceImpl {

    private static WeShareProcessDataSourceProperties weShareProcessDataSourceProperties;

    @Autowired
    WeShareProcessDataSourceProperties dataSourceProperties;

    @PostConstruct
    public void setWeShareProcessDataSourceProperties() {
        weShareProcessDataSourceProperties = dataSourceProperties;
    }

    private static ProcessEngine processEngine;

    private static ProcessEngine getProcessEngine() {
        if (processEngine == null) {
            log.info("activiti processEngine config:{}", weShareProcessDataSourceProperties.toString());
            processEngine = initProcessEngine();
        }
        return processEngine;
    }

    private static ProcessEngine initProcessEngine() {
        ProcessEngineConfiguration processEngineConfiguration;
        processEngineConfiguration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        //Jdbc设置
        processEngineConfiguration.setJdbcDriver(weShareProcessDataSourceProperties.getJdbcDriver());
        processEngineConfiguration.setJdbcUrl(weShareProcessDataSourceProperties.getJdbcUrl());
        processEngineConfiguration.setJdbcUsername(weShareProcessDataSourceProperties.getJdbcUsername());
        processEngineConfiguration.setJdbcPassword(weShareProcessDataSourceProperties.getJdbcPassword());
        processEngineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        return processEngineConfiguration.buildProcessEngine();
    }


    /**
     * 获取 工作流仓储服务
     *
     * @return
     */
    public RepositoryService getRepositoryService() {
        return getProcessEngine().getRepositoryService();
    }

    /**
     * 获取 工作流运行时服务
     *
     * @return
     */
    public RuntimeService getRuntimeService() {
        return getProcessEngine().getRuntimeService();

    }

    /**
     * 获取 工作流任务运行时服务
     *
     * @return
     */
    public TaskService getTaskService() {
        return getProcessEngine().getTaskService();

    }

    /**
     * 获取 工作流历史服务
     *
     * @return
     */
    public HistoryService getHistoryService() {
        return getProcessEngine().getHistoryService();
    }


}
