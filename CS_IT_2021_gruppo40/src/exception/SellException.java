package exception;

/**
 * Classe che si occupa di gestire e/o catturare eventuali errori/eccezioni che possono presentarsi per quanto riguarda la vendita
 * @author Alex
 *
 */
public class SellException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3695754011611279502L;
	/**
	 * 
	 */
	
	public SellException() {}
	
	public SellException(String msg) {
		super(msg);
	}
	
}
