package com.weshare.phoenix.controller;

import com.weshare.phoenix.activiti.entity.ProcessRequest;
import com.weshare.phoenix.activiti.entity.ProcessResponse;
import com.weshare.phoenix.activiti.process.ProcessServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Author MCC
 * @Create 2019/4/12 13:37
 */
@RestController
@Slf4j
@Api("userController相关api")
public class ProcessController {

    @Autowired
    ProcessServiceImpl processService;

    @RequestMapping(value = "/initProcess", method = RequestMethod.POST)
    public ProcessResponse initProcess(@RequestBody ProcessRequest processRequest) {
        log.info("process controller receive init process request,file name {}", processRequest);
        //processService.deployFlowChartByFileName(fileName);
        return new ProcessResponse();
    }

    @RequestMapping(value = "/initProcess1", method = RequestMethod.GET)
    public ProcessResponse initProcess1(@RequestParam String fileName) {
        log.info("process controller receive init process request,file name {}", fileName);
        //processService.deployFlowChartByFileName(fileName);
        return new ProcessResponse();
    }

}
