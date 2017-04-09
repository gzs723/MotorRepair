package com.city.oa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.city.oa.dao.ICustomerDao;
import com.city.oa.factory.ConnectionFactory;
import com.city.oa.value.CustomerValue;


public class CustomerDaoImpl implements ICustomerDao {

	@Override
	public void create(CustomerValue cv) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into customer values (?,?,?,?)";
		Connection cn=ConnectionFactory.getConnection();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setInt(1, cv.getCusid());
		ps.setString(2, cv.getCusname());
		ps.setString(3, cv.getNumber());
		ps.setInt(4,cv.getCustel());
		
		
		ps.executeUpdate();
		ps.close();
		cn.close();

	}

	@Override
	public void delete(CustomerValue cv) throws Exception {
		// TODO Auto-generated method stub

		String sql="delete from customer where cusid=?";
		Connection cn=ConnectionFactory.getConnection();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setInt(1, cv.getCusid());
		ps.executeUpdate();
		ps.close();
		cn.close();
		
	}

	@Override
	public void update(CustomerValue cv) throws Exception {
		// TODO Auto-generated method stub
		String sql="update customer set cusname=?,[plate number]=?,custel=? where cusid=?";
		Connection cn=ConnectionFactory.getConnection();
		PreparedStatement ps=cn.prepareStatement(sql);
		
		
		ps.setString(1, cv.getCusname());
		ps.setString(2, cv.getNumber());
		ps.setInt(3, cv.getCustel());
		ps.setInt(4, cv.getCusid());
		
		
		ps.executeUpdate();
		ps.close();
		cn.close();
		
	}

	@Override
	public CustomerValue getCustomer(int id) throws Exception {
		CustomerValue cv=null;
		String sql="select * from customer where cusid=?";
		Connection cn=ConnectionFactory.getConnection();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			cv=new CustomerValue();
			cv.setCusid(id);
			cv.setCusname(rs.getString("cusname"));
			cv.setNumber(rs.getString("plate number"));
			cv.setCustel(rs.getInt("custel"));
		}
		rs.close();
		ps.close();
		cn.close();
		return cv;
	}

	@Override
	public List<CustomerValue> getListByAll() throws Exception {
		
		List<CustomerValue> list=new ArrayList<CustomerValue>();
		String sql="select *from customer";
		Connection cn=ConnectionFactory.getConnection();
		PreparedStatement ps=cn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			CustomerValue cv=new CustomerValue();
			
			cv.setCusid(rs.getInt("cusid"));
			cv.setCusname(rs.getString("cusname"));
			cv.setNumber(rs.getString("plate number"));
			cv.setCustel(rs.getInt("custel"));
			
			list.add(cv);
		}
		
		rs.close();
		ps.close();
		cn.close();
		
		return list;
	}

}
