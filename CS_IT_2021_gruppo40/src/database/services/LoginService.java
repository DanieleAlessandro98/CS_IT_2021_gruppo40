package database.services;

/**
 * Classe che si occupa di interfacciarsi con la relativa classe DAO con lo scopo di acquisire o memorizzare informazioni relative al login
 */
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
