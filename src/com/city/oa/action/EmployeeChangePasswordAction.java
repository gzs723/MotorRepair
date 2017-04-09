package com.city.oa.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class EmployeeChangePasswordAction
 */
@WebServlet("/employee/changepassword.do")
public class EmployeeChangePasswordAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeChangePasswordAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
          IEmployeeBusiness employeeBusiness=BusinessFactory.createEmployeeBusiness();
		
		try
		{
			String oldpassword=request.getParameter("oldpassword");
			String newpassword=request.getParameter("newpassword");
			String newpasswordconfirm=request.getParameter("newpasswordconfirm");
			
			HttpSession session=request.getSession();
			EmployeeValue ev=(EmployeeValue)session.getAttribute("employee");
			//判断员工旧密码输入正确，且新密码与确认密码相符才进行密码修改
			if(ev!=null&&ev.getPassword().equals(oldpassword)&&newpassword!=null&&newpassword.trim().length()>0&&newpasswordconfirm!=null&&newpasswordconfirm.trim().length()>0&&newpasswordconfirm.equals(newpassword))
			{
				employeeBusiness.changePassword(ev.getEmpid(), newpassword);
				RequestDispatcher rd=request.getRequestDispatcher("changepasswordconfirm.jsp");
				rd.forward(request, response);
				
			}
			else
			{
				response.sendRedirect("tochangepassword.do");
			}
			
		}
		catch(Exception e)
		{
			System.out.println("员工修改密码后处理分发Servlet错误:"+e.getMessage());
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
