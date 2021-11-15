package database.services;

import database.DAO.LoginDAO;
import exception.DatabaseException;

public class LoginService {
	
	public static int login(String username, String password) {
		int result = -1;
		
		try {
			result = LoginDAO.login(username, password);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
