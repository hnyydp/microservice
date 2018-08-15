package org.pu.dept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients //开启Feign客户端
@EnableEurekaClient
@SpringBootApplication
public class DeptConsumerFeignApplication {
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumerFeignApplication.class, args);
	}
}
