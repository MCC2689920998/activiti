package com.weshare.phoenix.server.activiti.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @Author: MCC
 * @Date: 2019/2/27 14:10
 * @Description:
 */
@Data
@Builder
public class ProcessEntity {
    private ProcessRequest processRequest;
    private ProcessResponse processResponse;
}
