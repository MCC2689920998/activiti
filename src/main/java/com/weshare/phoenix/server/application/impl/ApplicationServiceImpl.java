package com.weshare.phoenix.server.application.impl;

import com.weshare.phoenix.controller.contract.MessageRequest;
import com.weshare.phoenix.controller.contract.MessageResponse;
import com.weshare.phoenix.dao.entity.BaseNodeActuatorCfg;
import com.weshare.phoenix.dao.repository.BaseNodeActuatorCfgRepository;
import com.weshare.phoenix.server.application.ApplicationService;
import com.weshare.phoenix.server.exception.ApsException;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author MCC
 * @Create 2019/4/15 18:10
 */
@Service
@Slf4j
public class ApplicationServiceImpl implements ApplicationService<MessageRequest, MessageResponse> {

    @Autowired
    BaseNodeActuatorCfgRepository baseNodeActuatorCfgRepository;


    @Override
    public MessageResponse applicationCommit(MessageRequest messageRequest) throws ApsException {
        //防止高并发请求

        //获取执行器
        List<BaseNodeActuatorCfg> baseNodeActuatorCfgs = baseNodeActuatorCfgRepository
                .findBaseNodeActuatorCfgsByNodeCode(messageRequest.getCurrentNodeCode());
        //执行执行器
        MessageResponse response =executeAllNodeActuator(baseNodeActuatorCfgs);

        return response;
    }




    private MessageResponse executeAllNodeActuator(List<BaseNodeActuatorCfg> baseNodeActuatorCfgs) {
        return new MessageResponse();
    }
}
