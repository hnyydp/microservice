package org.pu.dept;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ConfigClientApplication_7002 {
	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication_7002.class, args);
	}
	
	@Value("${spring.hello}")
	private String hello;

	@RequestMapping("/hello")
	public String hello() {
		return hello;
	}
}
