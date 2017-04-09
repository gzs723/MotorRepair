package com.city.oa.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.oa.business.ICustomerBusiness;
import com.city.oa.factory.BusinessFactory;

/**
 * Servlet implementation class CustomerDeleteAction
 */
@WebServlet("/customer/delete.do")
public class CustomerDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerDeleteAction() {
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
			
			ICustomerBusiness customerbusiness=BusinessFactory.createCustomerBusiness();
			customerbusiness.delete(id);
			response.sendRedirect("tomain.do");
		}
		catch(Exception e)
		{
			System.out.println("�ͻ�ɾ����������"+e.getMessage());
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
