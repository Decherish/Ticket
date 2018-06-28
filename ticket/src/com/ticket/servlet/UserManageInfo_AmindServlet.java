package com.ticket.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ticket.dao.UserManageInfo_AmindDao;

public class UserManageInfo_AmindServlet extends HttpServlet {

	
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String tempsex = "男";
		String loginName = request.getParameter("loginName");
		String uid = request.getParameter("select");
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
		
		UserManageInfo_AmindDao userManageInfo_AmindDao = new UserManageInfo_AmindDao();
		userManageInfo_AmindDao.Update(loginName, tempsex, uid, realName, city, cardType, cardNumber, birthday, type, info);
		userManageInfo_AmindDao.Closed();
		
		request.getRequestDispatcher("/servlet/UserManageServlet").forward(request, response);
	}
}
