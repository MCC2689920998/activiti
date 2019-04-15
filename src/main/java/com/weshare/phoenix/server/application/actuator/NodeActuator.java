package com.weshare.phoenix.server.application.actuator;

import com.weshare.phoenix.server.exception.ApsException;

/**
 * @Author MCC
 * @Create 2019/4/15 18:08
 */
public interface NodeActuator<I, O, T> {
    O execute(I i,T t) throws ApsException;

}
