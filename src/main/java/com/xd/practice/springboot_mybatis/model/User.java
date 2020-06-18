package com.xd.practice.springboot_mybatis.model;

import com.xd.practice.springboot_mybatis.enums.GenderEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author xiaqi
 */
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @ApiModelProperty(value = "用户ID",required = true)
    private String id;

    @ApiModelProperty(value = "用户名称",required = true)
    private String username;

    @ApiModelProperty(value = "用户密码",required = true)
    private String password;

    @ApiModelProperty(value = "用户性别",required = true)
    private GenderEnum gender;

    @ApiModelProperty(value = "用户年龄",required = true)
    private Integer age;

    @ApiModelProperty(value = "用户昵称",required = true)
    private String nickname;

    @ApiModelProperty(value = "用户创建时间",required = true)
    private Date createTime;

    @ApiModelProperty(value = "用户创建人",required = true)
    private String createBy;

    @ApiModelProperty(value = "用户更新时间",required = true)
    private Date updateTime;

    @ApiModelProperty(value = "用户更新人",required = true)
    private String updateBy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }
}