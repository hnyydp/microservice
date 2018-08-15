package org.pu.dept.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.pu.dept.entity.Dept;

/**
 * 数据库操作
 * 注意添加mybatis @Mapper注解
 * @author dave
 *
 */
@Mapper
public interface DeptMapper {

	@Select("select * from t_dept")
	@Results({ @Result(id = true, column = "dept_id", property = "deptId"),
			@Result(column = "dept_name", property = "deptName") })
	public List<Dept> selectList();

	@Select("select * from t_dept where dept_id = #{id}")
	public Dept selectById(Integer id);

	@Update("update t_dept t set t.dept_name = #{deptName} where dept_id = #{deptId}")
	public int update(Dept dept);

	@Options(useGeneratedKeys = true, keyProperty = "deptId")
	@Insert("insert into t_dept (dept_name) values (#{deptName})")
	public int insert(Dept dept);

	@Delete("delete from t_dept where dept_id = #{id}")
	public int deleteById(Integer id);
}
