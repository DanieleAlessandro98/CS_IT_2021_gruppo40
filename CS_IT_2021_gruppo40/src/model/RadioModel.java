package model;

public class RadioModel implements IRadioModel {

	private int id;
	private Brand brand;
	private Type type;
	private int size;
	private String color;
	private String optional;
	private String antenna;
	
	public RadioModel() {}
	
	public RadioModel(int id, Brand brand, Type type, int size, String color, String optional, String antenna) {
		this.id = id;
		this.brand = brand;
		this.type = type;
		this.size = size;
		this.color = color;
		this.optional = optional;
		this.antenna = antenna;
	}

	@Override
	public int getID() {
		return id;
	}

	@Override
	public Brand getBrand() {
		return brand;
	}

	@Override
	public Type getType() {
		return type;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public String getOptional() {
		return optional;
	}

	@Override
	public String getAntenna() {
		return antenna;
	}

}
