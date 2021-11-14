package observer;

import model.LoginModel;
import model.RadioModel;
import model.RadioTableModel;
import model.UserModel;

public class Observable {

	private ObservableLogin observableLogin;
	private ObservableSelectRadio observableSelectRadio;
	private ObservableUser observableUser;
	private ObservableRadio observableRadio;
	
	public Observable() {
		observableLogin = new LoginModel();
		observableSelectRadio = new RadioTableModel();
		observableUser = new UserModel();
		observableRadio = new RadioModel();
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
	
}
