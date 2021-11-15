package model.contracts;

import exception.LoginException;

public interface ILoginModel extends IModel {
	public void login(String username, String password) throws LoginException;
}
