package com.city.oa.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.city.oa.business.IEmployeeBusiness;
import com.city.oa.factory.BusinessFactory;
import com.city.oa.value.EmployeeValue;

/**
 * Ա����ҳǰ�ַ�������Action
 */
@WebServlet("/employee/tomain.do")
public class EmployeeToMainAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeToMainAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IEmployeeBusiness employeebusiness=BusinessFactory.createEmployeeBusiness();
		try
		{
			List<EmployeeValue> list=employeebusiness.getListByAll();
			request.setAttribute("EmployeeList", list);
			
			RequestDispatcher rd=request.getRequestDispatcher("main.jsp");
						rd.forward(request, response);
			
		}
		catch(Exception e)
		{
			System.out.println("Ա��������ҳ��ǰ�ַ�Servlet����:"+e.getMessage());
			response.sendRedirect("../error.jsp?message="+e.getMessage());
		}
		
		
	}
		
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
