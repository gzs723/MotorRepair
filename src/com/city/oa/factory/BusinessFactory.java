package com.city.oa.factory;

import com.city.oa.business.ICustomerBusiness;
import com.city.oa.business.IDepartmentBusiness;
import com.city.oa.business.IEmployeeBusiness;
import com.city.oa.business.impl.CustomerBusinessImpl;
import com.city.oa.business.impl.DepartmentBusinessImpl;
import com.city.oa.business.impl.EmployeeBusinessImpl;

public class BusinessFactory {

	//创建部门业务接口实现类对象
		public static IDepartmentBusiness createDepartmentBusiness()
		{
			return new DepartmentBusinessImpl();
		}
	//创建员工业务接口实现类对象
		public static IEmployeeBusiness createEmployeeBusiness()
		{
			return new EmployeeBusinessImpl();
		}
	//创建客户业务接口实现类对象
		public static ICustomerBusiness createCustomerBusiness()
		{
			return new CustomerBusinessImpl();
		}
}
