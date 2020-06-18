package com.xd.practice.springboot_mybatis.service;

import com.xd.practice.springboot_mybatis.common.Result;
import com.xd.practice.springboot_mybatis.model.User;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author xiaqi
 * @Date 16/06/2020 15:09
 * @Version 1.0
 **/
public interface UserService {

    Result saveUser(User user);

    User getUser(String id);
}
