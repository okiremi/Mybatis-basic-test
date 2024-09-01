package com.learn.mapper;

import com.learn.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();
    User selectById(int id);
}
