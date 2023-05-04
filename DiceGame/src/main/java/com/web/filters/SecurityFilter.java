package com.web.filters;

import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.apache.log4j.Logger;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;


public class SecurityFilter extends HttpFilter {
	
	Logger LOGGER= Logger.getLogger(getClass());

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		LOGGER.debug("Execution du filtre SecurityFilter");
		
		HttpServletRequest req= (HttpServletRequest)request;
		
		HttpSession session= req.getSession();
		
		if(session.getAttribute("user")==null) {
			getServletContext().getRequestDispatcher("/WEB-INF/vues/pages/loginForm.jsp").forward(request, response);
			
			return;
			
		}else {
			
			chain.doFilter(request, response);
		}
	}

}
