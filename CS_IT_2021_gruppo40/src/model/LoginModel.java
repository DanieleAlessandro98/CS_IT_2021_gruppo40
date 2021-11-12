package model;

public class LoginModel implements ILoginModel {
	
	private String username;
	private String password;
	
	public LoginModel() {}
	
	public LoginModel(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@Override
	public void login(String username, String password) {
		this.username = username;
		this.password = password;
		
		processLogin();
	}
	
	private void processLogin() {
		boolean loginSuccessful = LoginManagment.login(username, password);
		
		if (!loginSuccessful)
			System.out.println("Error1 login ....");		// Probabilmente gestito in seguito con exception
	}
	
}
