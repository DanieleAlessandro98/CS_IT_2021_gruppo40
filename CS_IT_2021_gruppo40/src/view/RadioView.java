package view;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.Color;

public class RadioView extends AbstractView {
	
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
	
	public RadioView() {
		super();
		
		initProperty();
		initComponents();
		addComponents();
		setPositionComponents();
	}
	
	@Override
	public void initProperty() {
		this.setLayout(null);
		this.setBounds(10, 10, 355, 185);
		this.setBorder(new TitledBorder(null, "Radio", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
	}
	
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
	
	@Override
	public void addComponents() {
		this.add(brand);
		this.add(type);
		this.add(size);
		this.add(color);
		this.add(optional);
		this.add(antenna);
	}

	@Override
	public void setPositionComponents() {
		brand.setBounds(12, 46, 100, 20);
		type.setBounds(12, 86, 100, 20);
		size.setBounds(152, 46, 100, 20);
		color.setBounds(152, 86, 100, 20);
		optional.setBounds(12, 136, 100, 20);
		antenna.setBounds(152, 136, 100, 20);
	}
	
}
