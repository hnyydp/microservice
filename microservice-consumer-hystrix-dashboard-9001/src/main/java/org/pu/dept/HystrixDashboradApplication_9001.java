package org.pu.dept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard //开启断路器仪表盘功能
@SpringBootApplication
public class HystrixDashboradApplication_9001 {
	public static void main(String[] args) {
		SpringApplication.run(HystrixDashboradApplication_9001.class, args);
	}
}
