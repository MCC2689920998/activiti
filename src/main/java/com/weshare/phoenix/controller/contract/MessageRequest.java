package com.weshare.phoenix.controller.contract;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

/**
 * @Author MCC
 * @Create 2019/4/15 17:56
 */
@Data
public class MessageRequest {

    @ApiModelProperty(value = "当前环节")
    @NonNull
    private String currentNodeCode;
    @ApiModelProperty(value = "电话号码")
    private String phoneNum;

}
