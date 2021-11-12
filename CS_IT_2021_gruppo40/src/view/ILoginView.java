package view;

import controller.ILoginController;

public interface ILoginView {
	public void setController(ILoginController controller);
	public ILoginController getController();
}
