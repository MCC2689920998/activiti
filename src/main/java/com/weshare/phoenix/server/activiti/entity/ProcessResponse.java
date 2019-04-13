package com.weshare.phoenix.server.activiti.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author: MCC
 * @Date: 2019/3/9 9:50
 * @Description:
 */
@Data
public class ProcessResponse {

    private List<String> executedNodeList;
    private List<String> nextNodeList;

}
