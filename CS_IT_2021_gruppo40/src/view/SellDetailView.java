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

	@Override
	public void initProperty() {
		this.setLayout(null);
		this.setBounds(10, 10, 355, 130);
		this.setBorder(new TitledBorder(null, "Dettagli Vendita", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
	}

	@Override
	public void initComponents() {
		numRadio = new JTextField();
		date = new JTextField();
		price = new JTextField();
		
		JLabel numRadioLabel;
		JLabel dateLabel;
		JLabel priceLabel;
		
		numRadioLabel = new JLabel("Numero radio");
		numRadioLabel.setBounds(12, 37, 100, 10);
		this.add(numRadioLabel);
		
		dateLabel = new JLabel("Data");
		dateLabel.setBounds(12, 77, 100, 10);
		this.add(dateLabel);

		priceLabel = new JLabel("Prezzo");
		priceLabel.setBounds(152, 37, 100, 10);
		this.add(priceLabel);
	}

	@Override
	public void addComponents() {
		this.add(numRadio);
		this.add(date);
		this.add(price);
	}

	@Override
	public void setPositionComponents() {
		numRadio.setBounds(12, 47, 100, 20);
		date.setBounds(12, 87, 100, 20);
		price.setBounds(152, 47, 100, 20);
	}

	@Override
	public void setController(ISellDetailController controller) {
		this.controller = controller;
	}

	@Override
	public ISellDetailController getController() {
		return controller;
	}
	
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
	
	private void ShowWrongFormat() {
		JOptionPane.showMessageDialog(this, "Formato inserito errato.");
	}
	
}
