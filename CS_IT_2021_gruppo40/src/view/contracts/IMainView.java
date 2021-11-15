package view.contracts;

import javax.swing.JComponent;

import utility.Window;

/**
 * Interfaccia della view che si occupa delle componenti principali del software
 * @author Alex
 *
 */
public interface IMainView extends IView {
	public JComponent getSellView();
	public JComponent getLoginView();
	
	public void updateWindow(Window newWindow);
}
