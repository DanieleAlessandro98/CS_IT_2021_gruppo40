package utility;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Classe di utilità generale che si occupa della manipolazione e formattazione delle date
 * @author Alex
 *
 */
public class DateFormat {

	/**
	 * Converte il formato della data da java.util.Date a java.sql.Date
	 * Utile per memorizzare sulla base di dati la data inserita
	 * @param utilDate Data inserita
	 * @return Data in formato SQL
	 */
	public static java.sql.Date convertToSQLFormat(java.util.Date utilDate) {
		return new java.sql.Date(utilDate.getTime());
	}
	
	/**
	 * Converte il formato della data da Date a Timestamp
	 * Utile per memorizzare sulla base di dati oltre che il dd-mm-yyyy ma anche l'ora ed il minuto
	 * @param utilDate Data inserita
	 * @return Data in formato timestamp
	 */
	public static Timestamp convertTimestampToSQLFormat(java.util.Date utilDate) {
		return new Timestamp(utilDate.getTime());
	}
	
	/**
	 * Serve per ottenere il range di date da controllare per conteggiare il numero di vendite effettuato in un semestre
	 * @return Range delle due date
	 */
	public static ArrayList<Date> getHalfYearRange() {
		ArrayList<Date> halfYearRange = new ArrayList<>();
		
		Calendar rightNow = Calendar.getInstance();
		int currentYear = rightNow.get(Calendar.YEAR);
		int currentMonth = rightNow.get(Calendar.MONTH);
		
		// Supponiamo che un semestre, per la traccia, corrisponde a 6 mesi (metà anno)
		// Suddividiamo in 2 parti il range in base al mese corrente
		if (currentMonth >= Calendar.JANUARY && currentMonth <= Calendar.JUNE)
		{
			halfYearRange.add(new GregorianCalendar(currentYear, Calendar.JANUARY, 1).getTime());
			halfYearRange.add(new GregorianCalendar(currentYear, Calendar.JULY, 31).getTime());
		}
		else
		{
			halfYearRange.add(new GregorianCalendar(currentYear, Calendar.JULY, 1).getTime());
			halfYearRange.add(new GregorianCalendar(currentYear, Calendar.DECEMBER, 31).getTime());
		}
		
		return halfYearRange;
	}
	
	/**
	 * Converte una stringa in formato data
	 * @param dateString Stringa inserita
	 * @return Data inserita
	 * @throws Exception
	 */
	public static Date valueOf(String dateString) throws Exception {
		Date date = null;
		try {
			date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(dateString);
		} catch (ParseException e) {
			throw new Exception();
		}
		
		return date;
	}
	
}
