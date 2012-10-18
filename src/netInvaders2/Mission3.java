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

import netInvaders2.Opciones.Opciones;
import netInvaders2.Opciones.Perfiles;


public class Mission3 extends  Fase {

	public Mission3() {
		super();
	}
	
	
	public void jugar() {
		usedTime=1000;
		//eventTime,nuevotime;
		t=0;
		idMission=3;
		int i;
		int contador1=-30;

		int contador2=0;
		initWorld(); 
		soundCache.PlaySongMp3("musica/Wild Side.mp3",true);
		
		long nuevoTime = System.currentTimeMillis();
		long fichaTiempo = 0;
		while (!gameEnded) {
			t=t+30;
			long startTime = System.currentTimeMillis();
			updateWorld();
			
			if(player.vivo==1){
			player.score=player.score+20;
			}
			if(NuevoJuego.nJugadores == 2){
				if(player2.vivo==1){
					player2.score=player2.score+20;
				}
			}
			
			checkCollisions();
			paintWorld();
			
			eventTime = System.currentTimeMillis()-nuevoTime;
			
			if(fichaTiempo < (int)(eventTime/100)){
				contador1++;
				
				if(contador1==-29){
				player.fuegoDisponible=0;
				player.choqueDisponible=1;
				if(NuevoJuego.nJugadores==2){
					player2.fuegoDisponible=0;
					player2.choqueDisponible=1;

				}
				}

				if(contador1==-29){
					Actor m = new Start(this);
			        m.setX(150 ) ;
				    m.setY( 200+ (int)(Math.random()*20) );
			      actors.add(m);
			      
					 Charla.getCharla().pdamonConf();
					 Charla.getCharla().setMensaje("Supera la fase a toda velocidad sin resultar herido");
				      
				}
				
				if(contador1==20){
				      Monster m = new MonsterTiradorPreciso2(this,true);
				        m.setX(0) ;
					    m.setY(700);
					    m.setVx(5);
					    m.setVy(5);
				      actors.add(m);
					
					if(NuevoJuego.nJugadores==2){
					      Monster c = new MonsterTiradorPreciso2(this,false);
					        c.setX(0) ;
						    c.setY(700);
						    c.setVx(5);
						    c.setVy(5);
					      actors.add(c);
					}
				}
				
				
				if(contador1>=20 && contador1<=50 ){
					for(i=0;i<2;i++){
				      Monster a = new Piedra(this);
				        a.setX(20 + i*700 ) ;
					    a.setY( 0 );
					    a.setVx(  0);
					    a.setVy( 10);
				      actors.add(a);
					}
				}
				
				if(contador1>=50 && contador1<=100 ){
					for(i=0;i<2;i++){
				      Monster m = new Piedra(this);
				        m.setX(120 + i*500 ) ;
					    m.setY( 0 );
					    m.setVx(  0);
					    m.setVy( 10);
				      actors.add(m);
					}
				}
				if(contador1>=100 && contador1<=200 ){
					for(i=0;i<2;i++){
				      Monster m = new Piedra(this);
				        m.setX(220 + i*300 ) ;
					    m.setY( 0 );
					    m.setVx(  0);
					    m.setVy( 10);
				      actors.add(m);
					}
				}
				if(contador1>=200 && contador1<=300 ){
					for(i=0;i<2;i++){
				      Monster m = new Piedra(this);
				        m.setX(320 + i*100 ) ;
					    m.setY( 0 );
					    m.setVx(  0);
					    m.setVy( 10);
				      actors.add(m);
					}
				}
				if(contador1==301  ){
					for(i=0;i<1;i++){
				      Monster m = new Piedra(this);
				        m.setX(420 + i*100 ) ;
					    m.setY( 0 );
					    m.setVx(  0);
					    m.setVy( 10);
				      actors.add(m);
					}
				}
				if(contador1>=302 && contador1<=1000 ){
					for(i=0;i<1;i++){
				      Monster m = new Piedra(this);
				        m.setX((int)(Math.random()*790) ) ;
					    m.setY( 0 );
					    m.setVx(  0);
					    m.setVy( 10);
				      actors.add(m);
					}
				}
				
				if(contador1==500 || contador1==700 || contador1==900){
					for(i=0;i<NuevoJuego.nJugadores;i++){
				      PaqueteVida m = new PaqueteVida(this);
				        m.setX((int)(Math.random()*790) ) ;
					    m.setY( 0 );
					    m.setVx(  0);
					    m.setVy( 10);
				      actors.add(m);
					}
				}
					
				

				
				if(contador1==1050 && contador2==0){
					contador2=1;

					if(bandera==1){
						Charla.getCharla().pdamonConf();
						Charla.getCharla().setMensaje("Perfecto, has realizado toda la mision con exito, felicidades");
						player.score=player.score+(VidaUno*100);
						//if(Perfiles.getPerfil(Opciones.perfilJ1).getScore(player.numero-1,idMission-1) < player.score){
							//Perfiles.getPerfil(Opciones.perfilJ1).actualizarScore(player.numero-1,idMission-1 , player.score);
							//}
						
						
						if(NuevoJuego.nJugadores==2){
							player2.score=player2.score+(VidaDos*100);
							//if(Perfiles.getPerfil(Opciones.perfilJ2).getScore(player2.numero-1,idMission-1) < player2.score){
							//Perfiles.getPerfil(Opciones.perfilJ2).actualizarScore(player2.numero-1,idMission-1 , player2.score);
							//}
							

						}
						
					}



					Actor m = new MissionFinal(this);
					m.setX(-600 ) ;
					m.setY( 200 );
					actors.add(m);
					
					mensajesTwitter(1);
					
					/*
					Perfiles.getPerfil(Opciones.perfilJ1).fasesDisponibles[player.numero-1][4-1]=true;
					
					if(NuevoJuego.nJugadores==2){
					Perfiles.getPerfil(Opciones.perfilJ2).fasesDisponibles[player2.numero-1][4-1]=true;
					}
					*/
				}	
				
				
				if(contador2>=1){
					contador2++;
				}
				
				
				if(contador2==100){
				Charla.getCharla().quitaMensaje();
				soundCache.StopSongMp3();
				this.limpiaMemo();
				NuevoJuego.getNuevoJuego().playComponent((Component)NuevoJuego.getNuevoJuego().Secuencia4 (), 30);
				NuevoJuego.getNuevoJuego().playGame();
				}
				
				
				
				
				calcvida();
					
				
				
			}
			fichaTiempo = eventTime / 100;
			usedTime = System.currentTimeMillis()-startTime;
			do {
				Thread.yield();
			} while (System.currentTimeMillis()-startTime< 17);		}
		
		
		if(bandera==0){
			paintGameOver();
		}
		if(bandera==1){
			 NuevoJuego.getNuevoJuego().playComponent((Component)NuevoJuego.getNuevoJuego().Secuencia4 (), 30);
		      NuevoJuego.getNuevoJuego().playGame();
		}
		
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


		if(NuevoJuego.nJugadores==2){
			if(segundoVivo==1){
				player2.paint(g);
			}
		}
		
		if(primeroVivo==1){
			player.paint(g);
		}

		paintStatus(g);
		Charla.getCharla().paint(g);
		
		g.setColor(Color.white);
		strategy.show();
	}

}
