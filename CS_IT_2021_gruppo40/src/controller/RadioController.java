package controller;

import controller.contracts.IRadioController;
import factory.FactoryObservable;
import model.contracts.IRadioModel;
import observer.ObserverSelectRadio;
import view.contracts.IRadioView;

public class RadioController extends AbstractController implements IRadioController, ObserverSelectRadio {
	
	private IRadioModel model;
	private IRadioView view;
	
	public RadioController(FactoryObservable observable, IRadioView view) {
		super(observable);
		
		this.model = (IRadioModel) observable.getObservableRadio();
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
