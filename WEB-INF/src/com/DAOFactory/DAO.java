/**
 * 
 */
package com.DAOFactory;

import java.sql.ResultSet;


public abstract class DAO
{
	public abstract boolean loginCHK(String name,String pass);
	public abstract boolean register(String id,String pass,String name,String gender,String add,String city,String email,String phone,String groups);
	public abstract boolean CHK(String id);
	public abstract ResultSet getProfile(String name);
	public abstract boolean editProfile(String [] s);
	public abstract boolean chnagePass(int id,String cpass);
	public abstract ResultSet getUsers();
	public abstract ResultSet getCloud();
	public abstract ResultSet getHash();
	public abstract ResultSet getUsers(String id);
	public abstract boolean deleteUser(String id);
	public abstract boolean deleteKeys(String id);
	public abstract boolean editUser(String [] s);
	public abstract ResultSet getAuditors();
	public abstract ResultSet getAuditors(String id);
	public abstract boolean CHKAuditor(String id);
	public abstract boolean addAuditor(String [] s);
	public abstract boolean editAuditor(String [] s);
	public abstract boolean deleteAuditor(String s);
	public abstract boolean updateRequest(String[] fileIdArr, String userId, String filename);
	public abstract boolean updatestatus(String[] fileIdArr);
	public abstract boolean updatestatusNo(String fileIdArr);
	public abstract String getFilename(String[] fid);
	
	
	
	
	
	
	
	
	
	
	public abstract boolean deleteCloud(String id);

	
	public abstract boolean editCloud(String [] s);
	public abstract ResultSet getClouds();
	public abstract boolean CHKCloud(String id);
	public abstract ResultSet getClouds(int id);
	
	
}
