/**
 * 
 */
package com.DAOFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import com.database.Database;



public class Admin extends DAO 
{
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	
	public boolean loginCHK(String name, String pass) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from adminlogin where adminid='"+name+"' and password='"+pass+"'");
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Admin Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO.loginCHK()....."+e);
		}
		return flag;
	}
	public boolean register(String id, String pass, String name, String gender,	String add, String city, String email, String phone,String groups) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			String sql="insert into userlogin (userid,password,username,gender,address,city,email,phone) values('"+id+"','"+pass+"','"+name+"','"+gender+"','"+add+"','"+city+"','"+email+"','"+phone+"')";
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User Registeration Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-register()....."+e);
		}
		return flag;
	}
	public boolean CHK(String id) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from userlogin where userid='"+id+"'");
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("User Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-CHK()....."+e);
		}
		return flag;
	}
	public ResultSet getProfile(String name)
	{
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from adminlogin where adminid='"+name+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-getProfile()....."+e);
		}
		return resultSet;
	}
	public boolean editProfile(String [] s) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i=statement.executeUpdate("update adminlogin set name='"+s[1]+"',address='"+s[2]+"',phone='"+s[3]+"',email='"+s[4]+"' where id='"+s[0]+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Edit Profile Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-editProfile()....."+e);
		}
		return flag;
	}
	public boolean chnagePass(int id, String cpass) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i=statement.executeUpdate("update adminlogin set password='"+cpass+"' where id='"+id+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Change Pass Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-chnagePass()....."+e);
		}
		return flag;
	}
	public ResultSet getUsers() 
	{
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from userlogin");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-getUsers()....."+e);
		}
		return resultSet;
	}
	
	
	
	public ResultSet getCloud() 
	{
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_cloud");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-getCloud()....."+e);
		}
		return resultSet;
	}
	
	public ResultSet getHash() 
	{
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_hash_code");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-getUsers()....."+e);
		}
		return resultSet;
	}
	
	
	
	
	public boolean deleteUser(String id) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i=statement.executeUpdate("delete from userlogin where id='"+id+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin delete user Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-deleteUser()....."+e);
		}
		return flag;
	}
	public ResultSet getUsers(String id)
	{
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from userlogin where id='"+id+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-getUsers()....."+e);
		}
		return resultSet;
	}
	public boolean editUser(String[] s) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i=statement.executeUpdate("update userlogin set username='"+s[1]+"',address='"+s[2]+"',city='"+s[3]+"',email='"+s[4]+"',phone='"+s[5]+"' where id='"+s[0]+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin User Edit Profile Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-editUser()....."+e);
		}
		return flag;
	}
	public ResultSet getAuditors() 
	{
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from auditlogin");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-getAuditors()....."+e);
		}
		return resultSet;
	}
	public boolean CHKAuditor(String id) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from auditlogin where auditid='"+id+"'");
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Audit Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-CHKAuditor()....."+e);
		}
		return flag;
	}
	public boolean addAuditor(String[] s) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i=statement.executeUpdate("insert into auditlogin (name,password,auditid,address,phone,email) values('"+s[0]+"','"+s[1]+"','"+s[2]+"','"+s[3]+"','"+s[4]+"','"+s[5]+"')");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Add Auditor Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-addAuditor()....."+e);
		}
		return flag;
	}
	public boolean deleteAuditor(String s) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i=statement.executeUpdate("delete from auditlogin where id='"+s+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin delete auditor Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-deleteAuditor()....."+e);
		}
		return flag;
	}
	public boolean editAuditor(String[] s) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i=statement.executeUpdate("update auditlogin set name='"+s[1]+"',auditid='"+s[2]+"',address='"+s[3]+"',phone='"+s[4]+"',email='"+s[5]+"' where id='"+s[0]+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Auditor Edit Profile Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-editAuditor()....."+e);
		}
		return flag;
	}
	public ResultSet getAuditors(String id)
	{
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from auditlogin where id='"+id+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-getAuditors()....."+e);
		}
		return resultSet;
	}
	
	public boolean deleteKeys(String id) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i=statement.executeUpdate("delete from digkey where userid='"+id+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin delete user Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-deleteUser()....."+e);
		}
		return flag;
	}
	
	public static boolean addGroup(String[] s) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i=statement.executeUpdate("insert into  cloud.group (grp_id,grp_name) values('"+s[0]+"','"+s[1]+"')");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Add Group Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-addGroup()....."+e);
		}
		return flag;
	}
	public static boolean deleteGroup(String s) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i=statement.executeUpdate("delete from cloud.group where grp_id='"+s+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin delete group Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-deleteGroup()....."+e);
		}
		return flag;
	}
	public static boolean editGroup(String[] s) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i=statement.executeUpdate("update cloud.group set grp_name='"+s[1]+"'where grp_id='"+s[0]+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Group Edit Profile Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-editGroup()....."+e);
		}
		return flag;
	}
	
	
	public static ResultSet getGroups()
	{
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from cloud.group");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-getGroups()....."+e);
		}
		return resultSet;
	}
	
	public static int getGroupMembers(int uid)
	{
		Statement st=null;
		ResultSet rs=null;
		Connection con=null;
		int no=0;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select groups from userlogin where id='"+uid+"'");
			
			while(resultSet.next())
			{
				con=database.connector();
				st=con.createStatement();
				rs=st.executeQuery("select groups from userlogin where groups='"+resultSet.getString(1)+"'");
				
				while(rs.next())
				{
					no=no+1;
				}
				
			}
			
			
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-getGroups()....."+e);
		}
		return no;
	}
	
	public static String getMemberId(String uid)
	{
		Statement st=null;
		ResultSet rs=null;
		Connection con=null;
		String no=null;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			
			
			
				con=database.connector();
				st=con.createStatement();
				
				String sql="select * from userlogin where id='"+uid+"'";
				System.out.println("sql :"+sql);
				rs=st.executeQuery(sql);
				
				while(rs.next())
				{
					no=rs.getString(2);
				}
			
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return no;
	}
	
	
	public static int updateFileRecomented(String uid,byte ds[],String fid)
	{
		Statement st=null;
		ResultSet rs=null;
		Connection con=null;
		int no=0;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			
			String sql="update m_trans set user_id='"+uid+"',file_ds='"+ds+"' where id='"+fid+"'";
			System.out.println("sql :"+sql);
				con=database.connector();
				st=con.createStatement();
				no=st.executeUpdate(sql);
				
			
			
			
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-getGroups()....."+e);
		}
		return no;
	}
	
	public static int updateMemberCount(String gpname,int k)
	{
		Statement st=null;
		ResultSet rs=null;
		Connection con=null;
		int no=0;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			
			String sql="update cloud.group set no='"+k+"' where grp_name='"+gpname+"'";
			
				con=database.connector();
				st=con.createStatement();
				no=st.executeUpdate(sql);
				
			
			
			
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-getGroups()....."+e);
		}
		return no;
	}
	
	
	public static ResultSet getGroupMembers2(int uid)
	{
		Statement st=null;
		ResultSet rs=null;
		Connection con=null;
		int no=0;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select groups from userlogin where id='"+uid+"'");
			
			while(resultSet.next())
			{
				con=database.connector();
				st=con.createStatement();
				rs=st.executeQuery("select * from userlogin where groups='"+resultSet.getString(1)+"'");
				
				
			}
			
			
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-getGroups()....."+e);
		}
		return rs;
	}
	
	public static boolean editno(int n,String s) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			String sql="update cloud.group set no='"+n+"'where grp_name='"+s+"'";
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Group number editno  Status : "+flag);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}
		
		public static String grpName(int n) 
		{
			String s="";
			boolean flag=false;
			try
			{
			
				
				Database database=Database.getInstance();
				connection=database.connector();
				statement = connection.createStatement();
				String sql="select groups from userlogin where id='"+n+"'";
				System.out.println(sql);
				ResultSet rs=statement.executeQuery(sql);
				while(rs.next())
				{
					s=rs.getString(1);
					
				}
				System.out.println("Admin grpName   Status : "+flag);
			}
			
		
		
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-grpName()....."+e);
		}
		return s;
	}
	
		
		public static ResultSet getGroupsByID(String id)
		{
			try
			{
				Database database=Database.getInstance();
				connection=database.connector();
				statement = connection.createStatement();
				resultSet = statement.executeQuery("select * from cloud.group where grp_id='"+id+"'");
			}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in AdminDAO-getGroups()....."+e);
			}
			return resultSet;
		}
	
	
		public static ResultSet getMemberFile(String id)
		{
			try
			{
				Database database=Database.getInstance();
				connection=database.connector();
				statement = connection.createStatement();
				resultSet = statement.executeQuery("select * from m_trans where user_id='"+id+"'");
			}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in AdminDAO-getGroups()....."+e);
			}
			return resultSet;
		}
	
		
		
	public static int checkno(String s) 
	{
		int i=0;
		Boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			String sql="select no from cloud.group where grp_id='"+s+"'";
			System.out.println(sql);
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				i=rs.getInt(1);
				
			}
			System.out.println("Admin Group Selcttttt number   Status : "+flag);
			flag=true;
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-select-no()....."+e);
		}
		System.out.println("value of iiiiiiiiii in admin class is"+i);
		return i;
		
	}
	@Override
	public boolean updateRequest(String[] fileIdArr, String userId,String filename)
	{
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String getFilename(String[] fid) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean updatestatus(String[] fileIdArr) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean updatestatusNo(String fileIdArr) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deleteCloud(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean editCloud(String[] s) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public ResultSet getClouds() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean CHKCloud(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public ResultSet getClouds(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
