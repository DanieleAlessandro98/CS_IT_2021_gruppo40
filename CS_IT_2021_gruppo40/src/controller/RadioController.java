package controller;

import model.IRadioModel;
import view.RadioView;

public class RadioController {
	private IRadioModel model;
	private RadioView view;
	
	public RadioController(IRadioModel model, RadioView view) {
		this.model = model;
		this.view = view;
	}
	
}
