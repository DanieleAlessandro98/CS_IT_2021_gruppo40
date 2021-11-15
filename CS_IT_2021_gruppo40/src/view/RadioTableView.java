package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.contracts.IRadioTableController;
import model.contracts.IRadioModel;
import utility.ParentFrame;
import view.contracts.IRadioTableView;

public class RadioTableView extends AbstractView implements IRadioTableView {

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
	
	private IRadioTableController controller;

	public RadioTableView() {
		super();
		
		initProperty();
		initComponents();
		addComponents();
		setPositionComponents();
		
		initDialogProperty();
		
		initActionListener();
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

	@Override
	public void setController(IRadioTableController controller) {
		this.controller = controller;
		
		initRadioTable();		// inizializza la tabella con i dati delle radio (presi dal controller -> model)
	}

	@Override
	public IRadioTableController getController() {
		return controller;
	}
	
	private void initActionListener() {
		btnSelectRadio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.showRadioTableActionListener();
			}
			
		});
		
		radioTable.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int row = radioTable.rowAtPoint(e.getPoint());
				int id = Integer.parseInt(radioTable.getValueAt(row, 0).toString());
				controller.selectRadioMouseListener(id);
			}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}
			
		});
	}

	@Override
	public void initRadioTable(List<IRadioModel> radios) {
		for (IRadioModel radio : radios) {
			tableModel.addRow(new String[] {
					String.valueOf(radio.getID()),
					String.valueOf(radio.getBrand()),
					String.valueOf(radio.getType()),
					String.valueOf(radio.getSize()),
					String.valueOf(radio.getColor()),
					String.valueOf(radio.getOptional()),
					String.valueOf(radio.getAntenna())
			});
		}
	}

	@Override
	public void setTableVisibility(boolean status) {
		radioTableDialog.setVisible(status);
	}
	
	private void initRadioTable() {
		controller.initRadioTable();
	}

}
