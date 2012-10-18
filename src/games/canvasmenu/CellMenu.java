package games.canvasmenu;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

import games.*;


public class CellMenu extends Canvas implements PlayableCanvas{
	private int width = -1;
	private int height = -1;
	private int spaceInterCells = 100;
	private static final int DEFAULT_SPACE_INTER_CELLS = 200;
	public Vector cells = null;
	MyMouseAdapter myMouseAdapter = null;
	String selectionIndicatorImage = null;
	String bgImage= "menu/bgMenu.png";
	private BufferStrategy strategy;

	
	public CellMenu(int width, int height, int spaceInterCells) {
		setBounds(0,0,width,height);
		
		this.width = width;
		this.height = height;
		this.spaceInterCells = 40;
		
		cells = new Vector();

		myMouseAdapter = new MyMouseAdapter();
		this.addMouseListener(myMouseAdapter);	
		this.addMouseMotionListener(myMouseAdapter);
		this.setIgnoreRepaint(true);
		
		
	}
	
	
	public void addCell (CellElement cell) {
		addCellMouseListener(cell);
	}
	
	public void addCellMouseListener (CellMouseListener cml) {
		cells.add(cml);
		calculatePositions();
	}
	
	private void calculatePositions () {
		int cellPad = spaceInterCells;
		
		if (cells.size() > 1) {
			if (cellPad == -1) {
				cellPad = DEFAULT_SPACE_INTER_CELLS;
			}
			int menuHeight = getTotalCellHeights() + (cellPad * (cells.size()-1));
			((CellElement) cells.elementAt(0)).setY( (this.height-menuHeight) / 2); 
			for (int i = 1; i < cells.size(); i++) {
				((CellElement) cells.elementAt(i)).setY( ((CellElement) cells.elementAt(i-1)).getY() + ((CellElement) cells.elementAt(i-1)).getHeight() + cellPad );
			}
			for (int i = 0; i < cells.size(); i++) {
				((CellElement) cells.elementAt(i)).setX( (this.width - ((CellElement) cells.elementAt(i)).getWidth()) / 2);
			}
		}
	}
	
	private int getTotalCellHeights () {
		int total = 0;
		for (int i = 0; i < cells.size(); i++) {
			total += ((CellElement)cells.elementAt(i)).getHeight();
		}
		return total;
	}
	public void setBg(String bgImage){
		this.bgImage=bgImage;
	}
	
	
	public void paintStrategy() {
		Graphics2D g = (Graphics2D)this.getBufferStrategy().getDrawGraphics();
		
		g.setColor(g.getBackground());
		g.fillRect(0, 0, this.width, this.height);
		g.drawImage(MenuCache.getSpriteCache().getSprite(bgImage),null,0,0);
		
		for (int i = 0; i < cells.size(); i++){
			((CellElement)cells.elementAt(i)).paint(g);
		}
		
		if (myMouseAdapter.activeCell != null) {
			Image selImage = MenuCache.getSpriteCache().getSprite(selectionIndicatorImage);
			g.drawImage(selImage, (this.width - selImage.getWidth(null)) / 2, myMouseAdapter.activeCell.getY()+35, null);
		}
		this.getBufferStrategy().show();
	}
	
	public void setSelectionIndicatorImage (String selectionIndicatorImage) { this.selectionIndicatorImage = selectionIndicatorImage; }
	public String getSelectionIndicatorImage () { return this.selectionIndicatorImage; }
	
	
	public void play () {
		paintStrategy();
	}
	
	
	
	
	
	
	public class MyMouseAdapter extends MouseAdapter {
		CellElement activeCell = null;
		
		public void mouseClicked(MouseEvent e) {
			for (int i = 0; i < cells.size(); i++) {
				CellMouseListener cml = (CellMouseListener) cells.get(i);
				if (isMouseOverCell(e.getX(), e.getY(), cml)) {
					cml.cellClicked();
				}
			}
		}
		
		public void mouseMoved(MouseEvent e) {
			for (int i = 0; i < cells.size(); i++) {
				CellElement cell = (CellElement) cells.get(i);
				if (isMouseOverCell(e.getX(), e.getY(), cell) && cell.mouseOverMe == false) {
					if ( (activeCell != null && !activeCell.equals(cell))) {
						activeCell.cellMouseExited();
						activeCell = null;
						paintStrategy();
					}
					cell.cellMouseEntered();
					activeCell = cell;
					paintStrategy();
				}
			}
			if (!isOverAnyCell(e) && activeCell != null) {
				activeCell.cellMouseExited();
				activeCell = null;
				paintStrategy();
			}
		}
		
		private boolean isOverAnyCell (MouseEvent e) {
			for (int i = 0; i < cells.size(); i++) {
				CellElement cell = (CellElement) cells.get(i);
				if (isMouseOverCell(e.getX(), e.getY(), cell)) {
					return true;
				}
			}
			return false;
		}
		 
		private boolean isMouseOverCell (int xMouse, int yMouse, CellMouseListener cell) {
			return (xMouse > cell.getX() && xMouse < cell.getX() + cell.getWidth() &&
					yMouse > cell.getY()+35 && yMouse < cell.getY()+70 + cell.getHeight());
		}
	}



	public void addCell(String string, ActionListener actionListener) {
		// TODO Auto-generated method stub
	}
}

/*
en nuevo juego 

	public PlayableCanvas getMainMenu () {
		if (mainMenu == null) {
			mainMenu = new CellMenu(width, height, -1);
			mainMenu.setSelectionIndicatorImage("menu/selec2.png");
			mainMenu.addCell(new CellElement("menu/jugar.png", new ActionListener (){
				public void actionPerformed (ActionEvent evt) {
					//try {
						playComponent(panelOpciones, 1000);
						//playComponent((Component) new Secuencia(NuevoJuego.opcion1,NuevoJuego.opcion2,NuevoJuego.opcion3),30);
		
					}
					catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}));
			mainMenu.addCell(new CellElement("menu/opciones.png", new ActionListener (){
				public void actionPerformed (ActionEvent evt) {
					playComponent(panelOpciones, 1000);
				}
			}));
			mainMenu.addCell(new CellElement("menu/creditos.png", new ActionListener (){
				public void actionPerformed (ActionEvent evt) {
					playComponent(panelOpciones, 1000);
				}
			}));
			mainMenu.addCell(new CellElement("menu/salir.png", new ActionListener (){
				public void actionPerformed (ActionEvent evt) {
					closing();
				}
			}));
		}
		return mainMenu;
	}

*/
