package com.web.helpers;

import com.web.dao.GameContextManagement;
import com.web.dao.GameDatabaseManagement;

import jakarta.servlet.ServletContext;

public class DataManagementFactory {
	public static IGameDataManagement getFactory(String type, ServletContext context) {
		if(!"db".equals(type)) {
			return GameContextManagement.getInstance(context);
		}
		return GameDatabaseManagement.getInstance();
	}
}
