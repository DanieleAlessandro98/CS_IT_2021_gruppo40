package view;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class SellDetailView extends AbstractView {
	
	private JTextField numRadio;
	private JTextField date;
	private JTextField price;
	
	/*
	 * Temporaneamente disabilitati
	 * Probabilmente info di user e radio saranno date dalle altre rispettive viste
	private JTextField user;
	private JTextField radio;
	*/
	
	public SellDetailView() {
		super();
		
		initProperty();
		initComponents();
		addComponents();
		setPositionComponents();
	}

	@Override
	public void initProperty() {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(300, 300));
	}

	@Override
	public void initComponents() {
		numRadio = new JTextField();
		date = new JTextField();
		price = new JTextField();
		
		/*
		user = new JTextField();
		radio = new JTextField();
		*/
		
		JLabel numRadioLabel;
		JLabel dateLabel;
		JLabel priceLabel;
		JLabel userLabel;
		JLabel radioLabel;
		
		numRadioLabel = new JLabel("Numero radio");
		numRadioLabel.setBounds(10, 10, 100, 10);
		this.add(numRadioLabel);
		
		dateLabel = new JLabel("Data");
		dateLabel.setBounds(10, 50, 100, 10);
		this.add(dateLabel);

		priceLabel = new JLabel("Prezzo");
		priceLabel.setBounds(150, 10, 100, 10);
		this.add(priceLabel);

		/*
		userLabel = new JLabel("Utente");
		userLabel.setBounds(150, 50, 100, 10);
		this.add(userLabel);

		radioLabel = new JLabel("Radio");
		radioLabel.setBounds(10, 100, 100, 10);
		this.add(radioLabel);
		*/
	}

	@Override
	public void addComponents() {
		this.add(numRadio);
		this.add(date);
		this.add(price);
		
		/*
		this.add(user);
		this.add(radio);
		*/
	}

	@Override
	public void setPositionComponents() {
		numRadio.setBounds(10, 20, 100, 20);
		date.setBounds(10, 60, 100, 20);
		price.setBounds(150, 20, 100, 20);
		
		/*
		user.setBounds(150, 60, 100, 20);
		radio.setBounds(10, 110, 100, 20);
		*/
	}
	
}
