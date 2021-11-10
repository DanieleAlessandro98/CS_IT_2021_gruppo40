package view;

import javax.swing.JComponent;
import javax.swing.JPanel;

public abstract class AbstractView extends JPanel implements IView {

	public AbstractView() {}
	
	@Override
	public JComponent getView() {
		return this;
	}
	
	@Override
	abstract public void initProperty();

	@Override
	abstract public void initComponents();

	@Override
	abstract public void addComponents();
	
	@Override
	abstract public void setPositionComponents();

}
