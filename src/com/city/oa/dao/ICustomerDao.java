package com.city.oa.dao;

import java.util.List;
import com.city.oa.value.CustomerValue;


public interface ICustomerDao {

	//���ӿͻ�
			public void create(CustomerValue cv) throws Exception;			
	//ɾ���ͻ�
			public void delete(CustomerValue cv) throws Exception;
	//�޸Ŀͻ���Ϣ
			public void update(CustomerValue cv) throws Exception;
	//ȡ��ָ���Ŀͻ��б�
			public CustomerValue getCustomer(int id) throws Exception;
	//ȡ�����еĿͻ�
			public List<CustomerValue> getListByAll() throws Exception;
}
