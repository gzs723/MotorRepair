package com.city.oa.action;

import java.io.IOException;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.oa.business.IEmployeeBusiness;
import com.city.oa.factory.BusinessFactory;
import com.city.oa.value.EmployeeValue;



/**
 * Servlet implementation class EmployeeAddAction
 */
@WebServlet("/employee/add.do")
public class EmployeeAddAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeAddAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			
			request.setCharacterEncoding("utf-8");
			IEmployeeBusiness EmployeeBusiness=BusinessFactory.createEmployeeBusiness();
			try
			{
				String iempid=request.getParameter("id");
				String idepid=request.getParameter("depid");
	         	String name=request.getParameter("name");
				String sex=request.getParameter("sex");
				
				String iemptel=request.getParameter("emptel");
				String email=request.getParameter("email");
				String password=request.getParameter("password");
			    //System.out.println(iempid);
				
				if(iempid==null||iempid.length()==0||idepid==null||idepid.length()==0||name==null||name.trim().length()==0||sex==null||sex.trim().length()==0||iemptel==null||iemptel.trim().length()==0||email==null||email.trim().length()==0)
				{
					
					response.sendRedirect("toadd.do");
				}
				else
				{
					int empid=Integer.parseInt(iempid);
					int depid=Integer.parseInt(idepid);
					int tel=Integer.parseInt(iemptel);
					
					EmployeeValue ev=new EmployeeValue();
					EmployeeBusiness.add(empid, depid, sex, tel, email, name, password);
					ev.setEmpid(empid);
					ev.setDepid(depid);
					ev.setName(name);
					ev.setEmail(email);
					ev.setSex(sex);
					ev.setTel(tel);
					ev.setPassword(password);
					ServletContext context=request.getServletContext();
					context.setAttribute("g",iempid);
				
					response.sendRedirect("../employee/toview.do");
				}
				
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("员工增加处理错误:"+e.getMessage());
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
