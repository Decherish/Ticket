package com.ticket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ticket.util.DBAccess;

public class UserManageInfo_AmindDao {

	DBAccess dbAccess = new DBAccess();

	public void Update(String loginName, String sex, String uid,
			String realName, String city, String cardType, String cardNumber,
			String birthday, String type, String info) {

		String sql = "update User set sex=?,uid=?,realName=?,city=?,cardType=?,cardNumber=?,birthday=?,type=?,info=? where loginName='"
				+ loginName + "'";
		Connection conn = dbAccess.getConn();
		try {
			PreparedStatement pt = conn.prepareStatement(sql);

			pt.setString(1, sex);
			pt.setString(2, uid);
			pt.setString(3, realName);
			pt.setString(4, city);
			pt.setString(5, cardType);
			pt.setString(6, cardNumber);
			pt.setString(7, birthday);
			pt.setString(8, type);
			pt.setString(9, info);

			int n = pt.executeUpdate();
			if (n >= 1) {
				System.out.println("修改成功");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void Closed() {
		dbAccess.CloseAll();
	}
}
