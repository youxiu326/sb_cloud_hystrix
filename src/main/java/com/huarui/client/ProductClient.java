package com.huarui.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Map;

/**
 * Created by Shinelon on 2019/3/16.
 */
@FeignClient(value = "SB-CLOUD-PRODUCT",fallback = ProductClient.ProductClientFallback.class )
public interface ProductClient {

    @GetMapping({"/product/getMsg"})
    public Map<String,String> getMsg();

    @Component
    static class ProductClientFallback implements ProductClient{

        @Override
        public Map<String, String> getMsg() {
            return null;
        }
    }

}
