package utility;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Classe di utilità generale che si occupa della manipolazione delle password (formato MD5)
 * @author Alex
 *
 */
public class Hash {

	/**
	 * Converte una determinata stringa in input in formato MD5
	 * {@link https://stackoverflow.com/a/421696}
	 * @author user49913
	 * @param password Password corrente
	 * @return Restituisce la stringa convertita in MD5
	 */
	public static String getMD5String(String password) {
		String result = null;
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.reset();
			md.update(password.getBytes());
			byte[] digest = md.digest();
			BigInteger bigInt = new BigInteger(1, digest);
			
			result = bigInt.toString(16);
					
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
