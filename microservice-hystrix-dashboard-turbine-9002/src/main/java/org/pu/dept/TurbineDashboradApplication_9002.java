package org.pu.dept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableTurbine  //开启Turbine, 只会监控有Hystrix的服务
@EnableHystrixDashboard //开启断路器仪表盘功能
@SpringBootApplication
public class TurbineDashboradApplication_9002 {
	public static void main(String[] args) {
		SpringApplication.run(TurbineDashboradApplication_9002.class, args);
	}
}
