package com.city.oa.dao;

import java.util.List;
import com.city.oa.value.CustomerValue;


public interface ICustomerDao {

	//增加客户
			public void create(CustomerValue cv) throws Exception;			
	//删除客户
			public void delete(CustomerValue cv) throws Exception;
	//修改客户信息
			public void update(CustomerValue cv) throws Exception;
	//取得指定的客户列表
			public CustomerValue getCustomer(int id) throws Exception;
	//取得所有的客户
			public List<CustomerValue> getListByAll() throws Exception;
}
