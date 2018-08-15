package org.pu.dept.service;

import java.util.List;

import org.pu.dept.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 声明feign接口
 * @author dave
 *
 */
@FeignClient(value = "MICROSERVICE-DEPT")  // 指定调用哪个服务
public interface DeptClientService {

	@GetMapping("/depts")
	public List<Dept> depts();

	@GetMapping("/dept/{id}")
	public Dept dept(@PathVariable(value = "id") Integer id);

	@PostMapping("/dept")
	public Dept insert(@RequestBody Dept dept);

	@PutMapping("/dept")
	public Dept update(@RequestBody Dept dept);

	@DeleteMapping("/dept/{id}")
	public boolean delete(@PathVariable(value = "id") Integer id);
}
