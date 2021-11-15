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
	
	private void initControllers() {
		for (WindowsSell window : WindowsSell.values())
			controllers.add(factorySell.getController(observable, view, window));
	}

	@Override
	public void bindView() {
		view.setController(this);
		
		for (IController controller : controllers)
			controller.bindView();
	}

	@Override
	public void bindObserver() {
		observable.addObserverUser(this);
		observable.addObserverRadio(this);
		observable.addObserverSellDetail(this);
		
		for (IController controller : controllers)
			controller.bindObserver();
	}
	
	@Override
	public void insertSellActionListener() {
		try {
			model.insertSell();
			view.insertSellSuccessful();
		} catch (SellException e) {
			view.insertSellFailed(e.getMessage());
		}
	}

	@Override
	public void updateUser(Object user) {
		model.setUser(user);
	}

	@Override
	public void updateRadio(Object radio) {
		model.setRadio(radio);
	}

	@Override
	public void updateSellDetail(Object sellDetail) {
		model.setSellDetail(sellDetail);
	}

}
