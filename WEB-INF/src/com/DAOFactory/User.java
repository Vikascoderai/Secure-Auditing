/**
 * 
 */
package com.DAOFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.database.Database;
import com.util.ConvertArrayToString;

public class User extends DAO {
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;

	public boolean loginCHK(String name, String pass) {
		boolean flag = false;
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			System.out.println("select * from userlogin where userid='" + name
					+ "' and password='" + pass + "'");
			resultSet = statement
					.executeQuery("select * from userlogin where userid='"
							+ name + "' and password='" + pass + "'");
			while (resultSet.next()) {
				flag = true;
			}
			System.out.println("User Login Status : " + flag);
		} catch (Exception e) {
			System.out.println("Opp's Error is in UserDAO-loginCHK()....." + e);
		}
		return flag;
	}

	public boolean register(String id, String pass, String name, String gender,
			String add, String city, String email, String phone, String groups) {
		boolean flag = false;
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			String sql = "insert into cloud.userlogin (userid,password,username,gender,address,city,email,phone,groups) values('"
					+ id
					+ "','"
					+ pass
					+ "','"
					+ name
					+ "','"
					+ gender
					+ "','"
					+ add
					+ "','"
					+ city
					+ "','"
					+ email
					+ "','"
					+ phone
					+ "','" + groups + "')";
			System.out.println(sql);
			int i = statement.executeUpdate(sql);

			if (i != 0) {
				flag = true;
			}
			System.out.println("User Registeration Status : " + flag);
		} catch (Exception e) {
			System.out.println("Opp's Error is in UserDAO-register()....." + e);
		}
		return flag;
	}

	public boolean CHK(String id) {
		boolean flag = false;
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery("select * from userlogin where userid='" + id
							+ "'");
			while (resultSet.next()) {
				flag = true;
			}
			System.out.println("User Login Status : " + flag);
		} catch (Exception e) {
			System.out.println("Opp's Error is in UserDAO-CHK()....." + e);
		}
		return flag;
	}

	public ResultSet getProfile(String id) {
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery("select * from userlogin where userid='" + id
							+ "'");
		} catch (Exception e) {
			System.out.println("Opp's Error is in UserDAO-getProfile()....."
					+ e);
		}
		return resultSet;
	}

	public boolean editProfile(String[] s) {
		boolean flag = false;
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			int i = statement.executeUpdate("update userlogin set username='"
					+ s[1] + "',address='" + s[3]
					+ "',email='" + s[5] + "',phone='"
					+ s[6] + "' where id='" + s[0] + "'");
			if (i != 0)
			{
				flag = true;
			}
			System.out.println("User Edit Profile Status : " + flag);
		} catch (Exception e) {
			System.out.println("Opp's Error is in UserDAO-editProfile()....."
					+ e);
		}
		return flag;
	}

	public boolean chnagePass(int id, String cpass) {
		boolean flag = false;
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			int i = statement.executeUpdate("update userlogin set password='"
					+ cpass + "' where id='" + id + "'");
			if (i != 0) {
				flag = true;
			}
			System.out.println("User Change Pass Status : " + flag);
		} catch (Exception e) {
			System.out.println("Opp's Error is in UserDAO-chnagePass()....."
					+ e);
		}
		return flag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nitin.DAOFactory.DAO#getUsers()
	 */
	@Override
	public ResultSet getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nitin.DAOFactory.DAO#deleteUser(java.lang.String)
	 */
	@Override
	public boolean deleteUser(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nitin.DAOFactory.DAO#getUsers(java.lang.String)
	 */
	@Override
	public ResultSet getUsers(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nitin.DAOFactory.DAO#editUser(java.lang.String[])
	 */
	@Override
	public boolean editUser(String[] s) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nitin.DAOFactory.DAO#getAuditors()
	 */
	@Override
	public ResultSet getAuditors() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nitin.DAOFactory.DAO#CHKAuditor(java.lang.String)
	 */
	@Override
	public boolean CHKAuditor(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nitin.DAOFactory.DAO#addAuditor(java.lang.String[])
	 */
	@Override
	public boolean addAuditor(String[] s) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nitin.DAOFactory.DAO#deleteAuditor(java.lang.String)
	 */
	@Override
	public boolean deleteAuditor(String s) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nitin.DAOFactory.DAO#editAuditor(java.lang.String[])
	 */
	@Override
	public boolean editAuditor(String[] s) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nitin.DAOFactory.DAO#getAuditors(java.lang.String)
	 */
	@Override
	public ResultSet getAuditors(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteKeys(String id) {
		boolean flag = false;
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			int i = statement.executeUpdate("delete from digkey where userid='"
					+ id + "'");
			if (i != 0) {
				flag = true;
			}
			System.out.println("Admin delete user Status : " + flag);
		} catch (Exception e) {
			System.out.println("Opp's Error is in AdminDAO-deleteUser()....."
					+ e);
		}
		return flag;
	}

	
	
	
	
	public String getFilename(String[] fid) {
		String filename1 = "";
		String fileid= ConvertArrayToString.convertToString(fid);
		System.out.println("-----...,.filename.,.,..,.<<>><><<>><>"+fileid);
		System.out.println("-----...,..,.,..,.<<>><><<>><>"+fileid);
		System.out.println("-----...,..,.,..,.<<>><><<>><>"+fileid);
		System.out.println("-----...,..,.,..,.<<>><><<>><>"+fileid);
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery("select file_name from m_trans where id='" + fileid+ "'");
			
			while(resultSet.next())
			{
				filename1=resultSet.getString(3);
				System.out.println("-----...,.filename1.,.,..,.<<>><><<>><>"+filename1);
				System.out.println("-----...,.filename1.,.,..,.<<>><><<>><>"+filename1);
				System.out.println("-----...,.filename1.,.,..,.<<>><><<>><>"+filename1);
				System.out.println("-----...,.filename1.,.,..,.<<>><><<>><>"+filename1);
			}
		} catch (Exception e) {
			System.out.println("Opp's Error is in UserDAO-getProfile()....."
					+ e);
		}
		return filename1;
	}
	
	
/*public boolean updatestatus1(String[] fileIdArr ) {
		
		String fileId = ConvertArrayToString.convertToString(fileIdArr);

		String query = " (File_id, User_id, File_name) VALUES('"
				+ fileId + "','" + userId + "', '" + filename + "')";
		//String query2= "Select file_name from m_trans where id='"+fileId+"'";
		
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			int i = statement.executeUpdate(query);
			
			if (i != 0) {
				return true;
			}
		} catch (SQLException e) {
			System.out
					.println("Exception in User ---> updateRequest ---> SQLException");
			e.printStackTrace();
		}

		return false;
	}
*/
public boolean updatestatus(String[] fileIdArr)
{
	String fileId = ConvertArrayToString.convertToString(fileIdArr);
	boolean flag=false;
	String value="yes";
	try
	{
		Database database=Database.getInstance();
		connection=database.connector();
		statement = connection.createStatement();
		String sql="update m_trans set status='"+value+"' where id='"+fileId+"'";
		int i=statement.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
		}
		System.out.println("updatestatus Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in User-updatestatus()....."+e);
	}
	return flag;
}
public boolean updatestatusNo(String fileIdArr)
{
	String fileId = fileIdArr;
	boolean flag=false;
	String value="no";
	try
	{
		Database database=Database.getInstance();
		connection=database.connector();
		statement = connection.createStatement();
		String sql="update m_trans set status='"+value+"' where file_name='"+fileIdArr+"'";
		int i=statement.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
			System.out.println("*********************no status ********************"+flag);
		}
		System.out.println("updatestatus Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in User-updatestatusNo()....."+e);
	}
	return flag;
}
	
	
public boolean deleteFileReq(String filename) {
	boolean flag = false;
	try {
		Database database = Database.getInstance();
		connection = database.connector();
		statement = connection.createStatement();
		int i = statement.executeUpdate("delete from m_audit_request where File_name='"
				+ filename + "'");
		if (i != 0) {
			flag = true;
		System.out.println("@@@@@@@@@@@@@@@ delete flag from req table@@@@@@@@@@@@@@@@@@@@@@"+flag);
		}
		System.out.println("Admin delete user Status : " + flag);
	} catch (Exception e) {
		System.out.println("Opp's Error is in AdminDAO-deleteUser()....."
				+ e);
	}
	return flag;
}

	
	
	
	public boolean updateRequest(String[] fileIdArr, String userId, String filename ) {
		
		String fileId = ConvertArrayToString.convertToString(fileIdArr);
		
		String query = "INSERT INTO m_audit_request (File_id, User_id, File_name) VALUES('"
				+ fileId + "','" + userId + "', '" + filename + "')";
		//String query2= "Select file_name from m_trans where id='"+fileId+"'";
		
		try {
			Database database = Database.getInstance();
			connection = database.connector();
			statement = connection.createStatement();
			int i = statement.executeUpdate(query);
			
			if (i != 0) {
				return true;
			}
		} catch (SQLException e) {
			System.out
					.println("Exception in User ---> updateRequest ---> SQLException");
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public ResultSet getCloud() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getHash() {
		// TODO Auto-generated method stub
		return null;
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
