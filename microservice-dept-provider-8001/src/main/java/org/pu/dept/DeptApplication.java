package org.pu.dept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient  //服务启动后会自动注册到Eureka注册中心中
@SpringBootApplication
public class DeptApplication {
	public static void main(String[] args) {
		SpringApplication.run(DeptApplication.class, args);
	}
}
