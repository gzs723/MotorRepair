package com.city.oa.business;

import java.util.List;

import com.city.oa.value.EmployeeValue;

public interface IEmployeeBusiness {

    //增加新员工
		public void add(int empid, int depid,String sex, int tel,String email,String name,String password) throws Exception;
    //验证员工登录是否合法
		public boolean validate(int  id,String password) throws Exception;
    //取得指定的员工信息
		public EmployeeValue getEmployee(int id) throws Exception;
	//取得所有员工列表
		public List<EmployeeValue> getListByAll() throws Exception;
	//删除员工
		public void delete(int id) throws Exception;
	//修改员工
		public void modify(String a,int depid,String sex,int tel,String email,String name) throws Exception;
	//修改员工密码	
		public void changePassword(int id,String password) throws Exception;
		
}
