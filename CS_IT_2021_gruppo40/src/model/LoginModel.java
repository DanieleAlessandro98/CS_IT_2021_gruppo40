package model;

import java.util.ArrayList;
import java.util.List;

import database.services.LoginService;
import exception.LoginException;
import exception.LoginExceptionMessage;
import model.contracts.ILoginModel;
import observer.ObservableLogin;
import observer.ObserverLogin;

/**
 * Classe concreta del package Model
 * Si occupa anche di implementare la logica di business per quanto riguarda la fase di login
 * @author Alex
 *
 */
public class LoginModel extends AbstractModel implements ILoginModel, ObservableLogin {
	
	private String username;
	private String password;
	private int userID;

	private List<ObserverLogin> observers;
	
	public LoginModel() {
		setUserID(-1);
		
		observers = new ArrayList<>();
	}

	@Override
	public void login(String username, String password) throws LoginException {
		this.username = username;
		this.password = password;
		
		processLogin();
	}
	
	/**
	 * Metodo che applica la logica di business del login a seguito dell'interazione con l'utente
	 * Il controller verrà notificato in caso di errore (ad esmepio login errato)
	 * 
	 */
	private void processLogin() throws LoginException {
		setUserID(LoginService.login(username, password));
		
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
			ob.updateLogin(getUserID());
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