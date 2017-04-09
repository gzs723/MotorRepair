package com.city.oa.business;

import java.util.List;

import com.city.oa.value.EmployeeValue;

public interface IEmployeeBusiness {

    //������Ա��
		public void add(int empid, int depid,String sex, int tel,String email,String name,String password) throws Exception;
    //��֤Ա����¼�Ƿ�Ϸ�
		public boolean validate(int  id,String password) throws Exception;
    //ȡ��ָ����Ա����Ϣ
		public EmployeeValue getEmployee(int id) throws Exception;
	//ȡ������Ա���б�
		public List<EmployeeValue> getListByAll() throws Exception;
	//ɾ��Ա��
		public void delete(int id) throws Exception;
	//�޸�Ա��
		public void modify(String a,int depid,String sex,int tel,String email,String name) throws Exception;
	//�޸�Ա������	
		public void changePassword(int id,String password) throws Exception;
		
}
