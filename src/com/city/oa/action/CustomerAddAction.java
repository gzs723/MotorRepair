package com.city.oa.action;

import java.io.IOException;

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
 * Servlet implementation class CustomerAddAction
 */
@WebServlet("/customer/add.do")
public class CustomerAddAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerAddAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		ICustomerBusiness customerBusiness=BusinessFactory.createCustomerBusiness();
		try
		{
			String icusid=request.getParameter("id");
         	String cusname=request.getParameter("name");
			String number=request.getParameter("carnum");
			String icustel=request.getParameter("tel");
			
		
			
			if(icusid==null||icusid.length()==0||cusname==null||cusname.length()==0||number==null||number.trim().length()==0||icustel==null||icustel.trim().length()==0)
			{
				
				response.sendRedirect("toadd.do");
			}
			else
			{
				int cusid=Integer.parseInt(icusid);
				int custel=Integer.parseInt(icustel);
				
				CustomerValue cv=new CustomerValue();
				customerBusiness.add(cusid, cusname, number, custel);
				cv.setCusid(cusid);
				cv.setCusname(cusname);
				cv.setNumber(number);
				cv.setCustel(custel);
				
				ServletContext context=request.getServletContext();
				context.setAttribute("g",icusid);
				response.sendRedirect("../customer/toview.do");
			}
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("部门主页前分发Servlet错误:"+e.getMessage());
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
