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

/**
 * Classe concreta del package view
 * Si occupa anche di implementare tutto ciò che occorre per la visualizzazione grafica delle radio presenti
 * @author Alex
 *
 */
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
	
	/**
	 * Metodo che si occupa di inizializzare le proprietà del componente grafico
	 */
	@Override
	public void initProperty() {
		this.setLayout(null);
		this.setBounds(10, 10, 140, 25);
	}

	/**
	 * Metodo che si occupa di istanziare gli elementi grafici
	 */
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

	/**
	 * Metodo astratto che si occupa di aggiungere gli elementi grafici al componente padre
	 */
	@Override
	public void addComponents() {
		this.add(btnSelectRadio);
	}

	/**
	 * Metodo che si occupa di posizionare gli elementi grafici all'interno del componente padre
	 */
	@Override
	public void setPositionComponents() {
		btnSelectRadio.setLocation(0, 0);
	}
	
	/**
	 * Metodo che setta le proprietà del dialog contenete la tabella con le radio
	 */
	private void initDialogProperty() {
		radioTableDialog.add(radioTable);
		radioTableDialog.setPreferredSize(new Dimension(300, 300));
		radioTableDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		radioTableDialog.setLocationRelativeTo(null);
		radioTableDialog.pack();
		radioTableDialog.setVisible(false);
	}

	/**
	 * Metodo che associa il corrispettivo controller
	 */
	@Override
	public void setController(IRadioTableController controller) {
		this.controller = controller;
		
		initRadioTable();		// inizializza la tabella con i dati delle radio (presi dal controller -> model)
	}

	/**
	 * Metodo che restituisce il corrispettivo controller
	 */
	@Override
	public IRadioTableController getController() {
		return controller;
	}
	
	/**
	 * Associa gli action lister ai vari elementi grafici e lo associa al controller
	 */
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

	/**
	 * Metodo che inizializza i valor idella tabella con le radio
	 */
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

	/**
	 * Metodo che visualizza o nasconde il dialog
	 */
	@Override
	public void setTableVisibility(boolean status) {
		radioTableDialog.setVisible(status);
	}
	
	/**
	 * Metodo che avvia l'inizializzazione delle radio
	 */
	private void initRadioTable() {
		controller.initRadioTable();
	}

}
