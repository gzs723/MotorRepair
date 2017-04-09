package com.city.oa.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public static Connection getConnection(){
		Connection cn=null;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			cn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=car","aa","1234");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("连接工厂错误： "+e.getMessage());
		}
		return cn;
}
}
