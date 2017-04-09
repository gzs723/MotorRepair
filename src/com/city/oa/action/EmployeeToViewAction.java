package com.city.oa.action;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.oa.business.IEmployeeBusiness;
import com.city.oa.factory.BusinessFactory;
import com.city.oa.value.EmployeeValue;

/**
 * Servlet implementation class EmployeeToViewAction
 */
@WebServlet("/employee/toview.do")
public class EmployeeToViewAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeToViewAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IEmployeeBusiness employeeBusiness=BusinessFactory.createEmployeeBusiness();
		try
		{
			ServletContext context=request.getServletContext();
			String a=(String) context.getAttribute("g");
			int aa=Integer.parseInt(a);
	
			EmployeeValue ev=employeeBusiness.getEmployee(aa);
			request.setAttribute("ev", ev);
			RequestDispatcher rd=request.getRequestDispatcher("view.jsp");
			rd.forward(request, response);
			
			
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=car", "aa",
//					"1234");         //url,用户名，密码
//			CallableStatement cs=cn.prepareCall("{call select_01(4)}");     //创建存储过程  (4)表示参数为4，例如<4；或者（？）
//			cs.setInt(1, 5);      // 1表示第一个？参数为5
//			cs.execute();        //执行程序
//			ResultSet rs=cs.getResultSet();  //得到rs对象
//           while (rs.next()) {
//				
//				System.out.println(rs.getString("EMPID"));
//				System.out.println(rs.getString("DEPID"));
//				System.out.println(rs.getString("sex"));
//				System.out.println(rs.getInt("tel"));
//				System.out.println(rs.getString("email"));
//				System.out.println(rs.getString("name"));
//			
//		}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("员工查看前分发Servlet错误:"+e.getMessage());
			response.sendRedirect("../error.jsp?message="+e.getMessage());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
