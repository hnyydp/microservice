package org.pu.dept.Controller;

import java.util.List;

import org.pu.dept.entity.Dept;
import org.pu.dept.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/consumer")
@RestController
public class DeptConsumerController {

	@Autowired
	private DeptClientService deptClientService;  //使用Feign接口
	
	@GetMapping("/depts")
	public List<Dept> depts() {
		return deptClientService.depts();
	}

	@GetMapping("/dept/{id}")
	public Dept dept(@PathVariable(value = "id") Integer id) {
		return deptClientService.dept(id);
	}

	@PostMapping("/dept")
	public Dept insert(@RequestBody Dept dept) {
		return deptClientService.insert(dept);
	}

	@PutMapping("/dept")
	public Dept update(@RequestBody Dept dept) {
		return deptClientService.update(dept);
	}

	@DeleteMapping("/dept/{id}")
	public boolean delete(@PathVariable(value = "id") Integer id) {
		try {
			deptClientService.delete(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
