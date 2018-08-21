package org.pu.dept.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	
	/**
	 *  调用restful服务模版,客户端模版工具
	 * @return
	 */
	@LoadBalanced   //开始客户端负载均衡
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
