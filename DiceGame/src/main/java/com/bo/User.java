package com.bo;

import java.util.ArrayList;
import java.util.List;

public class User {
	String firstName;
	String lastName;
	String login;
	String password;
	int actualScore;
	int bestScore;
	int compteurLancer;
	
	public User() {
		
	}
	
	public User(String FirstName, String LastName, String Login, String Password) {
		this.firstName= FirstName;
		this.lastName= LastName;
		this.login= Login;
		this.password= Password;
		this.actualScore= 0;
		this.bestScore= 0;
		this.compteurLancer= 0;
	}

	public User(String FirstName, String LastName, String Login, String Password, int actualScore, int bestScore) {
		this.firstName= FirstName;
		this.lastName= LastName;
		this.login= Login;
		this.password= Password;
		this.actualScore= actualScore;
		this.bestScore= bestScore;
		this.compteurLancer= 0;
	}
	

	@Override
	public String toString() {
		return "User [FirstName=" + firstName + ", LastName=" + lastName + ", Login=" + login + ", Password=" + password
				+ ", score=" + actualScore + ", bestScore=" + bestScore + ", compteurLancer=" + compteurLancer + "]";
	}

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getActualScore() {
		return actualScore;
	}

	public void setActualScore(int actualScore) {
		this.actualScore = actualScore;
	}
	
	public int getCompteurLancer() {
		return compteurLancer;
	}

	public void setCompteurLancer(int compteurLancer) {
		this.compteurLancer = compteurLancer;
	}
	
	public void incrementCompteurLance() {
		this.compteurLancer++;
	}
	
	public void setBestScore(int actualScore) {
		this.bestScore= actualScore;
	}
	
	public int getBestScore() {
		return bestScore;
	}
	
	
}
