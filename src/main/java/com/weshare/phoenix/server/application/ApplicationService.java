package com.weshare.phoenix.server.application;

import org.springframework.stereotype.Service;

/**
 * @Author MCC
 * @Create 2019/4/15 18:08
 */
public interface ApplicationService<I, O> {
    O applicationCommit(I i);
}
