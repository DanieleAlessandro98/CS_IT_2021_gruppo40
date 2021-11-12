package model;

import java.util.List;

import database.RadioDAO;

public class RadioManagment {

	public static List<IRadioModel> getRadiosData() {
		return RadioDAO.getRadiosData();
	}
	
}
