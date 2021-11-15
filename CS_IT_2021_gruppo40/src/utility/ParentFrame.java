package utility;

import java.awt.Frame;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Classe di utilità generale che si occupa del Frame
 * @author Alex
 *
 */
public class ParentFrame {
	
	/**
	 * Trova il genitore (Frame) del JPanel dato in input
	 * {@link https://stackoverflow.com/questions/10522121/instantiate-jdialog-from-jpanel/10522340}
	 * @author Guillaume Polet
	 * @param currentPanel JPannel corrente
	 * @return Frame del corrispettivo JPanel
	 */
	public static Frame findParentFrame(JPanel currentPanel) {
		java.awt.Window parentWindow = SwingUtilities.windowForComponent(currentPanel);
		Frame parentFrame = null;
		
		if (parentWindow instanceof Frame)
			parentFrame = (Frame)parentWindow;
		
		return parentFrame;
	}
}
