package com.city.oa.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.oa.business.IEmployeeBusiness;
import com.city.oa.factory.BusinessFactory;

/**
 * Servlet implementation class EmployeeDeleteAction
 */
@WebServlet("/employee/delete.do")
public class EmployeeDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeDeleteAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			
			String sid=request.getParameter("no");
			int id=Integer.parseInt(sid);
			
			IEmployeeBusiness employeeBusiness=BusinessFactory.createEmployeeBusiness();
			employeeBusiness.delete(id);
			response.sendRedirect("tomain.do");
		}
		catch(Exception e)
		{
			System.out.println("员工删除处理错误"+e.getMessage());
			response.sendRedirect("../error.jsp?mess="+e.getMessage());
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
