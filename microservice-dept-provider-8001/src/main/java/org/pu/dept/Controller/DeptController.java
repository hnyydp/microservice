package org.pu.dept.Controller;

import java.util.List;

import org.pu.dept.entity.Dept;
import org.pu.dept.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
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

	@GetMapping("/depts")
	public List<Dept> depts() {
		return deptService.selectList();
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
}
