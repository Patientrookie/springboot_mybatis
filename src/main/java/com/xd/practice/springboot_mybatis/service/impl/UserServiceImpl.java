package com.xd.practice.springboot_mybatis.service.impl;

import com.xd.practice.springboot_mybatis.common.Result;
import com.xd.practice.springboot_mybatis.dao.UserMapper;
import com.xd.practice.springboot_mybatis.model.User;
import com.xd.practice.springboot_mybatis.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author xiaqi
 * @Date 16/06/2020 15:11
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public Result saveUser(User user){
        int flag = userMapper.insert(user);
        if(flag > 0){
            return Result.success("添加用户成功");
        }
        return Result.error("添加用户失败");
    }

    @Override
    public User getUser(String id)  {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }
}
