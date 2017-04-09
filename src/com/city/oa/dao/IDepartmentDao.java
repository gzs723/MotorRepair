package com.city.oa.dao;

import java.util.List;

import com.city.oa.value.DepartmentValue;


public interface IDepartmentDao {

	//���Ӳ���
		public void create(DepartmentValue dv) throws Exception;
	//ȡ��ָ����Ա���б�
		public DepartmentValue getEmployee(int id) throws Exception;
    //ȡ�����е�Ա��
		public List<DepartmentValue> getListByAll() throws Exception;
	//�޸Ĳ���
		public void update(DepartmentValue dv) throws Exception;
	//ɾ������
		public void delete(DepartmentValue dv) throws Exception;
		
		
}
