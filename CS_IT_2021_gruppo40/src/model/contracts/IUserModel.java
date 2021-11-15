package model.contracts;

/**
 * Interfaccia del model che si occupa dell'utente
 * @author Alex
 *
 */
public interface IUserModel extends IModel {
	public int getID();
	public String getName();
	public String getSurname();
	public int getDayCurrentSells();
	public int getHalfYearMaxSells();
	
	public void setData(int userID);
	public void setDayCurrentSells();
}
