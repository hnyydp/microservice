package org.pu.rule;

import java.util.List;
import java.util.Random;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

/**
 * 自定义负载均衡: 每台服务器随机连续访问5次，
 * 
 * @author dave
 *
 */
public class MySelfRule extends AbstractLoadBalancerRule {

	Random rand;

	public MySelfRule() {
		this.rand = new Random();
	}

	private int total = 0;
	private int index = 0;
	private boolean isFirst = true; // 首次访问

	@SuppressWarnings("rawtypes")
	public Server choose(ILoadBalancer lb, Object key) {
		if (lb == null) {
			return null;
		}
		Server server = null;

		while (server == null) {
			if (Thread.interrupted()) {
				return null;
			}
			List upList = lb.getReachableServers(); // 获取在线的服务
			List allList = lb.getAllServers(); // 获取所有的服务

			int serverCount = allList.size();
			if (serverCount == 0) {
				return null;
			}
			if (isFirst) {
				index = rand.nextInt(serverCount); // 哪台服务器，每台调5次
			}
			if (total < 5) {
				server = (Server) upList.get(index);
				isFirst = false;
				total++;
			} else {
				total = 0;
				isFirst = true;
			}

			if (server == null) {
				Thread.yield();
				continue;
			}

			if (server.isAlive()) {
				return server;
			}

			server = null;
			Thread.yield();
		}

		return server;
	}

	@Override
	public void initWithNiwsConfig(IClientConfig arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Server choose(Object paramObject) {
		return choose(getLoadBalancer(), paramObject);
	}

}
