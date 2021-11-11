package controller;

import model.IRadioTableModel;
import view.IView;

public class RadioTableController {
	
	private IRadioTableModel model;
	private IView view;
	
	public RadioTableController(IRadioTableModel model, IView view) {
		this.model = model;
		this.view = view;
	}
	
}
