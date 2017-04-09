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
 * Servlet implementation class EmployeeModifyAction
 */
@WebServlet("/employee/modify.do")
public class EmployeeModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeModifyAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		    request.setCharacterEncoding("utf-8");
		    
			String sempid=request.getParameter("empid");
			String sdepid=request.getParameter("depid");
			String sex=request.getParameter("sex");
			String stel=request.getParameter("tel");
			String email=request.getParameter("email");
			String name=request.getParameter("name");
			

		try
		{
			int depid=0;
			if(sdepid!=null&&sdepid.trim().length()>0)
			{
				depid=Integer.parseInt(sdepid);
			}
			
			int tel=0;
			if(stel!=null&&stel.trim().length()>0)
			{
				tel=Integer.parseInt(stel);
			}
			
			System.out.println(stel);
			System.out.println(666);
			IEmployeeBusiness employeeBusiness=BusinessFactory.createEmployeeBusiness();
			employeeBusiness.modify(sempid,depid, sex, tel, email, name);

			
			response.sendRedirect("tomain.do");
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("员工修改前分发serlet错误！"+e.getMessage());
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
