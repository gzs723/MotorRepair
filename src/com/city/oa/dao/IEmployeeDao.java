package com.city.oa.dao;

import java.util.List;
import com.city.oa.value.EmployeeValue;

public interface IEmployeeDao {

	//增加员工
			public void create(EmployeeValue ev) throws Exception;
	//取得指定的员工列表
			public EmployeeValue getEmployee(int id) throws Exception;
	//取得所有的员工
			public List<EmployeeValue> getListByAll() throws Exception;
	//删除客户
			public void delete(EmployeeValue ev) throws Exception;
	//修改客户信息
			public void update(EmployeeValue ev) throws Exception;
}
