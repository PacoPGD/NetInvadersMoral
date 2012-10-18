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


public class Secuencia2 extends  Fase {


	public Secuencia2() {
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
					Charla.getCharla().pdamonConf();
					Charla.getCharla().setMensaje("Los programadores .net han vuelto del abismo de la muerte del que RedStar los encerro y estan dispuestos a destruir nuestro mundo por venganza");
				}
				
				if(contador1==50){
					Charla.getCharla().pacoConf();
					Charla.getCharla().setMensaje("Sabiamos que este dia llegaria antes o despues... ademas ya han transformado a Salvador...");
				}
				
				if(contador1==120){
					Charla.getCharla().juanConf();
					Charla.getCharla().setMensaje("Los programadores .net se aprovechan de la gente que esta asustada y les inculcan su lenguaje maligno");
				}
				if(contador1==200){
					Charla.getCharla().angelConf();
					Charla.getCharla().setMensaje("He vuelto de la luna, los programadores.net tienen alli un gran arsenal de armas y bicicletas voladoras");
				}
				if(contador1==250){
					Charla.getCharla().pdamonConf();
					Charla.getCharla().setMensaje("Perfecto, asi que tendremos que ir a detener a esos malvados...");
				}
				if(contador1==300){
					Charla.getCharla().angelConf();
					Charla.getCharla().setMensaje("Ire a la luna a comprobar sus armas");
				}
				if(contador1==350){
					Charla.getCharla().loboConf();
					Charla.getCharla().setMensaje("¿No has dicho que acabas de comprobarlo?");
				}
				if(contador1==400){
					Charla.getCharla().defaultConf();
					Charla.getCharla().setMensaje("Angel es tan veloz que tiene la capacidad de viajar a traves del tiempo, por eso ahora va a comprobarlo, el otro mensaje lo mando antes de salir, es un poco complicado de explicar...");
				}
				if(contador1==470){
					Charla.getCharla().loboConf();
					Charla.getCharla().setMensaje("Vaya... su poder de velocidad es realmente util");
				}
				if(contador1==520){
					Charla.getCharla().pacoConf();
					Charla.getCharla().setMensaje("Tengo un mal presentimiento, como que nos espera otra cara conocida en la luna");
				}
				if(contador1==570){
					Charla.getCharla().defaultConf();
					Charla.getCharla().setMensaje("Bueno, si es asi de todos modos no habrá mas remedio que destruirle, no hay otra salida");
				}
				if(contador1==630){
					Charla.getCharla().adamConf();
					Charla.getCharla().setMensaje("Pe pe pe pe...");
				}
				if(contador1==680){
					Charla.getCharla().jesusConf();
					Charla.getCharla().setMensaje("Vale, entonces está decidido, ¡nos vamos a la luna!");
				}
				if(contador1==720){
					Charla.getCharla().adamConf();
					Charla.getCharla().setMensaje("pe pe pero ten ten tendriamos que tra tra trazar zar zar un p p p plan");
				}

				if(contador1==770){
					Charla.getCharla().quitaMensaje();
					soundCache.StopSongMp3();
					this.limpiaMemo();
					NuevoJuego.getNuevoJuego().playComponent((Component)NuevoJuego.getNuevoJuego().Mission2 (), 30);
					NuevoJuego.getNuevoJuego().playGame();
				}
				
				if(player.escape==true){
					Charla.getCharla().quitaMensaje();
					soundCache.StopSongMp3();
					this.limpiaMemo();
					NuevoJuego.getNuevoJuego().playComponent((Component)NuevoJuego.getNuevoJuego().Mission2 (), 30);
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