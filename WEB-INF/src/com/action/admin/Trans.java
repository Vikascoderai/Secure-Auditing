/**
 * 
 */
package com.action.admin;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAOFactory.DAO;
import com.DAOFactory.DAOFactory;


public class Trans extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out = response.getWriter();
		try
		{
			String task=request.getParameter("submit");
			System.out.println("Start "+task);
			
			DAOFactory factory=new DAOFactory();
			DAO dao=factory.getInstance("Admin");
			ResultSet rs=null;
			if(task.equals("get"))
			{
				System.out.println("Start ");
				/*rs = dao.getUsers();
				int count=0;
				while(rs.next())
					count++;
				rs = dao.getUsers();
				request.setAttribute("rs", rs);*/
				RequestDispatcher rd=null;
				rd=request.getRequestDispatcher("Files/JSP/Admin/trans.jsp");
				rd.forward(request, response);
				
			}
			if(task.equals("Ok"))
			{
				String name=request.getParameter("name");
				out.println("<html><body>");
				out.println("<h1>Transactions</h1>");
				FileInputStream fstream = new FileInputStream(getServletContext().getRealPath("/")+"\\Files\\Transactios\\"+name+".txt");
				System.out.println("-------fstream>>><<<<>>><<>))))))"+fstream);
				System.out.println("-------fstream>>><<<<>>><<>))))))"+fstream);
				System.out.println("-------fstream>>><<<<>>><<>))))))"+fstream);
				System.out.println("-------fstream>>><<<<>>><<>))))))"+fstream);
				
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				String text="";
				
				while((text = br.readLine()) != null)
				{
					out.println("<h4>"+text+"</h4>");
					
				}
				out.println("</body></html>");
			}
		}
		catch(Exception e)
		{
			String name=request.getParameter("name");
			System.out.println("Opps's Error is in User Transaction Servlet......"+e);
			//out.println("Opps's Error is in User Transaction Servlet......"+e);
			out.println("<html><body>");
			out.println("<h1> not yet done by *"+name+"</h1>");
		}
	}
}
