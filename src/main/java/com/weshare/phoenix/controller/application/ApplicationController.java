package com.weshare.phoenix.controller.application;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author MCC
 * @Create 2019/4/13 15:10
 */
@RestController
@Slf4j
@Api("申请控制相关api")
public class ApplicationController {


    @RequestMapping(value = "/applicationCommit",method = RequestMethod.POST)
    public String applicationCommit(String fileName) {

        return "success";
    }


}
