package com.hp.client;

import com.hp.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserFalBack implements UserClient {
    @Override
    public User queryById(long i) {
        User user = new User();
        user.setName("呵呵，拥堵了");
        return user;
    }
}
