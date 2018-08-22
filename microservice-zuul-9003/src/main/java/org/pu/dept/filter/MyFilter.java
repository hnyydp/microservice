package org.pu.dept.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * 自定义过滤
 * @author dave
 *
 */
@Component
public class MyFilter extends ZuulFilter{

	private Logger logger =  LoggerFactory.getLogger(MyFilter.class);
	
	@Override
	public Object run() throws ZuulException {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		
		logger.info(String.format("****Method:%s, URL:%s*****",request.getMethod(),request.getRequestURL().toString()));
		return null;
	}

	// 判断是否需要过滤
	@Override
	public boolean shouldFilter() {
		return true;
	}

	// 过滤器的优先级，越大越靠后执行
	@Override
	public int filterOrder() {
		return 1;
	}

	/**
	 * 过滤器类型：
	 *  pre：路由之前
	 *	routing：路由之时
	 *	post： 路由之后
	 *	error：发送错误调用
	 */
	@Override
	public String filterType() {
		return "pre";
	}

}
