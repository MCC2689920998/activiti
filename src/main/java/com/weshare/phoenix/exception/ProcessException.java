package com.weshare.phoenix.exception;

import com.weshare.phoenix.statusenum.ProcessErrorCodeEnum;
import lombok.Data;

/**
 * @Author MCC
 * @Create 2019/4/12 16:51
 */
@Data
public class ProcessException extends Exception {

    private Long errorCode;
    private String errorMessage;

    public ProcessException(ProcessErrorCodeEnum processErrorCodeEnum) {
        super(processErrorCodeEnum.getMessage());
        this.errorCode = processErrorCodeEnum.getCode();
        this.errorMessage = processErrorCodeEnum.getMessage();
    }

}
