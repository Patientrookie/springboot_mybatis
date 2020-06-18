package com.xd.practice.springboot_mybatis.common;

/**
 * @ClassName BaseResponseCode
 * @Description TODO
 * @Author xiaqi
 * @Date 18/06/2020 17:16
 * @Version 1.0
 **/
public enum  BaseResponseCode implements ResponseCodeInterface {

    /** */
    SUCCESS(0,"操作成功"),
    SYSTEM_BUSY(500001, "系统繁忙，请稍候再试"),
    OPERATION_ERRO(500002,"操作失败");

    /**
     * 错误码
     */
    private final int code;
    /**
     * 错误消息
     */
    private final String msg;

    BaseResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
