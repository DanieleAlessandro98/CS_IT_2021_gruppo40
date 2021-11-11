package view;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class UserView extends AbstractView {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -974787412692568207L;
	/**
	 * 
	 */

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
		this.setBounds(10, 10, 355, 145);
		this.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dipendente", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
	}

	@Override
	public void initComponents() {
		name = new JTextField();
		surname = new JTextField();
		maxHalfYearSell = new JTextField();	
		
		JLabel nameLabel;
		JLabel surnameLabel;
		JLabel maxHalfYearSellLabel;
		
		nameLabel = new JLabel("Nome");
		nameLabel.setBounds(12, 29, 100, 16);
		this.add(nameLabel);
		
		surnameLabel = new JLabel("Cognome");
		surnameLabel.setBounds(12, 86, 100, 16);
		this.add(surnameLabel);

		maxHalfYearSellLabel = new JLabel("Massimo vendite per semestre");
		maxHalfYearSellLabel.setBounds(152, 32, 175, 10);
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
		name.setBounds(12, 42, 100, 20);
		surname.setBounds(12, 101, 100, 20);
		maxHalfYearSell.setBounds(152, 42, 100, 20);
	}
	
}
