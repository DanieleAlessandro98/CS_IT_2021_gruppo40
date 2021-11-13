package model;

import java.util.ArrayList;
import java.util.List;

import observer.ObservableLogin;
import observer.ObserverLogin;
import utility.Window;

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
	public void login(String username, String password) {
		this.username = username;
		this.password = password;
		
		processLogin();
	}
	
	private void processLogin() {
		userID = LoginManagment.login(username, password);
		
		if (userID == -1)
			System.out.println("Error1 login ....");		// Probabilmente gestito in seguito con exception
		else
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