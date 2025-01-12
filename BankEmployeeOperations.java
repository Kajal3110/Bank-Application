package com.bankApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankEmployeeOperations {
	
	DatabaseConnectivity ob=new DatabaseConnectivity();
	Connection conn=ob.dbConnection();
	
	public boolean login(int eid,String password) throws SQLException 
	{
		
		PreparedStatement ps=conn.prepareStatement("select * from bank_employee where emp_id=? && password=?");
		ps.setInt(1, eid);
		ps.setString(2, password);
		ResultSet result=ps.executeQuery();
		
		
			if(result.next())
			{
				return true; 
			}
			else
			{
				return false;
			}
			
		
	}		
	
	public boolean openAccount(long acid,String accname,String accaddress,long phone,String email,double balance,String pass) throws SQLException
	{
		PreparedStatement ps=conn.prepareStatement("insert into bank_user values(?,?,?,?,?,?,?)");
		ps.setLong(1, acid);
		ps.setString(2, accname);
		ps.setString(3, accaddress);
		ps.setLong(4, phone);
		ps.setString(5,email);
		ps.setDouble(6,balance);
		ps.setString(7, pass);
		
		int affectedRows=ps.executeUpdate();
		
		if(affectedRows>0)
			return true;
		else
			return false;
	}

}
