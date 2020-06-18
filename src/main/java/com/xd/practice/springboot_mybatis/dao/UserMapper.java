package com.xd.practice.springboot_mybatis.dao;

import com.xd.practice.springboot_mybatis.model.User;

/**
 * @author xiaqi
 */
public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}