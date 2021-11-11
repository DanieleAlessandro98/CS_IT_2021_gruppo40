package view;

import java.awt.Dimension;

public class SellView extends AbstractView {

	private IView userView;
	private IView sellDetailView;
	private IView radioView;
	
	public SellView() {
		super();
		
		initProperty();
		initComponents();
		addComponents();
		setPositionComponents();
	}
	
	@Override
	public void initProperty() {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(900, 900));
	}

	@Override
	public void initComponents() {
		userView = new UserView();
		sellDetailView = new SellDetailView();
		radioView = new RadioView();
	}

	@Override
	public void addComponents() {
		this.add(userView.getView());
		this.add(sellDetailView.getView());
		this.add(radioView.getView());
	}

	@Override
	public void setPositionComponents() {
		userView.getView().setBounds(10, 20, 400, 200);
		sellDetailView.getView().setBounds(10, 420, 400, 200);
		radioView.getView().setBounds(10, 220, 400, 200);
	}

}
