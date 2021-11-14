package controller;

import model.ISellModel;
import model.SellModel;
import observer.Observable;
import observer.ObserverRadio;
import observer.ObserverSellDetail;
import observer.ObserverUser;
import view.IRadioTableView;
import view.IRadioView;
import view.ISellDetailView;
import view.ISellView;
import view.IUserView;

public class SellController extends AbstractController implements ISellController, ObserverUser, ObserverRadio, ObserverSellDetail {
	
	private ISellModel model;
	private ISellView view;
	
	private IController userController;
	private IController sellDetailController;
	private IController radioController;
	private IController radioTableController;
	
	public SellController(Observable observable, ISellView view) {
		super(observable);
		
		this.model = new SellModel();
		this.view = view;
		
		initControllers();
	}
	
	private void initControllers() {
		userController = new UserController(observable, (IUserView) view.getUserView());
		sellDetailController = new SellDetailController(observable, (ISellDetailView) view.getSellDetailView());
		radioController = new RadioController(observable, (IRadioView) view.getRadioView());
		radioTableController = new RadioTableController(observable, (IRadioTableView) view.getRadioTableView());
	}

	@Override
	public void bindView() {
		view.setController(this);
		
		userController.bindView();
		sellDetailController.bindView();
		radioController.bindView();
		radioTableController.bindView();
	}

	@Override
	public void bindObserver() {
		observable.addObserverUser(this);
		observable.addObserverRadio(this);
		observable.addObserverSellDetail(this);
		
		userController.bindObserver();
		sellDetailController.bindObserver();
		radioController.bindObserver();
		radioTableController.bindObserver();
	}
	
	@Override
	public void insertSellActionListener() {
		model.insertSell();
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
