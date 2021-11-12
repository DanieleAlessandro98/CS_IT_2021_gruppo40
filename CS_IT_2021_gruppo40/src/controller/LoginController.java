package controller;

import model.ILoginModel;
import model.LoginModel;
import view.ILoginView;

public class LoginController extends AbstractController implements ILoginController {

	private ILoginModel model;
	private ILoginView view;
	
	public LoginController(ILoginView view) {
		this.model = new LoginModel();
		this.view = view;
	}
	
	@Override
	public void bindView() {
		view.setController(this);
	}

}
