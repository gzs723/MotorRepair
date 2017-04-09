package com.city.oa.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.oa.business.ICustomerBusiness;
import com.city.oa.factory.BusinessFactory;
import com.city.oa.value.CustomerValue;


/**
 * Servlet implementation class CustomerToViewAction
 */
@WebServlet("/customer/toview.do")
public class CustomerToViewAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerToViewAction() {
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
			ServletContext context=request.getServletContext();
			String a=(String) context.getAttribute("g");
			int aa=Integer.parseInt(a);
	
			CustomerValue cv=customerbusiness.getCustomer(aa);
			request.setAttribute("cv", cv);
			RequestDispatcher rd=request.getRequestDispatcher("view.jsp");
			rd.forward(request, response);
			
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
