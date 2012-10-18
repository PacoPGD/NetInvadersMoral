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


public class SecuenciaFinalA extends  Fase {


	public SecuenciaFinalA() {
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
			t=t+1;
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
					Charla.getCharla().defaultConf();
					Charla.getCharla().setMensaje("Adamuz oscuro ha sido realmente temible y poderoso");
				}
				if(contador1==50){
					Charla.getCharla().pacoConf();
					Charla.getCharla().setMensaje("Bien, ahora volvamos al rumbo original para acabar con esos programadores del demonio");
				}
				if(contador1==100){
					Charla.getCharla().jesusConf();
					Charla.getCharla().setMensaje("Siento decir una cosa bastante seria...");
				}
				if(contador1==150){
					Charla.getCharla().adamConf();
					Charla.getCharla().setMensaje("No no no, no puede ser...");
				}
				if(contador1==200){
					Charla.getCharla().jesusConf();
					Charla.getCharla().setMensaje("La energia de la nave");
				}
				if(contador1==250){
					Charla.getCharla().juanConf();
					Charla.getCharla().setMensaje("¡ESTA PRACTICAMENTE AGOTADA!");
				}
				if(contador1==300){
					Charla.getCharla().juanConf();
					Charla.getCharla().setMensaje("¡NO PUEDE SER!, ¡¿COMO VAMOS A ESCAPAR?!");
				}
				if(contador1==350){
					Charla.getCharla().pacoConf();
					Charla.getCharla().setMensaje("No queda mas... que entregarnos al mundo ninja oscuro y ser ninjas para la eternidad...");
				}
				if(contador1==400){
					for(i=0;i<8;i++){
						for(int j=0;j<5;j++){
					Adorno cosa = new Adorno(this,"../personajes/AdamuzOscuro.png");
					cosa.x=i*100;
					cosa.y=j*100;
					actors.add(cosa);
						}
					}
				}
				
				if(contador1==450){
					Charla.getCharla().defaultConf();
					Charla.getCharla().setMensaje("Arigato");
				}
				if(contador1==465){
					Charla.getCharla().angelConf();
					Charla.getCharla().setMensaje("Miyamoto");
				}
				if(contador1==480){
					Charla.getCharla().adamConf();
					Charla.getCharla().setMensaje("Pikachu, Doraemon...");
				}
				if(contador1==520){
					Charla.getCharla().quitaMensaje();
					soundCache.StopSongMp3();
					NuevoJuego.getNuevoJuego().playComponent((Component)NuevoJuego.getNuevoJuego().Creditos (), 30);
					NuevoJuego.getNuevoJuego().playGame();
				}
				
				if(player.escape==true){
					Charla.getCharla().quitaMensaje();
					soundCache.StopSongMp3();
					NuevoJuego.getNuevoJuego().playComponent((Component)NuevoJuego.getNuevoJuego().Creditos (), 30);
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
		ocean = spriteCache.getSprite("fondos/rara.gif");
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