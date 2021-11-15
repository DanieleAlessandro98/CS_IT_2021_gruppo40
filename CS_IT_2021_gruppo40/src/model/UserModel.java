package model;

import java.util.ArrayList;
import java.util.List;

import database.services.UserService;
import model.contracts.IUserModel;
import observer.ObservableUser;
import observer.ObserverUser;

public class UserModel extends AbstractModel implements IUserModel, ObservableUser {

	private int id;
	private String name;
	private String surname;
	private int dayCurrentSells;
	private int halfYearMaxSells;
	
	private List<ObserverUser> observers;
	
	public UserModel() {
		observers = new ArrayList<>();
	}
	
	public UserModel(int id, String name, String surname, int dayCurrentSells, int halfYearMaxSells) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.dayCurrentSells = dayCurrentSells;
		this.halfYearMaxSells = halfYearMaxSells;
		
		observers = new ArrayList<>();
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

	@Override
	public void setData(int userID) {
		IUserModel tempUser = UserService.getData(userID);
		
		this.id = tempUser.getID();
		this.name = tempUser.getName();
		this.surname = tempUser.getSurname();
		this.dayCurrentSells = tempUser.getDayCurrentSells();
		this.halfYearMaxSells = tempUser.getHalfYearMaxSells();
		
		notifyObservers();
	}

	@Override
	public void addObserver(ObserverUser observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(ObserverUser observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (ObserverUser ob : observers) {
			ob.updateUser(this);
		}
	}

	@Override
	public boolean isValidData() {
		if (name == null || name == "")
			return false;

		if (surname == null || surname == "")
			return false;

		return true;
	}

}
