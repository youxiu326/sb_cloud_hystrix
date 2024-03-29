package com.huarui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;




/*
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
*/
@SpringCloudApplication
@EnableFeignClients(basePackages = "com.huarui")
public class SbCloudHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbCloudHystrixApplication.class, args);
	}

}
