package view.contracts;

import javax.swing.JComponent;

/**
 * Interfaccia che ogni view, in quanto tale, deve rispettare ed implementare
 * @author Alex
 *
 */
public interface IView {
	public JComponent getView();
	
	public void initProperty();
	public void initComponents();
	public void addComponents();
	public void setPositionComponents();
}
