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
 * Servlet implementation class CustomerModifyAction
 */
@WebServlet("/customer/modify.do")
public class CustomerModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerModifyAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
	    
		String scusid=request.getParameter("cusid");
		String cusname=request.getParameter("name");
		String carnum=request.getParameter("carnum");
		String stel=request.getParameter("tel");
		
		

	try
	{
		int cusid=0;
		if(scusid!=null&&scusid.trim().length()>0)
		{
			cusid=Integer.parseInt(scusid);
		}
		
		int tel=0;
		if(stel!=null&&stel.trim().length()>0)
		{
			tel=Integer.parseInt(stel);
		}
		
		System.out.println(stel);
		System.out.println(666);
		ICustomerBusiness customerbusiness=BusinessFactory.createCustomerBusiness();
		customerbusiness.modify(scusid, cusname, carnum, tel);

		
		response.sendRedirect("tomain.do");
		
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("客户修改前分发serlet错误！"+e.getMessage());
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
