package com.city.oa.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.oa.business.IDepartmentBusiness;
import com.city.oa.factory.BusinessFactory;
import com.city.oa.value.DepartmentValue;


/**
 * Servlet implementation class DepartmentToDeleteAction
 */
@WebServlet("/department/todelete.do")
public class DepartmentToDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentToDeleteAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IDepartmentBusiness departmentBusiness=BusinessFactory.createDepartmentBusiness();
		try
		{
			String sid=request.getParameter("no");
			int id=Integer.parseInt(sid);
			DepartmentValue dv=departmentBusiness.getDepartment(id);
			
			
			request.setAttribute("dv", dv);
			RequestDispatcher rd=request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("¿Í»§É¾³ýServlet´íÎó:"+e.getMessage());
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
