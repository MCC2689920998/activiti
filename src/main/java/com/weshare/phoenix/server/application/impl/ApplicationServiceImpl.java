package com.weshare.phoenix.server.application.impl;

import com.weshare.phoenix.controller.contract.MessageRequest;
import com.weshare.phoenix.controller.contract.MessageResponse;
import com.weshare.phoenix.server.application.ApplicationService;
import org.springframework.stereotype.Service;

/**
 * @Author MCC
 * @Create 2019/4/15 18:10
 */
@Service
public class ApplicationServiceImpl implements ApplicationService<MessageRequest, MessageResponse> {
    @Override
    public MessageResponse applicationCommit(MessageRequest messageRequest) {

        return new MessageResponse();
    }


}
