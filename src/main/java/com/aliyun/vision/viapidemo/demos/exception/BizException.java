package com.aliyun.vision.viapidemo.demos.exception;


import com.aliyun.vision.viapidemo.demos.constants.ResponseEnum;

/**
 * <pre>
 * </pre>
 */
public class BizException extends RuntimeException {
    private Integer code;
    private String msg;

    public BizException(ResponseEnum responseEnum) {
        this.code = Integer.valueOf(responseEnum.getCode());
        this.msg = responseEnum.getName();
    }

    public BizException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
