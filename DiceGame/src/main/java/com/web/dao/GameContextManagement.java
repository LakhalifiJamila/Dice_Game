package com.web.dao;

import java.util.List;

import com.bo.User;
import com.web.helpers.IGameDataManagement;

import jakarta.servlet.ServletContext;

public class GameContextManagement implements IGameDataManagement{

	private ServletContext context;
	
	private static GameContextManagement instance;
	
	private GameContextManagement(ServletContext context) {
		this.context= context;
	}
	
	synchronized public static final GameContextManagement getInstance(ServletContext context) {
		if(instance==null) {
			instance= new GameContextManagement(context);
		}
		return instance;
	}

	@Override
	public List<User> getAllUsers() {
		return (List<User>)context.getAttribute("users");
	}

	@Override
	public void updateBestScore(User user) {
		List<User> list= getAllUsers();
		for(User u: list) {
			if(u.getLogin().equals(user.getLogin())) {
				u.setBestScore(user.getActualScore());
				break;
			}
		}
	}

	@Override
	public void insertUser(User user) {
		List<User> list= (List<User>)context.getAttribute("users");
		list.add(user);
	}

	@Override
	public User getUserByLogin(String login) {
		List<User> list= getAllUsers();
		
		for(User u: list) {
			if(u.getLogin().equals(login)) {
				return u;
			}
		}
		return null;
	}
	
	
}
