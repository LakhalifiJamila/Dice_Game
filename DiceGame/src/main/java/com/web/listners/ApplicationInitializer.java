package com.web.listners;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.bo.User;
import com.web.helpers.DataManagementFactory;
import com.web.helpers.IGameDataManagement;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import jakarta.servlet.annotation.WebListener;

@WebListener
public class ApplicationInitializer implements ServletContextListener {

    public ApplicationInitializer() {
        
    }
	
    
    public void contextInitialized(ServletContextEvent sce){
		Logger LOGGER= Logger.getLogger(getClass());
    	try (
        		InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
        	    Properties prop = new Properties();
        	    if (input == null) {
        	       LOGGER.debug("impossible de trouver le fichier 'config.properties'");
        	    }
        	    prop.load(input);
        	    ServletContext context= sce.getServletContext();
        	    String type_stockage = prop.getProperty("type_stockage");
        	    
        	    IGameDataManagement gameData= DataManagementFactory.getFactory(type_stockage, context);
        		context.setAttribute("gameData", gameData);

        		List<User> userList = Collections.synchronizedList(new ArrayList<User>());
        		context.setAttribute("users", userList);
        	    
        	    
        	} catch (IOException ex) {
        		 throw new RuntimeException("Fichier de configuration 'config.properties' introuvable dans le chemin de classe.");
        	}
    	
    }
}
