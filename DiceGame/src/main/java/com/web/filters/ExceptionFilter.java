package com.web.filters;

import jakarta.servlet.http.HttpFilter;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.bo.Message;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;


public class ExceptionFilter extends HttpFilter {

	Logger LOGGER= Logger.getLogger(getClass());
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		LOGGER.debug("Execution du filtre ExceptionFilter");
		try{
			chain.doFilter(request, response);
			
		}catch(Exception e) {
			LOGGER.debug("Erreur gérée par le filtre ExceptionFilter. C'est à cause de l'exception: "+ e.getMessage(), e);
			List<Message> list= new ArrayList<>();
			list.add(new Message("une erreur est survenue veuillez consulter le fichier myapp.log pour plus de détails", Message.ERROR));
			
			request.setAttribute("messages", list);
			getServletContext().getRequestDispatcher("/WEB-INF/vues/pages/error.jsp").forward(request, response);
		}
		
	}


}
