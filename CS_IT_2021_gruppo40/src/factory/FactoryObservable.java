package factory;

import model.LoginModel;
import model.RadioModel;
import model.RadioTableModel;
import model.SellDetailModel;
import model.UserModel;
import observer.ObservableLogin;
import observer.ObservableRadio;
import observer.ObservableSelectRadio;
import observer.ObservableSellDetail;
import observer.ObservableUser;
import observer.ObserverLogin;
import observer.ObserverRadio;
import observer.ObserverSelectRadio;
import observer.ObserverSellDetail;
import observer.ObserverUser;

public class FactoryObservable {

	private ObservableLogin observableLogin;
	private ObservableSelectRadio observableSelectRadio;
	private ObservableUser observableUser;
	private ObservableRadio observableRadio;
	private ObservableSellDetail observableSellDetail;
	
	public FactoryObservable() {
		observableLogin = new LoginModel();
		observableSelectRadio = new RadioTableModel();
		observableUser = new UserModel();
		observableRadio = new RadioModel();
		observableSellDetail = new SellDetailModel();
	}
	
	public void addObserverLogin(ObserverLogin observer) {
		observableLogin.addObserver(observer);
	}
	
	public void addObserverSelectRadio(ObserverSelectRadio observer) {
		observableSelectRadio.addObserver(observer);
	}
	
	public void addObserverUser(ObserverUser observer) {
		observableUser.addObserver(observer);
	}
	
	public void addObserverRadio(ObserverRadio observer) {
		observableRadio.addObserver(observer);
	}
	
	public void addObserverSellDetail(ObserverSellDetail observer) {
		observableSellDetail.addObserver(observer);
	}
	
	public ObservableLogin getObservableLogin() {
		return observableLogin;
	}
	
	public ObservableSelectRadio getObservableSelectRadio() {
		return observableSelectRadio;
	}
	
	public ObservableUser getObservableUser() {
		return observableUser;
	}
	
	public ObservableRadio getObservableRadio() {
		return observableRadio;
	}
	
	public ObservableSellDetail getObservableSellDetail() {
		return observableSellDetail;
	}
	
}
