package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.contracts.ILoginController;
import view.contracts.ILoginView;

/**
 * Classe concreta del package view
 * Si occupa anche di implementare tutto ciò che occorre per la visualizzazione grafica della fase di login
 * @author Alex
 *
 */
public class LoginView extends AbstractView implements ILoginView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1726149234228190070L;
	/**
	 * 
	 */
	
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton btnLogin;
	
	private ILoginController controller;
	
	public LoginView() {
		super();
		
		initProperty();
		initComponents();
		addComponents();
		setPositionComponents();
		
		initActionListener();
	}
	
	/**
	 * Associa gli action lister ai vari elementi grafici e lo associa al controller
	 */
	private void initActionListener() {
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.loginActionListener(usernameField.getText(), String.copyValueOf(passwordField.getPassword()));
			}
			
		});
	}
	
	/**
	 * Metodo che si occupa di inizializzare le proprietà del componente grafico
	 */
	@Override
	public void initProperty() {
		this.setLayout(null);
		this.setBounds(10, 10, 400, 600);
		this.setBorder(new TitledBorder(null, "Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	}

	/**
	 * Metodo che si occupa di istanziare gli elementi grafici
	 */
	@Override
	public void initComponents() {
		usernameField = new JTextField();
		passwordField = new JPasswordField();
		btnLogin = new JButton("Login");
		
		JLabel usernameLabel;
		JLabel passwordLabel;

		usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(12, 29, 100, 16);
		this.add(usernameLabel);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(12, 86, 100, 16);
		this.add(passwordLabel);
	}

	/**
	 * Metodo astratto che si occupa di aggiungere gli elementi grafici al componente padre
	 */
	@Override
	public void addComponents() {
		this.add(usernameField);
		this.add(passwordField);
		this.add(btnLogin);
	}

	/**
	 * Metodo che si occupa di posizionare gli elementi grafici all'interno del componente padre
	 */
	@Override
	public void setPositionComponents() {
		usernameField.setBounds(12, 42, 100, 20);
		passwordField.setBounds(12, 101, 100, 20);
		btnLogin.setBounds(12, 141, 100, 20);
	}

	/**
	 * Metodo che associa il corrispettivo controller
	 */
	@Override
	public void setController(ILoginController controller) {
		this.controller = controller;
	}

	/**
	 * Metodo che restituisce il corrispettivo controller
	 */
	@Override
	public ILoginController getController() {
		return controller;
	}

	/**
	 * Metodo che notifica l'utente del login avvenuto con successo
	 */
	@Override
	public void loginSuccessful() {
		JOptionPane.showMessageDialog(this, "Login avvenuto con successo");
	}

	/**
	 * Metodo che notifica l'utente del login fallito ( e ne specifica il messaggio)
	 */
	@Override
	public void loginFailed(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}

}
