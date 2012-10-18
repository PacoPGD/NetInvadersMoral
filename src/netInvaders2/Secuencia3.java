package netInvaders2;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Secuencia3 extends  Fase {


	public Secuencia3() {
		super();
	}


	public void jugar() {
		usedTime=1000;
		//eventTime,nuevotime;
		t=0;
		int i;
		int contador1=-1;  
		int contador2=0;
		int vidaMonster=1;

		
		initWorld(); 

		long nuevoTime = System.currentTimeMillis();
		long fichaTiempo = 0;



		while (isVisible() && !gameEnded) {
			t=t+2;
			long startTime = System.currentTimeMillis();
			updateWorld();
			checkCollisions();
			paintWorld();
			usedTime = System.currentTimeMillis()-startTime;

			eventTime = System.currentTimeMillis()-nuevoTime;

			if(fichaTiempo < (int)(eventTime/100)){
				contador1++;

				if(contador1==0){
					player.choqueDisponible=0;
					player.fuegoDisponible=0;
					if(NuevoJuego.nJugadores==2){
						player2.choqueDisponible=0;
						player2.fuegoDisponible=0;
					}
				}
				
				if(contador1==0){
					Charla.getCharla().jesusConf();
					Charla.getCharla().setMensaje("Que esta pasando aqui... los .net son viejos conocidos... ¿como han podido llegar a ese punto?");
				}
				

				if(contador1==50){
					Charla.getCharla().pdamonConf();
					Charla.getCharla().setMensaje("Es muy sencillo, los programadores .net han realizado un arma de letal poder, el moral inyector que convierte a cualquiera que reciba un disparo directo en programador .net");
				}
				

				if(contador1==150){
					Charla.getCharla().pacoConf();
					Charla.getCharla().setMensaje("Necesitamos encontrar ese arma y destruirla... pero no tenemos ni idea de donde se ocultan");
				}

				if(contador1==200){
					Charla.getCharla().angelConf();
					Charla.getCharla().setMensaje("Acabo de volver del desierto y he divisado actividad enemiga");
				}

				if(contador1==250){
					Charla.getCharla().pdamonConf();
					Charla.getCharla().setMensaje("Entonces esta claro lo que tenemos que hacer, nos dirigiremos al planeta desertico y demostraremos cual es el lenguaje predonimante de la galaxia a esos malditos .net");
				}

				if(contador1==300){
					Charla.getCharla().adamConf();
					Charla.getCharla().setMensaje("por por por por por por por por por supuesto");
				}

				if(contador1==350){
					Charla.getCharla().juanConf();
					Charla.getCharla().setMensaje("Si, pero podria ser una trampa de los mismos .net para destruirnos a todos de un golpe");
				}

				if(contador1==400){
					Charla.getCharla().pacoConf();
					Charla.getCharla().setMensaje("Yo opto por continuar, es mejor que si no hacemos nada ¿que os parece?");
				}

				if(contador1==450){
					Charla.getCharla().loboConf();
					Charla.getCharla().setMensaje("Yo estoy de acuerdo, no ganamos nada quedandonos aqui de brazos cruzados");
				}
				
			
				if(contador1==500){
					Charla.getCharla().defaultConf();
					Charla.getCharla().setMensaje("Si, es una estupenda idea, un ataque directo como ellos quieren, nuestras naves java les aplastaran ¿que opina jefe?");
				}
				if(contador1==550){
					Charla.getCharla().pdamonConf();
					Charla.getCharla().setMensaje("Esta bien, id a microsun a toda velocidad, cuando llegueis alli destruid todo rastro de .net ");
				}
				

				if(contador1==600){
					Charla.getCharla().quitaMensaje();
					soundCache.StopSongMp3();
					this.limpiaMemo();
					NuevoJuego.getNuevoJuego().playComponent((Component)NuevoJuego.getNuevoJuego().Mission3 (), 30);
					NuevoJuego.getNuevoJuego().playGame();
				}
				
				if(player.escape==true){
					Charla.getCharla().quitaMensaje();
					soundCache.StopSongMp3();
					this.limpiaMemo();
					NuevoJuego.getNuevoJuego().playComponent((Component)NuevoJuego.getNuevoJuego().Mission3 (), 30);
					NuevoJuego.getNuevoJuego().playGame();
					}
				
			}
			fichaTiempo = eventTime / 100;

			do {
				Thread.yield();
			} while (System.currentTimeMillis()-startTime< 17);		}




	}




	public void paintWorld() {
		Graphics2D g = (Graphics2D)strategy.getDrawGraphics();
		ocean = spriteCache.getSprite("fondos/bg1.gif");
		g.setPaint(new TexturePaint(ocean, new Rectangle(0,t,ocean.getWidth(),ocean.getHeight())));
		g.fillRect(0,0,getWidth(),getHeight());
		Charla.getCharla().paint(g);

		for (int i = 0; i < actors.size(); i++) {
			Actor m = (Actor)actors.get(i);
			m.paint(g);
		}


		paintfps(g);

		g.setColor(Color.white);
		strategy.show();
	}


	public void initWorld(){
		super.initWorld();	
	}


	public void paintGameOver() {
		super.paintGameOver();
	}



	public void updateWorld() {
		super.updateWorld();
	}



	public void paintShields(Graphics2D g) {
		super.paintShields(g);
	}

	public void paintScore(Graphics2D g) {
		super.paintScore(g);

	}

	public void paintAmmo(Graphics2D g) {
		super.paintAmmo(g);
	}

	public void paintfps(Graphics2D g) {
		super.paintfps(g);
	}


	public void paintStatus(Graphics2D g) {
		super.paintStatus(g);
	}	



	public void checkCollisions() {
		super.checkCollisions();
	}	

	public void addActor(Actor a) {
		super.addActor(a);
	} 


	public void gameOver () {
		super.gameOver();
	}


	public Player getPlayer(int jugador) {
		if(jugador==1){
			return player;
		}
		else
		{
			return player2;		
		}

	}


	public SoundCache getSoundCache() {
		return soundCache;
	}	


	public SpriteCache getSpriteCache() {
		return spriteCache;
	}


	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
	}

	public void keyReleased(KeyEvent e) {
		super.keyReleased(e);
	}


	public void keyTyped(KeyEvent e) {

	}


	@Override
	public void play() {
		jugar();

	}




}