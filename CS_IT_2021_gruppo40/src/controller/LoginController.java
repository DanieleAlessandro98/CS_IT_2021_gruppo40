package controller;

import model.ILoginModel;
import observer.Observable;
import view.ILoginView;

public class LoginController extends AbstractController implements ILoginController {

	private ILoginModel model;
	private ILoginView view;
	
	public LoginController(Observable observable, ILoginView view) {
		super(observable);
		
		this.model = (ILoginModel) observable.getObservableLogin();
		this.view = view;
	}
	
	@Override
	public void bindView() {
		view.setController(this);
	}

	@Override
	public void loginActionListener(String username, String password) {
		model.login(username, password);
	}

}
