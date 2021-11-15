package database.services;

/**
 * Classe che si occupa di interfacciarsi con la relativa classe DAO con lo scopo di acquisire o memorizzare informazioni relative al login
 */
import database.DAO.LoginDAO;
import exception.DatabaseException;

public class LoginService {
	
	/**
	 * Metodo che si relaziona con la relativa classe DAO e gestisce eventuali errori
	 * @param username Username dell'utente dato in input
	 * @param password Password dell'utente dato in input
	 * @return ID dell'utente
	 */
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
