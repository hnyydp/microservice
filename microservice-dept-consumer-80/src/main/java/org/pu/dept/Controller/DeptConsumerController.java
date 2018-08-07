package org.pu.dept.Controller;

import java.util.List;

import org.pu.dept.entity.Dept;
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

@RequestMapping("/consumer")
@RestController
public class DeptConsumerController {

	private final static String URL_PREFIX = "http://localhost:8001";

	@Autowired
	private RestTemplate restTemplate;

	@SuppressWarnings("unchecked")
	@GetMapping("/depts")
	public List<Dept> depts() {
		return restTemplate.getForObject(URL_PREFIX + "/depts", List.class);
	}

	@GetMapping("/dept/{id}")
	public Dept dept(@PathVariable(value = "id") Integer id) {
		return restTemplate
				.getForObject(URL_PREFIX + "/dept/" + id, Dept.class);
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

}
