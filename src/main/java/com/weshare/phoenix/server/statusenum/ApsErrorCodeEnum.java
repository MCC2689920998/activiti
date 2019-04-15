package com.weshare.phoenix.server.statusenum;

/**
 * @Author MCC
 * @Create 2019/4/15 18:41
 */
public enum ApsErrorCodeEnum {

    APS_NODE_ACTUATOR_NULL(3001L, "环节执行器为空");

    private Long errorCode;
    private String errorMessage;

    ApsErrorCodeEnum(long errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public static ApsErrorCodeEnum getEnumByCode(Long code) {
        for (ApsErrorCodeEnum p : values()) {
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
