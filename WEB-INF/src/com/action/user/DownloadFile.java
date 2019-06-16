/**
 * 
 */
package com.action.user;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.DAOFactory.CommonDAO;
import com.database.Database;
import com.util.AES_Algorithm;
import com.util.MD5;
import com.util.Utility;


public class DownloadFile extends HttpServlet 
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
	
	String processingServerUrl="";
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	File downloadedFile=null;
	File newTextFile1=null;
	String root="";
	String root2="";
	boolean flag78=false;
	String status1=null;
	String status2="pass";
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			HttpSession session = request.getSession();  
			String submit=request.getParameter("submit");
			String name=request.getParameter("name");
			boolean result=false;
			//int id=CommonDAO.getID(name);
			ResultSet rs=CommonDAO.getFiles(CommonDAO.getUserID(name),"Upload");
			RequestDispatcher rd=null;
			if(submit.equals("get"))
			{
				if(rs.next())
				{
					rs=CommonDAO.getFiles(CommonDAO.getUserID(name),"Upload");
					request.setAttribute("rs", rs);
					request.setAttribute("name", name);
					rd=request.getRequestDispatcher("/Files/JSP/User/download.jsp");
					rd.forward(request, response);
				}
				else
				{
					rd=request.getRequestDispatcher("/Files/JSP/User/download.jsp?no=-1");
					rd.forward(request, response);
				}
			}
			else if(submit.equals("Delete"))
			{
				String []chk=request.getParameterValues("chk");
				request.setAttribute("name", name);
				if(chk==null)
				{
					rs=CommonDAO.getFiles(CommonDAO.getUserID(name),"Upload");
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Files/JSP/User/download.jsp?no=3");
					rd.forward(request,response);
				}
				else
				{
					for(int i=0;i<chk.length;i++)
					{
						
						String fname=CommonDAO.getFileName(chk[i]);
						result=Utility.deleteFile(Utility.getPro("server"), Utility.getPro("user"), Utility.getPro("pass"), fname);
						if(result)
						{
						CommonDAO.UpdateTrans(chk[i], "Upload");
						Utility.writeOnFile(name+".txt", "User has deleted file ("+fname+") on date "+Utility.getDate()+" and time "+Utility.getTime()+"", getServletContext().getRealPath("/"));
						}
					}
					if(result)
					{
						
						rs=CommonDAO.getFiles(CommonDAO.getUserID(name),"Upload");
						request.setAttribute("rs", rs);
						rd=request.getRequestDispatcher("/Files/JSP/User/download.jsp?no=4");
						rd.forward(request,response);
					}
					if(result==false)
					{
						rd=request.getRequestDispatcher("/Files/JSP/User/files.jsp?no=5");
						rd.forward(request,response);
					}
				}
			}
			else if(submit.equals("Download"))
			{
				
				if ( session.getAttribute( "waitPage" ) == null ) 
			    {  
			    	   session.setAttribute( "waitPage", Boolean.TRUE );  
			    	   PrintWriter outter = response.getWriter();  
			    	   outter.println( "<html><head>" );  
			    	   outter.println( "<title>Please Wait...</title>" );  
			       	   outter.println( "<meta http-equiv=\"Refresh\" content=\"0\">" );  
			    	   outter.println( "</head><body background='Files/Images/ralubg.jpeg'>" );  
			    	   outter.println( "<br>" );
			    	   outter.println( "<center>" );
			    	   outter.print("<font color='red'>");
			    	   outter.println( "Please Do not press Back or Refresh button.......<br>  " );
			    	   outter.println("</font>");
			    	   outter.print("<font color='#fedcba'>");
			    	   outter.println( "Please,Wait..........<br>  " );
			    	   outter.println( "Download Athentication In Process..." );
			    	   outter.println( "<br>" );
			    	   outter.println("</font>");
			    	   outter.println( "<br>" );
			    	   outter.print( "<img src='Files/Images/ajax_loader.gif'></img><br><br>");
			    	   outter.print("<font color='#AD814E'>");
			    	   outter.println( "Please Do not press Back or Refresh button.......<br>  " );
			    	   outter.println( "<br>" );
			    	   outter.println( "Downloading is in process..." );
			    	   outter.println( "<br>" );
			    	   outter.println( "The File is in local server1...." );
			    	   outter.println("</font>");
			    	   outter.println( "<br>" );
			    	   outter.println( "Please wait....</h1></center");  
			    	   outter.close();  
			     }  
				  
				  //*  File Download process*//
				  
				  else 
			       { 
				    	session.removeAttribute( "waitPage" );  
				    	
						response.setContentType("text/html");
						String []chk=request.getParameterValues("chk");
						request.setAttribute("name", name);
						if(chk==null || chk.length!=1)
						{
							rs=CommonDAO.getFiles(CommonDAO.getUserID(name),"Upload");
							request.setAttribute("rs", rs);
							rd=request.getRequestDispatcher("/Files/JSP/User/download.jsp?no=3");
							rd.forward(request,response);
						}
						else
						{
							
									String fname=CommonDAO.getFileName(chk[0]);
								
									String hashblknos=CommonDAO.gethashblknos(fname);
									System.out.println("Hash blocks id is"+hashblknos);
									
									String str = CommonDAO.gethashblknos(fname);
									  String[] temp;
									 
									  /* delimiter */
									  String delimiter = "-";
									  /* given string will be split by the argument delimiter provided. */
									  temp = str.split(delimiter);
									  /* print substrings */
									  System.out.println("======== "+str);
									  String blockname="";
									  String dest1=request.getRealPath("") + "/MergedFile/"+fname; 
									  File f=new File(dest1);
									  f.delete();
									  String dest=request.getRealPath("") + "/MergedFile/"+fname;
									  //root = getServletContext().getRealPath("/MergedFile");
									  root2 = getServletContext().getRealPath("/download2");
									  //File res = new File(root);
									  
									 
									  
									  System.out.println("what is dest++++++++"+dest);
									  
									 
								         
									  
									 // File fin = new File(Merged);
									 
									  boolean flag44=CommonDAO.deleteIntegrity();
									  //System.out.println("flag44 status"+flag44);
									  //System.out.println("-----Temp Size--"+temp.length);
									  for(int i =0; i < temp.length ; i++)
									  {
										    
									    System.out.println("--===-======-= "+temp[i]);
									 
									    blockname=CommonDAO.getblocks(temp[i]); 
										System.out.println("----BLOCKNAME-----"+blockname);
										
										String old_hcode=CommonDAO.gethashcode(blockname);
										System.out.println("old hash code :"+old_hcode);
										//String decrypt=AES_Algorithm.decrypt(blockname);
										
										
										String destFilePath=request.getRealPath("") + "/Download/";
										result=Utility.download(Utility.getPro("server"), Utility.getPro("user"), Utility.getPro("pass"),blockname,destFilePath);
										File fin =new File(destFilePath+blockname);
										
										
										 String block = readFile(fin);
										 String decrypt ="";
								         try
								         {
								        	 decrypt=AES_Algorithm.decrypt(block);
								         }
								         catch(Exception e)
								         {
								        	 System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++data is hacked or modified in cloud");
								         }
								         
								         try {
								             String str1 = decrypt;
								             newTextFile1 = new File(root2+"/"+blockname);

								             FileWriter fw = new FileWriter(newTextFile1);
								             fw.write(str1);
								             fw.close();

								         } catch (IOException iox) {
								             iox.printStackTrace();
								         }
								         
										
										
										String newHashCode = MD5.MD(fin);
										//System.out.println("decrypted data is+++++++ "+newTextFile);
										System.out.println("new hash code is "+newHashCode);
										
										if(newHashCode.equals(old_hcode))
										{
											System.out.println("inside if equals block");
											status1="pass";
											boolean flag7 = CommonDAO.insertIntegrity(newHashCode, old_hcode,status1 );
											System.out.println("============== ");
										
									    FileInputStream fis = new FileInputStream(newTextFile1);
										BufferedReader in = new BufferedReader(new InputStreamReader(fis));
									    	
										FileWriter fstream = new FileWriter(dest, true);
										BufferedWriter out = new BufferedWriter(fstream);
										String aLine = null;
										
										while ((aLine = in.readLine()) != null )  
										{
											if(aLine.startsWith("*"))
											{
													System.out
															.println("inside * block");
											}
											else
											{   
												out.write(aLine);
												out.newLine();
												System.out
														.println("inside else * block");
											}
											
											//Process each line and add output to Dest.txt file
										}
										System.out.println("outside else * block");
										
										/*String block = readFile(res);
								         
								         String decrypt=AES_Algorithm.decrypt(block);
								         
								         try {
								             String str1 = decrypt;
								             newTextFile1 = new File(root2+"/"+blockname);

								             FileWriter fw = new FileWriter(newTextFile1);
								             fw.write(str1);
								             fw.close();

								         } catch (IOException iox) {
								             iox.printStackTrace();
								         }*/
								 
										// do not forget to close the buffer reader
										in.close();
										// close buffer writer
										out.close();
									  
										
											/*
											PrintWriter out1=response.getWriter();
											out1.println("<script type=\"text/javascript\">");
										       out1.println("alert('success');");
										       out1.println("</script>");
										       */
										}
										else
											
										{
											System.out.println("inside flag78 block");
											flag78=true;
											status2="failed";
											boolean flag7 = CommonDAO.insertIntegrity(newHashCode, old_hcode,status2 );
											System.out.println("============== "+flag7);
											

											
										}
										
										
								}
								if(status2.equals("failed"))
								{
										  rs=CommonDAO.getFiles(CommonDAO.getUserID(name),"Upload");
										  Utility.writeOnFile(name+".txt", "User has downloaded file ("+fname+") on date "+Utility.getDate()+" and time "+Utility.getTime()+"", getServletContext().getRealPath("/"));
											request.setAttribute("rs", rs);
											rd=request.getRequestDispatcher("/Files/JSP/User/download.jsp?no=7");
											rd.forward(request,response);
								}
									 
								if(status1.equals("pass"))
								{
										 rs=CommonDAO.getFiles(CommonDAO.getUserID(name),"Upload");
										 request.setAttribute("rs", rs);
										  Utility.writeOnFile(name+".txt", "User has downloaded file ("+fname+") on date "+Utility.getDate()+" and time "+Utility.getTime()+"", getServletContext().getRealPath("/"));
											rd=request.getRequestDispatcher("/Files/JSP/User/download.jsp?no=6");
											rd.forward(request,response);
											
								}
									 
									
									 
					          }
			       }
			}
						
			else if(submit.equals("Integrity"))
			{
				
				
					rs=CommonDAO.getDetails();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Files/JSP/User/integrity.jsp");
					rd.forward(request,response);
				
				
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Opps's Error is in User DownloadFile Servlet......"+e);
	
		}
		}
	
		
	
}

