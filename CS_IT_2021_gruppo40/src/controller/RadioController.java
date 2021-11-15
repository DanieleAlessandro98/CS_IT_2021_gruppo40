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

	/**
	 * Metodo che effettua il binding tra il controller corrente e la propria vista di interesse
	 */
	@Override
	public void bindView() {
		view.setController(this);
	}

	/**
	 * Metodo che effettua il binding tra il controller corrente e gli observer di interesse
	 */
	@Override
	public void bindObserver() {
		observable.addObserverSelectRadio(this);
	}

	/**
	 * Metodo che gestisce l'aggiornamento dello stato della radio selezionata a seguito della selezione della radio che si è venduta
	 * 
	 * @param radioID ID della radio ottenuta a seguito della selezione della radio che si è venduta
	 */
	@Override
	public void updateSelectRadio(int radioID) {
		model.setData(radioID);
		view.updateRadio(model);
	}
	
}
