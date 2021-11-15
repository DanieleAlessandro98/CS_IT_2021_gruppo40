package view;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import controller.contracts.IUserController;
import model.contracts.IUserModel;
import view.contracts.IUserView;

import javax.swing.UIManager;

/**
 *  * Classe concreta del package view
 * Si occupa anche di implementare tutto ciò che occorre per la visualizzazione grafica dei dati dell'utente
 * @author Alex
 *
 */
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

	/**
	 * Metodo che si occupa di inizializzare le proprietà del componente grafico
	 */
	@Override
	public void initProperty() {
		this.setLayout(null);
		this.setBounds(10, 10, 355, 145);
		this.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dipendente", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
	}

	/**
	 * Metodo che si occupa di istanziare gli elementi grafici
	 */
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

	/**
	 * Metodo astratto che si occupa di aggiungere gli elementi grafici al componente padre
	 */
	@Override
	public void addComponents() {
		this.add(name);
		this.add(surname);
		this.add(currentDaySell);
		this.add(maxHalfYearSell);
	}

	/**
	 * Metodo che si occupa di posizionare gli elementi grafici all'interno del componente padre
	 */
	@Override
	public void setPositionComponents() {
		name.setBounds(12, 42, 100, 20);
		surname.setBounds(12, 101, 100, 20);
		currentDaySell.setBounds(152, 101, 100, 20);
		maxHalfYearSell.setBounds(152, 42, 100, 20);
	}

	/**
	 * Metodo che associa il corrispettivo controller
	 */
	@Override
	public void setController(IUserController controller) {
		this.controller = controller;
	}

	/**
	 * Metodo che restituisce il corrispettivo controller
	 */
	@Override
	public IUserController getController() {
		return controller;
	}

	/**
	 * Aggirna i dati dell'utente
	 */
	@Override
	public void updateUser(IUserModel user) {
		name.setText(user.getName());
		surname.setText(user.getSurname());
		currentDaySell.setText(String.valueOf(user.getDayCurrentSells()));
		maxHalfYearSell.setText(String.valueOf(user.getHalfYearMaxSells()));
	}
	
	/**
	 * Metodo che setta lo status che devono avere i componenti
	 * @param status Status dei componenti
	 */
	private void setEditableStatus(boolean status) {
		name.setEditable(status);
		surname.setEditable(status);
		currentDaySell.setEditable(status);
		maxHalfYearSell.setEditable(status);
	}
	
}
