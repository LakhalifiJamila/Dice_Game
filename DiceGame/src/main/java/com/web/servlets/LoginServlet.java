package com.web.servlets;

import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bo.GameState;
import com.bo.Message;
import com.bo.User;
import com.web.helpers.IGameDataManagement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login= request.getParameter("login");
		String password= request.getParameter("password");
		
		List<Message> messages= new ArrayList<>();
		
		IGameDataManagement gameData= (IGameDataManagement) getServletContext().getAttribute("gameData");
		
		User user= gameData.getUserByLogin(login);
		
		if(user!=null) {
			
			if(user.getPassword()!=null && user.getPassword().equals(password)) {
				
				GameState gameState= new GameState(user);
				request.getSession().setAttribute("gameState", gameState);
				
				request.getSession().setAttribute("user", user);
				
				getServletContext().getRequestDispatcher("/WEB-INF/vues/pages/homePage.jsp").forward(request, response);
				
			}else {
				messages.add(new Message("Login ou mot de passe incorrect!", Message.WARN));
				request.setAttribute("messages", messages);
				
				getServletContext().getRequestDispatcher("/WEB-INF/vues/pages/loginForm.jsp").forward(request, response);
			}
		}else {
			messages.add(new Message("Login ou mot de passe incorrect!", Message.WARN));
			
			request.setAttribute("messages", messages);
			
			getServletContext().getRequestDispatcher("/WEB-INF/vues/pages/loginForm.jsp").forward(request, response);
		}
	}

}
