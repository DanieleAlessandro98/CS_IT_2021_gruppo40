package model;

import database.SellDAO;
import exception.DatabaseException;

public class SellManagment {
	
	public static void insertSell(IUserModel user, IRadioModel radio, ISellDetailModel sellDetail) {
		try {
			SellDAO.insertSell(user, radio, sellDetail);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
	}
	
}
