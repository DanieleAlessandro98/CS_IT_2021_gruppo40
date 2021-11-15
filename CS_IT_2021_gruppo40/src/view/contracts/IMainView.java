package view.contracts;

import javax.swing.JComponent;

import utility.Window;

public interface IMainView extends IView {
	public JComponent getSellView();
	public JComponent getLoginView();
	
	public void updateWindow(Window newWindow);
}
