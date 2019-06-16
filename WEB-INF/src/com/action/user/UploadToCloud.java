/**
 * 
 */
package com.action.user;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.DAOFactory.Admin;
import com.DAOFactory.CommonDAO;
import com.util.AES_Algorithm;
import com.util.Utility;

public class UploadToCloud extends HttpServlet 
{
	
	static String readFile(File fileName) throws IOException
	{
		
	    BufferedReader br = new BufferedReader(new FileReader(fileName.getAbsolutePath()));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) 
	        {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        return sb.toString();
	    } 
	    finally 
	    {
	        br.close();
	    }
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		PrintWriter out = response.getWriter();
		try {
			String fileName = "", root = "", md = "", dir = "Secure_auditing",root1 = "",root2="",root3="";
			String status; 
			String[] name = new String[2];
			int i = 0;
			File uploadedFile = null;
			File uploadedFile1=null;
			File newTextFile=null;
			File encryptFile=null;
			ResultSet rs = null;
			boolean flag = false;
			boolean flag_upload = false;
			RequestDispatcher rd = null;
			Random random = new Random();
			int num, num1 = 0;
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			String name1=request.getParameter("name");
			System.out.println("value of name1 is  "+name1);
		
			if (isMultipart)
			{
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				try 
				{
					List items = upload.parseRequest(request);
					Iterator iterator = items.iterator();
					while (iterator.hasNext())
					{
						FileItem item = (FileItem) iterator.next();
						if (item.isFormField())
						{
							name[i] = item.getString();
							i++;
						} 
						else 
						{
							fileName = item.getName();
							System.out.println("filename iss" + fileName);
							root = getServletContext().getRealPath("/CLOUD_PROJECT");
							root1 = getServletContext().getRealPath("/OUT");
							root2 = getServletContext().getRealPath("/OUT2");
							root3 = getServletContext().getRealPath("/OUT3");
							num1 = random.nextInt(12345) + 1;
							uploadedFile = new File(root +"/"+fileName);
							
							System.out.println("Directory name iss" + uploadedFile);
							item.write(uploadedFile);
						}
					}
					
					int id = CommonDAO.getUserID(name1);
					boolean flag_packet=Packet1.formPacket(id,uploadedFile,root1,root2,dir);
					System.out.println("UserId :"+id);
					num = (random.nextInt((2 - 1) + 1)) + 1;
					String hash_blk_nos=CommonDAO.gethashblocknos(fileName);
					 for (String retval: hash_blk_nos.split("-"))
					 {
				          int k=Integer.parseInt(retval);
						 System.out.println("=======RETURN VALUE AFTER SPLITTING======"+retval);
				         String blk_name=CommonDAO.gethashblockname(k);
				         if (blk_name==null)
				         {
				        	continue; 
				         }
				         else
				         {
				         uploadedFile1 = new File(root2 +"/"+blk_name);
				         
				        //AES
				         
				         String block = readFile(uploadedFile1);
				         
				         String encrypt=AES_Algorithm.encrypt(block);
				         
				         try {
				             String str = encrypt;
				             uploadedFile1 = new File(root2+"/"+blk_name);

				             FileWriter fw = new FileWriter(uploadedFile1);
				             fw.write(str);
				             fw.close();

				         } catch (IOException iox) {
				             iox.printStackTrace();
				         }
				         
				         /*
				         int len1 = block.length();
				         int len = encrypt.length();
				         System.out.println("readed block length is++++++ "+len1);
				         System.out.println("encrypted file length is "+len);
				         */
				         
				         System.out.println("After encryption++++++++++++");
				         
				         //encryptFile= new File(root3 +"/"+encrypt);
				         
				        
				         
				         
				         flag_upload=Utility.uploadFile(Utility.getPro("server"), Utility.getPro("user"), Utility.getPro("pass"),blk_name,uploadedFile1, dir); 
				         if(flag_upload)
				         {
				        	int m= CommonDAO.m_upload_status(blk_name);
				        	System.out.println("=======Uploaded to cloud succcessfully ======="+m);
				         }
				       }
					      
					 }
						
						flag = Utility.writeOnFile(name1+ ".txt",
								"User has uploaded file (" + fileName+ ") on date "+ Utility.getDate()+ " and time "+ Utility.getTime() + "",
								getServletContext().getRealPath("/"));
						rs = CommonDAO.getFiles((id), "uploaded");
						if (rs.next()) 
						{
							rs = CommonDAO.getFiles((id), "uploaded");
							request.setAttribute("rs", rs);
							rd = request.getRequestDispatcher("/Files/JSP/User/files.jsp?no=2");
						    rd.forward(request, response);
					    }
				
					else
					{
						rd = request.getRequestDispatcher("/Files/JSP/User/files.jsp?no=5");
						rd.forward(request, response);
					}
					
				}
			
                  catch (Exception e1)
                  {
					System.out.println("Opps's Error is in User UploadToCloud isMultipart Servlet......"+ e1);
					out.println("Opps's Error is in User UploadToCloud Servlet isMultipart......"+ e1);
				}
			}
		} 
		catch (Exception e)
		{
			System.out.println("Opps's Error is in User UploadToCloud Servlet......"+ e);
			out.println("Opps's Error is in User UploadToCloud Servlet......"+ e);
		}
	}
}
