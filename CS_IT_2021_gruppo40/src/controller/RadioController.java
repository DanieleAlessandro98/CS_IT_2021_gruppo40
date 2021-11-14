package controller;

import model.IRadioModel;
import model.RadioModel;
import observer.Observable;
import observer.ObserverSelectRadio;
import view.IRadioView;

public class RadioController extends AbstractController implements IRadioController, ObserverSelectRadio {
	
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

	@Override
	public void bindObserver() {
		observable.addObserverSelectRadio(this);
	}

	@Override
	public void update(int radioID) {
		model.setData(radioID);
		view.updateRadio(model);
	}
	
}
