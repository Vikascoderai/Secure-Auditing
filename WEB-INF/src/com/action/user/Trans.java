/**
 * 
 */
package com.action.user;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.Utility;


public class Trans extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		try
		{
			String name=request.getParameter("name");
			out.println("<html><body>");
			out.println("<h1><justify>Transactions</justify></h1>");
			FileInputStream fstream = new FileInputStream(getServletContext().getRealPath("/")+"\\Files\\Transactios\\"+name+".txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String text="";
			
			while((text = br.readLine()) != null)
			{
				out.println("<h4><justify>"+text+"</justify></h4>");
				
			}
			out.println("</body></html>");
			
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in UserLogin Servlet......"+e);
			out.println("Opps's Error is in UserLogin Servlet......"+e);
		}
	}
}
