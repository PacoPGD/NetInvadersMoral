package games.canvasmenu;

import java.awt.Cursor;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.*;
import java.util.HashMap;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.awt.Frame;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.imageio.ImageIO;
import games.*;

public class CellElement implements CellMouseListener {
	public int x =0, y = 0;
	public boolean mouseOverMe = false;
	private Image spriteCell = null;
	private Image spriteUnSelectedCell = null;
	private Image spriteSelectedCell = null;
	private ActionListener actionListener = null;

	public CellElement() {
	}
    
	public CellElement(String spriteCell, ActionListener actionListener) {
		init(spriteCell, spriteCell, actionListener);
	} 
		
	public CellElement(String spriteUnSelectedCell, String spriteSelectedCell, ActionListener actionListener) {
		init(spriteUnSelectedCell, spriteSelectedCell, actionListener);
	}
	
	private void init (String spriteUnSelectedCell, String spriteSelectedCell, ActionListener actionListener) {
		this.spriteCell = MenuCache.getSpriteCache().getSprite(spriteUnSelectedCell);
		this.spriteUnSelectedCell = spriteCell;
		this.spriteSelectedCell = MenuCache.getSpriteCache().getSprite(spriteSelectedCell);
		this.actionListener = actionListener;
	}
	
	public void paint(Graphics g) {
		g.drawImage(spriteCell,x,y+70, null);
	}
	
	
	public void cellClicked() {
		actionListener.actionPerformed(null);
	}

	public void cellMouseMoved() {}
	
	public void cellMouseEntered() {
		mouseOverMe = true;
		spriteCell = spriteUnSelectedCell;
	}
	
	public void cellMouseExited() {
		if (mouseOverMe) { mouseOverMe = false; }
		spriteCell = spriteSelectedCell;
	}

	public int getX() { return this.x; }
	public int getY() {	return this.y; }
	public int getWidth() { return this.spriteCell.getWidth(null);	}
	public int getHeight() { return this.spriteCell.getHeight(null); }
	
	public void setX(int x) { this.x = x; } 
	public void setY(int y) { this.y = y; } 
}
