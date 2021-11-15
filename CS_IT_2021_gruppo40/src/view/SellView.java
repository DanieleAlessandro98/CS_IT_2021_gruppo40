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
	
	@Override
	public void initProperty() {
		this.setLayout(null);
		this.setBounds(10, 10, 400, 600);
		this.setBorder(new TitledBorder(null, "Gestione nuova vendita", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	}

	@Override
	public void initComponents() {
		userView = new UserView();
		sellDetailView = new SellDetailView();
		radioView = new RadioView();
		radioTableView = new RadioTableView();
		
		btnInsertSell = new JButton("Inserisci vendita");
		btnInsertSell.setSize(140, 25);
	}

	@Override
	public void addComponents() {
		this.add(userView.getView());
		this.add(sellDetailView.getView());
		this.add(radioView.getView());
		this.add(radioTableView.getView());
		
		this.add(btnInsertSell);
	}

	@Override
	public void setPositionComponents() {		
		int i = 0;
		
		userView.getView().setLocation(10, 33 * (++i));
		sellDetailView.getView().setLocation(10, userView.getView().getHeight() + (30 * (++i)));
		radioView.getView().setLocation(10, userView.getView().getHeight() + sellDetailView.getView().getHeight() + (30 * (++i)));
		radioTableView.getView().setLocation(10, userView.getView().getHeight() + sellDetailView.getView().getHeight() + radioView.getView().getHeight() + (30 * (++i)));

		btnInsertSell.setLocation(100, 565);
	}

	@Override
	public JComponent getUserView() {
		return userView.getView();
	}

	@Override
	public JComponent getSellDetailView() {
		return sellDetailView.getView();
	}

	@Override
	public JComponent getRadioView() {
		return radioView.getView();
	}

	@Override
	public JComponent getRadioTableView() {
		return radioTableView.getView();
	}

	@Override
	public void setController(ISellController controller) {
		this.controller = controller;
	}

	@Override
	public ISellController getController() {
		return controller;
	}
	
	private void initActionListener() {
		btnInsertSell.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.insertSellActionListener();
			}
			
		});
	}

	@Override
	public void insertSellSuccessful() {
		JOptionPane.showMessageDialog(this, "Vendita inserita con successo");
	}

	@Override
	public void insertSellFailed(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
	
}
