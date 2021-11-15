package exception;

/**
 * Classe che si occupa di gestire e/o catturare eventuali errori/eccezioni che possono presentarsi per quanto riguarda il login
 * @author Alex
 *
 */
public class LoginException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1954246253432570683L;
	/**
	 * 
	 */
	
	public LoginException() {}
	
	public LoginException(String msg) {
		super(msg);
	}
	
}
