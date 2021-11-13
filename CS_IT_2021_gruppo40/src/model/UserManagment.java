package model;

import database.UserDAO;

public class UserManagment {

	public static int getDayCurrentSells(int userID) {
		return UserDAO.getDayCurrentSells(userID);
	}
	
	public static int getHalfYearCurrentSells(int userID) {
		return UserDAO.getHalfYearCurrentSells(userID);
	}
	
	public static IUserModel getData(int userID) {
		return UserDAO.getData(userID);
	}
	
}
