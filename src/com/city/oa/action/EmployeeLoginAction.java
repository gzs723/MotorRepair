package com.city.oa.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.city.oa.business.IEmployeeBusiness;
import com.city.oa.factory.BusinessFactory;
import com.city.oa.value.EmployeeValue;

/**
 * Servlet implementation class EmployeeLoginAction
 */
@WebServlet("/login.do")
public class EmployeeLoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String iuserid=request.getParameter("userid");
		String password=request.getParameter("password");
		if(iuserid==null||iuserid.trim().length()==0)
		{
			
			response.sendRedirect("login.jsp?mess=账号为空");
		}
		else if(password==null||password.trim().length()==0)
		{
			response.sendRedirect("login.jsp?mess=密码为空");
		}
		else
		{
		
			IEmployeeBusiness employeeBusiness=BusinessFactory.createEmployeeBusiness();
			int userid=Integer.parseInt(iuserid);
			try
			{
				if(!employeeBusiness.validate(userid, password))
				{
					response.sendRedirect("login.jsp?mess=员工验证失败");
				}
				else
				{
					EmployeeValue ev=employeeBusiness.getEmployee(userid);
					HttpSession session=request.getSession();
					//保存员工的登录会话信息
					session.setAttribute("employee", ev);
					
					response.sendRedirect("home/main.do");
				}
			}
			catch(Exception e)
			{
				System.out.println("员工登录处理错误"+e.getMessage());
				response.sendRedirect("error.jsp?mess="+e.getMessage());
				
			}
			
			
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
