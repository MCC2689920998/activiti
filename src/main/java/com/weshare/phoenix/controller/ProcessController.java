package com.weshare.phoenix.controller;

import com.weshare.phoenix.activiti.process.ProcessServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author MCC
 * @Create 2019/4/12 13:37
 */
@RestController
@Slf4j
public class ProcessController {

    @Autowired
    ProcessServiceImpl processService;

    @RequestMapping(value = "/initProcess",method = RequestMethod.POST)
    public String initProcess(String fileName){
        log.info("process controller receive init process request ");
        processService.deployFlowChartByFileName(fileName);
        return fileName+"deploy success";
    }




}
