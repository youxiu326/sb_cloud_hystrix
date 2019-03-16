package com.huarui.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;

/**
 * Created by Shinelon on 2019/3/15.
 */
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {


    @HystrixCommand(fallbackMethod = "fallback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    @GetMapping("/getProductList")
    public String getProductList(){

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:9000/product/getMsg",
                String.class);
    }

    @HystrixCommand(commandKey = "getProductListDefa")  //commandKey 默认就是方法名，用来在配置文件中单独设置超时时间
    @GetMapping("/getProductList2")
    public String getProductListDefa(){

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:9000/product/getMsg",
                String.class);
    }

    private String fallback(){
        return "太拥挤了，请稍后再试";
    }

    private String defaultFallback(){
        return "全局返回 稍后再试";
    }

}
