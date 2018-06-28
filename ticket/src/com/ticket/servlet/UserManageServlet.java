package com.ticket.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.ticket.dao.UserManageDao;
import com.ticket.message.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserManageServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserManageDao userManageDao = new UserManageDao();
		String sql = "select * from user";
		List<User> userList = new ArrayList<User>();
		userList = userManageDao.selectList(sql);	
		userManageDao.closed();
		
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("/Admin/UserManageQuery.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	//	response.sendRedirect("/Admin/UserManageQuery.jsp");
	}

}
