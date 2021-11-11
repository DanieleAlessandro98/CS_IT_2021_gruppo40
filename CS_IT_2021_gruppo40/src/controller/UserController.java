package controller;

import model.IUserModel;
import model.UserModel;
import view.IView;

public class UserController {
	
	private IUserModel model;
	private IView view;
	
	public UserController(IView view) {
		this.model = new UserModel();
		this.view = view;
	}

}
