package controller;

import model.IUserModel;
import view.UserView;

public class UserController {
	private IUserModel model;
	private UserView view;
	
	public UserController(IUserModel model, UserView view) {
		this.model = model;
		this.view = view;
	}
	
}
