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


public class Secuencia extends  Fase {


	public Secuencia() {
		super();
	}


	public void jugar() {
		usedTime=1000;
		//eventTime,nuevotime;
		t=0;
		int i;
		int contador1=-30;
		//int contador1=400;
		int contador2=0;
		int vidaMonster=1;

		initWorld(); 
		soundCache.PlaySongMp3("musica/Oblivion.mp3",true);
		
		long nuevoTime = System.currentTimeMillis();
		long fichaTiempo = 0;



		while (isVisible() && !gameEnded) {
			t=t+2;
			long startTime = System.currentTimeMillis();
			updateWorld();
			checkCollisions();
			paintWorld();
			

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
					
					Charla.getCharla().adamuzConf();
					//Charla.getCharla().setMensaje("En un mundo donde la programacion es la base de toda vida");
					Charla.getCharla().setMensaje("En un mundo paralelo donde la programacion es fuente de toda vida...");
				}

				
				if(contador1==50){
					//Charla.getCharla().setMensaje("Un grupo de malvados programadores... queria hacer añicos a la humanidad");
					Charla.getCharla().setMensaje("Una raza de malvados programadores se reveló contra el mundo conocido hasta hoy... pero tenemos un heroe con el que no contaban...");
				}
				
				if(contador1==150){
					Charla.getCharla().setMensaje("Hace 15.811.200 segundos nuestro heroe combatio a los malvados programadores con valentia y honor evitando que sus alumnos cayeran en el lado oscuro");
					
				}
				if(contador1==250){
					Charla.getCharla().setMensaje("De este lenguaje a surgido un nuevo y tenebroso poder que pretende controlar el mundo, la naturaleza y el universo en su totalidad");
				}
				 
				
				
				
				if(contador1==370){
					Charla.getCharla().Net2Conf();
					Charla.getCharla().setMensaje("Jajajaja, el © moral inyector esta acabado");
				}
				if(contador1==400){
					Charla.getCharla().NetConf();
					Charla.getCharla().setMensaje("Si, ahora tendremos que dispararlo contra alguien para probar su elegante poder .net");
				}
				if(contador1==450 || contador1==465 || contador1==480 || contador1==495 || contador1==510){
					for(i=0;i<16;i++){
						Monster m = new MonsterGeneric(this,0);
						m.setX(1+i*50 ) ;
						m.setY( 1 );
						m.setVx( 0 );
						m.setVy( 2);
						actors.add(m);
						}
				}
				
				
				if(contador1==600){
					MonsterMoralInyector m = new MonsterMoralInyector(this);
					m.setX(200 ) ;
					m.setY( 1 );
					m.setVx( 0 );
					m.setVy( 1);
					actors.add(m);
				}
				
				if(contador1==600){
					Charla.getCharla().Net2Conf();
					Charla.getCharla().setMensaje("Si, moral inyector, el arma definitiva esta aqui ante nuestros ojos");
				}
				if(contador1==650){
					Charla.getCharla().NetConf();
					Charla.getCharla().setMensaje("En sus perfectas formas se nota la programacion .net mas optima jamas compilada");
				}
				if(contador1==700){
					Charla.getCharla().NetConf();
					Charla.getCharla().setMensaje("Este arma cambiara el curso de la guerra y nos hara salir victoriosos... esta vez RedStar no se saldra con la suya");
				}
				if(contador1==750){
					Charla.getCharla().Net2Conf();
					Charla.getCharla().setMensaje("Bien, vamos a hacer el ataque de la siguiente manera...");
				}
				
				if(contador1==800 || player.escape==true){
					
				player.choqueDisponible=1;
					
					if(NuevoJuego.nJugadores==2){
						player2.choqueDisponible=1;
					}
					
					
				 Charla.getCharla().quitaMensaje();
				 soundCache.StopSongMp3();
				 this.limpiaMemo();
				 NuevoJuego.getNuevoJuego().playComponent((Component)NuevoJuego.getNuevoJuego().Secuencia1 (), 30);
				 NuevoJuego.getNuevoJuego().playGame();
				}
	

			}
			fichaTiempo = eventTime / 100;
			usedTime = System.currentTimeMillis()-startTime;
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


		paintfps(g);
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