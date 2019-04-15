package com.weshare.phoenix.server.application;

import com.weshare.phoenix.server.exception.ApsException;

/**
 * @Author MCC
 * @Create 2019/4/15 18:08
 */
public interface ApplicationService<I, O> {
    O applicationCommit(I i) throws ApsException;
}
