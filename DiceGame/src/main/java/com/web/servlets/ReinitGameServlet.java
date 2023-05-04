package com.web.servlets;

import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

import com.bo.GameState;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class ReinitGameServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session= request.getSession();
		
		GameState gs= (GameState)session.getAttribute("gameState");
		
		if(gs!=null) {
			gs.reinit();
		}
		
		session.setAttribute("firstResult", 0);
		session.setAttribute("secondResult", 0);
		session.setAttribute("thirdResult", 0);
		session.setAttribute("oldDice", 0);
		
		getServletContext().getRequestDispatcher("/WEB-INF/vues/pages/homePage.jsp").forward(request, response);
		
		return;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
