package utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateFormat {

	public static java.sql.Date convertToSQLFormat(java.util.Date utilDate) {
		return new java.sql.Date(utilDate.getTime());
	}
	
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
	
	public static Date valueOf(String dateString) {
		Date date = null;
		try {
			date = new SimpleDateFormat("dd/mm/yyyy HH:mm").parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
	}
	
}
