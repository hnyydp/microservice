package org.pu.dept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy   //开启Zuul路由
@EnableEurekaClient
@SpringBootApplication
public class ZuulGatewayApplication_9003 {
	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayApplication_9003.class, args);
	}
}
