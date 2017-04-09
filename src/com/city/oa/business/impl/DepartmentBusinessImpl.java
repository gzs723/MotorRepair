package com.city.oa.business.impl;

import java.util.List;

import com.city.oa.business.IDepartmentBusiness;
import com.city.oa.dao.IDepartmentDao;
import com.city.oa.factory.DaoFactory;
import com.city.oa.value.DepartmentValue;



public class DepartmentBusinessImpl implements IDepartmentBusiness {

	//取得部门DAO层业务接口对象，通过DAO工厂类获得
		private IDepartmentDao departmentDao=DaoFactory.createDepartmetnDao();

	@Override
	public void add(int depid, String depname, String depaddr, int deptel) throws Exception{
		// TODO Auto-generated method stub
		DepartmentValue dv=new DepartmentValue();
		dv.setDepid(depid);
		dv.setDepname(depname);
		dv.setDepaddr(depaddr);
		dv.setDeptel(deptel);
		DaoFactory.createDepartmetnDao().create(dv);

	}



	@Override
	public DepartmentValue getDepartment(int id) throws Exception {
		// TODO Auto-generated method stub
		return departmentDao.getEmployee(id);
	}

	@Override
	public List<DepartmentValue> getListByAll() throws Exception {
		// TODO Auto-generated method stub
		return departmentDao.getListByAll();
	}



	@Override
	public void modify(String sdepid, String depname, String addr, int tel) throws Exception {
		// TODO Auto-generated method stub
		DepartmentValue dv=new DepartmentValue();
		
		int depid=Integer.parseInt(sdepid);
		dv.setDepid(depid);
		dv.setDepname(depname);
		dv.setDepaddr(addr);
		dv.setDeptel(tel);
		
		
		
		departmentDao.update(dv);
		
	}

	@Override
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		DepartmentValue dv=new DepartmentValue();
		dv.setDepid(id);
		departmentDao.delete(dv);
		
	}

}
