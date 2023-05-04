package com.web.helpers;

import java.util.List;

import com.bo.User;

public interface IGameDataManagement {
	
	public List<User> getAllUsers();

	public void updateBestScore(User user);

	public void insertUser(User user);

	public User getUserByLogin(String login);

}
