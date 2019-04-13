package com.weshare.phoenix.activiti.entity;

import io.swagger.annotations.Api;
import lombok.Builder;
import lombok.Data;

/**
 * @Author: MCC
 * @Date: 2019/3/9 9:51
 * @Description:
 */
@Data
public class ProcessRequest {
    private String applyId;
    private Boolean riskControlConclusion;
    private String nextNodeCode;
    private String currentNodeCode;
    private String processCode;

    public ProcessRequest() {
    }

}
