package model;

import java.util.List;

public interface IRadioTableModel extends IModel {
	public int getSelectedRadioID();
	
	public List<IRadioModel> initRadioTable();
	public void selectRadio(int radioID);
}
