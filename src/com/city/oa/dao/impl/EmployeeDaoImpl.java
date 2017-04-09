package com.city.oa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.city.oa.dao.IEmployeeDao;
import com.city.oa.factory.ConnectionFactory;
import com.city.oa.value.EmployeeValue;

public class EmployeeDaoImpl implements IEmployeeDao {

	@Override
	public void create(EmployeeValue ev) throws Exception {
		// TODO Auto-generated method stub

		String sql="insert into employee values (?,?,?,?,?,?,?)";
		Connection cn=ConnectionFactory.getConnection();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setInt(1, ev.getEmpid());
		ps.setInt(2, ev.getDepid());
		ps.setString(3, ev.getSex());
		ps.setInt(4,ev.getTel());
		ps.setString(5,ev.getEmail());
		ps.setString(6,ev.getName());
		ps.setString(7,ev.getPassword());
		
		
		ps.executeUpdate();
		ps.close();
		cn.close();
	}

	@Override
	public EmployeeValue getEmployee(int id) throws Exception {
		EmployeeValue ev=null;
		String sql="select * from employee where EMPID=?";
		Connection cn=ConnectionFactory.getConnection();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			ev=new EmployeeValue();
			ev.setEmpid(id);
			ev.setDepid(rs.getInt("DEPID"));
			ev.setSex(rs.getString("sex"));
			ev.setTel(rs.getInt("tel"));
			ev.setEmail(rs.getString("email"));
			ev.setName(rs.getString("name"));
			ev.setPassword(rs.getString("password"));
			
			
			
		}
		rs.close();
		ps.close();
		cn.close();
		return ev;
		
	}

	@Override
	public List<EmployeeValue> getListByAll() throws Exception {
		
		List<EmployeeValue> list=new ArrayList<EmployeeValue>();
		String sql="select *from employee";
		Connection cn=ConnectionFactory.getConnection();
		PreparedStatement ps=cn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			EmployeeValue ev=new EmployeeValue();
			//System.out.println(rs.getInt("EMPID"));
			ev.setEmpid(rs.getInt("EMPID"));
			ev.setDepid(rs.getInt("DEPID"));
			ev.setSex(rs.getString("sex"));
			ev.setTel(rs.getInt("tel"));
			ev.setEmail(rs.getString("email"));
			ev.setName(rs.getString("name"));
			ev.setPassword(rs.getString("password"));
			
			list.add(ev);
		}
		
		rs.close();
		ps.close();
		cn.close();
		
		return list;
	}

	@Override
	public void delete(EmployeeValue ev) throws Exception {
		
		String sql="delete from employee where EMPID=?";
		Connection cn=ConnectionFactory.getConnection();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setInt(1, ev.getEmpid());
		ps.executeUpdate();
		ps.close();
		cn.close();
		
	}

	@Override
	public void update(EmployeeValue ev) throws Exception {
		String sql="update employee set DEPID=?,sex=?,tel=?,email=?,name=? where EMPID=?";
		Connection cn=ConnectionFactory.getConnection();
		PreparedStatement ps=cn.prepareStatement(sql);
		
		ps.setInt(1, ev.getDepid());
		ps.setString(2, ev.getSex());
		ps.setInt(3, ev.getTel());
		ps.setString(4, ev.getEmail());
		ps.setString(5,ev.getName());
		
		ps.setInt(6,ev.getEmpid());
		
		
		ps.executeUpdate();
		ps.close();
		cn.close();
		
	}
	}


