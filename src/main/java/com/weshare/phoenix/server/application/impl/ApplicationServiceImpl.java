package com.weshare.phoenix.server.application.impl;

import com.weshare.phoenix.controller.contract.MessageRequest;
import com.weshare.phoenix.controller.contract.MessageResponse;
import com.weshare.phoenix.dao.entity.BaseNodeActuatorCfg;
import com.weshare.phoenix.dao.repository.BaseNodeActuatorCfgRepository;
import com.weshare.phoenix.server.application.ApplicationService;
import com.weshare.phoenix.server.application.actuator.NodeActuator;
import com.weshare.phoenix.server.exception.ApsException;
import com.weshare.phoenix.server.statusenum.ApsErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.weshare.phoenix.server.statusenum.ApsErrorCodeEnum.APS_NODE_ACTUATOR_NULL;

/**
 * @Author MCC
 * @Create 2019/4/15 18:10
 */
@Service
@Slf4j
public class ApplicationServiceImpl implements ApplicationService<MessageRequest, MessageResponse> {

    @Autowired
    BaseNodeActuatorCfgRepository baseNodeActuatorCfgRepository;
    @Autowired
    ApplicationContext applicationContext;


    @Override
    public MessageResponse applicationCommit(MessageRequest messageRequest) throws ApsException {
        String currentNodeCode = messageRequest.getCurrentNodeCode();
        //防止高并发，重复请求

        //获取执行器
        List<BaseNodeActuatorCfg> baseNodeActuatorCfgs = baseNodeActuatorCfgRepository
                .findBaseNodeActuatorCfgsByNodeCodeDesc(currentNodeCode);
        if (baseNodeActuatorCfgs == null || baseNodeActuatorCfgs.size() < 0) {
            log.warn("{} 环节执行器为空,请查看相关配置", currentNodeCode);
            throw new ApsException(ApsErrorCodeEnum.APS_NODE_ACTUATOR_NULL);
        }
        //执行执行器
        MessageResponse response = executeAllNodeActuator(baseNodeActuatorCfgs, messageRequest);

        return response;
    }


    /**
     * 执行申请执行器
     *
     * @param baseNodeActuatorCfgs
     * @return
     */
    private MessageResponse executeAllNodeActuator(List<BaseNodeActuatorCfg> baseNodeActuatorCfgs, MessageRequest messageRequest) throws ApsException {
        MessageResponse response = new MessageResponse();
        for (BaseNodeActuatorCfg b : baseNodeActuatorCfgs) {
            NodeActuator actuator = (NodeActuator) applicationContext.getBean(b.getActuatorCode());
            response = (MessageResponse) actuator.execute(messageRequest, response);
        }
        return response;
    }
}
