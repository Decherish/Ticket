package com.ticket.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ticket.dao.LoginDao;
import com.ticket.message.Login;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Login login = new Login();
		HttpSession session = request.getSession();
		String sql = "select id,name,password,uid from login where name='"+username+"' and password='"+password+"'";
		LoginDao loginDao = new LoginDao();
		ResultSet rs = loginDao.isRoot(sql);
		try {
			if(rs.next()){
				login.setId(rs.getInt("id"));
				login.setName(rs.getString("name"));
				login.setPassword(rs.getString("password"));
				login.setUid(rs.getInt("uid"));
				session.setAttribute("username", login.getName());
				if(rs.getInt("uid")==0){
					response.sendRedirect("/test/Admin/Index.jsp");
				}else {
					response.sendRedirect("/test/User/Index.jsp");
				}
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		loginDao.closed();
	}
		
}
