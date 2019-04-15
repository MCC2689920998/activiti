package com.weshare.phoenix.controller.contract;

import lombok.Data;

import java.util.List;

/**
 * @Author MCC
 * @Create 2019/4/15 17:58
 */
@Data
public class MessageResponse {
    private List<String> executedNodeList;
    private List<String> nextNodeList;
}
