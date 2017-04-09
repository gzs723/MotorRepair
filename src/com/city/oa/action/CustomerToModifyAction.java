package com.city.oa.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.oa.business.ICustomerBusiness;
import com.city.oa.business.IEmployeeBusiness;
import com.city.oa.factory.BusinessFactory;
import com.city.oa.value.CustomerValue;
import com.city.oa.value.EmployeeValue;

/**
 * Servlet implementation class CustomerToModifyAction
 */
@WebServlet("/customer/tomodify.do")
public class CustomerToModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerToModifyAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ICustomerBusiness customerbusiness=BusinessFactory.createCustomerBusiness();
		try
		{
		
			String sid=request.getParameter("no");
			int id=Integer.parseInt(sid);
			CustomerValue cv=customerbusiness.getCustomer(id);
			request.setAttribute("cv", cv);
			RequestDispatcher rd=request.getRequestDispatcher("modify.jsp");
			rd.forward(request, response);
			
		}
		catch(Exception e)
		{
			System.out.println("员工修改前分发Servlet错误:"+e.getMessage());
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
