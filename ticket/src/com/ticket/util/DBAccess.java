package com.ticket.util;


import java.sql.*;


public class DBAccess {
	
	private static String url="jdbc:mysql://localhost:3306/stms?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	private static String user = "root";
	private static String pwd = "123456";
	private static Connection conn=null;
	private static Statement stmt=null;
	private static ResultSet rs = null;
	private static PreparedStatement pt = null;
	
	
	public Connection getConn(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void CloseAll(){
		try {
			if(rs!=null){
				rs.close();
			}
			if(stmt!=null){
				stmt.close();
			}
			if(pt!=null){
				pt.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
