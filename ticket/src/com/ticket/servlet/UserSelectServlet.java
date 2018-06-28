package com.ticket.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ticket.dao.UserSelectDao;
import com.ticket.message.User;

public class UserSelectServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String sex = request.getParameter("select");
		String cardType = request.getParameter("loginUserDTO.id_type_code");
		String type = request.getParameter("passenger_type");
		String cardNmuber = request.getParameter("cardNmuber");

		List<User> userList = new ArrayList<User>();
		UserSelectDao userSelectDao = new UserSelectDao();
		if(cardNmuber.length()==0 && name.length()==0){
			userList = userSelectDao.selectBySex(sex, cardType, type);
		}else if(name.length()==0){
			userList = userSelectDao.selectByCard(sex, cardType, type,cardNmuber);
		}else if(cardNmuber.length()==0){
			userList = userSelectDao.selectByName(name, sex, cardType, type);
		}else{
			userList = userSelectDao.selectOne(name, sex, cardType, type,cardNmuber);
		}
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("/Admin/UserManageQuery.jsp").forward(request, response);
	}

	
	
}
