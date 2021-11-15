package model;

import model.contracts.IModel;

public abstract class AbstractModel implements IModel {

	@Override
	abstract public boolean isValidData();

}
