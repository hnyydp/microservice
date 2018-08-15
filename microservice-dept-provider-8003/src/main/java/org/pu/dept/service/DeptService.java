package org.pu.dept.service;

import java.util.List;

import org.pu.dept.entity.Dept;

public interface DeptService {
	//查询所有
	public List<Dept> selectList();
	//通过ID查询
	public Dept selectById(Integer id);
	//更新
	public int update(Dept dept);
	//插入
	public int insert(Dept dept);
	//删除
	public int deleteById(Integer id);
}
