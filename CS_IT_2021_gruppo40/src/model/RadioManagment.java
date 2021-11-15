package model;

import java.util.List;

import database.RadioDAO;
import exception.DatabaseException;

public class RadioManagment {

	public static List<IRadioModel> getRadiosData() {
		List<IRadioModel> result = null;
		
		try {
			result = RadioDAO.getRadiosData();
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static IRadioModel getData(int radioID) {
		IRadioModel result = null;
		
		try {
			result = RadioDAO.getData(radioID);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
