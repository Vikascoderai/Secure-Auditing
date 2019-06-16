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

import com.DAOFactory.Admin;
import com.DAOFactory.CommonDAO;
import com.DAOFactory.DAO;
import com.DAOFactory.DAOFactory;
import com.drw.util.RSA_Algorithm;
import com.util.Utility;


public class UserList extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
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
			String submit=request.getParameter("submit");
			System.out.println("value of submit button in user list issss  "+submit);
			DAOFactory factory=new DAOFactory();
			DAO dao=factory.getInstance("Admin");
			ResultSet rs=dao.getUsers();
			RequestDispatcher rd=null;
			if(submit.equals("get"))
			{
				if(rs.next())
				{
					rs=dao.getUsers();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Files/JSP/Admin/users.jsp");
					rd.forward(request, response);
				}
				else
				{
					rd=request.getRequestDispatcher("/Files/JSP/Admin/users.jsp?no=-1");
					rd.forward(request, response);
				}
			}
			if(submit.equals("Add"))
			{
				if(com.util.Utility.parse1(request.getParameter("add1")).equals("YES"))
				{
				
					boolean result=dao.CHK(id);
					if(!result)
					{
						result=dao.register(id, pass, name, gender, add, city, email,phone, groups);
						/*ResultSet rs1=Admin.getGroups();
						int no=0;
						while (rs1.next())
						{
							no=rs1.getInt(3);
						}
						no=no+1;
						boolean noo=Admin.editno(no,groups);
						System.out.println("value of noooooooooooo is"+noo);
						*/
						if(result)
						{
							
							/*String SQL="insert into digkey values(?,?,?)";
							String db_name=Utility.getPro("DB");
							RSA_Algorithm.getKey(id, SQL, db_name, "message".getBytes());*/
							rs=dao.getUsers();
							request.setAttribute("rs", rs);
							rd=request.getRequestDispatcher("/Files/JSP/Admin/users.jsp?no=1");
							rd.forward(request, response);
						}
						else
						{
							
							response.sendRedirect(request.getContextPath()+"/Files/JSP/Admin/adduser.jsp?no=1");
						}
					}
					else
					{
						
						response.sendRedirect(request.getContextPath()+"/Files/JSP/Admin/adduser.jsp?no=1");
					}
				}
				else
				{
					
					response.sendRedirect(request.getContextPath()+"/Files/JSP/Admin/adduser.jsp");
					
				}
			}
			if(submit.equals("Edit"))
			{
				String []chk=request.getParameterValues("chk");
				if(com.util.Utility.parse1(request.getParameter("edit1")).equals("YES"))
				{
					String s[]=new String[6];
					s[0]=request.getParameter("id");
					s[1]=request.getParameter("name");
					s[2]=request.getParameter("add");
					s[3]=request.getParameter("city");
					s[4]=request.getParameter("email");
					s[5]=request.getParameter("phone");
					
					dao.editUser(s);
					rs=dao.getUsers();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Files/JSP/Admin/users.jsp?no=5");
					rd.forward(request,response);
				}
				else if(chk==null)
				{
					rs=dao.getUsers();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Files/JSP/Admin/users.jsp?no=2");
					rd.forward(request,response);
				}
				else if(chk.length!=1)
				{
					rs=dao.getUsers();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Files/JSP/Admin/users.jsp?no=4");
					rd.forward(request,response);
				}
				else if(chk.length==1)
				{
					rs=dao.getUsers(chk[0]);
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Files/JSP/Admin/edituser.jsp");
					rd.forward(request,response);
				}
			}
			if(submit.equals("Delete"))
			{
				String []chk=request.getParameterValues("chk");
				if(chk==null)
				{
					rs=dao.getUsers();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Files/JSP/Admin/users.jsp?no=2");
					rd.forward(request,response);
				}
				else
				{
					for(int i=0;i<chk.length;i++)
					{
											
						dao.deleteUser(chk[i]);
					}
					rs=dao.getUsers();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Files/JSP/Admin/users.jsp?no=3");
					rd.forward(request,response);
				
			   }
		
			}
		}
		
		
		
	
		catch(Exception e)
		{
			System.out.println("Opps's Error is in Admin UserList Servlet......"+e);
			out.println("Opps's Error is in Admin UserList Servlet......"+e);
		}
	}
}
