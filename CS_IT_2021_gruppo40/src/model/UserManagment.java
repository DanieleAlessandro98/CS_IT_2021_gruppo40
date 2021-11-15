package model;

import database.UserDAO;
import exception.DatabaseException;

public class UserManagment {

	public static int getDayCurrentSells(int userID) {
		int result = -1;
		
		try {
			result = UserDAO.getDayCurrentSells(userID);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static int getHalfYearCurrentSells(int userID) {
		int result = -1;

		try {
			result = UserDAO.getHalfYearCurrentSells(userID);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static IUserModel getData(int userID) {
		IUserModel result = null;
		
		try {
			result = UserDAO.getData(userID);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
