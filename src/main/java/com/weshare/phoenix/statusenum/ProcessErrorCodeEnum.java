package com.weshare.phoenix.statusenum;


/**
 * @Author: MCC
 * @Date: 2019/2/27 12:15
 * @Description:
 */
public enum ProcessErrorCodeEnum {


    PROCESS_TASK_REPETITION_CODE(4001L, "存在相同任务"),
    PROCESS_NOT_DEFINITION_CODE(4002L, "流程图未部署");

    private final Long errorCode;
    private final String errorMessage;

    ProcessErrorCodeEnum(long errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public static ProcessErrorCodeEnum getEnumByCode(Long code) {
        for (ProcessErrorCodeEnum p : values()) {
            if (p.getCode().equals(code)) {
                return p;
            }
        }
        return null;
    }

    public Long getCode() {
        return this.errorCode;
    }

    public String getMessage() {
        return this.errorMessage;
    }

    public String getName() {
        return name();
    }




}
