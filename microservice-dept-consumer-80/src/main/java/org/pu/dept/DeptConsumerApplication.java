package org.pu.dept;

import org.pu.rule.MyRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;


//启动该微服务的时候会加载客制化策略的配置类，使其生效
@RibbonClient(name="MICROSERVICE-DEPT",configuration=MyRuleConfig.class)
@SpringBootApplication
public class DeptConsumerApplication {
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumerApplication.class, args);
	}
}
