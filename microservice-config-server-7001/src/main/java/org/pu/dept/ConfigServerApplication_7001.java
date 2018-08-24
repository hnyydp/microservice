package org.pu.dept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer  //开启Config配置中心
@SpringBootApplication
public class ConfigServerApplication_7001 {
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication_7001.class, args);
	}
}
