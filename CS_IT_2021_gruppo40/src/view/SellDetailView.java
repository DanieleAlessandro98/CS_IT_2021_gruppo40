package view;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.contracts.ISellDetailController;
import utility.DateFormat;
import view.contracts.ISellDetailView;

import java.awt.Color;
import java.util.Date;

/**
 * Classe concreta del package view
 * Si occupa anche di implementare tutto ciò che occorre per la visualizzazione grafica dei dettagli della vendita
 * @author Alex
 *
 */
public class SellDetailView extends AbstractView implements ISellDetailView {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5674436431961903553L;
	/**
	 * 
	 */
	
	private JTextField numRadio;
	private JTextField date;
	private JTextField price;
	
	private ISellDetailController controller;
	
	public SellDetailView() {
		super();
		
		initProperty();
		initComponents();
		addComponents();
		setPositionComponents();
		
		initActionListener();
	}

	/**
	 * Metodo che si occupa di inizializzare le proprietà del componente grafico
	 */
	@Override
	public void initProperty() {
		this.setLayout(null);
		this.setBounds(10, 10, 355, 130);
		this.setBorder(new TitledBorder(null, "Dettagli Vendita", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
	}

	/**
	 * Metodo che si occupa di istanziare gli elementi grafici
	 */
	@Override
	public void initComponents() {
		numRadio = new JTextField();
		date = new JTextField();
		price = new JTextField();
		
		JLabel numRadioLabel;
		JLabel dateLabel;
		JLabel priceLabel;
		
		numRadioLabel = new JLabel("Numero radio");
		numRadioLabel.setBounds(152, 37, 100, 10);
		this.add(numRadioLabel);
		
		dateLabel = new JLabel("Data");
		dateLabel.setBounds(152, 80, 100, 10);
		this.add(dateLabel);

		priceLabel = new JLabel("Prezzo");
		priceLabel.setBounds(12, 80, 100, 10);
		this.add(priceLabel);
	}

	/**
	 * Metodo astratto che si occupa di aggiungere gli elementi grafici al componente padre
	 */
	@Override
	public void addComponents() {
		this.add(numRadio);
		this.add(date);
		this.add(price);
	}

	/**
	 * Metodo che si occupa di posizionare gli elementi grafici all'interno del componente padre
	 */
	@Override
	public void setPositionComponents() {
		numRadio.setBounds(152, 47, 100, 20);
		date.setBounds(152, 90, 100, 20);
		price.setBounds(12, 90, 100, 20);
	}

	/**
	 * Metodo che associa il corrispettivo controller
	 */
	@Override
	public void setController(ISellDetailController controller) {
		this.controller = controller;
	}

	/**
	 * Metodo che restituisce il corrispettivo controller
	 */
	@Override
	public ISellDetailController getController() {
		return controller;
	}
	
	/**
	 * Associa gli action lister ai vari elementi grafici e lo associa al controller
	 */
	private void initActionListener() {
		numRadio.setInputVerifier(new InputVerifier() {

			@Override
			public boolean verify(JComponent arg0) {				
				String stringValue = numRadio.getText();
				int value = -1;
				
				try {
					value = Integer.valueOf(stringValue);
					controller.setNumRadioActionListener(value);
				}
				catch (NumberFormatException e) {
					ShowWrongFormat();
				}
				
				return true;
			}
			
		});
		
		date.setInputVerifier(new InputVerifier() {

			@Override
			public boolean verify(JComponent arg0) {				
				String stringValue = date.getText();
				Date value = null;
				
				try {
					value = DateFormat.valueOf(stringValue);
					controller.setDateActionListener(value);
				}
				catch (Exception e) {
					ShowWrongFormat();
				}
				
				return true;
			}
			
		});
		
		price.setInputVerifier(new InputVerifier() {

			@Override
			public boolean verify(JComponent input) {
				String stringValue = price.getText();
				double value = -1;
				
				try {
					value = Double.valueOf(stringValue);
					controller.setPriceActionListener(value);
				}
				catch (NumberFormatException e) {
					ShowWrongFormat();
				}
								
				return true;
			}
			
		});
	}
	
	/**
	 * Metodo che notifica l'utente dell'errato inserimento di un valore
	 */
	private void ShowWrongFormat() {
		JOptionPane.showMessageDialog(this, "Formato inserito errato.");
	}
	
}
