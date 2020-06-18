package com.xd.practice.springboot_mybatis.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Result
 * @Description TODO
 * @Author xiaqi
 * @Date 16/06/2020 16:00
 * @Version 1.0
 **/
@Data
@ApiModel(value = "通用接口返回对象")
public class Result implements Serializable {


    /** 结果标记(true:执行成功 false:执行失败) */
    @ApiModelProperty(required = true,notes = "标识",example = "200")
    private Boolean flag;
    /** 消息状态码 */
    @ApiModelProperty(required = true,notes = "状态码")
    private Integer code;
    /** 消息 */
    @ApiModelProperty(required = true,notes = "返回消息")
    private String msg;
    /** 返回数据 */
    @ApiModelProperty(required = true,notes = "返回数据")
    private Object data;

    private Result(Boolean flag, Integer code, String msg, Object data) {
        this.flag = flag;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 响应成功(带返回数据)
     * @param data 返回数据
     * @return Result
     */
    public static Result success(String message,Object data){
        return new Result(true,200,message,data);
    }

    /**
     * 响应成功
     * @return Result
     */
    public static Result success(String message){
        return new Result(true,200,message,null);
    }

    /**
     * 响应错误(不带状态码,带消息)
     * @return Result
     */
    public static Result error(String msg){
        return new Result(false,210,msg,null);
    }

    /**
     * 响应错误(带错误码,消息提醒)
     * @return
     */
    public static Result errorMsg(Integer code,String msg){
        return new Result(false,code,msg,null);
    }

}
