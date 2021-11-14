package controller;

import model.IUserModel;
import observer.Observable;
import observer.ObserverLogin;
import view.IUserView;

public class UserController extends AbstractController implements IUserController, ObserverLogin {
	
	private IUserModel model;
	private IUserView view;
	
	public UserController(Observable observable, IUserView view) {
		super(observable);
		
		this.model = (IUserModel) observable.getObservableUser();
		this.view = view;
	}

	@Override
	public void bindView() {
		view.setController(this);
	}

	@Override
	public void bindObserver() {
		observable.addObserverLogin(this);
	}

	@Override
	public void update(int userID) {
		model.setData(userID);
		view.updateUser(model);
	}

}
