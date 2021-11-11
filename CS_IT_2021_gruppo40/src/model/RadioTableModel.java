package model;

import java.util.List;
import java.util.ArrayList;

public class RadioTableModel implements IRadioTableModel {
	
	private List<IRadioModel> radios;
	
	public RadioTableModel() {
		radios = new ArrayList<>();
	}
	
}
