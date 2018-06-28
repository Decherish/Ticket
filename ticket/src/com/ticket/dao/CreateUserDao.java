package com.ticket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ticket.util.DBAccess;

public class CreateUserDao {

	PreparedStatement ptmt=null;
	DBAccess db = new DBAccess();
	public void insert(String sql,String loginName,int i,String realName,String tempsex,String city, String cardType, String birthday, String cardNumber, String type, String info){
		
		try {
			Connection conn = db.getConn();
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, loginName);
			ptmt.setInt(2, i);
			ptmt.setString(3, realName);
			ptmt.setString(4, tempsex);
			ptmt.setString(5,city);
			ptmt.setString(6, cardType);
			ptmt.setString(7, cardNumber);
			ptmt.setString(8, birthday);
			ptmt.setString(9, type);
			ptmt.setString(10,info);
			ptmt.executeUpdate();
		} catch (Exception e) {
			// TODO �Զ���ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	public void closed(){
		db.CloseAll();
	}
}
