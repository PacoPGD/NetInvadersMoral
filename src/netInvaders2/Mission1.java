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

import twitter4j.TwitterException;

import netInvaders2.Opciones.*;




public class Mission1 extends  Fase {


	public Mission1() {
		super();
	}


	public void jugar() {
		usedTime=1000;
		//eventTime,nuevotime;
		t=0;
		idMission=1;
		int i;
		int contador1=-50;  
		//int contador1=890;
		int contador2=0;
		int vidaMonster=1;
		JefeFinal M= new MonsterBarco(this);


		initWorld(); 



		long nuevoTime = System.currentTimeMillis();
		long fichaTiempo = 0;
		soundCache.PlaySongMp3("musica/Across the Blue Skys.mp3",true);
		
		while (isVisible() && !gameEnded) {
			t=t+10;
			long startTime = System.currentTimeMillis();
			updateWorld();
			checkCollisions();
			paintWorld();
			

			eventTime = System.currentTimeMillis()-nuevoTime;

			if(fichaTiempo < (int)(eventTime/100)){
				contador1++;
				//NuevoJuego.getNuevoJuego().vibra(10,10,10);
				
				if(contador1==-29){

					Charla.getCharla().pdamonConf();
					Charla.getCharla().setMensaje("Destruye la oleada de programadores .net sin piedad, no les podemos permitir adueñarse de la tierra");
				}



				if(contador1==-15){
					Actor m = new Start(this);
					m.setX(150 ) ;
					m.setY( 200+ (int)(Math.random()*20) );
					actors.add(m);
					player.fuegoDisponible=1;
					player.choqueDisponible=1;
					if(NuevoJuego.nJugadores==2){
						player2.fuegoDisponible=1;
						player2.choqueDisponible=1;

					}

				}




				if(contador1>=10 && contador1<=250 && contador1%25==0){
					//Charla.getCharla().quitaMensaje();
					Monster m = new MonsterTiradorPreciso(this);
					m.setX(20+50 ) ;
					m.setY( 20+ (int)(Math.random()*20) );
					m.setVx( 10 );
					m.setVy( 10);
					actors.add(m);
				}

				if(contador1>=10 && contador1<=250 && contador1%12==0){
					Monster m = new MonsterGeneric(this);
					m.setX(20+50 ) ;
					m.setY( 20+ (int)(Math.random()*20) );
					m.setVx( 8 );
					m.setVy( 2);
					actors.add(m);
				}


				if(contador1>=10 && contador1<=250 && contador1%15==0){
					Monster m = new MonsterBanzai(this);
					m.setX(200) ;
					m.setY( 20+ (int)(Math.random()*20) );
					m.setVx( 10 );
					m.setVy( 10);
					actors.add(m);
				}



				if(contador1==300){
					if(Fase.identidad1==1){
						Charla.getCharla().defaultConf();
						Charla.getCharla().setMensaje("La programacion .net no tiene ningun futuro, acabo de destruirlos... facilmente");
					}

					if(Fase.identidad1==2){
						Charla.getCharla().pacoConf();
						Charla.getCharla().setMensaje("Estupidos programadores .net ¿se piensan que pueden pararme con eso?");
					}
					if(Fase.identidad1==4){
						Charla.getCharla().juanConf();
						Charla.getCharla().setMensaje("...");
					}
				}



				if(contador1>=350 && contador1<=450 && contador1%25==0){
					for(i=0;i<10;i++){
						Monster m = new MonsterGeneric(this);
						m.setX(200+(int)(Math.random()*200)+i*4 ) ;
						m.setY( 20+ (int)(Math.random()*20) );
						if(i%2==0){
							m.setVx( i);
						}
						else{
							m.setVx(-i);
						}
						m.setVy( 5);
						actors.add(m);
					}

				}


				if(contador1==500){
					if(Fase.identidad1==1){
						Charla.getCharla().defaultConf();
						Charla.getCharla().setMensaje("Tengo que acabar con este problema de raiz, a ver donde esta su jefe...");
					}

					if(Fase.identidad1==2){
						Charla.getCharla().pacoConf();
						Charla.getCharla().setMensaje("YEAH ¡esto si que es hardcore!");
					}
					if(Fase.identidad1==4){
						Charla.getCharla().juanConf();
						Charla.getCharla().setMensaje("...");
					}
				}

				if(contador1>=550 && contador1<=650 && contador1%25==0){
					Monster m = new MonsterBanzai(this);
					m.setX((int)(Math.random()*800)) ;
					m.setY( 20+ (int)(Math.random()*20) );
					m.setVx( 15 );
					m.setVy( 15);
					actors.add(m);
				}


				if(contador1==750){
					soundCache.StopSongMp3();
					soundCache.PlaySongMp3("musica/Come Back Time.mp3",true);
					Charla.getCharla().salvaConf();
					Charla.getCharla().setMensaje("Soy Salva y soy DJ y voy a demostrar mi navegador de abordo, te voy a pegar una paliza con mi barco volador");	
				}

				if(contador1==800){
					if(Fase.identidad1==2){
						Charla.getCharla().pacoConf();
						Charla.getCharla().setMensaje("¿Eres el fantasma de salvador? si ahora eres .net mereces ser exterminado por mi nave java");
					}
					if(Fase.identidad1==3){
						Charla.getCharla().jesusConf();
						Charla.getCharla().setMensaje("¿Como va tu pierna?");
					}
				}

				if(contador1==850){
					Charla.getCharla().salvaConf();
					Charla.getCharla().setMensaje("te voy a destruir gracias a mis neuroimplantes, que ahora son .net");	
				}


				if(contador1==900){

					M.setX( 20) ;
					M.setY( -200 );
					M.setVx( 5 );
					M.setVy( 2);
					actors.add(M);      
				}

				if(contador1>900){
					vidaMonster=M.Monsterv();
				}
				
				
				if(contador1==950){
					MonsterBarco.vy=0;
				}

				//System.out.println("primero:"+primeroVivo);
				//System.out.println("segundo:"+segundoVivo);

				calcvida();

				
				

				if(vidaMonster==0 && contador2==0){
					contador2=1;
					//if(bandera==0){
						
					//}
					if(bandera==1){
						Charla.getCharla().salvaConf();
						Charla.getCharla().setMensaje("GRRRRRAAAAAAAAAARRRRR VOLVEREEEEEEEEEEEEE");
					}



					Actor m = new MissionFinal(this);
					m.setX(-600 ) ;
					m.setY( 200 );
					actors.add(m);

				
					calcpuntos();
					/*
					Perfiles.getPerfil(Opciones.perfilJ1).fasesDisponibles[player.numero-1][2-1]=true;
					
					if(NuevoJuego.nJugadores==2){
					Perfiles.getPerfil(Opciones.perfilJ2).fasesDisponibles[player2.numero-1][2-1]=true;
					}
					*/
					
					
					
				}		


				
				if(contador2>=1){
					contador2++;
				}
				
				
				if(contador2==100){
				Charla.getCharla().quitaMensaje();
				this.limpiaMemo();
				this.getSpriteCache().limpiarCache();
				NuevoJuego.getNuevoJuego().playComponent((Component)NuevoJuego.getNuevoJuego().Secuencia2(), 30);
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
		ocean = spriteCache.getSprite("fondos/cielo.gif");
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
