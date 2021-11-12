package model;

public class LoginModel implements ILoginModel {
	
	private String username;
	private String password;
	
	public LoginModel() {}
	
	public LoginModel(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
}
