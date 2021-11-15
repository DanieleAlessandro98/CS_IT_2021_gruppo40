package model;

import java.util.ArrayList;
import java.util.List;

import exception.LoginException;
import exception.LoginExceptionMessage;
import observer.ObservableLogin;
import observer.ObserverLogin;

public class LoginModel extends AbstractModel implements ILoginModel, ObservableLogin {
	
	private String username;
	private String password;
	private int userID;

	private List<ObserverLogin> observers;
	
	public LoginModel() {
		setUserID(-1);
		
		observers = new ArrayList<>();
	}
	
	public LoginModel(String username, String password) {
		this.username = username;
		this.password = password;
		setUserID(-1);
		
		observers = new ArrayList<>();
	}

	@Override
	public void login(String username, String password) throws LoginException {
		this.username = username;
		this.password = password;
		
		processLogin();
	}
	
	private void processLogin() throws LoginException {
		setUserID(LoginManagment.login(username, password));
		
		if (!isValidData())
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
			ob.update(getUserID());
	}

	@Override
	public boolean isValidData() {
		if (username == null || username == "")
			return false;
		
		if (password == null || password == "")
			return false;
		
		if (getUserID() == -1)
			return false;

		return true;
	}
	
	private int getUserID() {
		return userID;
	}

	private void setUserID(int userID) {
		this.userID = userID;
	}
	
}