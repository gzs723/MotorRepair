package com.city.oa.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.oa.business.IDepartmentBusiness;
import com.city.oa.factory.BusinessFactory;

/**
 * Servlet implementation class DepartmentModifyAction
 */
@WebServlet("/department/modify.do")
public class DepartmentModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentModifyAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
	    
		String sdepid=request.getParameter("depid");
		String depname=request.getParameter("depname");
		String addr=request.getParameter("depaddr");
		String stel=request.getParameter("deptel");
	
		

	try
	{
//		int depid=0;
//		if(sdepid!=null&&sdepid.trim().length()>0)
//		{
//			depid=Integer.parseInt(sdepid);
//		}
		
		int tel=0;
		if(stel!=null&&stel.trim().length()>0)
		{
			tel=Integer.parseInt(stel);
		}
		
		//System.out.println(stel);
		//System.out.println(666);
		IDepartmentBusiness departmentbusiness=BusinessFactory.createDepartmentBusiness();
		departmentbusiness.modify(sdepid, depname, addr, tel);
		
		response.sendRedirect("tomain.do");
		
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("员工修改后分发Servlet错误"+e.getMessage());
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
