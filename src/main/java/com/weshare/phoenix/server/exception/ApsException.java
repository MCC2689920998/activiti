package com.weshare.phoenix.server.exception;

import com.weshare.phoenix.server.statusenum.ApsErrorCodeEnum;
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

    public ApsException(ApsErrorCodeEnum apsErrorCodeEnum) {
        super(apsErrorCodeEnum.getMessage());
        this.errorCode = apsErrorCodeEnum.getCode();
        this.errorMessage = apsErrorCodeEnum.getMessage();
    }

    public ApsException(Long code, String message) {

    }
}
