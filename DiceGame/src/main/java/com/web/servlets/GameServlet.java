package com.web.servlets;

import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import com.bo.GameState;
import com.bo.Message;
import com.bo.User;
import com.web.helpers.IGameDataManagement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class GameServlet extends HttpServlet {
	

	protected void play(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session= request.getSession();
		
		User user= (User) session.getAttribute("user");
		
		
		IGameDataManagement gameData= (IGameDataManagement) getServletContext().getAttribute("gameData");
		
		GameState gameState= (GameState) session.getAttribute("gameState");
		
		if(!gameState.isGameOver()) {
			String actualDice= request.getParameter("numDe");
			if(actualDice.equals("1") || actualDice.equals("2") || actualDice.equals("3")) {
				
				
				if(actualDice.equals(session.getAttribute("oldDice"))) {
					
					user.setActualScore(-1);
					gameState.setGameOver(true);
					
					getServletContext().getRequestDispatcher("/WEB-INF/vues/pages/userPage.jsp").forward(request, response);
					
					return;
				}
				
				if(user.getCompteurLancer()==0) {
					
					
					session.setAttribute("firstResult", new Random().nextInt(1, 7));
					
				}
				
				if(user.getCompteurLancer()==1) {
					
					session.setAttribute("secondResult", new Random().nextInt(1, 7));
					
					int result1= (int)session.getAttribute("firstResult");
					int result2= (int)session.getAttribute("secondResult");
					
					
					if(result2==6 || (result1==result2)) {
						gameState.setGameOver(true);
						user.setActualScore(0);
						
						getServletContext().getRequestDispatcher("/WEB-INF/vues/pages/userPage.jsp").forward(request, response);
						
						return;
					}
					
				}
				
				if(user.getCompteurLancer()==2) {
					
					
					session.setAttribute("thirdResult", new Random().nextInt(1, 7));
					
					gameState.setGameOver(true);
					
					
					int result1= (int)session.getAttribute("firstResult");
					int result2= (int)session.getAttribute("secondResult");
					int result3= (int)session.getAttribute("thirdResult");
					
					int score= 0;
					
					if(result1>result2 && result2>result3) {
						score= result1*result2*result3;
						
						
					}else if(result1<result2 && result2<result3) {
					
						score= result1+result2+result3;
						
					}
					
					user.setActualScore(score);
					
					
					if(score>user.getBestScore()) {
						//update in the session
						user.setBestScore(score);
						
						//update in the context
						gameData.updateBestScore(user);
					}
					
					getServletContext().getRequestDispatcher("/WEB-INF/vues/pages/userPage.jsp").forward(request, response);
					
					return;
				}
				gameState.addMessage(new Message("le dé numéro : "+actualDice+", le résultat actuel: "+actualDice, Message.INFO));
				session.setAttribute("oldDice", actualDice);
				user.incrementCompteurLance();
				
				
			}
		}
		getServletContext().getRequestDispatcher("/WEB-INF/vues/pages/homePage.jsp").forward(request, response);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		play(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		play(request, response);
	}

}
