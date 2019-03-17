package com.huarui.controller;

import com.huarui.client.ProductClient;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Shinelon on 2019/3/16.
 */
@RestController
public class FeignController {

    @Autowired
    private ProductClient productClient;


    @GetMapping("/feign/getProductMsg")
    public Map getProduct(){
        Map map = productClient.getMsg();
        System.out.println(map);
        return map;

    }

}
