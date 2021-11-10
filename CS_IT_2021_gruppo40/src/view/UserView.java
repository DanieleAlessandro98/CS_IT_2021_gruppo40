package view;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class UserView extends AbstractView {
	
	private JTextField name;
	private JTextField surname;
	private JTextField maxHalfYearSell;
	
	public UserView() {
		super();
		
		initProperty();
		initComponents();
		addComponents();
		setPositionComponents();
	}

	@Override
	public void initProperty() {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(200, 200));
	}

	@Override
	public void initComponents() {
		name = new JTextField();
		name.setPreferredSize(new Dimension(50, 20));

		surname = new JTextField();
		surname.setPreferredSize(new Dimension(50, 20));

		maxHalfYearSell = new JTextField();	
		maxHalfYearSell.setPreferredSize(new Dimension(50, 20));
		
		JLabel nameLabel;
		JLabel surnameLabel;
		JLabel maxHalfYearSellLabel;
		
		nameLabel = new JLabel("Nome");
		nameLabel.setBounds(10, 10, 100, 10);
		this.add(nameLabel);
		
		surnameLabel = new JLabel("Cognome");
		surnameLabel.setBounds(10, 50, 100, 10);
		this.add(surnameLabel);

		maxHalfYearSellLabel = new JLabel("Massimo vendite per semestre");
		maxHalfYearSellLabel.setBounds(150, 10, 100, 10);
		this.add(maxHalfYearSellLabel);
	}

	@Override
	public void addComponents() {
		this.add(name);
		this.add(surname);
		this.add(maxHalfYearSell);
	}

	@Override
	public void setPositionComponents() {
		name.setBounds(10, 20, 100, 20);
		surname.setBounds(10, 60, 100, 20);
		maxHalfYearSell.setBounds(150, 20, 100, 20);
	}
	
}
