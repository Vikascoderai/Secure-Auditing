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

import com.DAOFactory.CommonDAO;
import com.DAOFactory.DAO;
import com.DAOFactory.DAOFactory;
import com.util.Utility;

public class UploadFile extends HttpServlet 
{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out = response.getWriter();
		try
		{
			String submit=request.getParameter("submit");
			String name=request.getParameter("name");
			//System.out.println("submit---"+submit);
			//System.out.println("name----"+name);
			boolean result=false;
			ResultSet rs=CommonDAO.getFiles(CommonDAO.getUserID(name),"uploaded");
			RequestDispatcher rd=null;
			if(submit.equals("get"))
			{
				if(rs.next())
				{
					rs=CommonDAO.getFiles(CommonDAO.getUserID(name),"uploaded");
					request.setAttribute("rs", rs);
					request.setAttribute("name", name);
					rd=request.getRequestDispatcher("/Files/JSP/User/files.jsp");
					rd.forward(request, response);
				}
				else
				{
					rd=request.getRequestDispatcher("/Files/JSP/User/files.jsp?no=-1");
					rd.forward(request, response);
				}
			}
			else if(submit.equals("Upload"))
			{
				rs=CommonDAO.getFiles(CommonDAO.getUserID(name),"uploaded");
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/Files/JSP/User/files.jsp?no=1");
				rd.forward(request, response);
			}
			else if(submit.equals("Delete"))
			{
				String []chk=request.getParameterValues("chk");
				request.setAttribute("name", name);
				if(chk==null)
				{
					rs=CommonDAO.getFiles(CommonDAO.getUserID(name),"uploaded");
				    request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Files/JSP/User/files.jsp?no=3");
					rd.forward(request,response);
				}
				else
				{
					for(int i=0;i<chk.length;i++)
					{
						
						String fname=CommonDAO.getFileName(chk[i]);
						String hashblocks=CommonDAO.gethashblknos(fname);
						
						 String[] temp;
						 
						  /* delimiter */
						  String delimiter = "-";
						  /* given string will be split by the argument delimiter provided. */
						  temp = hashblocks.split(delimiter);
						  /* print substrings */
						  System.out.println("======== "+hashblocks);
						  String blockname="";
						  System.out.println("-----Temp Size--"+temp.length);
						  for(int j =0; j < temp.length ; j++)
						  {
							  System.out.println("--===-======-= "+temp[j]);
							    //int id2=Integer.parseInt(temp[i]);
							    blockname=CommonDAO.getblocks(temp[j]); 
							    System.out.println("-----BLOCK NAME------"+blockname);
							    boolean flag=false;
							    flag=CommonDAO.getInstance(temp[j]);
							    if(flag==true)
							    {
							    	result=Utility.deleteFile(Utility.getPro("server"),Utility.getPro("user"),Utility.getPro("pass"), blockname);	
							    	 result=CommonDAO. Updatehashtable(temp[j]);
							    }
							}
						
						 result=CommonDAO.UpdateTrans(chk[i], "uploaded");
						Utility.writeOnFile(name+".txt", "User has deleted file ("+fname+") on date "+Utility.getDate()+" and time "+Utility.getTime()+"", getServletContext().getRealPath("/"));
					
					}
						rs=CommonDAO.getFiles(CommonDAO.getUserID(name),"uploaded");
						request.setAttribute("rs", rs);
						rd=request.getRequestDispatcher("/Files/JSP/User/files.jsp?no=4");
						rd.forward(request,response);
					}
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in User UploadFile Servlet......"+e);
			out.println("Opps's Error is in User UploadFile Servlet......"+e);
		}
	}
}
