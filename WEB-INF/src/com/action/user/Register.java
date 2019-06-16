/**
 * 
 */
package com.action.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAOFactory.DAO;
import com.DAOFactory.DAOFactory;
import com.drw.util.RSA_Algorithm;
import com.util.Utility;


public class Register extends HttpServlet 
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out = response.getWriter();
		try
		{
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String add = request.getParameter("add");
			String city = request.getParameter("city");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String groups=request.getParameter("select");
			DAOFactory factory=new DAOFactory();
			DAO dao=factory.getInstance("User");
			boolean result=dao.CHK(id);
			if(!result)
			{
				result=dao.register(id, pass, name, gender, add, city, email,phone,groups);
				if(result)
				{
					String SQL="insert into digkey values(?,?,?)";
					String db_name=Utility.getPro("DB");
					RSA_Algorithm.getKey(id, SQL, db_name, "message".getBytes());
					response.sendRedirect(request.getContextPath()+"?no=4");
				}
				else
					response.sendRedirect(request.getContextPath()+"?no=3");
			}
			else
			{
				response.sendRedirect(request.getContextPath()+"?no=2&no1=5");
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in Register Servlet......"+e);
			out.println("Opps's Error is in Register Servlet......"+e);
		}
	}
}
