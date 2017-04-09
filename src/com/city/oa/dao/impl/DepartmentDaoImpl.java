package com.city.oa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.city.oa.dao.IDepartmentDao;
import com.city.oa.factory.ConnectionFactory;
import com.city.oa.value.DepartmentValue;


public class DepartmentDaoImpl implements IDepartmentDao {

	@Override
	public void create(DepartmentValue dv) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into department values (?,?,?,?)";
		Connection cn=ConnectionFactory.getConnection();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setInt(1, dv.getDepid());
		ps.setString(2, dv.getDepname());
		ps.setString(3, dv.getDepaddr());
		ps.setInt(4, dv.getDeptel());
		
		ps.executeUpdate();
		ps.close();
		cn.close();

	}

	@Override
	public void update(DepartmentValue dv) throws Exception {
		// TODO Auto-generated method stub
		String sql="update department set DEPName=?,DEPAddr=?,DEPTel=? where DEPID=?";
		Connection cn=ConnectionFactory.getConnection();
		PreparedStatement ps=cn.prepareStatement(sql);
		
		//ps.setInt(1, dv.getDepid());
		ps.setString(1, dv.getDepname());
		ps.setString(2, dv.getDepaddr());
		ps.setInt(3, dv.getDeptel());
		ps.setInt(4, dv.getDepid());

		ps.executeUpdate();
		ps.close();
		cn.close();
	}

	@Override
	public void delete(DepartmentValue dv) throws Exception {
		// TODO Auto-generated method stub
		String sql="delete from department where DEPID=?";
		Connection cn=ConnectionFactory.getConnection();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setInt(1, dv.getDepid());
		ps.executeUpdate();
		ps.close();
		cn.close();

	}

	@Override
	public DepartmentValue getEmployee(int id) throws Exception {

		DepartmentValue dv=null;
		String sql="select *from department where DEPID=?";
		Connection cn=ConnectionFactory.getConnection();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			dv=new DepartmentValue();
			dv.setDepid(id);
			
			dv.setDepname(rs.getString("DEPName"));
			dv.setDepaddr(rs.getString("DEPAddr"));
			dv.setDeptel(rs.getInt("DEPTel"));
			
			
			
			
		}
		rs.close();
		ps.close();
		cn.close();
		return dv;
	}

	@Override
	public List<DepartmentValue> getListByAll() throws Exception {

		List<DepartmentValue> list=new ArrayList<DepartmentValue>();
		String sql="select *from department";
		Connection cn=ConnectionFactory.getConnection();
		PreparedStatement ps=cn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			DepartmentValue dv=new DepartmentValue();
			
			
			dv.setDepid(rs.getInt("DEPID"));
			dv.setDepname(rs.getString("DEPName"));
			dv.setDepaddr(rs.getString("DEPAddr"));
			dv.setDeptel(rs.getInt("DEPTel"));
			
			
			list.add(dv);
		}
		
		rs.close();
		ps.close();
		cn.close();
		
		return list;
	}

}
