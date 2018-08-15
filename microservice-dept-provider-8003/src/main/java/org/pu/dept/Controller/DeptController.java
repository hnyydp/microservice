package org.pu.dept.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.pu.dept.entity.Dept;
import org.pu.dept.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

	@Autowired
	private DeptService deptService;

	@Value("${server.port}")
	private Integer port;
	
	@GetMapping("/depts")
	public List<Dept> depts() {
		//添加端口信息
		List<Dept> list = deptService.selectList();
		return list.stream().map(dept->{
			dept.setPort(port);
			return dept;
		}).collect(Collectors.toList());
	}

	@GetMapping("/dept/{id}")
	public Dept dept(@PathVariable(value = "id") Integer id) {
		return deptService.selectById(id);
	}

	@PostMapping("/dept")
	public Dept insert(@RequestBody Dept dept) {
		deptService.insert(dept);
		return dept;
	}

	@PutMapping("/dept")
	public Dept update(@RequestBody Dept dept) {
		deptService.update(dept);
		return dept;
	}

	@DeleteMapping("/dept/{id}")
	public boolean delete(@PathVariable(value = "id") Integer id) {
		return deptService.deleteById(id) > 0;
	}
	
	@Autowired
	private DiscoveryClient discoveryClient;  //服务发现接口
	
	@GetMapping("/dept/discovery")
	public List<ServiceInstance> discovery(){
		List<String> list = discoveryClient.getServices();  //获取服务列表
		System.out.println("***获取服务列表："+list);
		//返回当前实例信息
		return discoveryClient.getInstances("MICROSERVICE-DEPT");
	}
	
	
}
