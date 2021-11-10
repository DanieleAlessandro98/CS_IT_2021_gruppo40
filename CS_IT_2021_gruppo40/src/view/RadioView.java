package view;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class RadioView extends AbstractView {
	
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
		this.setPreferredSize(new Dimension(200, 200));
	}
	
	@Override
	public void initComponents() {
		brand = new JTextField();
		brand.setPreferredSize(new Dimension(50, 20));

		type = new JTextField();
		type.setPreferredSize(new Dimension(50, 20));

		size = new JTextField();
		size.setPreferredSize(new Dimension(50, 20));

		color = new JTextField();
		color.setPreferredSize(new Dimension(50, 20));

		optional = new JTextField();
		optional.setPreferredSize(new Dimension(50, 20));

		antenna = new JTextField();
		antenna.setPreferredSize(new Dimension(50, 20));
		
		JLabel brandLabel;
		JLabel typeLabel;
		JLabel sizeLabel;
		JLabel colorLabel;
		JLabel optionalLabel;
		JLabel antennaLabel;
		
		brandLabel = new JLabel("Brand");
		brandLabel.setBounds(10, 10, 100, 10);
		this.add(brandLabel);

		typeLabel = new JLabel("Tipo");
		typeLabel.setBounds(10, 50, 100, 10);
		this.add(typeLabel);

		sizeLabel = new JLabel("Dimensione");
		sizeLabel.setBounds(150, 10, 100, 10);
		this.add(sizeLabel);

		colorLabel = new JLabel("Colore");
		colorLabel.setBounds(150, 50, 100, 10);
		this.add(colorLabel);

		optionalLabel = new JLabel("Opzional");
		optionalLabel.setBounds(10, 100, 100, 10);
		this.add(optionalLabel);
		
		antennaLabel = new JLabel("Antenna");
		antennaLabel.setBounds(150, 100, 100, 10);
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
		brand.setBounds(10, 20, 100, 20);
		type.setBounds(10, 60, 100, 20);
		size.setBounds(150, 20, 100, 20);
		color.setBounds(150, 60, 100, 20);
		optional.setBounds(10, 110, 100, 20);
		antenna.setBounds(150, 110, 100, 20);
	}
	
}
