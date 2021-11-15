package view;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import controller.contracts.IUserController;
import model.contracts.IUserModel;
import view.contracts.IUserView;

import javax.swing.UIManager;

public class UserView extends AbstractView implements IUserView {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -974787412692568207L;
	/**
	 * 
	 */

	private JTextField name;
	private JTextField surname;
	private JTextField currentDaySell;
	private JTextField maxHalfYearSell;
	
	private IUserController controller;
	
	public UserView() {
		super();
		
		initProperty();
		initComponents();
		addComponents();
		setPositionComponents();
		
		setEditableStatus(false);
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
		currentDaySell = new JTextField();
		maxHalfYearSell = new JTextField();	
		
		JLabel nameLabel;
		JLabel surnameLabel;
		JLabel currentDaySellLabel;
		JLabel maxHalfYearSellLabel;
		
		nameLabel = new JLabel("Nome");
		nameLabel.setBounds(12, 29, 100, 16);
		this.add(nameLabel);
		
		surnameLabel = new JLabel("Cognome");
		surnameLabel.setBounds(12, 86, 100, 16);
		this.add(surnameLabel);

		currentDaySellLabel = new JLabel("Vendite giornaliere");
		currentDaySellLabel.setBounds(152, 89, 175, 10);
		this.add(currentDaySellLabel);
		
		maxHalfYearSellLabel = new JLabel("Massimo vendite per semestre");
		maxHalfYearSellLabel.setBounds(152, 32, 175, 10);
		this.add(maxHalfYearSellLabel);
	}

	@Override
	public void addComponents() {
		this.add(name);
		this.add(surname);
		this.add(currentDaySell);
		this.add(maxHalfYearSell);
	}

	@Override
	public void setPositionComponents() {
		name.setBounds(12, 42, 100, 20);
		surname.setBounds(12, 101, 100, 20);
		currentDaySell.setBounds(152, 101, 100, 20);
		maxHalfYearSell.setBounds(152, 42, 100, 20);
	}

	@Override
	public void setController(IUserController controller) {
		this.controller = controller;
	}

	@Override
	public IUserController getController() {
		return controller;
	}

	@Override
	public void updateUser(IUserModel user) {
		name.setText(user.getName());
		surname.setText(user.getSurname());
		currentDaySell.setText(String.valueOf(user.getDayCurrentSells()));
		maxHalfYearSell.setText(String.valueOf(user.getHalfYearMaxSells()));
	}
	
	private void setEditableStatus(boolean status) {
		name.setEditable(status);
		surname.setEditable(status);
		currentDaySell.setEditable(status);
		maxHalfYearSell.setEditable(status);
	}
	
}
