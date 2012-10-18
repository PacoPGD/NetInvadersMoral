package games.canvasmenu;

import javax.swing.JFrame;


public interface CellMouseListener {
	public void cellClicked();
	public void cellMouseMoved();
	public void cellMouseEntered();
	public void cellMouseExited();
	public int getX();
	public int getY();
	public int getWidth();
	public int getHeight();
}
