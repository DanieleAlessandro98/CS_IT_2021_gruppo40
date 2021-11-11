package controller;

import model.IRadioTableModel;
import model.RadioTableModel;
import view.IView;

public class RadioTableController {
	
	private IRadioTableModel model;
	private IView view;
	
	public RadioTableController(IView view) {
		this.model = new RadioTableModel();
		this.view = view;
	}
	
}
