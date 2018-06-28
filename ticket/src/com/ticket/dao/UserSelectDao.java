package com.ticket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ticket.message.User;
import com.ticket.util.DBAccess;

public class UserSelectDao {

	DBAccess dbAccess = new DBAccess();

	public List<User> selectByName(String name, String sex, String cardType,
			String type) {

		String sql = "select id,loginName,uid,realName,sex,city,cardType,cardNumber,birthday,type,info from User where realName like '%"
				+ name
				+ "%' and sex='"
				+ sex
				+ "' and cardType='"
				+ cardType
				+ "' and type='" + type + "'";
		UserManageDao userManageDao = new UserManageDao();
		List<User> userList = new ArrayList<User>();
		userList = userManageDao.selectList(sql);
		return userList;
	}

	public List<User> selectByCard(String sex, String cardType, String type,
			String cardNumbaer) {

		String sql = "select id,loginName,uid,realName,sex,city,cardType,cardNumber,birthday,type,info from User where sex='"
				+ sex
				+ "' and cardType='"
				+ cardType
				+ "' and type='"
				+ type
				+ "' and cardNumber='" + cardNumbaer + "'";
		UserManageDao userManageDao = new UserManageDao();
		List<User> userList = new ArrayList<User>();
		userList = userManageDao.selectList(sql);
		return userList;
	}

	public List<User> selectBySex(String sex, String cardType, String type) {

		String sql = "select id,loginName,uid,realName,sex,city,cardType,cardNumber,birthday,type,info from User where sex='"
				+ sex
				+ "' and cardType='"
				+ cardType
				+ "' and type='"
				+ type
				+ "'";
		UserManageDao userManageDao = new UserManageDao();
		List<User> userList = new ArrayList<User>();
		userList = userManageDao.selectList(sql);
		return userList;
	}

	public List<User> selectOne(String name, String sex, String cardType,
			String type, String cardNumbaer) {

		String sql = "select id,loginName,uid,realName,sex,city,cardType,cardNumber,birthday,type,info from User where realName='"
				+ name
				+ "' and sex='"
				+ sex
				+ "' and cardType='"
				+ cardType
				+ "' and type='"
				+ type
				+ "' and cardNumber='"
				+ cardNumbaer
				+ "'";
		UserManageDao userManageDao = new UserManageDao();
		List<User> userList = new ArrayList<User>();
		userList = userManageDao.selectList(sql);
		return userList;
	}

}
