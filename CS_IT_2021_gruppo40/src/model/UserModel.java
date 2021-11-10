package model;

public class UserModel implements IUserModel {

	private int id;
	private String name;
	private String surname;
	private int halfYearMaxSells;
	
	public UserModel(int id, String name, String surname, int halfYearMaxSells) {
		this.id = id;
		this.name = name;
		this.surname = surname;
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
	public int getHalfYearMaxSells() {
		return halfYearMaxSells;
	}

}
