package com.xd.practice.springboot_mybatis.controller;

import com.xd.practice.springboot_mybatis.common.Result;
import com.xd.practice.springboot_mybatis.model.User;
import com.xd.practice.springboot_mybatis.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author xiaqi
 * @Date 16/06/2020 15:08
 * @Version 1.0
 **/
@Api(value = "用户管理文档", tags = "用户管理文档")
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    UserService userService;

    @GetMapping(value = "/getUser")
    @ApiOperation(value = "查询用户信息",notes = "查询用户信息",responseContainer = "User",response = User.class)
    public Result getUser(@RequestParam(value = "id") String id){
        return Result.success("用户信息查询成功",userService.getUser(id));
    }

}
