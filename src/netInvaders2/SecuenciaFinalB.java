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


public class SecuenciaFinalB extends  Fase {


	public SecuenciaFinalB() {
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
		soundCache.PlaySongMp3("musica/Thinking About a Better World.mp3",true);
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
					Charla.getCharla().setMensaje("Siiiiii, el moral inyector ha sido destruido finalmente");
				}

				if(contador1==50){
					Charla.getCharla().pacoConf();
					Charla.getCharla().setMensaje("Nuestro objetivo ha sido finalizado, ya podemos volver a la tierra");
				}
				if(contador1==150){
					Charla.getCharla().TelecoConf();
					Charla.getCharla().setMensaje("Jajajaja, inutiles programadores java... ¿no sabeis lo que estaba pasando?");
				}
				if(contador1==190){
					Charla.getCharla().defaultConf();
					Charla.getCharla().setMensaje("No puede ser, ¡ES UN TELECO SEGUN INDICA SU NOMBRE!");
				}
				if(contador1==230){
					Charla.getCharla().angelConf();
					Charla.getCharla().setMensaje("¿Un teleco? ¿que quieres decir?");
				}
				if(contador1==270){
					Charla.getCharla().defaultConf();
					Charla.getCharla().setMensaje("Es un hibrido de informatico bastante común en nuestro mundo, pero llenos de maldad");
				}
				if(contador1==310){
					Charla.getCharla().loboConf();
					Charla.getCharla().setMensaje("Eso quiere decir que son los verdaderos enemigos");
				}
				if(contador1==350){
					Charla.getCharla().TelecoConf();
					Charla.getCharla().setMensaje("O eramos, gracias a la distracción que proporcionaron los .net no pudisteis daros cuenta de nuestro plan");
				}
				if(contador1==390){
					Charla.getCharla().defaultConf();
					Charla.getCharla().setMensaje("¿Que plan? ¿de que hablas?");
				}
				if(contador1==420){
					Charla.getCharla().TelecoConf();
					Charla.getCharla().setMensaje("El monopolio de comunicaciones, hemos instalado la mayor red wifi de la historia y ocupa toda la galaxia");
				}
				if(contador1==460){
					Charla.getCharla().TelecoConf();
					Charla.getCharla().setMensaje("Y yo soy el presidente de vomistar y marina d´or ci**ad de vaca***nes");
				}
				if(contador1==500){
					Charla.getCharla().pacoConf();
					Charla.getCharla().setMensaje("¿Y esos asteriscos? si todos saben que querias decir marina");
				}
				if(contador1==520){
					Charla.getCharla().TelecoConf();
					Charla.getCharla().setMensaje("¡CALLATE QUE NOS CRUJE LA SGAE! pero bueno, dicho esto ya sabeis a que ateneros");
				}
				if(contador1==560){
					Charla.getCharla().loboConf();
					Charla.getCharla().setMensaje("¿A que?");
				}
				if(contador1==600){
					Charla.getCharla().TelecoConf();
					Charla.getCharla().setMensaje("A pagar una cuota vitalicia de 60 € al mes por un ADSL no simetrico 1MB Bajada 158KB Subida");
				}
				if(contador1==640){
					Charla.getCharla().defaultConf();
					Charla.getCharla().setMensaje("NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
				}
				if(contador1==700){
					Charla.getCharla().TelecoConf();
					Charla.getCharla().setMensaje("JAJAJAJAJAJAJAJAJAJAJAJA");
				}
				
				if(contador1==710){
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