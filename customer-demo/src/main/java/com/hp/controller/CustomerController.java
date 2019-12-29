package com.hp.controller;

import com.hp.client.UserClient;
import com.hp.entity.User;

import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
//@DefaultProperties(defaultFallback = "defaultFallback" )
public class CustomerController {
//    @Autowired
//    private RestTemplate template;

//    @Autowired
//    private DiscoveryClient discoveryClient; //eureka客户端

      @Autowired
        private UserClient userClient;

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
/*
    @GetMapping("/{i}")
    public User getUser(@PathVariable("i") long id){
        String url="http://user-service/user"+id;
        User user=template.getForObject(url,User.class);
        return user;
    }*/

/**
 * Hystrix熔断器第一种方法
 */
//    @GetMapping("/{i}")
//    @HystrixCommand(fallbackMethod = "queryBack")//方法熔断
//    public String getUser(@PathVariable("i") long id){
//        String url="http://user-service/user"+id;
//        String user=template.getForObject(url,String.class);
//        return user;
//    }
//
//    //当发生失败，调用queryBack
//    public String queryBack(long id){
//        return "活动过于火爆，请稍后再试";
//    }
    /***
     *  Hystrix熔断器第二种方法
     */
//    @GetMapping("/{i}")
//    //@HystrixCommand//方法熔断
//    public String getUser(@PathVariable("i") long id){
//
//        String url="http://user-service/user/"+id;
//        String user=template.getForObject(url,String.class);
//        return user;
//    }
//
//    //当发生失败，调用queryBack
//    public String defaultFallback(){
//        return "活动过于火爆，请稍后再试";
//    }

    /**
     * Feign方法
     * @param id
     * @return
     */
    @GetMapping("/{i}")

    public User getUser(@PathVariable("i") long id){
        return userClient.queryById(id);
    }

}
