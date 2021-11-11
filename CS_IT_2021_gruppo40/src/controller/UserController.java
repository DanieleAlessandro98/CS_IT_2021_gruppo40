package controller;

import model.IUserModel;
import view.IView;

public class UserController {
	private IUserModel model;
	private IView view;
	
	public UserController(IUserModel model, IView view) {
		this.model = model;
		this.view = view;
	}
	
}
