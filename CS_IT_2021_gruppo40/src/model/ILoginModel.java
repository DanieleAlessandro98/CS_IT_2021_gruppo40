package model;

import exception.LoginException;

public interface ILoginModel {
	public void login(String username, String password) throws LoginException;
}
