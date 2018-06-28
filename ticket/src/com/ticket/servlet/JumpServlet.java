package com.ticket.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.ticket.message.User;


@WebServlet("/JumpServlet")
public class JumpServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("JumpId");
		User u1 = (User) request.getSession().getAttribute("user"+id);
		HttpSession session = request.getSession();
		
		session.setAttribute("User", u1);
		request.getRequestDispatcher("/Admin/UserManageInfo_Amind_Edit.jsp").forward(request, response);
	}

}
