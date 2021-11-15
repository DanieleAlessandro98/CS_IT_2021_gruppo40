package factory;

import model.LoginModel;
import model.RadioModel;
import model.RadioTableModel;
import model.SellDetailModel;
import model.SellModel;
import model.UserModel;
import observer.ObservableLogin;
import observer.ObservableRadio;
import observer.ObservableSelectRadio;
import observer.ObservableSell;
import observer.ObservableSellDetail;
import observer.ObservableUser;
import observer.ObserverLogin;
import observer.ObserverRadio;
import observer.ObserverSelectRadio;
import observer.ObserverSell;
import observer.ObserverSellDetail;
import observer.ObserverUser;

public class FactoryObservable {

	private ObservableLogin observableLogin;
	private ObservableSelectRadio observableSelectRadio;
	private ObservableUser observableUser;
	private ObservableRadio observableRadio;
	private ObservableSellDetail observableSellDetail;
	private ObservableSell observableSell;
	
	public FactoryObservable() {
		observableLogin = new LoginModel();
		observableSelectRadio = new RadioTableModel();
		observableUser = new UserModel();
		observableRadio = new RadioModel();
		observableSellDetail = new SellDetailModel();
		observableSell = new SellModel();
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
	
	public void addObserverSell(ObserverSell observer) {
		observableSell.addObserver(observer);
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
	
	public ObservableSell getObservableSell() {
		return observableSell;
	}
	
}
