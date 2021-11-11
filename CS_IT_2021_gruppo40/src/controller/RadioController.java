package controller;

import model.IRadioModel;
import model.RadioModel;
import view.IView;

public class RadioController {
	private IRadioModel model;
	private IView view;
	
	public RadioController(IView view) {
		this.model = new RadioModel();
		this.view = view;
	}
	
}
