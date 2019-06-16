/**
 * 
 */
package com.action.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAOFactory.DAO;
import com.DAOFactory.DAOFactory;
import com.util.Utility;


public class Login extends HttpServlet 
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out = response.getWriter();
		HttpSession session =request.getSession();
		try
		{
			String name=request.getParameter("name");
			String pass=request.getParameter("pass");
			DAOFactory factory=new DAOFactory();
			DAO dao=factory.getInstance("User");
			boolean result=dao.loginCHK(name, pass);
			if(result)
			{
				request.setAttribute("user", name);
				session.setAttribute("userid", name);
				Utility.writeOnFile(name+".txt", "Successfully Logged in on date "+Utility.getDate()+" and time "+Utility.getTime()+"", getServletContext().getRealPath("/"));
				RequestDispatcher rd=request.getRequestDispatcher("/Files/JSP/User/home.jsp");
				rd.forward(request, response);
			}
			else
			{
				response.sendRedirect(request.getContextPath()+"?no=1");
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in UserLogin Servlet......"+e);
			out.println("Opps's Error is in UserLogin Servlet......"+e);
		}
	}
}
