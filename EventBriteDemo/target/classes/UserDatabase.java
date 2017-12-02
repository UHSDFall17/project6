
//package com.EventBrite.EventBriteDemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class UserDatabase {

	public String username, password, email;
	boolean isCorporate = false;

	public UserDatabase() {
		username = "";
		password = "";
		email = "";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String name) {
		username = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pass) {
		password = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String mail) {
		email = mail;
	}

	public boolean getCorporate() {
		return isCorporate;

	}

	public void setCorporate(boolean changeCorp) {
		isCorporate = changeCorp;
	}

}