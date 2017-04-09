package com.city.oa.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.city.oa.business.ICustomerBusiness;
import com.city.oa.factory.BusinessFactory;
import com.city.oa.value.CustomerValue;

/**
 * Servlet implementation class CustomerToMainAction
 */
@WebServlet("/customer/tomain.do")
public class CustomerToMainAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerToMainAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ICustomerBusiness customerBusiness=BusinessFactory.createCustomerBusiness();
		try
		{
			List<CustomerValue> list=customerBusiness.getListByAll();
			request.setAttribute("customerList", list);
			
			RequestDispatcher rd=request.getRequestDispatcher("main.jsp");
						rd.forward(request, response);
			
		}
		catch(Exception e)
		{
			System.out.println("部门主管理页面前分发Servlet错误:"+e.getMessage());
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
