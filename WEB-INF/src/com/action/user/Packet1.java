package com.action.user;
import com.DAOFactory.CommonDAO;
import com.database.Database;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.Random;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.AES_Algorithm;
import com.util.MD5;
import com.util.Utility;
public class Packet1 extends HttpServlet 
{
    static int upload_flag;
    static int download_flag;
    static int num1;
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;	
	static byte[] byteArray=new byte[512];
	static Random random=new Random();
	 static boolean flag_new=false;
	
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
	public static boolean formPacket(int userid,File file, String root1,String root2,String dir ) throws NoSuchAlgorithmException 
	{		
		try 
		{ 
			 String path=file.getCanonicalPath();
			 System.out.println("-------PATH IN FORM PACKET----"+path);
			//BufferedWriter bwr1 = new BufferedWriter(new FileWriter(new File("hash_code.txt")));
			StringBuilder sb = new StringBuilder();
			String hash_blk_nos=null;
			String pack=Utility.getPro("Packet");
			int packet_size=Integer.parseInt(pack);
			System.out.println(" - PACKET PACKET PACKET===============+++++++++++++++++++++++++++++++++++++++++++++- - "+packet_size);
			//int packet_size=500;
			int no_block=0;
			int rem=0;
			int no_padding=0;
			String temp="";
			String content =readFile(file);
			String filename=file.getName();
			int file_size1=content.length();
			System.out.println("File Size is : "+content.length() );
			no_block=(content.length())/ packet_size;
			rem= (content.length())% packet_size;
			if (rem != 0) 
			{
				no_padding= packet_size - rem;
				no_block = no_block + 1;
				
				for (int i = 0; i < no_padding ; i++)
				{
					temp = temp+"*";
					
				}
				content=content+temp;
			}
			System.out.println("number of packets == " + no_block);
			System.out.println("remainder == " + rem);
			System.out.println("Padding == " + no_padding);
			int bytes= content.getBytes().length;
			System.out.println("Content Length after Padding" + content.length());
	        System.out.println("---------------------------------------");
			int file_size2=content.length();
	        String[] Packet = new String[no_block];
			int Pointer = 0;
			for (int i=0;i<no_block;i++)
			{
				// Packet Formation Process
				Packet[i] = content.substring(Pointer, (Pointer + packet_size));
				Pointer = Pointer +  packet_size;
			}
			for (int i=0;i<no_block;i++)
			{
				// Packet Formation Process
				System.out.println(Packet[i]);
			}
	     	String[] array= new String[no_block];
	        for(int i=0;i<Packet.length;i++)
	        {
		    BufferedWriter bwr = new BufferedWriter(new FileWriter(new File(root1+"\\blk_"+(i+1)+".txt")));
	        //write contents of StringBuffer to a file
	        bwr.write(Packet[i]);
	        //flush the stream
	        bwr.flush();
	        File file1=new File(root1+"\\blk_"+(i+1)+".txt");
	       
	        //Getting File name
	        
	        String filename1=file1.toString();
	        String filename2= file1.getName();
	        System.out.println("------FILE NAME-------"+filename1);
			try
			{
			//Hashcode generation of files	
				
				 String block = readFile(file1);
		         
		         String encrypt=AES_Algorithm.encrypt(block);
		         
		         try {
		             String str = encrypt;
		             file1 = new File(root1+"\\blk_"+(i+1)+".txt");

		             FileWriter fw = new FileWriter(file1);
		             fw.write(str);
		             fw.close();

		         } catch (IOException iox) {
		             iox.printStackTrace();
		         }
				
				
			
				String hashcode= MD5.MD(file1);
				
			//Spliting hashcode into two-two-remaining characters
			
			String ss=hashcode.substring(0,2);
			String ss1=hashcode.substring(2,4);
			String ss2=hashcode.substring(4);
			System.out.println("----SUBSTRING3----"+ss2);
			System.out.println("----SUBSTRING2----"+ss1);
			
			//Getting id of first byte
			
			int id=CommonDAO.m_file_byteone(ss);
			
			//Inserting two bytes
			int m_l2_id=CommonDAO.m_file_level2_insert_getid(id,ss1);
			System.out.println("----M_L2_CODE------"+m_l2_id);
			System.out.println("-----BYTEONE----------"+id);
			System.out.println("-----SUBSTRING----------"+ss);
		    System.out.println("---Hash Code---"+hashcode);
		    System.out.println("----i---"+i);
		  
		  //Block_name perfectioning
		     String blockname1 = filename2.replaceAll("[0-9]",""); 
		     String blockname2 = blockname1.replaceAll("_","");
		     System.out.println("===========Perferct Block name======"+blockname2);
		   
		    //Inserting in to m_hash_code table
		    int id2=CommonDAO.m_hash_code_insert_getid(hashcode,blockname2);
		     System.out.println("======Insert into m_hash_Code table Status====== "+id2);
		    
		   
		    //Getting hash block id number
		     int hash_no=CommonDAO.m_file_get_hash_id(hashcode);
		     System.out.println("-----Unique Hash number----"+hash_no);
		     
		     
		     //Level three insertion
			   	boolean flag1=CommonDAO.m_file_level3_insert(m_l2_id,ss2,hash_no);
			    System.out.println("--------M_L3_Insert---"+flag1);
		     
		    
			 System.out.println("<><><><><><><>><>>hash_no><><><><><>"+hash_no);
		     String hash_id=Integer.toString(hash_no);
		     //Appending "-" to hash block numbers
		    
		     sb.append(hash_id);
		     sb.append("-");
		     //creating unique blocks to upload 
		     
		     BufferedWriter bwr1 = new BufferedWriter(new FileWriter(new File(root2+"\\"+id2+"blk.txt")));
		        //write contents of StringBuffer to a file
		        bwr1.write(Packet[i]);
		        //flush the stream
		        bwr1.flush();
		        
		        
		    
		    }
			catch(Exception e)
			{
				e.printStackTrace();
			}       
	        bwr.close();
	      }
	       
		 hash_blk_nos = sb.toString();
		 System.out.println("========hash_block======"+hash_blk_nos);
		 String date=Utility.getDate();
		 String time=Utility.getTime();
		 String day=Utility.getDay();
		 boolean flag2=CommonDAO.m_file_one(filename,file_size1,file_size2,no_padding,no_block,hash_blk_nos,userid,date,time,day);
		 System.out.println("---insert into m_file_one table---"+flag2);
		
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return flag_new;
		
	 }
	public static void main(String[] args) throws IOException 
	{
	//Packet1 P = new Packet1();
	//File F = new File("JavaV1.txt");
	//Packet1.formPacket(F);
	}
}
