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


public class SecuenciaFinalC extends  Fase {


	public SecuenciaFinalC() {
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
					Charla.getCharla().TelecoConf();
					Charla.getCharla().setMensaje("AAAAAAAAARRRG, HIJOS... DE PUTA");
				}
				if(contador1==50){
					Charla.getCharla().defaultConf();
					Charla.getCharla().setMensaje("La justicia siempre vence y ahora tus planes no se llevaran a cabo");
				}
				if(contador1==100){
					Charla.getCharla().TelecoConf();
					Charla.getCharla().setMensaje("Tenia grandes proyectos para vomistar... y ahora... no se llevaran a cabo");
				}
				if(contador1==150){
					Charla.getCharla().TelecoConf();
					Charla.getCharla().setMensaje("Pero no importa... tengo mas compa�eros en mari*a d�or ciudad de va**c*o*es");
				}
				if(contador1==200){
					Charla.getCharla().pacoConf();
					Charla.getCharla().setMensaje("Bueno... entonces supongo que al fin ha terminado todo...");
				}
				if(contador1==220){
					Charla.getCharla().TelecoConf();
					Charla.getCharla().setMensaje("pero si he dicho que...");
				}
				if(contador1==250){
					Charla.getCharla().loboConf();
					Charla.getCharla().setMensaje("Si, al fin la galaxia vuelve a su equilibrio");
				}
				if(contador1==270){
					Charla.getCharla().TelecoConf();
					Charla.getCharla().setMensaje("�no me habeis escuchado?");
				}
				if(contador1==300){
					Charla.getCharla().jesusConf();
					Charla.getCharla().setMensaje("Bueno, volvamos a la tierra");
				}
				if(contador1==320){
					Charla.getCharla().TelecoConf();
					Charla.getCharla().setMensaje("...");
				}
				if(contador1==350){
					Charla.getCharla().defaultConf();
					Charla.getCharla().setMensaje("Se�ores... buen trabajo");
				}
				if(contador1==370){
					Charla.getCharla().TelecoConf();
					Charla.getCharla().setMensaje("ESCUCHADME CO�OOOOOOOOOO");
				}
				if(contador1==400){
					Charla.getCharla().quitaMensaje();
					soundCache.StopSongMp3();
					NuevoJuego.getNuevoJuego().playComponent((Component)NuevoJuego.getNuevoJuego().Creditos(), 30);
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