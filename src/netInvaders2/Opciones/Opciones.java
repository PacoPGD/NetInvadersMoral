package netInvaders2.Opciones;
import games.MenuCache;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.http.AccessToken;
import twitter4j.http.RequestToken;

import Navegador.Navegador;
import TwitterS.TwitterS;

import com.sun.java.swing.plaf.nimbus.TabbedPanePainter;

import netInvaders2.Mission5;
import netInvaders2.Mission6;
import netInvaders2.Mission7;
import netInvaders2.Mission8;
import netInvaders2.NuevoJuego;
import netInvaders2.Secuencia;
import netInvaders2.Secuencia2;
import netInvaders2.Secuencia3;
import netInvaders2.Secuencia4;
import netInvaders2.Tutorial;

/**
 * 
 * @author Jesus Rodriguez Perez
 * @version 1.5
 * @since 25-6-2009
 * <dt>Opciones</dt><dd>Muestra un menu de seleccion de nave para el juego Space Invaders Moral Inyector</dd>
 * <dt>Perfiles y Perfil</dt>
 * <dd>Sistema para administrar los perfiles de los usuarios, las partidas guardadas</dd>
 * <dt>ListenerDeBotones,ListenerSeleccionPerfil,ListenerSeleccionNave y ListenerSeleccionJugadores</dt>
 * <dd>Listeners que controlan las acciones de la interfaz de usuario</dd>
 */


@SuppressWarnings("serial")
public class Opciones extends JPanel{
	//varibles utiles en juego
	/*public static int nJugadores=1;
	public static int naveJ1=0;
	public static int naveJ2=1;*/
	public static int perfilJ1=0;
	public static int perfilJ2=1;
	public static String faseSeleccionada;
	
	//arrays para cabios rapidos en el caso de que los alla
	public static String[]pilotos={"Rafa","Paco","Jesus","Juan","PeerGynt Lobogris","Adam","Angel"};//8
	public static String[]naves={"MasinguerJava","WhiteGaleon","BlueFang","GreenSnaug","GreyWolf","KipperShip","Supersonic"};
	public static String[]misiones={"cielo","luna","espacio","marte","tetrico","desierto","metal1","metal2"};//8
	public static String[]nombreMisiones={"Protegiedo la tierra","Contrataque Lunar","Carrera","Una gorda en gravedad 0","El mundo de Adamuz oscuro","Base .net en el desierto","la caceria .net","Muerte a los telecos"};
	
	//Perfiles
	public static JComboBox listaPerfilesJ1;
	public static JComboBox listaPerfilesJ2;
	public static Perfiles perfiles;
	
	//botones
	public static JButton crearNuevoPerfil;
	public static JButton borrarPerfil;
	public static JButton subirPuntuacion;
	public static JButton verPuntuacion;
	public static JButton jugar;
	public static JButton volver;
	
	//seleccion de jugadores
	static JRadioButton onePlayer;
	static JRadioButton twoPlayers;
	
	//seleccion de naves
	public static JComboBox listaNavesJ1;
	public static JComboBox listaNavesJ2;
	public static JLabel navePreviewJ1;
	public static JLabel navePreviewJ2;
	
	//seleccion de fase
	public static JComboBox listaFases;
	
	//paneles
	static JPanel panelPrincipal;
	private JPanel panelBotonera;
	private JPanel panelCentral;
	private JPanel panelOpcionesJ1;
	private JPanel panelSeleccionNaveJ1;
	static JPanel panelOpcionesJ2;
	static JPanel panelSeleccionNaveJ2;
	private JPanel panelInferior;
	private JPanel panelSeleccionFase;
	private JTabbedPane panelSocial;
	public static PanelSocialJugador psJ1;
	public static PanelSocialJugador psJ2;

	public static TwitterS twitter1 = new TwitterS();		
	public static TwitterS twitter2 = new TwitterS();	
	public static RequestToken requestToken;
	public static AccessToken accessToken;
	public static RequestToken requestToken2;
	public static AccessToken accessToken2;
	
	public Opciones (){

		//inicializaTwitter();
		
		definirUI();
		
		perfiles=new Perfiles();
		try{
			perfiles.cargarFichero();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("no carga el fichero perfiles");
		}
		
		creaOpciones();
		actualizarPreview();
	}
	
	private void inicializaTwitter(){
		twitter1.setOAuthConsumer("EiQIZw2bve8kVphjRiiTwA", "pFbzdyBayxjn3QHkp8oB1k8ASriMsLQIYb7rfeOBIY");
		twitter2.setOAuthConsumer("EiQIZw2bve8kVphjRiiTwA", "pFbzdyBayxjn3QHkp8oB1k8ASriMsLQIYb7rfeOBIY");

		try {
			requestToken = twitter1.getOAuthRequestToken();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			requestToken2 = twitter2.getOAuthRequestToken();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void creaOpciones(){
		panelPrincipal=new JPanel(new GridLayout(3,1));
		panelBotonera=new JPanel(new GridLayout(2,6));
		panelCentral=new JPanel(new GridLayout(2,1));
		panelOpcionesJ1=new JPanel(new GridLayout(1,3));
		panelSeleccionNaveJ1=new JPanel(new GridLayout(1,2));
		panelOpcionesJ2=new JPanel(new GridLayout(1,3));
		panelSeleccionNaveJ2=new JPanel(new GridLayout(1,2));
		panelInferior=new JPanel(new GridLayout(1,2,20,20));
		panelSeleccionFase=new JPanel(new GridLayout(3,1));
		panelSocial=new JTabbedPane();
		
		
		
		creaBotonera();
		panelPrincipal.add(panelBotonera);

		
		creaCentral();
		panelPrincipal.add(panelCentral);
		
		creaSocial();
		creaSeleccionFase();
		
		panelInferior.add(panelSocial);
		panelInferior.add(panelSeleccionFase);

		panelPrincipal.add(panelInferior);
		
		this.setLayout(new GridLayout(1,1));
		add(panelPrincipal);		
	}
	
	private void creaSocial() {
		psJ1=new PanelSocialJugador();
		psJ1=new PanelSocialJugador();
		panelSocial.add(psJ1,"Jugador 1");
		panelSocial.add(psJ2,"Jugador 2");
	}



	private void creaBotonera(){
		crearNuevoPerfil=new JButton("Crear Perfil");
		borrarPerfil=new JButton("Borrar Perfil");
		verPuntuacion=new JButton("Ver Puntuacion");
		subirPuntuacion=new JButton("Subir Puntuacion");
		jugar=new JButton("Jugar!");
		volver=new JButton("Volver");
		
		
		ListenerDeBotones listenerDeBotones=new ListenerDeBotones();
		crearNuevoPerfil.addActionListener(listenerDeBotones);
		borrarPerfil.addActionListener(listenerDeBotones);
		verPuntuacion.addActionListener(listenerDeBotones);
		subirPuntuacion.addActionListener(listenerDeBotones);
		jugar.addActionListener(listenerDeBotones);
		volver.addActionListener(listenerDeBotones);
		
		panelBotonera.add(crearNuevoPerfil);
		panelBotonera.add(borrarPerfil);
		panelBotonera.add(volver);
		panelBotonera.add(verPuntuacion);
		panelBotonera.add(subirPuntuacion);
		panelBotonera.add(jugar);
		

	}
	
	private void creaCentral(){
		creaSeleccionDeJugadores();
		creaSeleccionPerfil();
		creaSeleccionNaves();
		panelOpcionesJ1.add(onePlayer);
		panelOpcionesJ1.add(listaPerfilesJ1);
		panelOpcionesJ1.add(panelSeleccionNaveJ1);
		
		panelOpcionesJ2.add(twoPlayers);
		panelOpcionesJ2.add(listaPerfilesJ2);
		panelOpcionesJ2.add(panelSeleccionNaveJ2);

		panelCentral.add(panelOpcionesJ1);
		panelCentral.add(panelOpcionesJ2);
		
		Opciones.listaPerfilesJ2.setVisible(false);
		Opciones.panelSeleccionNaveJ2.setVisible(false);
	}

	private void creaSeleccionFase(){
		listaFases=new JComboBox(perfiles.getPerfil(perfilJ1).getFasesDisponibles());
		println(perfiles.getPerfil(perfilJ1).getName());
		panelSeleccionFase.add(new JPanel());
		panelSeleccionFase.add(listaFases);
	}
	
	private void creaSeleccionDeJugadores(){
		ListenerSeleccionJugadores listenerSeleccionJugadores=new ListenerSeleccionJugadores();
		onePlayer=new JRadioButton("1 jugador");
		onePlayer.addActionListener(listenerSeleccionJugadores);
		onePlayer.setActionCommand("1");
		panelOpcionesJ1.add(onePlayer);
		onePlayer.setSelected(true);
		twoPlayers=new JRadioButton("2 jugadores");
		twoPlayers.addActionListener(listenerSeleccionJugadores);
		twoPlayers.setActionCommand("2");
		panelOpcionesJ2.add(twoPlayers);
		//se agrupan las opciones
		ButtonGroup grupoNJugadores=new ButtonGroup();
		grupoNJugadores.add(onePlayer);
		grupoNJugadores.add(twoPlayers);
	}
	private static void creaSeleccionPerfil(){
		ListenerSeleccionPerfil listenerSeleccionPerfil=new ListenerSeleccionPerfil();
		String[] NombreDePerfiles=perfiles.getPerfilesNames();

		listaPerfilesJ1=new JComboBox(NombreDePerfiles);
		listaPerfilesJ1.setSelectedIndex(perfilJ1);
		listaPerfilesJ1.addActionListener(listenerSeleccionPerfil);
		
		listaPerfilesJ2=new JComboBox(NombreDePerfiles);
		listaPerfilesJ2.setSelectedIndex(perfilJ2);
		listaPerfilesJ2.addActionListener(listenerSeleccionPerfil);
	}
	private void creaSeleccionNaves(){
		ListenerSeleccionNave listenerSeleccionNave=new ListenerSeleccionNave();
		listaNavesJ1=new JComboBox(Opciones.naves);
		listaNavesJ1.addActionListener(listenerSeleccionNave);
		panelSeleccionNaveJ1.add(listaNavesJ1);
		listaNavesJ2=new JComboBox(Opciones.naves);
		listaNavesJ2.addActionListener(listenerSeleccionNave);
		panelSeleccionNaveJ2.add(listaNavesJ2);
		navePreviewJ1= new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/naves/"+naves[0]+".png")));
		panelSeleccionNaveJ1.add(navePreviewJ1);
		navePreviewJ2= new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/naves/"+naves[1]+".png")));
		panelSeleccionNaveJ2.add(navePreviewJ2);
	}
	
	public static boolean palabraSinSimbolos(String palabra){
		for(int i=0;i<palabra.length();i++){
			char letra=palabra.charAt(i);
			if(!( (letra>='0' && letra<='9') || (letra>='A' && letra<='z'))){
				return false;
			}
		}
		return true;
	}
	
	public static int numeroDiferenteEntreRango(int diferenteDe,int min,int max){
		Random rand = new Random();
		float aleatorio;
		do{
			aleatorio = ( (rand.nextFloat()+min) * (max+1) );
		}while((int)aleatorio==diferenteDe);
		return (int)aleatorio;
	}
	
	public void println(String string){
		System.out.println(string);
	}
	
	public static void actualizarPreview(){
		//panel de seleccion de perfil
		//Opciones.listaNavesJ1.setToolTipText(""+Opciones.naveJ1);
		//Opciones.listaPerfilesJ1.setToolTipText(""+Opciones.perfilJ1);
		//panel de la nave
		//Opciones.navePreviewJ1.setText("lv: "+Opciones.perfiles.getPerfil(Opciones.perfilJ1).getlevel(Opciones.naveJ1));
		//Opciones.navePreviewJ1.setToolTipText("lv: "+Opciones.perfiles.getPerfil(Opciones.perfilJ1).getlevel(Opciones.naveJ1));
		//Opciones.navePreviewJ2.setText("lv: "+Opciones.perfiles.getPerfil(Opciones.perfilJ2).getlevel(Opciones.naveJ2));
		//Opciones.navePreviewJ2.setToolTipText("lv: "+Opciones.perfiles.getPerfil(Opciones.perfilJ2).getlevel(Opciones.naveJ2));
		/*Opciones.perfiles.getPerfil(perfilJ1).actualizarScore(1,0,5);
		Opciones.perfiles.getPerfil(perfilJ1).actualizarScore(0,0,5);
		Opciones.perfiles.getPerfil(perfilJ1).actualizarScore(0,1,6);
		Opciones.perfiles.getPerfil(perfilJ1).actualizarScore(0,2,6);
		Opciones.perfiles.getPerfil(perfilJ1).actualizarScore(0,4,6);*/
		/*Opciones.perfiles.getPerfil(perfilJ1).levelUp(1);
		Opciones.perfiles.getPerfil(perfilJ1).levelUp(1);
		Opciones.perfiles.getPerfil(perfilJ1).setLevel(0, 7);
		Opciones.perfiles.getPerfil(perfilJ1).setLevel(1, 8);
		Opciones.perfiles.getPerfil(perfilJ1).setLevel(2, 6);*/
		
		//TODO
		Opciones.listaPerfilesJ1.setToolTipText("Porcentaje completado: "+Opciones.perfiles.getPerfil(perfilJ1).getPorcentajeCompletado()+"%");
		//Opciones.listaNavesJ1.setToolTipText("Siguiente mision: "+NombreMisiones[Opciones.perfiles.getPerfil(perfilJ1).getNextMissionId(NuevoJuego.naveJ1)]);
		//Opciones.navePreviewJ1.setToolTipText("lv: "+Opciones.perfiles.getPerfil(Opciones.perfilJ1).getlevel(NuevoJuego.naveJ1));
		Opciones.listaPerfilesJ2.setToolTipText("Porcentaje completado: "+Opciones.perfiles.getPerfil(perfilJ2).getPorcentajeCompletado()+"%");
		//Opciones.listaNavesJ2.setToolTipText("Siguiente mision: "+NombreMisiones[Opciones.perfiles.getPerfil(perfilJ2).getNextMissionId(NuevoJuego.naveJ2)]);
		//Opciones.navePreviewJ2.setToolTipText("lv: "+Opciones.perfiles.getPerfil(Opciones.perfilJ2).getlevel(NuevoJuego.naveJ2));
	}
	
	/*public static void main(String s[]) {
		Opciones ventana = new Opciones();
		ventana.setSize(800,600);
		ventana.pack();
		ventana.setVisible(true);
	}*/
	private void definirUI(){
		if(isAvailableLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel")){
			try {
				Class<?> nimbus=Class.forName("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
				setUI((LookAndFeel) nimbus.newInstance(),(Component)this);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	
	private boolean isAvailableLookAndFeel(String laf) {
		try { 
			Class<?> lnfClass = Class.forName(laf);
			LookAndFeel newLAF = (LookAndFeel)(lnfClass.newInstance());
			return newLAF.isSupportedLookAndFeel();
		} catch (Exception e) { // If ANYTHING weird happens, return false
			return false;
		}
	}
	private static void setUI(LookAndFeel laf,Component component){
		try {
			UIManager.setLookAndFeel(laf);
			SwingUtilities.updateComponentTreeUI(component);
		} catch (UnsupportedLookAndFeelException exc) {
			// This should not happen because we already checked
			//((DefaultComboBoxModel)lafComboBox.getModel()).removeElement(supportedLaF);
		}
	}
}


class ListenerSeleccionJugadores implements ActionListener{
	
	public void actionPerformed(ActionEvent evt) {
		
		if(evt.getSource()==Opciones.onePlayer){
			NuevoJuego.nJugadores=1;
			Opciones.listaPerfilesJ2.setVisible(false);
			Opciones.panelSeleccionNaveJ2.setVisible(false);
		}
		if(evt.getSource()==Opciones.twoPlayers){
			NuevoJuego.nJugadores=2;
			Opciones.listaPerfilesJ2.setVisible(true);
			Opciones.panelSeleccionNaveJ2.setVisible(true);
			if(NuevoJuego.naveJ1==2){
				NuevoJuego.naveJ2=3;
				Opciones.listaNavesJ2.setSelectedIndex(2);
				Opciones.navePreviewJ2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("res/naves/"+Opciones.naves[2]+".png")));
			}
			else{
				NuevoJuego.naveJ2=2;
				Opciones.listaNavesJ2.setSelectedIndex(1);
				Opciones.navePreviewJ2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("res/naves/"+Opciones.naves[1]+".png")));
			}
		}
		Opciones.actualizarPreview();
	}
}


class ListenerSeleccionNave implements ActionListener{
	//System.out.println("Jesus");
	public void actionPerformed(ActionEvent evt) {
		
		if(evt.getSource()==Opciones.listaNavesJ1){
			for(int i=0;i<Opciones.naves.length;i++){
				if(Opciones.listaNavesJ1.getSelectedItem().equals(Opciones.naves[i])){
					NuevoJuego.naveJ1=i;
					Opciones.navePreviewJ1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("res/naves/"+Opciones.naves[i]+".png")));
				}
			}
			NuevoJuego.naveJ1++;
		}
		if(evt.getSource()==Opciones.listaNavesJ2){
			for(int i=0;i<Opciones.naves.length;i++){
				if(Opciones.listaNavesJ2.getSelectedItem().equals(Opciones.naves[i])){
					NuevoJuego.naveJ2=i;
					Opciones.navePreviewJ2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("res/naves/"+Opciones.naves[i]+".png")));
				}
			}
			NuevoJuego.naveJ2++;
		}
		//System.out.println("j1: " +NuevoJuego.naveJ1+ "   J2: "+NuevoJuego.naveJ2);
		Opciones.actualizarPreview();
	}
}




class ListenerDeBotones implements ActionListener{

	public void actionPerformed(ActionEvent evt){

		if(evt.getSource()==Opciones.crearNuevoPerfil){
			String nombre=null;
			nombre= JOptionPane.showInputDialog("Nombre del nuevo perfil: ");
			if(nombre==null || nombre.equals(" ") || nombre.equals("") || (nombre.length()>20 || !Opciones.palabraSinSimbolos(nombre))){
				JOptionPane.showMessageDialog(Opciones.panelPrincipal, "No se pudo crear perfil");
			}
			else{
				if( ! Opciones.perfiles.existePerfil(nombre)){
					Perfil p=new Perfil(nombre);
					Opciones.perfiles.add(p);
					Opciones.listaPerfilesJ1.addItem(nombre);
					Opciones.listaPerfilesJ2.addItem(nombre);
				}
				else{
					JOptionPane.showMessageDialog(Opciones.panelPrincipal, "El perfil ya existe");
				}
			}
			
		}
		if(evt.getSource()==Opciones.borrarPerfil){
			if(Perfiles.getPerfiles().size()>2){
				String perfilABorrar=JOptionPane.showInputDialog("Escribe el nombre del perfil a borrar");
				int idPerfilABorrar=Opciones.perfiles.getIdPerfil(perfilABorrar);
				if(idPerfilABorrar==-1){
					JOptionPane.showMessageDialog(Opciones.panelPrincipal, "No se pudo borrar, el perfil no existe");
				}
				else{
					int res = JOptionPane.showConfirmDialog(Opciones.panelPrincipal, "¿Estas seguro?","se borraran todos los datos referentes al perfil",JOptionPane.YES_NO_OPTION);
					if(res==0){ //System.out.println("si"); 
						//Opciones.listaPerfilesJ1.removeAllItems();
						//Opciones.listaPerfilesJ2.removeAllItems();
						Opciones.listaPerfilesJ1.removeItemAt(idPerfilABorrar);
						Opciones.listaPerfilesJ2.removeItemAt(idPerfilABorrar);
						Opciones.perfiles.borrarPerfil(idPerfilABorrar);
					}
				}
			}
			else{
				JOptionPane.showMessageDialog(Opciones.panelPrincipal, "Debe existir al menos un perfil para cada jugador");
			}
		}
		if(evt.getSource()==Opciones.verPuntuacion){
			@SuppressWarnings("unused")
			VisorPuntuacion ventanaPuntuaciones=new VisorPuntuacion();
		}
		if(evt.getSource()==Opciones.subirPuntuacion){
			//TODO
			try {
				String respuesta=(String) JOptionPane.showInputDialog(Opciones.panelPrincipal,"¿De que Perfil quieres subir la puntuacion?",
						"Selección de perfil",JOptionPane.QUESTION_MESSAGE,null, Opciones.perfiles.getPerfilesNames(), null);
				if(respuesta!=null){
					Perfil temp=Opciones.perfiles.getPerfil(Opciones.perfiles.getIdPerfil(respuesta));
					URL web=new URL("http://127.0.0.1/JRP-Streaming/snuevomensaje.php?texto="+temp.name+"%20"+"%22holaogolaosd%22");
					web.openStream();
					JOptionPane.showMessageDialog(Opciones.panelPrincipal, "Conexion con la Web correcta, comprueba que la puntuacion está correcta en la web");
				}
			}catch (MalformedURLException e) {System.out.println("mal");}

			catch (IOException e) {
				JOptionPane.showMessageDialog(Opciones.panelPrincipal, "Imposible conectar, comprueba tu conexion a internet");
			}


		}
		if(evt.getSource()==Opciones.jugar){
			try {
				Opciones.twitter1.updateStatus("Bueno, empieza el desafio");
			} catch (TwitterException e) {
			}
			if(NuevoJuego.nJugadores==2){
				try {
					Opciones.twitter2.updateStatus("Bueno, empieza el desafio");
				} catch (TwitterException e) {
				}
			}
			
			if(NuevoJuego.naveJ1==NuevoJuego.naveJ2 && NuevoJuego.nJugadores!=1){
				JOptionPane.showMessageDialog(Opciones.panelPrincipal, "Las naves deben de ser diferentes para cada jugador");
			}
			else{
				if(Opciones.perfilJ1==Opciones.perfilJ2 && NuevoJuego.nJugadores!=1){
					JOptionPane.showMessageDialog(Opciones.panelPrincipal, "Debes seleccionar Perfiles diferentes para cada jugador");
				}
				else{
					try {
						Opciones.accessToken = Opciones.twitter1.getOAuthAccessToken(Opciones.requestToken,Opciones.psJ1.nombreT.getText());
						Opciones.twitter1.setOAuthConsumer("EiQIZw2bve8kVphjRiiTwA", "pFbzdyBayxjn3QHkp8oB1k8ASriMsLQIYb7rfeOBIY");
						 
						Opciones.twitter1.setOAuthAccessToken(Opciones.accessToken);

					} catch (TwitterException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if(NuevoJuego.nJugadores==2){
						try {
							Opciones.accessToken2 = Opciones.twitter2.getOAuthAccessToken(Opciones.requestToken2,Opciones.psJ2.nombreT.getText());
							Opciones.twitter2.setOAuthConsumer("EiQIZw2bve8kVphjRiiTwA", "pFbzdyBayxjn3QHkp8oB1k8ASriMsLQIYb7rfeOBIY");
							 
							Opciones.twitter2.setOAuthAccessToken(Opciones.accessToken);
	
						} catch (TwitterException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					/*String respuesta=(String) JOptionPane.showInputDialog(Opciones.panelPrincipal,"Seleccione mision: ",
							"Selección de mision",JOptionPane.QUESTION_MESSAGE,null, Opciones.nombreMisiones, null);*/
					
						/*if(respuesta==null){
						}
						else{*/
							Opciones.faseSeleccionada=(String) Opciones.listaFases.getSelectedItem();
							MenuCache.stopMenuMusic();
							irfase();
						}

				}
			//}
		}
		if(evt.getSource()==Opciones.volver){
			NuevoJuego.getNuevoJuego().playComponent((Component)NuevoJuego.getNuevoJuego().getMainMenu(), 1000);
		}
	}

	public void irfase(){
		if(Opciones.faseSeleccionada==Opciones.nombreMisiones[0]){
			NuevoJuego.getNuevoJuego().playComponent((Component) new Tutorial(),30);
		}
		if(Opciones.faseSeleccionada==Opciones.nombreMisiones[1]){
			NuevoJuego.getNuevoJuego().playComponent((Component) new Secuencia2(),30);
		}
		if(Opciones.faseSeleccionada==Opciones.nombreMisiones[2]){
			NuevoJuego.getNuevoJuego().playComponent((Component) new Secuencia3(),30);
		}
		if(Opciones.faseSeleccionada==Opciones.nombreMisiones[3]){
			NuevoJuego.getNuevoJuego().playComponent((Component) new Secuencia4(),30);
		}
		if(Opciones.faseSeleccionada==Opciones.nombreMisiones[4]){
			NuevoJuego.getNuevoJuego().playComponent((Component) new Mission5(),30);
		}
		if(Opciones.faseSeleccionada==Opciones.nombreMisiones[5]){
			NuevoJuego.getNuevoJuego().playComponent((Component) new Mission6(),30);
		}
		if(Opciones.faseSeleccionada==Opciones.nombreMisiones[6]){
			NuevoJuego.getNuevoJuego().playComponent((Component) new Mission7(),30);
		}
		if(Opciones.faseSeleccionada==Opciones.nombreMisiones[7]){
			NuevoJuego.getNuevoJuego().playComponent((Component) new Mission8(),30);
		}
	}

}



class ListenerSeleccionPerfil implements ActionListener{

	public void actionPerformed(ActionEvent evt) {
		//System.out.println("seleccion de perfil: ");
		if(evt.getSource()==Opciones.listaPerfilesJ1){
			Opciones.perfilJ1=Opciones.listaPerfilesJ1.getSelectedIndex();
			//System.out.println("j1 perfi: "+Opciones.perfilJ1);
		}
		
		if(evt.getSource()==Opciones.listaPerfilesJ2){
			Opciones.perfilJ2=Opciones.listaPerfilesJ2.getSelectedIndex();
		}
		Opciones.actualizarPreview();
	}
}






