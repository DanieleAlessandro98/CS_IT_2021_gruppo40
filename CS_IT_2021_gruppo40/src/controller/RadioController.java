package controller;

import model.IRadioModel;
import model.RadioModel;
import view.IRadioView;

public class RadioController extends AbstractController implements IRadioController {
	private IRadioModel model;
	private IRadioView view;
	
	public RadioController(IRadioView view) {
		this.model = new RadioModel();
		this.view = view;
	}

	@Override
	public void bindView() {
		view.setController(this);
	}
	
}
