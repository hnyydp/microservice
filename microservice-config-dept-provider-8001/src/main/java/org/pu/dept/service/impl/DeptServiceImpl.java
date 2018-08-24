package org.pu.dept.service.impl;

import java.util.List;

import org.pu.dept.dao.DeptMapper;
import org.pu.dept.entity.Dept;
import org.pu.dept.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("deptService")
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptMapper deptMapper;

	public List<Dept> selectList() {
		return deptMapper.selectList();
	}

	public Dept selectById(Integer id) {
		return deptMapper.selectById(id);
	}

	public int update(Dept dept) {
		return deptMapper.update(dept);
	}

	public int insert(Dept dept) {
		return deptMapper.insert(dept);
	}

	public int deleteById(Integer id) {
		return deptMapper.deleteById(id);
	}

}
