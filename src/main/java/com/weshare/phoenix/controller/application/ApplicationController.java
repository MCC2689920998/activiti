package com.weshare.phoenix.controller.application;

import com.weshare.phoenix.controller.contract.MessageRequest;
import com.weshare.phoenix.controller.contract.MessageResponse;
import com.weshare.phoenix.server.application.impl.ApplicationServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    ApplicationServiceImpl applicationServiceImpl;

    @RequestMapping(value = "/applicationCommit", method = RequestMethod.POST)
    @ApiOperation(value = "申请提交接口", notes = "提交申请相关数据，推进流程")
    public MessageResponse applicationCommit(@RequestBody MessageRequest messageRequest) {
        return applicationServiceImpl.applicationCommit(messageRequest);
    }


}
