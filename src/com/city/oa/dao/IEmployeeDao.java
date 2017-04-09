package com.city.oa.dao;

import java.util.List;
import com.city.oa.value.EmployeeValue;

public interface IEmployeeDao {

	//����Ա��
			public void create(EmployeeValue ev) throws Exception;
	//ȡ��ָ����Ա���б�
			public EmployeeValue getEmployee(int id) throws Exception;
	//ȡ�����е�Ա��
			public List<EmployeeValue> getListByAll() throws Exception;
	//ɾ���ͻ�
			public void delete(EmployeeValue ev) throws Exception;
	//�޸Ŀͻ���Ϣ
			public void update(EmployeeValue ev) throws Exception;
}
