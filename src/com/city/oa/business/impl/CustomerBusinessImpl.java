package com.city.oa.business.impl;

import java.util.List;

import com.city.oa.business.ICustomerBusiness;
import com.city.oa.dao.ICustomerDao;
import com.city.oa.factory.DaoFactory;
import com.city.oa.value.CustomerValue;


public class CustomerBusinessImpl implements ICustomerBusiness {

	//取得客户DAO层业务接口对象，通过DAO工厂类获得
		private ICustomerDao customerDao=DaoFactory.createCustomerDao();
	@Override
	public void add(int cusid, String cusname, String number, int custel) throws Exception {
		// TODO Auto-generated method stub

		CustomerValue cv=new CustomerValue();
		cv.setCusid(cusid);
		cv.setCusname(cusname);
		cv.setNumber(number);
		cv.setCustel(custel);
		
		DaoFactory.createCustomerDao().create(cv);
	}

	@Override
	public CustomerValue getCustomer(int id) throws Exception {
		// TODO Auto-generated method stub
		return customerDao.getCustomer(id);
	}

	@Override
	public List<CustomerValue> getListByAll() throws Exception {
		// TODO Auto-generated method stub
		return customerDao.getListByAll();
	}

	@Override
	public void delete(int id) throws Exception {
		CustomerValue cv=new CustomerValue();
		cv.setCusid(id);
		customerDao.delete(cv);
	}

	@Override
	public void modify(String scusid, String cusname, String carnum, int tel) throws Exception {
		// TODO Auto-generated method stub
		CustomerValue cv=new CustomerValue();
		
		int cusid=Integer.parseInt(scusid);
		cv.setCusid(cusid);
		cv.setCusname(cusname);
		cv.setNumber(carnum);
		cv.setCustel(tel);
		
		customerDao.update(cv);
		
	}

}
