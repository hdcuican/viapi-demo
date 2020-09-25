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

    /**
     * 模板实例相关
     */
    TEMPLETE_INSTANCE_DELETE_UNAUTHORIZED(1001, "该页面人仍有模板实例在使用， 不能删除"),
    /**
     * 页面相关
     */
    PAGE_DELETE_NOT_ALLOW(1101, "页面下还有使用模板实例， 不能进行删除"),
    PAGE_IS_REPEAT(1102, "页面不能重复添加"),

    /**
     * 模板相关
     */
    TEMPLETE_DELETE_UNAUTHORIZED(1201, "该模板仍有模板实例在使用， 不能删除"),

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