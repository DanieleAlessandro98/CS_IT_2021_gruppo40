package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import controller.contracts.ISellController;
import view.contracts.ISellView;
import view.contracts.IView;

/**
 * Classe concreta del package view
 * Si occupa di istanziare quelli che sono le viste che componogono la vendita (in questo caso l'utente, la radio selezionata, i dettagli della vendita
 * e le radio presenti nel database).
 * Inoltre una volta fatto ciò, svolge le operazioni principali per il posizionamento dei componenti nella finestra principale
 * @author Alex
 *
 */
public class SellView extends AbstractView implements ISellView {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6629692344783315433L;
	/**
	 * 
	 */
	
	private IView userView;
	private IView sellDetailView;
	private IView radioView;
	private IView radioTableView;

	private JButton btnInsertSell;
	
	private ISellController controller;

	public SellView() {
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
		this.setBounds(10, 10, 400, 600);
		this.setBorder(new TitledBorder(null, "Gestione nuova vendita", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	}

	/**
	 * Metodo che si occupa di istanziare gli elementi grafici
	 */
	@Override
	public void initComponents() {
		userView = new UserView();
		sellDetailView = new SellDetailView();
		radioView = new RadioView();
		radioTableView = new RadioTableView();
		
		btnInsertSell = new JButton("Inserisci vendita");
		btnInsertSell.setSize(140, 25);
	}

	/**
	 * Metodo astratto che si occupa di aggiungere gli elementi grafici al componente padre
	 */
	@Override
	public void addComponents() {
		this.add(radioTableView.getView());
		this.add(userView.getView());
		this.add(sellDetailView.getView());
		this.add(radioView.getView());
		
		this.add(btnInsertSell);
	}

	/**
	 * Metodo che si occupa di posizionare gli elementi grafici all'interno del componente padre
	 */
	@Override
	public void setPositionComponents() {		
		int i = 0;
		
		userView.getView().setLocation(10, 33 * (++i));
		sellDetailView.getView().setLocation(10, userView.getView().getHeight() + (30 * (++i)));
		radioView.getView().setLocation(10, userView.getView().getHeight() + sellDetailView.getView().getHeight() + (30 * (++i)));
		radioTableView.getView().setLocation(20, 248);
		
		btnInsertSell.setLocation(100, 565);
	}

	/**
	 * Restituisce la view dell'utente
	 */
	@Override
	public JComponent getUserView() {
		return userView.getView();
	}

	/**
	 * Restituisce la view dei dettagli vendita
	 */
	@Override
	public JComponent getSellDetailView() {
		return sellDetailView.getView();
	}

	/**
	 * Restituisce la view della radio
	 */
	@Override
	public JComponent getRadioView() {
		return radioView.getView();
	}

	/**
	 * Restituisce la view delle radio
	 */
	@Override
	public JComponent getRadioTableView() {
		return radioTableView.getView();
	}

	/**
	 * Metodo che associa il corrispettivo controller
	 */
	@Override
	public void setController(ISellController controller) {
		this.controller = controller;
	}

	/**
	 * Metodo che restituisce il corrispettivo controller
	 */
	@Override
	public ISellController getController() {
		return controller;
	}
	
	/**
	 * Associa gli action lister ai vari elementi grafici e lo associa al controller
	 */
	private void initActionListener() {
		btnInsertSell.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.insertSellActionListener();
			}
			
		});
	}

	/**
	 * Notifica l'utente dell'inserimento avenuto con successo della vendita
	 */
	@Override
	public void insertSellSuccessful() {
		JOptionPane.showMessageDialog(this, "Vendita inserita con successo");
	}

	/**
	 * Notifica l'utente del fallimento della vendita
	 */
	@Override
	public void insertSellFailed(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
	
}
