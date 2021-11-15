package controller;

import controller.contracts.ILoginController;
import exception.LoginException;
import factory.FactoryObservable;
import model.contracts.ILoginModel;
import view.contracts.ILoginView;

/**
 * Classe concreta del package Controller
 * Si occupa anche di creare e gestire la connessione tra il model e la view per quanto riguarda la fase di login
 * @author Alex
 *
 */
public class LoginController extends AbstractController implements ILoginController {

	private ILoginModel model;
	private ILoginView view;
	
	public LoginController(FactoryObservable observable, ILoginView view) {
		super(observable);
		
		this.model = (ILoginModel) observable.getObservableLogin();
		this.view = view;
	}
	
	@Override
	public void bindView() {
		view.setController(this);
	}
	
	@Override
	public void bindObserver() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void loginActionListener(String username, String password) {
		try {
			model.login(username, password);
			view.loginSuccessful();
		} catch (LoginException e) {
			view.loginFailed(e.getMessage());
		}
	}

}
