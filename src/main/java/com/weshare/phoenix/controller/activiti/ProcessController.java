package com.weshare.phoenix.controller.activiti;

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
import springfox.documentation.annotations.ApiIgnore;


/**
 * @Author MCC
 * @Create 2019/4/12 13:37
 */
@RestController
@Slf4j
@Api("userController相关api")
//@ApiIgnore
public class ProcessController {

    @Autowired
    ProcessServiceImpl processService;

    @RequestMapping(value = "/initProcess", method = RequestMethod.GET)
    public String initProcess(@RequestParam String fileName) {
        log.info("process controller receive init process request,file name is {}", fileName);
        processService.deployFlowChartByFileName(fileName);
        return fileName + "deploy success";
    }










//    @RequestMapping(value = "/initProcess", method = RequestMethod.POST)
//    public ProcessResponse initProcess(@RequestBody ProcessRequest processRequest) {
//        log.info("process controller receive init process request,file name {}", processRequest);
//        //processService.deployFlowChartByFileName(fileName);
//        return new ProcessResponse();
//    }



}
