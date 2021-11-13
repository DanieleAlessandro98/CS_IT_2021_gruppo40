package observer;

import model.LoginModel;

public class Observable {

	private ObservableLogin observableLogin;
	
	public Observable() {
		observableLogin = new LoginModel();
	}
	
	public void addObserverLogin(ObserverLogin observer) {
		observableLogin.addObserver(observer);
	}
	
	public ObservableLogin getObservableLogin() {
		return observableLogin;
	}
	
}
