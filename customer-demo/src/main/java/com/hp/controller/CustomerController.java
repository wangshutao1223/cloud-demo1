package com.hp.controller;

import com.hp.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private RestTemplate template;

    @Autowired
    private DiscoveryClient discoveryClient; //eureka客户端

/*    @GetMapping("/{i}")
    public User getUser(@PathVariable("i") long id){
        //调用UserService
        User user=template.getForObject("http://localhost:8089/user/"+id,User.class);
        return user;
    }*/
/*        @GetMapping("/{i}")
        public User getUser(@PathVariable("i") long id){
            //获取服务列表
            List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
            //列表中取出 一个服务
            ServiceInstance serviceInstance = instances.get(0);
            String url="http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/"+id;

            //调用UserService
            User user=template.getForObject(url,User.class);
            return user;
        }*/

    @GetMapping("/{i}")
    public User getUser(@PathVariable("i") long id){
        String url="http://user-service/user"+id;
        User user=template.getForObject(url,User.class);
        return user;
    }
}
