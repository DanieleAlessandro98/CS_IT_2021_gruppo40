package observer;

import model.LoginModel;
import model.RadioTableModel;
import model.UserModel;

public class Observable {

	private ObservableLogin observableLogin;
	private ObservableSelectRadio observableSelectRadio;
	private ObservableUser observableUser;
	
	public Observable() {
		observableLogin = new LoginModel();
		observableSelectRadio = new RadioTableModel();
		observableUser = new UserModel();
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
	
	public ObservableLogin getObservableLogin() {
		return observableLogin;
	}
	
	public ObservableSelectRadio getObservableSelectRadio() {
		return observableSelectRadio;
	}
	
	public ObservableUser getObservableUser() {
		return observableUser;
	}
	
}
