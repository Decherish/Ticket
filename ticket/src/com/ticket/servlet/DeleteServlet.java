package com.ticket.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ticket.dao.DeleteDao;
import com.ticket.message.User;

public class DeleteServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] check = request.getParameterValues("checkId");
		DeleteDao deleteDao = new DeleteDao();
		
		for(int i=0;i<check.length;i++){
			deleteDao.DeleteUser(Integer.parseInt(check[i]));
		}
		deleteDao.Closed();
		
		request.getRequestDispatcher("/servlet/UserManageServlet").forward(request, response);
	}

}
