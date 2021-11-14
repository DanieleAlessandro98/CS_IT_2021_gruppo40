package model;

import java.util.List;

import database.RadioDAO;

public class RadioManagment {

	public static List<IRadioModel> getRadiosData() {
		return RadioDAO.getRadiosData();
	}
	
	public static IRadioModel getData(int radioID) {
		return RadioDAO.getData(radioID);
	}
	
}
