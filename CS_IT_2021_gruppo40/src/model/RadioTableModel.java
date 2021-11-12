package model;

import java.util.List;

public class RadioTableModel implements IRadioTableModel {
	
	private int selectedRadioID;
	
	public RadioTableModel() {
		selectedRadioID = -1;
	}

	@Override
	public int getSelectedRadioID() {
		return selectedRadioID;
	}
	
	@Override
	public List<IRadioModel> initRadioTable() {
		return RadioManagment.getRadiosData();
	}

	@Override
	public void selectRadio(int radioID) {
		this.selectedRadioID = radioID;
	}
	
}
