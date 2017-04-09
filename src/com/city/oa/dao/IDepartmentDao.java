package com.city.oa.dao;

import java.util.List;

import com.city.oa.value.DepartmentValue;


public interface IDepartmentDao {

	//增加部门
		public void create(DepartmentValue dv) throws Exception;
	//取得指定的员工列表
		public DepartmentValue getEmployee(int id) throws Exception;
    //取得所有的员工
		public List<DepartmentValue> getListByAll() throws Exception;
	//修改部门
		public void update(DepartmentValue dv) throws Exception;
	//删除部门
		public void delete(DepartmentValue dv) throws Exception;
		
		
}
