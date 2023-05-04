package com.web.servlets;

import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.util.List;

import com.bo.User;
import com.web.helpers.IGameDataManagement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class BestScoreServlet extends HttpServlet {
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IGameDataManagement gameData= (IGameDataManagement)getServletContext().getAttribute("gameData");
		
		List<User> users= gameData.getAllUsers();
		
		request.setAttribute("users", users);
		
		getServletContext().getRequestDispatcher("/WEB-INF/vues/pages/bestScore.jsp").forward(request, response);
		
		return;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
