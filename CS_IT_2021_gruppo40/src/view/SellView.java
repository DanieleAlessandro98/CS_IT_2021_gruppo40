package view;
import javax.swing.border.TitledBorder;

public class SellView extends AbstractView {

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
		this.setBounds(10, 10, 400, 600);
		this.setBorder(new TitledBorder(null, "Gestione nuova vendita", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		int i = 0;
		
		userView.getView().setLocation(10, 33 * (++i));
		sellDetailView.getView().setLocation(10, userView.getView().getHeight() + (30 * (++i)));
		radioView.getView().setLocation(10, userView.getView().getHeight() + sellDetailView.getView().getHeight() + (30 * (++i)));
	}

}
