package com.city.oa.factory;

import com.city.oa.dao.ICustomerDao;
import com.city.oa.dao.IDepartmentDao;
import com.city.oa.dao.IEmployeeDao;
import com.city.oa.dao.impl.CustomerDaoImpl;
import com.city.oa.dao.impl.DepartmentDaoImpl;
import com.city.oa.dao.impl.EmployeeDaoImpl;

public class DaoFactory {

	//���ű�
	public static IDepartmentDao createDepartmetnDao() {
		return new DepartmentDaoImpl();
	}
	
	//Ա����
	public static IEmployeeDao createEmployeeDao() {
		return new EmployeeDaoImpl();
	}
	
	public static ICustomerDao createCustomerDao() {
		return new CustomerDaoImpl();
	}
	
}
