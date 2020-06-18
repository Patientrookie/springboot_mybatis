package com.xd.practice.springboot_mybatis;

import com.xd.practice.springboot_mybatis.dao.UserMapper;
import com.xd.practice.springboot_mybatis.enums.GenderEnum;
import com.xd.practice.springboot_mybatis.model.User;
import com.xd.practice.springboot_mybatis.service.UserService;
import com.xd.practice.springboot_mybatis.utils.UuidUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @ClassName UserTest
 * @Description TODO
 * @Author xiaqi
 * @Date 16/06/2020 17:21
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {


    @Resource
    UserService userService;


    @Test
    public void saveUser(){

        User user = new User();
        user.setId(UuidUtil.base58Uuid());
        user.setUsername("cc");
        user.setPassword("123456");
        user.setGender(GenderEnum.FEMALE);
        user.setAge(32);
        user.setNickname("昵称1");
        user.setCreateTime(new Timestamp(new Date().getTime()));
        user.setCreateBy("shawn");
        user.setUpdateTime(new Timestamp(new Date().getTime()));
        user.setUpdateBy("shawn");

        userService.saveUser(user);
    }

    @Test
    public void getUser(){
        System.out.println(userService.getUser("4e2WSGPKRqQbmsCisWgUj9").getGender());
    }
}
