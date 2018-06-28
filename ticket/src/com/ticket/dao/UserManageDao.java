package com.ticket.dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ticket.message.User;
import com.ticket.util.DBAccess;

public class UserManageDao {

	List<User> userList = new ArrayList<User>();
	DBAccess dbAccess = new DBAccess();
	
	public List<User> selectList(String sql){
		try {
			
			Connection conn = dbAccess.getConn();
			PreparedStatement pt = conn.prepareStatement(sql);
			ResultSet rs = pt.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setLoginName(rs.getString("loginName"));
				user.setUid(rs.getInt("uid"));
				user.setRealName(rs.getString("realName"));
				user.setSex(rs.getString("sex"));
				user.setCity(rs.getString("city"));
				user.setCardType(rs.getString("cardType"));
				user.setCardNmuber(rs.getString("cardNumber"));
				user.setBirdathy(rs.getDate("birthday"));
				user.setType(rs.getString("type"));
				user.setInfo(rs.getString("info"));
				userList.add(user);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return userList;
	}
	
	
	public void closed(){
		dbAccess.CloseAll();
	}
	
}
