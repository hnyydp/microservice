package org.pu.dept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableCircuitBreaker   //开启Hystrxi断路器
@EnableEurekaClient
@SpringBootApplication
//@SpringCloudApplication   //可以只使用这个，已经包括前面三个注解
public class DeptConsumerRibbonHystrixApplication {
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumerRibbonHystrixApplication.class, args);
	}
}
