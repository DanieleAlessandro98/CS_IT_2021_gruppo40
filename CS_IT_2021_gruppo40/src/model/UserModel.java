package model;

public class UserModel implements IUserModel {

	private int id;
	private String name;
	private String surname;
	private int dayCurrentSells;
	private int halfYearMaxSells;
	
	public UserModel() {}
	
	public UserModel(int id, String name, String surname, int halfYearMaxSells) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.dayCurrentSells = 0;		// test
		this.halfYearMaxSells = halfYearMaxSells;
	}

	@Override
	public int getID() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getSurname() {
		return surname;
	}

	@Override
	public int getDayCurrentSells() {
		return dayCurrentSells;
	}
	
	@Override
	public int getHalfYearMaxSells() {
		return halfYearMaxSells;
	}

	@Override
	public void setDayCurrentSells(int numSells) {
		this.dayCurrentSells = numSells;
	}

}
