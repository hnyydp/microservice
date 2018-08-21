package org.pu.dept.fallback;

import java.util.List;

import org.pu.dept.entity.Dept;
import org.pu.dept.service.DeptClientService;
import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

@Component
public class DeptClientServiceFallbackFactory implements
		FallbackFactory<DeptClientService> {

	@Override
	public DeptClientService create(Throwable e) {
		return new DeptClientService() {

			@Override
			public Dept update(Dept dept) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Dept insert(Dept dept) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public List<Dept> depts() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Dept dept(Integer id) {
				return new Dept().setDeptId(500).setDeptName(
						"Error,调用服务异常！" + e.getMessage());
			}

			@Override
			public boolean delete(Integer id) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}

}
