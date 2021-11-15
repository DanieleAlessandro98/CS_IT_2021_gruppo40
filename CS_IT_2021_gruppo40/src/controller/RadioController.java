package controller;

/**
 * Classe concreta del package Controller
 * Si occupa di creare e gestire la connessione tra i dati della radio (già selezionata) presenti nel model, e la visualizzazione di questi nella view
 * @author Alex
 *
 */
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
	public void updateSelectRadio(int radioID) {
		model.setData(radioID);
		view.updateRadio(model);
	}
	
}
