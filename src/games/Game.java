package games;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Game {

	private int width = 800;
	private int height = 600;
	public static final int TITLE_BAR_HEIGHT = 35;
	static JFrame ventana = null;
	Component component = null;
	private boolean newComponent = false;
	private int maximunFramesPerSecond = 30;
	
	
	public Game() {
		new Game ("", width, height);
	}
	
	public Game (String gameName, int width, int height) {
		this.width = width;
		this.height = height;
		ventana = new JFrame(gameName);
		JPanel panel = (JPanel)ventana.getContentPane();
		panel.setLayout(null);
		ventana.setBounds(0,0,width,height + TITLE_BAR_HEIGHT);
		ventana.addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				closing();
			}
		});
		ventana.setResizable(false);
		ventana.setLocationRelativeTo(null);
		ventana.setAlwaysOnTop(false);
		ventana.setIconImage(MenuCache.getSpriteCache().getSprite("naves/"+netInvaders2.Opciones.Opciones.naves[0]+".png"));
		ventana.setVisible(true);
		
		
		Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(MenuCache.getSpriteCache().getSprite("menu/cursor.gif"), new Point(0, 0), "cursosNetInvaders");
		ventana.setCursor(cursor);
	}
	
	public static void vibra(int xRango,int yRango,int iteraciones){
		if(netInvaders2.Opciones.Preferencias.vibracion){
			Random rand = new Random();
			Point p=ventana.getLocationOnScreen();

			for(int i=0;i<iteraciones;i++){
				int aleatorioX = ( (rand.nextInt()  % (xRango + 1)));
				int aleatorioY = - Math.abs( (rand.nextInt()  % (yRango + 1)));
				if(rand.nextBoolean()){
					System.out.println("x: "+aleatorioX+"  y: "+aleatorioY);
					ventana.setLocation(p.x+aleatorioX,p.y+aleatorioY);
				}
			}
			ventana.setLocation(p);
		}
	}
	public static void vibra(){ vibra(20,20,50); }
	
	
	
	public void playGame () {
		while (true) {
			if (component != null) {
				try {
					if (newComponent) {
						if ( component != null && !(component instanceof PlayableCanvas || component instanceof JPanel)) {
							System.out.println ("El componente debe ser PlayableCanvas o JPanel");
							System.exit(0);
						}
						if (component instanceof PlayableCanvas) {
							((JPanel)ventana.getContentPane()).removeAll();
							((JPanel)ventana.getContentPane()).setLayout(null);
							((JPanel)ventana.getContentPane()).add(component);
							if (!ventana.isVisible()) {
								ventana.setVisible(true);
							}
							((Canvas)component).createBufferStrategy(2);
							((PlayableCanvas)component).play();
						}
						if (component instanceof JPanel) {
							((JPanel)ventana.getContentPane()).removeAll();
							((JPanel)ventana.getContentPane()).setLayout(new BorderLayout());
							((JPanel)ventana.getContentPane()).add(BorderLayout.CENTER, component);
							ventana.setVisible(true);
						}
						newComponent = false;
					}
					if (component instanceof PlayableCanvas) {
						Thread.currentThread().sleep(maximunFramesPerSecond);
						/*
						if (component != null) {
							((PlayableCanvas)component).play();
						}*/
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	
	
	public void playComponent (Component componente, int maximunFramesPerSecond) {
		newComponent = true; 
		component = componente;
		this.maximunFramesPerSecond = maximunFramesPerSecond;
	}

	
	public void closing() {
		
	}
}
