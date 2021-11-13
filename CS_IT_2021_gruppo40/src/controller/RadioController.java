package controller;

import model.IRadioModel;
import model.RadioModel;
import observer.Observable;
import view.IRadioView;

public class RadioController extends AbstractController implements IRadioController {
	
	private IRadioModel model;
	private IRadioView view;
	
	public RadioController(Observable observable, IRadioView view) {
		super(observable);
		
		this.model = new RadioModel();
		this.view = view;
	}

	@Override
	public void bindView() {
		view.setController(this);
	}
	
}
