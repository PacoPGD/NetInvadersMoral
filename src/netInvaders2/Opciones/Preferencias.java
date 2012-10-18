package netInvaders2.Opciones;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import netInvaders2.NuevoJuego;

/**
 * 
 * @author Jesus Rodriguez Perez
 * @version 0.6
 * @since 4-8-2009
 * <dt>Preferencias</dt><dd>Muestra un menu para cambiar las opciones de sonido, vibracion y controles </dd>
 */

@SuppressWarnings("serial")
public class Preferencias extends JPanel {
	public static boolean vibracion=false;
	public static boolean sonidoCharla=true;
	public static boolean sonidoEfectos=true;
	public static boolean sonidoMusica=true;
	//										0			1				2			3				4			5					6
	//									arriba		abajo			izqierda	derecha			disparo			bombas			especiales		
	public static int controlesJ1[]={KeyEvent.VK_W,KeyEvent.VK_S,KeyEvent.VK_A,KeyEvent.VK_D,KeyEvent.VK_SPACE,KeyEvent.VK_B,KeyEvent.VK_N};
	public static int controlesJ2[]={KeyEvent.VK_UP,KeyEvent.VK_DOWN,KeyEvent.VK_LEFT,KeyEvent.VK_RIGHT,KeyEvent.VK_ENTER,KeyEvent.VK_CONTROL,KeyEvent.VK_SHIFT};
	static JTextField jtfTeclasJ1[]=new JTextField[7];
	static JTextField jtfTeclasJ2[]=new JTextField[7];
	
	private static DataOutputStream salida;
	private DataInputStream entrada;
	public final static String PreferencesFile="NetInavders2Options.dat";
	
	private JPanel panelPreferencias;
	private JPanel panelSonido;
	private JPanel panelControles;
	private JPanel panelControlesIndicador;
	private JPanel panelControlesJ1;
	private JPanel panelControlesJ2;
	
	static JCheckBox chkVibracion;
	static JCheckBox chkCharla;
	static JCheckBox chkEfectos;
	static JCheckBox chkMusica;
	
	private JButton volver;
	
	
	public Preferencias(){
		cargaPreferencias();
		
		panelPreferencias=new JPanel(new GridLayout(1,2,50,50));
		//panelPreferencias=new JPanel(new FlowLayout(1));
		
		
		panelSonido=new JPanel(new GridLayout(10,1,5,5));
		//panelSonido=new JPanel();
		//panelSonido.setLayout(new BoxLayout(panelSonido,BoxLayout.Y_AXIS));
		//panelSonido.add(Box.createRigidArea(new Dimension(0,25)));
		//panelSonido.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelSonido.add(new JLabel("<html><h3>Otros</h3></hmtl>"));
		chkVibracion=new JCheckBox("Vibracion de pantalla");
		chkVibracion.setAlignmentY(Component.TOP_ALIGNMENT);
		panelSonido.add(chkVibracion);
		//el listener se lo meto cuando los controles de sonido
		
		
		creaPanelSonido();
		panelControles=new JPanel(new GridLayout(2,3));
		creaPanelControles();

		
		panelPreferencias.add(panelControles);
		panelPreferencias.add(panelSonido);
		//JLabel titulo=new JLabel("Opciones de juego");	
		//panelPreferencias.add(titulo);
		
		//this.setLayout(new GridLayout(2,1));
		this.setLayout(new GridLayout(1,1));
		add(panelPreferencias);	
		volver=new JButton("Volver");
		
		volver.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				guardaPreferencias();
				NuevoJuego.getNuevoJuego().playComponent((Component)NuevoJuego.getNuevoJuego().getMainMenu(), 1000);
			}
		});
		//JPanel boton
		panelPreferencias.add(volver);

		//addKeyListener(keyListener);		
	}
	
	
	public void creaPanelSonido(){
		panelSonido.add(new JLabel(""));
		panelSonido.add(new JLabel("<html><h3>Sonido</h3></hmtl>"));
		
		chkCharla=new JCheckBox("Charla");
		chkEfectos=new JCheckBox("Efectos");
		chkMusica=new JCheckBox("Musica");
		panelSonido.add(new JLabel(""));
		panelSonido.add(chkCharla);
		panelSonido.add(new JLabel(""));
		panelSonido.add(chkEfectos);
		panelSonido.add(new JLabel(""));
		panelSonido.add(chkMusica);
		
		ListenerControlesSonido listenerControlesSonido=new ListenerControlesSonido();
		chkCharla.addItemListener(listenerControlesSonido);
		chkEfectos.addItemListener(listenerControlesSonido);
		chkMusica.addItemListener(listenerControlesSonido);
		chkVibracion.addItemListener(listenerControlesSonido);
		chkVibracion.setSelected(vibracion);
		chkCharla.setSelected(sonidoCharla);
		chkEfectos.setSelected(sonidoEfectos);
		chkMusica.setSelected(sonidoMusica);
	}
	
	
	public void creaPanelControles(){
		panelControles.add(new JLabel("<html><h3>Controles</h3></hmtl>"));
		panelControles.add(new JLabel("<html><h3>J1</h3></hmtl>"));
		panelControles.add(new JLabel("<html><h3>J2</h3></hmtl>"));
		
		panelControlesIndicador=new JPanel(new GridLayout(7,1,5,5));
		panelControlesJ1=new JPanel(new GridLayout(7,1,5,5));
		panelControlesJ2=new JPanel(new GridLayout(7,1,5,5));
		
		panelControlesIndicador.add(new JLabel("arriba"));
		panelControlesIndicador.add(new JLabel("abajo"));
		panelControlesIndicador.add(new JLabel("izquierda"));
		panelControlesIndicador.add(new JLabel("derecha"));
		panelControlesIndicador.add(new JLabel("disparo"));
		panelControlesIndicador.add(new JLabel("bombas"));
		panelControlesIndicador.add(new JLabel("especial"));

		ListenerControles lC = new ListenerControles();
		for(int i=0;i<jtfTeclasJ1.length;i++){
			jtfTeclasJ1[i]=new JTextField(KeyEvent.getKeyText(controlesJ1[i]));
			panelControlesJ1.add(jtfTeclasJ1[i]);
			jtfTeclasJ1[i].addKeyListener(lC);
			
			jtfTeclasJ2[i]=new JTextField(KeyEvent.getKeyText(controlesJ2[i]));
			panelControlesJ2.add(jtfTeclasJ2[i]);
			jtfTeclasJ2[i].addKeyListener(lC);

		}
		
		panelControles.add(panelControlesIndicador);
		panelControles.add(panelControlesJ1);
		panelControles.add(panelControlesJ2);	
	}
	

	
	
	
	private void cargaPreferencias(){
		try {
			entrada = new DataInputStream(new FileInputStream(PreferencesFile));
			vibracion=entrada.readBoolean();entrada.readChar();
			sonidoCharla=entrada.readBoolean();entrada.readChar();
			sonidoEfectos=entrada.readBoolean();entrada.readChar();
			sonidoMusica=entrada.readBoolean();entrada.readChar();
			//System.out.println("c: "+sonidoCharla+" e: "+sonidoEfectos+" m: "+sonidoMusica);
			for(int i=0;i<controlesJ1.length;i++){
				controlesJ1[i]=entrada.readInt();
				controlesJ2[i]=entrada.readInt();
			}
			entrada.readChar();
			entrada.close();
		} catch (FileNotFoundException e) {
			System.out.println("EL fichero de preferencias no se puede cargar o no existe");
		} catch (IOException e) {
			System.out.println("EL fichero de preferencias no encontrado al cargar");
		}
	}
	public static void guardaPreferencias(){
		try {
			salida = new DataOutputStream(new FileOutputStream(PreferencesFile));
			salida.writeBoolean(vibracion);salida.writeChar('\t');
			salida.writeBoolean(sonidoCharla);salida.writeChar('\t');
			salida.writeBoolean(sonidoEfectos);salida.writeChar('\t');
			salida.writeBoolean(sonidoMusica);salida.writeChar('\n');
			for(int i=0;i<controlesJ1.length;i++){
				salida.writeInt(controlesJ1[i]);
				salida.writeInt(controlesJ2[i]);
			}
			salida.writeChar('\n');
			salida.close();
		} catch (FileNotFoundException e) {
			System.out.println("EL fichero de preferencias no se puede guardar");
		} catch (IOException e) {
			System.out.println("EL fichero de preferencias no encontrado");
		}
		//System.out.println("c: "+sonidoCharla+" e: "+sonidoEfectos+" m: "+sonidoMusica);
	}	
}




class ListenerControlesSonido implements ItemListener{
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==Preferencias.chkCharla){
			Preferencias.sonidoCharla=castIntToBoolean(e.getStateChange());
		}
		if(e.getSource()==Preferencias.chkEfectos){
			Preferencias.sonidoEfectos=castIntToBoolean(e.getStateChange());
		}
		if(e.getSource()==Preferencias.chkMusica){
			Preferencias.sonidoMusica=castIntToBoolean(e.getStateChange());
		}
		if(e.getSource()==Preferencias.chkVibracion){
			Preferencias.vibracion=castIntToBoolean(e.getStateChange());
		}
		//System.out.println("pulso "+e.getStateChange()+"  "+Preferencias.sonidoCharla+"  "+Preferencias.sonidoEfectos+"  "+Preferencias.sonidoMusica+ "  "+Preferencias.vibracion);
	}
	
	public boolean castIntToBoolean(int entero){
		if(entero==1){ return true; }
		return false;
	}
}

class ListenerControles implements KeyListener{

	public void keyPressed(KeyEvent e) { // EMPTY
	}
	public void keyReleased(KeyEvent e) {
		//System.out.println(e.getSource());
		for(int i=0;i<Preferencias.jtfTeclasJ1.length;i++){
			if(e.getSource()==Preferencias.jtfTeclasJ1[i]){
				Preferencias.controlesJ1[i]=e.getKeyCode();
				Preferencias.jtfTeclasJ1[i].setText(KeyEvent.getKeyText(e.getKeyCode()));
			}
			else{
				if(e.getSource()==Preferencias.jtfTeclasJ2[i]){
					Preferencias.controlesJ2[i]=e.getKeyCode();
					Preferencias.jtfTeclasJ2[i].setText(KeyEvent.getKeyText(e.getKeyCode()));
				}
			}
		}
		

		//System.out.println("suelto  "+e.getKeyCode()+" "+e.getKeyText(e.getKeyCode()));
	}


	public void keyTyped(KeyEvent e) { // EMPTY  
	}
	
}



