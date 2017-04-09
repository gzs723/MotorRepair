package com.city.oa.factory;

import com.city.oa.business.ICustomerBusiness;
import com.city.oa.business.IDepartmentBusiness;
import com.city.oa.business.IEmployeeBusiness;
import com.city.oa.business.impl.CustomerBusinessImpl;
import com.city.oa.business.impl.DepartmentBusinessImpl;
import com.city.oa.business.impl.EmployeeBusinessImpl;

public class BusinessFactory {

	//��������ҵ��ӿ�ʵ�������
		public static IDepartmentBusiness createDepartmentBusiness()
		{
			return new DepartmentBusinessImpl();
		}
	//����Ա��ҵ��ӿ�ʵ�������
		public static IEmployeeBusiness createEmployeeBusiness()
		{
			return new EmployeeBusinessImpl();
		}
	//�����ͻ�ҵ��ӿ�ʵ�������
		public static ICustomerBusiness createCustomerBusiness()
		{
			return new CustomerBusinessImpl();
		}
}
