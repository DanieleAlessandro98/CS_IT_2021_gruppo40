package view;

import controller.IUserController;

public interface IUserView {
	public void setController(IUserController controller);
	public IUserController getController();
}
