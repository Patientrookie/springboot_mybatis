package com.xd.practice.springboot_mybatis.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.models.auth.In;

/**
 * @ClassName GenderEnum
 * @Description TODO
 * @Author xiaqi
 * @Date 16/06/2020 16:55
 * @Version 1.0
 **/
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum GenderEnum{
    /**
     * 男
     */
    MALE(0,"男"),
    /**
     * 女
     */
    FEMALE(1,"女");

    @EnumValue
    private final Integer code;

    @JsonValue
    private final String desc;

    GenderEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return this.desc;
    }
}
