package com.city.oa.business;

import java.util.List;

import com.city.oa.value.CustomerValue;


public interface ICustomerBusiness {

	 //�����¿ͻ�
	       public void add(int cusid, String cusname, String number,int custel) throws Exception;
	//ȡ��ָ����Ա����Ϣ
			public CustomerValue getCustomer(int id) throws Exception;
	//ȡ������Ա���б�
			public List<CustomerValue> getListByAll() throws Exception;
	//ɾ��Ա��
			public void delete(int id) throws Exception;
	//�޸�Ա��
			public void modify(String scusid,String cusname,String carnum,int tel) throws Exception;
}
