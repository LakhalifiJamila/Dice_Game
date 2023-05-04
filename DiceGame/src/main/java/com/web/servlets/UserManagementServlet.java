package com.web.servlets;

import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.bo.Message;
import com.bo.User;
import com.web.helpers.IGameDataManagement;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//INSCRIPTION
public class UserManagementServlet extends HttpServlet {
	private final Logger LOGGER= Logger.getLogger(getClass());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inscriptionFormPage= "/WEB-INF/vues/pages/inscriptionForm.jsp";
		
		ServletContext context= getServletContext();
		
		if(request.getParameter("inscription")!=null) {
			LOGGER.debug("Redirection vers la page d'inscription.");
			
			context.getRequestDispatcher(inscriptionFormPage).forward(request, response);
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String errorPage= "/WEB-INF/vues/pages/error.jsp";
		String loginFormPage= "/WEB-INF/vues/pages/loginForm.jsp";
		
		ServletContext context= getServletContext();
		
		String nom= request.getParameter("nom");
		String prenom= request.getParameter("prenom");
		String password= request.getParameter("password");
		String login= request.getParameter("login");
		
		User user= new User(nom, prenom, login, password);
		
		List<Message> messages= new ArrayList<>();
		
		IGameDataManagement gameData= (IGameDataManagement) context.getAttribute("gameData"); 
		
		if(gameData.getUserByLogin(login)!=null) {
			
			messages.add(new Message("Login existe déjà!", Message.WARN));
			request.setAttribute("messages", messages);
			context.getRequestDispatcher(errorPage).forward(request, response);
			return;
		}
		
		gameData.insertUser(user);
		messages.add(new Message("inscription avec succès", Message.INFO));
		request.setAttribute("messages", messages);
		context.getRequestDispatcher(loginFormPage).forward(request, response);;
	}

}
