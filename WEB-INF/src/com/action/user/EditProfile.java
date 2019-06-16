/**
 * 
 */
package com.action.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAOFactory.DAO;
import com.DAOFactory.DAOFactory;
import com.util.Utility;


public class EditProfile extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException 
	{
		PrintWriter out=response.getWriter();
		try
		{
			int no=Integer.parseInt(request.getParameter("no"));
			DAOFactory factory=new DAOFactory();
			DAO dao=factory.getInstance("User");
			if(no==1)
			{
				String name=request.getParameter("name");
				ResultSet rs=dao.getProfile(name);
				if(rs.next())
				{
					rs=dao.getProfile(name);
					request.setAttribute("rs",rs);
					request.setAttribute("user", name);
					RequestDispatcher rd=request.getRequestDispatcher("/Files/JSP/User/editprof.jsp?no=0");
					rd.forward(request, response);
				}
				else
					response.sendRedirect(request.getContextPath()+"/Files/JSP/User/editprof.jsp?no=1");

			}
			if(no==2)
			{
				String name=request.getParameter("user");
				String [] s=new String [7];
				s[0] =request.getParameter("id");
				s[1]=request.getParameter("name");
				s[2]=request.getParameter("gender");
				s[3]=request.getParameter("add");
				s[4]=request.getParameter("city");
				s[5]=request.getParameter("email");
				s[6]=request.getParameter("phone");
				boolean result=dao.editProfile(s);
				if(result)
				{
					ResultSet rs=dao.getProfile(name);
					request.setAttribute("rs",rs);
					request.setAttribute("user", name);
					Utility.writeOnFile(name+".txt", "User has edited profile on date "+Utility.getDate()+" and time "+Utility.getTime()+"", getServletContext().getRealPath("/"));
					RequestDispatcher rd=request.getRequestDispatcher("/Files/JSP/User/profile.jsp?no=0&no1=1");
					rd.forward(request, response);
				}
				else
					response.sendRedirect(request.getContextPath()+"/Files/JSP/User/editprof.jsp?no=1");
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in User EditProfile Servlet......"+e);
			out.println("Opps's Error is in User EditProfile Servlet......"+e);
		}
	}
}
