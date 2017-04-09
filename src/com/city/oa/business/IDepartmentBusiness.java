package com.city.oa.business;

import java.util.List;

import com.city.oa.value.DepartmentValue;


public interface IDepartmentBusiness {

	//�����²���
	public void add(int depid, String depname, String depaddr, int deptel) throws Exception;
	//ȡ��ָ���Ĳ�����Ϣ
	public DepartmentValue getDepartment(int id) throws Exception;
    //ȡ�����в����б�
	public List<DepartmentValue> getListByAll() throws Exception;
	//�޸Ĳ���
	public void modify(String sdepid,String depname,String addr,int tel) throws Exception;
	//ɾ������
	public void delete(int id) throws Exception;
}
