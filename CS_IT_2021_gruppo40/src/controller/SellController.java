package controller;

import java.util.ArrayList;
import java.util.List;

import controller.contracts.IController;
import controller.contracts.ISellController;
import exception.SellException;
import factory.FactoryObservable;
import factory.FactorySell;
import factory.WindowsSell;
import model.contracts.ISellModel;
import observer.ObserverRadio;
import observer.ObserverSellDetail;
import observer.ObserverUser;
import view.contracts.ISellView;

/**
 * Classe concreta del package Controller
 * Si occupa di istanziare quelli che sono i controller che componogono la vendita (in questo caso l'utente, la radio selezionata, i dettagli della vendita
 * e le radio presenti nel database).
 * Inoltre una volta fatto ciò, svolge le operazioni principali per il binding di questi controller
 * Si occupa anche di creare e gestire la connessione tra il model e la view
 * @author Alex
 *
 */
public class SellController extends AbstractController implements ISellController, ObserverUser, ObserverRadio, ObserverSellDetail {
	
	private ISellModel model;
	private ISellView view;
	
	private List<IController> controllers;
	private FactorySell factorySell;
	
	public SellController(FactoryObservable observable, ISellView view) {
		super(observable);
		
		this.model = (ISellModel) observable.getObservableSell();
		this.view = view;
		
		controllers = new ArrayList<>();
		factorySell = new FactorySell();
		
		initControllers();
	}
	
	/**
	 * Metodo che gestisce l'inizializzazione di quelli che sono i controller associati alla vendita e li aggiunge alla lista usando il factory
	 */
	private void initControllers() {
		for (WindowsSell window : WindowsSell.values())
			controllers.add(factorySell.getController(observable, view, window));
	}

	/**
	 * Metodo che richiama per ogni controller della vendita, il relativo metodo per associarlo con la view
	 */
	@Override
	public void bindView() {
		view.setController(this);
		
		for (IController controller : controllers)
			controller.bindView();
	}

	/**
	 * Metodo che richiama per ogni controller della vendita, il relativo metodo per associarlo con gli observer
	 */
	@Override
	public void bindObserver() {
		observable.addObserverUser(this);
		observable.addObserverRadio(this);
		observable.addObserverSellDetail(this);
		
		for (IController controller : controllers)
			controller.bindObserver();
	}
	
	/**
	 * Metodo che gestisce l'action lister dell'insertimento della vendita (il button) a seguito dell'interazione con l'utente
	 */
	@Override
	public void insertSellActionListener() {
		try {
			model.insertSell();
			view.insertSellSuccessful();
		} catch (SellException e) {
			view.insertSellFailed(e.getMessage());
		}
	}

	/**
	 * Metodo che gestire l'aggiornamento dello stato dell'utente corrente
	 */
	@Override
	public void updateUser(Object user) {
		model.setUser(user);
	}

	/**
	 * Metodo che gestire l'aggiornamento dello stato della radio corrente
	 */
	@Override
	public void updateRadio(Object radio) {
		model.setRadio(radio);
	}

	/**
	 * Metodo che gestire l'aggiornamento dello stato dei dettagli della vendita
	 */
	@Override
	public void updateSellDetail(Object sellDetail) {
		model.setSellDetail(sellDetail);
	}

}
