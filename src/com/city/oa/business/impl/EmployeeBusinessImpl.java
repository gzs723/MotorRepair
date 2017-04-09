package com.city.oa.business.impl;

import java.util.List;

import com.city.oa.business.IEmployeeBusiness;
import com.city.oa.dao.IEmployeeDao;
import com.city.oa.factory.DaoFactory;
import com.city.oa.value.EmployeeValue;

public class EmployeeBusinessImpl implements IEmployeeBusiness {

	//取得员工DAO层业务接口对象，通过DAO工厂类获得
			private IEmployeeDao employeeDao=DaoFactory.createEmployeeDao();
	@Override
	public void add(int empid,int depid, String sex, int tel, String email,String name,String password) throws Exception {
		// TODO Auto-generated method stub
		
		EmployeeValue ev=new EmployeeValue();
		ev.setEmpid(empid);
		ev.setDepid(depid);
		ev.setSex(sex);
		ev.setTel(tel);
		ev.setEmail(email);
		ev.setName(name);
		ev.setPassword(password);
		DaoFactory.createEmployeeDao().create(ev);

	}
	
	@Override
	public boolean validate(int id, String password) throws Exception {
		// TODO Auto-generated method stub
		boolean result=false;
		EmployeeValue ev=employeeDao.getEmployee(id);
		if(ev!=null&&ev.getPassword().equals(password))
		{
			result=true;
		}
		
		return result;
	}
	
	
	public EmployeeValue getEmployee(int id) throws Exception {
		// TODO Auto-generated method stub
		return employeeDao.getEmployee(id);
	}
	@Override
	public List<EmployeeValue> getListByAll() throws Exception {
		// TODO Auto-generated method stub
		return employeeDao.getListByAll();
	}

	@Override
	public void delete(int id) throws Exception {

		EmployeeValue ev=new EmployeeValue();
		ev.setEmpid(id);		
		employeeDao.delete(ev);
		
	}

	@Override
	public void modify(String a,int depid, String sex, int tel, String email, String name) throws Exception {
		// TODO Auto-generated method stub
		
		EmployeeValue ev=new EmployeeValue();
		System.out.println(a);
		int empid=Integer.parseInt(a);
		ev.setEmpid(empid);
		ev.setDepid(depid);
		ev.setSex(sex);
		ev.setTel(tel);
		ev.setEmail(email);
		ev.setName(name);
		
		employeeDao.update(ev);
		
	}

	@Override
	public void changePassword(int id, String password) throws Exception {
		// TODO Auto-generated method stub
		
		EmployeeValue ev=employeeDao.getEmployee(id);
		if(ev!=null)
		{
			ev.setPassword(password);
			employeeDao.update(ev);
		}
		
	}



}
