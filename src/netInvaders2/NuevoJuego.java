package netInvaders2;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

import netInvaders2.Opciones.Opciones;
import netInvaders2.Opciones.Preferencias;


import games.*;
import games.canvasmenu.*;



public class NuevoJuego extends Game {

	
	public  static int nJugadores = 1;
	public  static int naveJ1 = 1;
	public  static int naveJ2 = 2;
	public int width;
	public int height;

	
	private CellMenu mainMenu = null;	
	
	public Preferencias panelPreferencias = new Preferencias();
	public Opciones panelOpciones = new Opciones();

	private static NuevoJuego nuevoJuego = null;
	
	public NuevoJuego (String gameName, int width, int height) {
		super (gameName, width, height);
		this.width = width;
		this.height = height;
	}
	
	public static NuevoJuego getNuevoJuego () {
		if (nuevoJuego == null) {
			nuevoJuego = new NuevoJuego("NET INVADERS MORAL INYECTOR", 800, 600);
		}
		
		return nuevoJuego;
	}
	

	
	public PlayableCanvas getMainMenu () {
		MenuCache.playmp3(); 
		
		
		if (mainMenu == null) {
			mainMenu = new CellMenu(width, height, -1);
			mainMenu.setSelectionIndicatorImage("menu/selec2.png");
			mainMenu.addCell(new CellElement("menu/jugar.png", new ActionListener (){
				public void actionPerformed (ActionEvent evt) {
					panelOpciones=new Opciones();
					playComponent(panelOpciones, 1000);
				}
			}));
			mainMenu.addCell(new CellElement("menu/opciones.png", new ActionListener (){
				public void actionPerformed (ActionEvent evt) {
					panelPreferencias=new Preferencias();
					playComponent(panelPreferencias, 1000);
				}
			}));
			mainMenu.addCell(new CellElement("menu/creditos.png", new ActionListener (){
				public void actionPerformed (ActionEvent evt) {
					MenuCache.stopMenuMusic();
					NuevoJuego.getNuevoJuego().playComponent((Component) new Creditos(),30);
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
	

	public void closing() {
		System.exit(0);
	}

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NuevoJuego.getNuevoJuego().playComponent((Component)NuevoJuego.getNuevoJuego().getMainMenu(), 1000);

		NuevoJuego.getNuevoJuego().playGame();

	}
	
	
	public PlayableCanvas Tutorial () {
		return new Tutorial();	
	}
	public PlayableCanvas Secuencia () {
		return new Secuencia();	
	}
	
	public PlayableCanvas Creditos () {
		return new Creditos();	
	}
	
	public PlayableCanvas Secuencia1 () {
		return new Secuencia1();	
	}
	
	public PlayableCanvas Secuencia2 () {
		return new Secuencia2();	
	}
	
	public PlayableCanvas Secuencia3 () {
		return new Secuencia3();	
	}
	public PlayableCanvas Secuencia4 () {
		return new Secuencia4();	
	}
	public PlayableCanvas Secuencia5 () {
		return new Secuencia5();	
	}
	public PlayableCanvas Secuencia6 () {
		return new Secuencia6();	
	}
	public PlayableCanvas Secuencia7 () {
		return new Secuencia7();	
	}
	public PlayableCanvas Secuencia8 () {
		return new Secuencia8();	
	}
	public PlayableCanvas SecuenciaFinalA () {
		return new SecuenciaFinalA();	
	}
	public PlayableCanvas SecuenciaFinalB () {
		return new SecuenciaFinalB();	
	}
	public PlayableCanvas SecuenciaFinalC () {
		return new SecuenciaFinalC();	
	}
	
	public PlayableCanvas Mission1 () {
		return new Mission1();	
	}
	
	public PlayableCanvas Mission2 () {
		return new Mission2();	
	}
	
	public PlayableCanvas Mission3 () {
		return new Mission3();	
	}

	public PlayableCanvas Mission4 () {
		return new Mission4();	
	}
	
	public PlayableCanvas Mission5 () {
		return new Mission5();	
	}
	
	public PlayableCanvas Mission6 () {
		return new Mission6();	
	}
	public PlayableCanvas Mission7 () {
		return new Mission7();	
	}
	public PlayableCanvas Mission8 () {
		return new Mission8();	
	}
	

}
