package view.contracts;

import controller.contracts.IUserController;
import model.contracts.IUserModel;

/**
 * Interfaccia della view che si occupa dell'utente
 * @author Alex
 *
 */
public interface IUserView {
	public void setController(IUserController controller);
	public IUserController getController();
	
	public void updateUser(IUserModel user);
}
