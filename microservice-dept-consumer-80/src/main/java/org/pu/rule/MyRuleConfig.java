package org.pu.rule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * 定义策略规则配置类
 * @author dave
 *
 */
@Configuration
public class MyRuleConfig {
	/**
	 * 修改我们需要的负载均衡策略
	 * @return
	 */
	@Bean
	public IRule myRule(){
//		return new RandomRule();   //修改默认的算法为随机算法
		
		return new MySelfRule();  //自定义策略
	}
}
