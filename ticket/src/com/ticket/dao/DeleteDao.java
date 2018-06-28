package com.ticket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ticket.message.User;
import com.ticket.util.DBAccess;

public class DeleteDao {

	DBAccess dbAccess = new DBAccess();
	public void DeleteUser(int id){
		try {
			String sql = "delete from User where id='"+id+"'";
			Connection conn = dbAccess.getConn();
			PreparedStatement pt = conn.prepareStatement(sql);
			int n = pt.executeUpdate();
			if(n>=1){
				System.out.println("删除成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Closed(){
		dbAccess.CloseAll();
	}
}
