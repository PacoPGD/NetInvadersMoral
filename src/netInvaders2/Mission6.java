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


public class Mission6 extends  Fase {
	static boolean bandera1=false;
	public Mission6() {
		super();
	}
	
	
	public void jugar() {

		int velocidad=30;
		usedTime=1000;
		//eventTime,nuevotime;
		t=0;
		idMission=6;
		int i;
		int contador1=-30;

		int contador2=0;
		bandera=2;
		int vidaMonster=1;
		int vidaMonster2=1;
		JefeFinal Ma= new MonsterSuperNet(this);
		JefeFinal Mb= new MonsterSuperNet(this);
		
		
		
		initWorld(); 
		soundCache.PlaySongMp3("musica/Wild Side.mp3",true);
		
		long nuevoTime = System.currentTimeMillis();
		long fichaTiempo = 0;
		while (!gameEnded) {
			t=t+velocidad;
			long startTime = System.currentTimeMillis();
			updateWorld();
			
			if(velocidad==30){
				if(player.vivo==1){
				player.score=player.score+20;
				}
				if(NuevoJuego.nJugadores == 2){
					if(player2.vivo==1){
						player2.score=player2.score+20;
					}
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
					 Charla.getCharla().setMensaje("Adelante, avanza rapidamente hasta encontrar a los cabecillas .net");
				      
				}
				

				
				
				if(contador1>=20 && contador1<=500 && contador1%2==0){
					for(i=0;i<3;i++){
				      Monster m = new Piedra(this);
				        m.setX((int)(Math.random()*790) ) ;
					    m.setY( 20 );
					    m.setVx(0);
					    m.setVy(10);
				      actors.add(m);
					}
				}
				
				if(contador1==400){
					for(i=0;i<NuevoJuego.nJugadores;i++){
				      PaqueteVida m = new PaqueteVida(this);
				        m.setX((int)(Math.random()*700) ) ;
					    m.setY( 20 );
					    m.setVx(  0);
					    m.setVy( 10);
				      actors.add(m);
					}
				}
					
				
				if(contador1==500){

					switch(Fase.identidad1){
					case 1:Charla.getCharla().defaultConf();
					break;
					case 2:Charla.getCharla().pacoConf();
					break;
					case 3:Charla.getCharla().jesusConf();
					break;
					case 4:Charla.getCharla().juanConf();
					break;
					case 5:Charla.getCharla().loboConf();
					break;
					case 6:Charla.getCharla().adamConf();
					break;
					case 7:Charla.getCharla().angelConf();
					break;
					case 8:Charla.getCharla().adamuzConf();
					break;
					
					}
					
					Charla.getCharla().setMensaje("Activando modo combate");
					velocidad=10;
					
					player.fuegoDisponible=1;
	
					if(NuevoJuego.nJugadores==2){
						player2.fuegoDisponible=1;
					}
				}
				


				if(contador1>=510 && contador1<=600 && contador1%10==0){
					for(i=0;i<3;i++){
						Monster m = new MonsterGeneric(this);
						if(contador1%50==0){
						m.setX(20) ;
						
						}
						else{
						m.setX(750);
						}
						m.setY(20+i*50);
						m.setVx(10);
						m.setVy(2);
						actors.add(m);
					}
				}
				
				if(contador1==535){
					Monster m = new MonsterGeneric2(this,0);
					m.setX(20);
					m.setY(70);
					m.setVx(8);
					m.setVy(4);
					actors.add(m);
				}
				
				
				
				if(contador1==700){

					soundCache.StopSongMp3();
					soundCache.PlaySongMp3("musica/Come Back Time.mp3",true);
					Charla.getCharla().NetConf();
					Charla.getCharla().setMensaje("Estais muertos malditos programadores java");
					Ma.setX( 200) ;
					Ma.setY( 0);
					Ma.setVx( 5 );
					Ma.setVy( 0);
					actors.add(Ma); 
				}
				
				if(contador1>700){
					vidaMonster=Ma.Monsterv();
				}
				
				if(contador1==800){	
					Charla.getCharla().Net2Conf();
					Charla.getCharla().setMensaje("Tranquilo, te ayudaré a destruirlos");
					Mb.setX( 200) ;
					Mb.setY( 60);
					Mb.setVx( 7 );
					Mb.setVy( 0);
					actors.add(Mb); 
				}
				
				if(contador1>800){
					vidaMonster2=Mb.Monsterv();
				}
				
				
				
				calcvida();
				
				
				if(vidaMonster==0 && vidaMonster2==0 && contador2==0){
					contador2=1;

					if(bandera==1){
						Charla.getCharla().pdamonConf();
						Charla.getCharla().setMensaje("Perfecto, has realizado toda la mision con exito, felicidades");
					}



					Actor m = new MissionFinal(this);
					m.setX(-600 ) ;
					m.setY( 200 );
					actors.add(m);

					//PONER CONDICION PARA ABRIR CADA FASE
					/*
					if(bandera==1){
						Perfiles.getPerfil(Opciones.perfilJ1).fasesDisponibles[player.numero-1][7-1]=true;
						
						if(NuevoJuego.nJugadores==2){
						Perfiles.getPerfil(Opciones.perfilJ2).fasesDisponibles[player2.numero-1][7-1]=true;
						}
					}
					
					
					if(bandera==2){
						Perfiles.getPerfil(Opciones.perfilJ1).fasesDisponibles[player.numero-1][8-1]=true;
						
						if(NuevoJuego.nJugadores==2){
						Perfiles.getPerfil(Opciones.perfilJ2).fasesDisponibles[player2.numero-1][8-1]=true;
						}
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
					if(bandera==1){
						NuevoJuego.getNuevoJuego().playComponent((Component)NuevoJuego.getNuevoJuego().Secuencia7 (), 30);
						NuevoJuego.getNuevoJuego().playGame();
					}
					if(bandera==2){
						NuevoJuego.getNuevoJuego().playComponent((Component)NuevoJuego.getNuevoJuego().Secuencia8 (), 30);
						NuevoJuego.getNuevoJuego().playGame();
					}
				}
				
				
				
				
				
				
				
				
				
				
					
				
				
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
			 NuevoJuego.getNuevoJuego().playComponent((Component)NuevoJuego.getNuevoJuego().Secuencia7 (), 30);//o la 8 ponlo
		      NuevoJuego.getNuevoJuego().playGame();
		}
		if(bandera==2){
			 NuevoJuego.getNuevoJuego().playComponent((Component)NuevoJuego.getNuevoJuego().Secuencia8 (), 30);//o la 8 ponlo
		      NuevoJuego.getNuevoJuego().playGame();
		}
		
	}

	
	
	
	public void paintWorld() {
		Graphics2D g = (Graphics2D)strategy.getDrawGraphics();
		ocean = spriteCache.getSprite("fondos/desert.gif");
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
