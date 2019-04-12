package com.weshare.phoenix.activiti.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @Author: MCC
 * @Date: 2019/3/9 9:51
 * @Description:
 */
@Data
@Builder
public class ProcessRequest {
    private String applyId;
    private Boolean riskControlConclusion;
    private String nextNodeCode;
    private String currentNodeCode;
    private String processCode;
}
