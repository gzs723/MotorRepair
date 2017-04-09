package com.city.oa.factory;

import com.city.oa.dao.ICustomerDao;
import com.city.oa.dao.IDepartmentDao;
import com.city.oa.dao.IEmployeeDao;
import com.city.oa.dao.impl.CustomerDaoImpl;
import com.city.oa.dao.impl.DepartmentDaoImpl;
import com.city.oa.dao.impl.EmployeeDaoImpl;

public class DaoFactory {

	//部门表
	public static IDepartmentDao createDepartmetnDao() {
		return new DepartmentDaoImpl();
	}
	
	//员工表
	public static IEmployeeDao createEmployeeDao() {
		return new EmployeeDaoImpl();
	}
	
	public static ICustomerDao createCustomerDao() {
		return new CustomerDaoImpl();
	}
	
}
