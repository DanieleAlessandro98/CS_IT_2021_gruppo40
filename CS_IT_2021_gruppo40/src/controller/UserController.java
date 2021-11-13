package controller;

import model.IUserModel;
import model.UserModel;
import observer.Observable;
import view.IUserView;

public class UserController extends AbstractController implements IUserController {
	
	private IUserModel model;
	private IUserView view;
	
	public UserController(Observable observable, IUserView view) {
		super(observable);
		
		this.model = new UserModel();
		this.view = view;
	}

	@Override
	public void bindView() {
		view.setController(this);
	}

}
