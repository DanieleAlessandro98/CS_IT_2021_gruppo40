package view.contracts;

import controller.contracts.ILoginController;

/**
 * Interfaccia della view che si occupa della parte di login
 * @author Alex
 *
 */
public interface ILoginView {
	public void setController(ILoginController controller);
	public ILoginController getController();
	
	public void loginSuccessful();
	public void loginFailed(String errorMessage);
}
