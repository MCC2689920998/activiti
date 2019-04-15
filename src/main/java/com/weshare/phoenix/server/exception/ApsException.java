package com.weshare.phoenix.server.exception;

import com.weshare.phoenix.server.statusenum.ProcessErrorCodeEnum;
import lombok.Data;

/**
 * @Author MCC
 * @Create 2019/4/15 18:23
 */
@Data
public class ApsException extends Exception {

    private Long errorCode;
    private String errorMessage;

    public ApsException(ProcessErrorCodeEnum processErrorCodeEnum) {
        super(processErrorCodeEnum.getMessage());
        this.errorCode = processErrorCodeEnum.getCode();
        this.errorMessage = processErrorCodeEnum.getMessage();
    }
}
