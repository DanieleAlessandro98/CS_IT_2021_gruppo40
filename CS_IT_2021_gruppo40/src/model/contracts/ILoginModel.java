package model.contracts;

import exception.LoginException;

/**
 * Interfaccia del model che si occupa della parte di login
 * @author Alex
 *
 */
public interface ILoginModel extends IModel {
	public void login(String username, String password) throws LoginException;
}
