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


public class Secuencia1 extends  Fase {


	public Secuencia1() {
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

		//soundCache.PlaySongMp3("musica/Across the Blue Skys.mp3",true);

		

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

				Adorno cosa = new Adorno(this,"planeta2.gif");
				cosa.x=500;
				cosa.y=400;
				actors.add(cosa);

				
				if(contador1==0){
					player.choqueDisponible=0;
					player.fuegoDisponible=0;
					if(NuevoJuego.nJugadores==2){
						player2.choqueDisponible=0;
						player2.fuegoDisponible=0;
					}
				}
				
				if(contador1==0){
					Charla.getCharla().pacoConf();
					Charla.getCharla().setMensaje("Bueno bueno, parece que todo esta calmado como siempre");

					
					
					
					Bot m = new PacoBot(this);
					m.setX(250 ) ;
					m.setY( 250 );
					m.setVx( 0 );
					m.setVy( 0);
					
					actors.add(m);
					
					
					Bot a = new JesusBot(this);
					a.setX(400 ) ;
					a.setY( 400 );
					a.setVx( 0 );
					a.setVy( 0);
					actors.add(a);
				}
				
				if(contador1==50){
					Charla.getCharla().jesusConf();
					Charla.getCharla().setMensaje("Hmmm, acaba de llegarme un email de pdamon, voy a ponerlo");
					JesusBot.vy=-7;
					JesusBot.vx=-3;
					
				}
				
				if(contador1==53){
					JesusBot.vy=0;
					JesusBot.vx=0;
				}
				
				if(contador1==100){
					Charla.getCharla().pdamonConf();
					Charla.getCharla().setMensaje("CUIDADO... ¡LOS PROGRAMADORES .NET SE APROXIMAN A TODA VELOCIDAD HACIA LA TIERRA!");	
				}
				
				if(contador1==150){
					Charla.getCharla().pacoConf();
					Charla.getCharla().setMensaje("Pues yo aun no veo a esos programadores .net...");	
				}
				
				if(contador1==170){
					for(i=0;i<5;i++){
					
						Monster m = new MonsterGeneric(this,0);
						m.setX(150*i ) ;
						m.setY( 0 );
						m.setVx( 0 );
						m.setVy( 20);
						actors.add(m);
					}
					
					
					Charla.getCharla().jesusConf();
					Charla.getCharla().setMensaje("¿¡Pero que!? acaban de pasarnos a toda velocidad");
				}
				
				if(contador1==200){
					Charla.getCharla().pacoConf();
					Charla.getCharla().setMensaje("Aunque mejoren sus naves jamas podran con la multiplataformidad de java... aunque la tierra tiene windows como SO");
				}
				
				if(contador1==250){
					if(Fase.identidad1==1){
						Charla.getCharla().jesusConf();
						Charla.getCharla().setMensaje("Voy a mandarle un email rapidamente al superior pelirrojo para que los intercepte... no tenemos de que preocuparnos");
					}
					if(Fase.identidad1==2){
						Charla.getCharla().pacoConf();
						Charla.getCharla().setMensaje("A esos los pillo yo ahora mismo ¡¡ADELANTE WHITE GALEON 2.3!!");
						PacoBot.vy=10;
					}
					if(Fase.identidad1==3){
						Charla.getCharla().jesusConf();
						Charla.getCharla().setMensaje("Mi nave es rapida como la luz, voy a destruirlos antes de que pisen la tierra");
						JesusBot.vy=10;
					}
					if(Fase.identidad1==4){
						Charla.getCharla().pacoConf();
						Charla.getCharla().setMensaje("El maestro estaba practicando karate con Adamuz, tendre que mandarle un mail a Juan");
					}
					if(Fase.identidad1==10){
						Charla.getCharla().pacoConf();
						Charla.getCharla().setMensaje("Adamuz es un ser supremo que nos salvara a todos... no tenemos ni que mandarle el mail...");
					}
					
					

					
				}
				
				if(contador1==300){

					if(Fase.identidad1==2){
						if(Fase.identidad2==3){
							Charla.getCharla().jesusConf();
							Charla.getCharla().setMensaje("Yo tambien voy a echarte un cable");
							JesusBot.vy=10;
						}
					}
					if(Fase.identidad1==3){
						if(Fase.identidad2==2){
							Charla.getCharla().pacoConf();
							Charla.getCharla().setMensaje("Bueno, me encanta la accion y no voy a dejarte disfrutar solo, ¡venid por mi cerdos!");
							PacoBot.vy=10;
						}
					}

				}
				
				
				
				if(contador1==350){
					Charla.getCharla().quitaMensaje();
					//soundCache.StopSongMp3();
					this.limpiaMemo();
					NuevoJuego.getNuevoJuego().playComponent((Component)NuevoJuego.getNuevoJuego().Mission1 (), 30);
					NuevoJuego.getNuevoJuego().playGame();
					}
				
				if(player.escape==true){
					Charla.getCharla().quitaMensaje();
					//soundCache.StopSongMp3();
					this.limpiaMemo();
					NuevoJuego.getNuevoJuego().playComponent((Component)NuevoJuego.getNuevoJuego().Mission1 (), 30);
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


		Charla.getCharla().paint(g);

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