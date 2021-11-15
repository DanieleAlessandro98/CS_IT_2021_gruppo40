package view.contracts;

import controller.contracts.IUserController;
import model.contracts.IUserModel;

public interface IUserView {
	public void setController(IUserController controller);
	public IUserController getController();
	
	public void updateUser(IUserModel user);
}
