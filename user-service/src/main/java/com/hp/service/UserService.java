package com.hp.service;

import com.hp.entity.User;
import com.hp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User queryById(long i) {
       return this.userMapper.selectByPrimaryKey(i);
    }
}
