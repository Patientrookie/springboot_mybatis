package com.xd.practice.springboot_mybatis.common;

/**
 * @ClassName CommonException
 * @Description TODO
 * @Author xiaqi
 * @Date 18/06/2020 14:43
 * @Version 1.0
 **/
public class CommonException extends RuntimeException {

    private String message;

    private int code;

    public CommonException(int code,String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
    /**
     * 构造函数
     * @param code 异常码
     */
    public CommonException(ResponseCodeInterface code) {
        this(code.getCode(), code.getMsg());
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
