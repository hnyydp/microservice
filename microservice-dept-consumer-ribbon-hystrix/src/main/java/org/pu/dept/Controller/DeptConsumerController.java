package org.pu.dept.Controller;

import java.util.List;

import org.pu.dept.entity.Dept;
import org.pu.dept.util.ValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RequestMapping("/consumer")
@RestController
public class DeptConsumerController {

	// private final static String URL_PREFIX = "http://localhost:8001";
	// Euraka整合Ribbon配置OK后就可以使用服务实例名访问，不需要提供IP和端口
	private final static String URL_PREFIX = "http://MICROSERVICE-DEPT";

	@Autowired
	private RestTemplate restTemplate;

	@SuppressWarnings("unchecked")
	@GetMapping("/depts")
	@HystrixCommand(fallbackMethod="fallBack_depts")
	public List<Dept> depts() {
		return restTemplate.getForObject(URL_PREFIX + "/depts", List.class);
	}

	@GetMapping("/dept/{id}")
	@HystrixCommand(fallbackMethod = "fallBack_dept")
	public Dept dept(@PathVariable(value = "id") Integer id) {
		Dept dept = restTemplate.getForObject(URL_PREFIX + "/dept/" + id,
				Dept.class);

		// 模拟产生异常，Hystrix实现服务熔断
		// 当服务调用抛出异常时，会自动调用@HystrixCommand中指定的fallback的方法
		if (dept == null) {
			throw new RuntimeException("没有找到ID:" + id + "对应的部门信息！");
		}

		return dept;
	}

	@PostMapping("/dept")
	public Dept insert(@RequestBody Dept dept) {
		return restTemplate.postForObject(URL_PREFIX + "/dept", dept,
				Dept.class);
	}

	@PutMapping("/dept")
	public Dept update(@RequestBody Dept dept) {
		restTemplate.put(URL_PREFIX + "/dept", dept, Dept.class);
		return dept;
	}

	@DeleteMapping("/dept/{id}")
	public boolean delete(@PathVariable(value = "id") Integer id) {
		try {
			restTemplate.delete(URL_PREFIX + "/dept/" + id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// ******************************//

	// 异常传入回退方法
	public Dept fallBack_dept(@PathVariable(value = "id") Integer id) {
		Dept dept = new Dept();
		return dept.setDeptId(id).setDeptName("没有找到ID:" + id + "对应的部门信息！");
	}

	// 服务超时或中断
	public List<Dept> fallBack_depts() {
		return ValueUtil.toList(new Dept().setDeptId(500).setDeptName(
				"Error ---  服务异常"));
	}

	// ******************************//

}
