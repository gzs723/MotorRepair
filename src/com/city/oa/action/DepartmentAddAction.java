package com.city.oa.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.oa.business.IDepartmentBusiness;
import com.city.oa.factory.BusinessFactory;
import com.city.oa.value.DepartmentValue;

/**
 * Servlet implementation class DepartmentAddAction
 */
@WebServlet("/department/add.do")
public class DepartmentAddAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentAddAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		IDepartmentBusiness departmentBusiness=BusinessFactory.createDepartmentBusiness();
		try
		{
			String idepid=request.getParameter("id");
         	String depname=request.getParameter("name");
			String depaddr=request.getParameter("addr");
			String ideptel=request.getParameter("tel");
		
			
			if(idepid==null||idepid.length()==0||depname==null||depname.trim().length()==0||depaddr==null||depaddr.trim().length()==0||ideptel==null||ideptel.trim().length()==0)
			{
				
				response.sendRedirect("toadd.do");
			}
			else
			{
				int depid=Integer.parseInt(idepid);
				int deptel=Integer.parseInt(ideptel);

				DepartmentValue dv=new DepartmentValue();
				departmentBusiness.add(depid, depname, depaddr, deptel);
			
				ServletContext context=request.getServletContext();
				context.setAttribute("g",idepid);
				
				
				response.sendRedirect("../department/toview.do");
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
