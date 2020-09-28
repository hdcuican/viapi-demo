package com.aliyun.vision.viapidemo.demos.constants;

/**
 * <pre>
 * </pre>
 */
public enum ResponseEnum {
    SUCCESS(0, "操作成功"),
    FAIL(1, "操作失败，请稍后重试"),
    PARAM_ERROR(400, "参数错误"),
    UNAUTHORIZED(401, "请登陆"),
    SIGN_ERROR(402, "验签失败"),
    NO_DATA(404, "无相关数据"),
    NO_MODIFY(304, "没有数据更新"),


    PARSE_FAIL(1001, "图片解析失败, 请重新尝试"),

    BUSY(1101, "系统繁忙"),
    EXCEPTION(9999, "系统异常，请稍后重试");


    private Integer code;
    private String name;

    ResponseEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}