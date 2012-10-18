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


public class Tutorial extends  Fase {


	public Tutorial() {
		super();
	}


	public void jugar() {
		usedTime=1000;
		//eventTime,nuevotime;
		t=0;
		int i;
		int contador1=0;  
		//int contador1=1249;
		int contador2=0;
		int vidaMonster=1;



		initWorld(); 
		soundCache.PlaySongMp3("musica/Into the Worm Hole.mp3",true);
		long nuevoTime = System.currentTimeMillis();
		long fichaTiempo = 0;



		while (isVisible() && !gameEnded) {
			t=t+10;
			long startTime = System.currentTimeMillis();
			updateWorld();
			checkCollisions();
			paintWorld();
			usedTime = System.currentTimeMillis()-startTime;

			eventTime = System.currentTimeMillis()-nuevoTime;

			if(fichaTiempo < (int)(eventTime/100)){
				contador1++;

				if(contador1==1){
					Charla.getCharla().pdamonConf();
					Charla.getCharla().setMensaje("Actualizando firmware...");
				}
				
				if(contador1==30){
				
					Charla.getCharla().setMensaje("Comprobando pilas de protocolos TCP/IP");
				}
				
				
				

				if(contador1==120){
				
					Charla.getCharla().setMensaje("Cargando interfaz de usuario...");
				}
				
				
				if(contador1==160){

					Charla.getCharla().defaultConf();
					Charla.getCharla().setMensaje("Recordemos como manejar nuestras naves programadas en java");
				}

						if(contador1==200){
							Charla.getCharla().setMensaje("Pulsando la tecla A, te moveras negativamente en el eje X, con W S y D te moveras a traves de los dos ejes con precision el jugador 2 hace lo mismo con las flechas del teclado");
						}
						if(contador1==300){
							Charla.getCharla().setMensaje("Prueba a controlar tu nave");
						}

				if(contador1==200){
					Actor m = new Start(this);
					m.setX(150 ) ;
					m.setY( 200+ (int)(Math.random()*20) );
					actors.add(m);
					player.fuegoDisponible=1;
					if(NuevoJuego.nJugadores==2){
						player2.fuegoDisponible=1;
					}
				}
				
				if(contador1==400){
					Charla.getCharla().setMensaje("Vamos a crear objects.proyectil, es facil solo tienes que pulsar la barra espaciadora para ello... el jugador 2 hace lo mismo con el intro");
				}
				
				if(contador1==500){
					Charla.getCharla().setMensaje("Con el boton B puedes generar poderosas bombas de plasma, el segundo jugador hace lo mismo con el boton Ctrl, para ello teneis que tener abajo disponibles");
				}
				
				if(contador1==600){
					player.fury=100;
					if(NuevoJuego.nJugadores==2){
					player2.fury=100;
					}
					Charla.getCharla().setMensaje("Para ejecutar tu ataque de furia tienes que pulsar el boton N, el segundo jugador con el mayusculas, con el contador lleno, pruebalo");
				}
				
				if(contador1==700){
					Charla.getCharla().setMensaje("CUANDO ACABES DE PROBAR LOS CONTROLES PULSA ESCAPE, QUE ADEMAS SIRVE PARA SALTAR LAS SECUENCIAS ANIMADAS");
				}



				

				if(player.escape==true){
					Charla.getCharla().quitaMensaje();
					soundCache.StopSongMp3();
					this.limpiaMemo();
					NuevoJuego.getNuevoJuego().playComponent((Component)NuevoJuego.getNuevoJuego().Secuencia (), 30);
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

		for (int i = 0; i < actors.size(); i++) {
			Actor m = (Actor)actors.get(i);
			m.paint(g);
		}



		if(primeroVivo==1){
			player.paint(g);
		}

		if(NuevoJuego.nJugadores==2){
			if(segundoVivo==1){
				player2.paint(g);
			}
		}

		paintStatus(g);
		Charla.getCharla().paint(g);
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