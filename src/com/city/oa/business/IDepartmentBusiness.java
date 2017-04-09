package com.city.oa.business;

import java.util.List;

import com.city.oa.value.DepartmentValue;


public interface IDepartmentBusiness {

	//增加新部门
	public void add(int depid, String depname, String depaddr, int deptel) throws Exception;
	//取得指定的部门信息
	public DepartmentValue getDepartment(int id) throws Exception;
    //取得所有部门列表
	public List<DepartmentValue> getListByAll() throws Exception;
	//修改部门
	public void modify(String sdepid,String depname,String addr,int tel) throws Exception;
	//删除部门
	public void delete(int id) throws Exception;
}
