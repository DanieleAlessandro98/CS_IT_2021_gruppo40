package view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import utility.ParentFrame;

public class RadioTableView extends AbstractView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4360934484665470165L;
	/**
	 * 
	 */
	
	private static final String[] columnNames = {
			"ID",
			"Marca",
			"Tipo",
			"Dimensione",
			"Colore",
			"Optional",
			"Antenna"
	};
	
	private JDialog radioTableDialog;
	private JTable radioTable;
	private DefaultTableModel tableModel;
	private JButton btnSelectRadio;

	public RadioTableView() {
		super();
		
		initProperty();
		initComponents();
		addComponents();
		setPositionComponents();
		
		initDialogProperty();
	}
	
	@Override
	public void initProperty() {
		this.setLayout(null);
		this.setBounds(10, 10, 200, 200);
	}

	@Override
	public void initComponents() {
		radioTableDialog = new JDialog(ParentFrame.findParentFrame(this));
		radioTableDialog.setTitle("Seleziona la radio");
		
		radioTable = new JTable();
		radioTable.setBounds(10, 10, 300, 300);

		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columnNames);
		radioTable.setModel(tableModel);
		
		btnSelectRadio = new JButton("Seleziona Radio");
		btnSelectRadio.setSize(140, 25);
	}

	@Override
	public void addComponents() {
		this.add(btnSelectRadio);
	}

	@Override
	public void setPositionComponents() {
		tableModel.addRow(new String[] {
				"line1",
				"line2",
				"line3",
				"line4",
				"line5",
				"line6",
				"line7",
		});
		
		btnSelectRadio.setLocation(0, 0);
	}
	
	private void initDialogProperty() {
		radioTableDialog.add(radioTable);
		radioTableDialog.setPreferredSize(new Dimension(300, 300));
		radioTableDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		radioTableDialog.setLocationRelativeTo(null);
		radioTableDialog.pack();
		radioTableDialog.setVisible(false);
	}

}
