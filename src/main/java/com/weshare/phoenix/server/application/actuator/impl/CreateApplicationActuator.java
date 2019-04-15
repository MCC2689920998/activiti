package com.weshare.phoenix.server.application.actuator.impl;

import com.weshare.phoenix.controller.contract.MessageRequest;
import com.weshare.phoenix.controller.contract.MessageResponse;
import com.weshare.phoenix.server.application.actuator.NodeActuator;
import com.weshare.phoenix.server.exception.ApsException;
import org.springframework.stereotype.Service;

/**
 * @Author MCC
 * @Create 2019/4/15 18:49
 */
@Service("createApplicationActuator")
public class CreateApplicationActuator implements NodeActuator<MessageRequest,MessageResponse,MessageResponse> {

    @Override
    public MessageResponse execute(MessageRequest messageRequest, MessageResponse messageResponse) throws ApsException {
        return null;
    }
}
