package com.ticket.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ticket.util.DBAccess;

public class LoginDao {

	ResultSet rs=null;
	DBAccess db = new DBAccess();
	public ResultSet isRoot(String sql){
		try {
			Connection conn	= db.getConn();
			Statement statement= conn.createStatement();
			rs = statement.executeQuery(sql);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return rs;
	}
	
	public void closed(){
		db.CloseAll();
	}
}
