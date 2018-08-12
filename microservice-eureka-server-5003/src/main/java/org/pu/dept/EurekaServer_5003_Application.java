package org.pu.dept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//SpringCloud中，如果要开启某个组件，使用@EnableXXXX注解即可
@EnableEurekaServer   //开启Eureka服务，使得这个应用变为Euraka服务器
@SpringBootApplication
public class EurekaServer_5003_Application {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServer_5003_Application.class, args);
	}
}
