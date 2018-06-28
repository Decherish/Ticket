package com.ticket.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ticket.dao.CreateUserDao;
import com.ticket.message.Login;
import com.ticket.message.User;

public class CreateUserServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int i=1;
		String tempsex = "男";
		String loginName = request.getParameter("loginName");
		String uid = request.getParameter("select");
		if(uid.equals("管理员")){
			i=0;
		}
		String realName = request.getParameter("realName");
		String sex = request.getParameter("userDTO.sex_code");
		if(!"M".equals(sex)){
			tempsex="女";
		}
		String city = request.getParameter("province") + request.getParameter("city");
		String cardType = request.getParameter("loginUserDTO.id_type_code");
		String cardNumber = request.getParameter("cardNumber");
		String birthday = request.getParameter("birthday");
		String type = request.getParameter("passenger_type");
		String info = request.getParameter("info");
		
		System.out.println(loginName+" "+uid+" "+realName+" "+sex+" "+city+" "+cardType+" "+cardNumber+" "+birthday+" "+type+" "+info);

		User u = new User();
		String sql = "insert into User(loginName,uid,realName,sex,city,cardType,cardNumber,birthday,type,info) values(?,?,?,?,?,?,?,?,?,?)";
 
		CreateUserDao createUserDao = new CreateUserDao();
		createUserDao.insert(sql, loginName, i, realName, tempsex, city, cardType, birthday, cardNumber, type, info);
		createUserDao.closed();
	}
}
