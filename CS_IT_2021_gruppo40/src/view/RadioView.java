package view;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.contracts.IRadioController;
import model.contracts.IRadioModel;
import view.contracts.IRadioView;

import java.awt.Color;

/**
 * Classe concreta del package view
 * Si occupa anche di implementare tutto ciò che occorre per la visualizzazione grafica della radio selezionata
 * @author Alex
 *
 */
public class RadioView extends AbstractView implements IRadioView {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2927480887488656333L;
	/**
	 * 
	 */
	
	private JTextField brand;
	private JTextField type;
	private JTextField size;
	private JTextField color;
	private JTextField optional;
	private JTextField antenna;
	
	private IRadioController controller;
	
	public RadioView() {
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
		this.setBounds(10, 10, 355, 185);
		this.setBorder(new TitledBorder(null, "Radio", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
	}
	
	/**
	 * Metodo che si occupa di istanziare gli elementi grafici
	 */
	@Override
	public void initComponents() {
		brand = new JTextField();
		type = new JTextField();
		size = new JTextField();
		color = new JTextField();
		optional = new JTextField();
		antenna = new JTextField();
		
		JLabel brandLabel;
		JLabel typeLabel;
		JLabel sizeLabel;
		JLabel colorLabel;
		JLabel optionalLabel;
		JLabel antennaLabel;
		
		brandLabel = new JLabel("Brand");
		brandLabel.setBounds(12, 36, 100, 10);
		this.add(brandLabel);

		typeLabel = new JLabel("Tipo");
		typeLabel.setBounds(12, 76, 100, 10);
		this.add(typeLabel);

		sizeLabel = new JLabel("Dimensione");
		sizeLabel.setBounds(152, 36, 100, 10);
		this.add(sizeLabel);

		colorLabel = new JLabel("Colore");
		colorLabel.setBounds(152, 76, 100, 10);
		this.add(colorLabel);

		optionalLabel = new JLabel("Opzional");
		optionalLabel.setBounds(12, 126, 100, 10);
		this.add(optionalLabel);
		
		antennaLabel = new JLabel("Antenna");
		antennaLabel.setBounds(152, 126, 100, 10);
		this.add(antennaLabel);
	}
	
	/**
	 * Metodo astratto che si occupa di aggiungere gli elementi grafici al componente padre
	 */
	@Override
	public void addComponents() {
		this.add(brand);
		this.add(type);
		this.add(size);
		this.add(color);
		this.add(optional);
		this.add(antenna);
	}

	/**
	 * Metodo che si occupa di posizionare gli elementi grafici all'interno del componente padre
	 */
	@Override
	public void setPositionComponents() {
		brand.setBounds(12, 46, 100, 20);
		type.setBounds(12, 86, 100, 20);
		size.setBounds(152, 46, 100, 20);
		color.setBounds(152, 86, 100, 20);
		optional.setBounds(12, 136, 100, 20);
		antenna.setBounds(152, 136, 100, 20);
	}

	/**
	 * Metodo che associa il corrispettivo controller
	 */
	@Override
	public void setController(IRadioController controller) {
		this.controller = controller;
	}

	/**
	 * Metodo che restituisce il corrispettivo controller
	 */
	@Override
	public IRadioController getController() {
		return controller;
	}

	/**
	 * Metodo che aggiorna i dati della radio selezionata
	 */
	@Override
	public void updateRadio(IRadioModel radio) {
		brand.setText(String.valueOf(radio.getBrand()));
		type.setText(String.valueOf(radio.getType()));
		size.setText(String.valueOf(radio.getSize()));
		color.setText(radio.getColor());
		optional.setText(radio.getOptional());
		antenna.setText(radio.getAntenna());
	}
	
	/**
	 * Metodo che setta lo status che devono avere i componenti
	 * @param status Status dei componenti
	 */
	private void setEditableStatus(boolean status) {
		brand.setEditable(status);
		type.setEditable(status);
		size.setEditable(status);
		color.setEditable(status);
		optional.setEditable(status);
		antenna.setEditable(status);
	}
	
}
