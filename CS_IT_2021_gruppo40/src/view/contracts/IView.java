package view.contracts;

import javax.swing.JComponent;

public interface IView {
	public JComponent getView();
	
	public void initProperty();
	public void initComponents();
	public void addComponents();
	public void setPositionComponents();
}
