package model;

import java.util.ArrayList;
import java.util.List;

import exception.LoginException;
import exception.LoginExceptionMessage;
import observer.ObservableLogin;
import observer.ObserverLogin;

public class LoginModel implements ILoginModel, ObservableLogin {
	
	private String username;
	private String password;
	private int userID;
	
	private List<ObserverLogin> observers;
	
	public LoginModel() {
		userID = -1;
		
		observers = new ArrayList<>();
	}
	
	public LoginModel(String username, String password) {
		this.username = username;
		this.password = password;
		userID = -1;
		
		observers = new ArrayList<>();
	}

	@Override
	public void login(String username, String password) throws LoginException {
		this.username = username;
		this.password = password;
		
		processLogin();
	}
	
	private void processLogin() throws LoginException {
		userID = LoginManagment.login(username, password);
		
		if (userID == -1)
			throw new LoginException(LoginExceptionMessage.LOGIN_USER_NOT_FOUND);

		notifyObservers();
	}

	@Override
	public void addObserver(ObserverLogin observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(ObserverLogin observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (ObserverLogin ob : observers)
			ob.update(userID);
	}
	
}