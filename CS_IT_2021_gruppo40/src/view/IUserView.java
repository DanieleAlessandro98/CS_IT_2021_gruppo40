package view;

import controller.IUserController;
import model.IUserModel;

public interface IUserView {
	public void setController(IUserController controller);
	public IUserController getController();
	
	public void updateUser(IUserModel user);
}
