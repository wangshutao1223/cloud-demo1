package com.hp.client;

import com.hp.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "unknown",fallback =UserFalBack.class)
public interface UserClient {

    @GetMapping("user/{id}")
    public User queryById(@PathVariable("id") long i);

    //自动拼成一个Url
    //http://user-service/user/1
}
