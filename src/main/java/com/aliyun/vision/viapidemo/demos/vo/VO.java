package com.aliyun.vision.viapidemo.demos.vo;


import com.aliyun.vision.viapidemo.demos.constants.ResponseEnum;

/**
 * </pre>
 */
public class VO<T> {
    private Integer code;
    private String msg;
    private T data;

    public VO(Integer code, String msg) {
        this(code, msg, null);
    }

    public VO(Integer code, String msg, T data) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static VO response(ResponseEnum responseEnum) {
        return new VO(responseEnum.getCode(), responseEnum.getName());
    }

    public static VO response(ResponseEnum responseEnum, Object obj) {
        return new VO(responseEnum.getCode(), responseEnum.getName(), obj);
    }

    public static VO success() {
        return new VO(Integer.valueOf(ResponseEnum.SUCCESS.getCode()), ResponseEnum.SUCCESS.getName());
    }

    public static VO success(String msg) {
        return new VO(ResponseEnum.SUCCESS.getCode(), msg);
    }

    public static VO error(Integer code, String msg) {
        return new VO(code, msg);
    }

    public static VO build(ResponseEnum responseEnum) {
        return new VO(responseEnum.getCode(), responseEnum.getName());
    }
}
