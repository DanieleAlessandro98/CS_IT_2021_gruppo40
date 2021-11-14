package observer;

import model.LoginModel;
import model.RadioTableModel;

public class Observable {

	private ObservableLogin observableLogin;
	private ObservableSelectRadio observableSelectRadio;
	
	public Observable() {
		observableLogin = new LoginModel();
		observableSelectRadio = new RadioTableModel();
	}
	
	public void addObserverLogin(ObserverLogin observer) {
		observableLogin.addObserver(observer);
	}
	
	public void addObserverSelectRadio(ObserverSelectRadio observer) {
		observableSelectRadio.addObserver(observer);
	}
	
	public ObservableLogin getObservableLogin() {
		return observableLogin;
	}
	
	public ObservableSelectRadio getObservableSelectRadio() {
		return observableSelectRadio;
	}
	
}
