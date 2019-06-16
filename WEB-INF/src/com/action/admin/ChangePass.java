/**
 * 
 */
package com.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAOFactory.DAO;
import com.DAOFactory.DAOFactory;

public class ChangePass extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException 
	{
		PrintWriter out=response.getWriter();
		try
		{
			int no=Integer.parseInt(request.getParameter("no"));
			if(no==1)
			{
				String name=request.getParameter("name");
				request.setAttribute("admin",name);
				RequestDispatcher rd=request.getRequestDispatcher("/Files/JSP/Admin/changepass.jsp?no=0");
				rd.forward(request, response);
			}
			if(no==2)
			{
				int id=Integer.parseInt(request.getParameter("id"));
				String pass=request.getParameter("pass");
				String npass=request.getParameter("npass");
				String cpass=request.getParameter("cpass");
				String admin=request.getParameter("admin");
				System.out.println("password is  "+pass);
				System.out.println("new password is  "+npass);
				System.out.println("confirm new password is  "+cpass);
				System.out.println("name of admin is  "+admin);
				request.setAttribute("admin", admin);
				DAOFactory factory=new DAOFactory();
				DAO dao=factory.getInstance("Admin");
				boolean result=dao.loginCHK(admin, pass);

				System.out.println("result is  "+result);
				if(result)
				{
					if(npass.equals(cpass))
					{
						result=dao.chnagePass(id, cpass);
						if(result)
						{
							ResultSet rs=dao.getProfile(admin);
							request.setAttribute("rs",rs);
							RequestDispatcher rd=request.getRequestDispatcher("/Files/JSP/Admin/profile.jsp?no=0&no1=1");
							rd.forward(request, response);
						}
						else
						{
							RequestDispatcher rd=request.getRequestDispatcher("/Files/JSP/Admin/changepass.jsp?no=3");
							rd.forward(request, response);
						}
					}
					else
					{
						RequestDispatcher rd=request.getRequestDispatcher("/Files/JSP/Admin/changepass.jsp?no=2");
						rd.forward(request, response);
					}
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("/Files/JSP/Admin/changepass.jsp?no=1");
					rd.forward(request, response);

					
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in Admin ChangePass Servlet......"+e);
			out.println("Opps's Error is in Admin ChangePass Servlet......"+e);
		}
	}
}
