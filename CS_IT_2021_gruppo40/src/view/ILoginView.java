package view;

import controller.ILoginController;

public interface ILoginView {
	public void setController(ILoginController controller);
	public ILoginController getController();
	
	public void loginSuccessful();
	public void loginFailed(String errorMessage);
}
