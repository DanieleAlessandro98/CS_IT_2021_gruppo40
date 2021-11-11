package controller;

import model.IRadioModel;
import view.IView;

public class RadioController {
	private IRadioModel model;
	private IView view;
	
	public RadioController(IRadioModel model, IView view) {
		this.model = model;
		this.view = view;
	}
	
}
