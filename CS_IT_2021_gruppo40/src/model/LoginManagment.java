package model;

import database.LoginDAO;

public class LoginManagment {
	
	public static int login(String username, String password) {
		return LoginDAO.login(username, password);
	}
	
}
