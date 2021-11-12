package model;

import database.LoginDAO;

public class LoginManagment {
	
	public static boolean login(String username, String password) {
		return LoginDAO.login(username, password);
	}
	
}
