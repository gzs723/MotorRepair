package com.city.oa.business;

import java.util.List;

import com.city.oa.value.CustomerValue;


public interface ICustomerBusiness {

	 //增加新客户
	       public void add(int cusid, String cusname, String number,int custel) throws Exception;
	//取得指定的员工信息
			public CustomerValue getCustomer(int id) throws Exception;
	//取得所有员工列表
			public List<CustomerValue> getListByAll() throws Exception;
	//删除员工
			public void delete(int id) throws Exception;
	//修改员工
			public void modify(String scusid,String cusname,String carnum,int tel) throws Exception;
}
