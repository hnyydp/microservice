package org.pu.dept.service;

import java.util.List;

import org.pu.dept.entity.Dept;
import org.pu.dept.fallback.DeptClientServiceFallbackFactory;
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
//也可以使用fallback属性，创建一个DeptClientService实现类管理fallback回调方法
//使用fallbackFactory可以获取异常Throwable
@FeignClient(value = "MICROSERVICE-DEPT",fallbackFactory=DeptClientServiceFallbackFactory.class)  // 指定调用哪个服务
//FeignClient(value = "MICROSERVICE-DEPT")
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
