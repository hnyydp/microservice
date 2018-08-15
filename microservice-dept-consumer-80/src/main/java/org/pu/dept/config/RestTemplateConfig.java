package org.pu.dept.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

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
	
	/**
	 * 修改我们需要的负载均衡策略
	 * @return
	 */
	@Bean
	public IRule myRule(){
		return new RandomRule();   //修改默认的算法为随机算法
	}
	
}
