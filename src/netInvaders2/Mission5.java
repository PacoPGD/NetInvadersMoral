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


public class Mission5 extends  Fase {


	public Mission5() {
		super();
	}


	public void jugar() {
		usedTime=1000;
		//eventTime,nuevotime;
		t=0;
		idMission=5;
		int i;
		int contador1=-30;  
		int contador2=0;
		int vidaMonster=1;
		JefeFinal M= new MonsterAdamuzOscuro(this);


		initWorld(); 
		soundCache.PlaySongMp3("musica/Ghost Time.mp3",true);

		long nuevoTime = System.currentTimeMillis();
		long fichaTiempo = 0;



		while (isVisible() && !gameEnded) {
			t=t+20;
			long startTime = System.currentTimeMillis();
			updateWorld();
			checkCollisions();
			paintWorld();
			

			eventTime = System.currentTimeMillis()-nuevoTime;

			if(fichaTiempo < (int)(eventTime/100)){
				contador1++;

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

				if(contador1==0){
					if(identidad1==2 || identidad2==2){
					Charla.getCharla().pacoConf();
					Charla.getCharla().setMensaje("Eres ¿adamuz?");
					}
				}
				
				if(contador1==15){
					if(identidad1==2 || identidad2==2){
						Charla.getCharla().adamuzOscuroConf();
						Charla.getCharla().setMensaje("YO SOY ADAMUZ OSCURO");
						}
				}
				
				if(contador1==30){
					if(identidad1==3 || identidad2==3){
					Charla.getCharla().jesusConf();
					Charla.getCharla().setMensaje("Nooooooooooooooo");
					}
				}
				
				
				if(contador1==45){
						Charla.getCharla().adamuzOscuroConf();
						Charla.getCharla().setMensaje("Preparate para sentir el mas extremo y alegre dolor, causado por mi parte");	
				}
				
				
				if(contador1>=50 && contador1<=300){
					if(contador1%25==0){
						MonsterNinja m = new MonsterNinja(this);
						m.setX((int)(Math.random()*700));
						m.setY((int)(Math.random()*300));
						m.setVx(5);
						m.setVy(5);
						actors.add(m);
					}
					      Monster a = new Piedra(this);
					        a.setX((int)(Math.random()*700) ) ;
						    a.setY( 20 );
						    a.setVx(  0);
						    a.setVy( 10);
					      actors.add(a);
					
				}
				
				if(contador1== 305){
				      Monster a = new MonsterDefender(this);
				        a.setX((int)(Math.random()*700) ) ;
					    a.setY( 20 );
					    a.setVx(  0);
					    a.setVy( 10);
				      actors.add(a);
				}
				if(contador1== 307){
				      Monster a = new MonsterDefender(this);
				        a.setX((int)(Math.random()*700) ) ;
					    a.setY( 20 );
					    a.setVx(  0);
					    a.setVy( 10);
				      actors.add(a);
				}
				if(contador1== 309){
				      Monster a = new MonsterDefender(this);
				        a.setX((int)(Math.random()*700) ) ;
					    a.setY( 20 );
					    a.setVx(  0);
					    a.setVy( 10);
				      actors.add(a);
				}
				if(contador1== 311){
				      Monster a =new MonsterDefender(this);
				        a.setX((int)(Math.random()*700) ) ;
					    a.setY( 20 );
					    a.setVx(  0);
					    a.setVy( 10);
				      actors.add(a);
				}
				if(contador1== 313){
				      Monster a = new MonsterDefender(this);
				        a.setX((int)(Math.random()*700) ) ;
					    a.setY( 20 );
					    a.setVx(  0);
					    a.setVy( 10);
				      actors.add(a);
				}
				if(contador1== 315){
				      Monster a = new MonsterDefender(this);
				        a.setX((int)(Math.random()*700) ) ;
					    a.setY( 20 );
					    a.setVx(  0);
					    a.setVy( 10);
				      actors.add(a);
				}
				if(contador1== 317){
				      Monster a = new MonsterDefender(this);
				        a.setX((int)(Math.random()*700) ) ;
					    a.setY( 20 );
					    a.setVx(  0);
					    a.setVy( 10);
				      actors.add(a);
				}
				if(contador1== 319){
				      Monster a = new MonsterDefender(this);
				        a.setX((int)(Math.random()*700) ) ;
					    a.setY( 20 );
					    a.setVx(  0);
					    a.setVy( 10);
				      actors.add(a);
				}
				if(contador1== 321){
				      Monster a = new MonsterDefender(this);
				        a.setX((int)(Math.random()*700) ) ;
					    a.setY( 20 );
					    a.setVx(  0);
					    a.setVy( 10);
				      actors.add(a);
				}
				if(contador1== 323){
				      Monster a = new MonsterDefender(this);
				        a.setX((int)(Math.random()*700) ) ;
					    a.setY( 20 );
					    a.setVx(  0);
					    a.setVy( 10);
				      actors.add(a);
				}
				if(contador1== 325){
				      Monster a = new MonsterDefender(this);
				        a.setX((int)(Math.random()*700) ) ;
					    a.setY( 20 );
					    a.setVx(  0);
					    a.setVy( 10);
				      actors.add(a);
				}
				
				if(contador1>= 350 && contador1<=360){
				      Monster a = new MonsterNinja(this);
				        a.setX((int)(Math.random()*700) ) ;
					    a.setY( 20 );
					    a.setVx(5);
					    a.setVy(5);
				      actors.add(a);
				}
				
				if(contador1>= 360 && contador1<=370){
				      Monster a = new MonsterGeneric(this);
				        a.setX((int)(Math.random()*700) ) ;
					    a.setY( 20 );
					    a.setVx(5);
					    a.setVy(5);
				      actors.add(a);
				}
				
				if(contador1>= 370 && contador1<=380){
					if(contador1%4==0){
					Monster a = new MonsterLateral(this,true);
					a.setY( 20+ (int)(Math.random()*20) );
					a.setVy( 4);
					actors.add(a);
					}
					if(contador1%4==1){
					Monster b = new MonsterLateral(this,false);	
					b.setY( 20+ (int)(Math.random()*20) );
					b.setVy( 3);
					actors.add(b);
					}
				}
				
				if(contador1>=380 && contador1<=385){
				      Monster a = new MonsterNinja(this);
				        a.setX((int)(Math.random()*700) ) ;
					    a.setY( 20 );
					    a.setVx(5);
					    a.setVy(5);
				      actors.add(a);
				}
				
				if (contador1==400){
					Charla.getCharla().adamuzOscuroConf();
					Charla.getCharla().setMensaje("Malditos programadores java, morid ante mi poder de teleco");
				}
				if (contador1==450){
					Charla.getCharla().pdamonConf();
					Charla.getCharla().setMensaje("¿Que? no es posible...");
				}
				
				if (contador1==450){
				      Monster a = new MonsterNinja(this);
				        a.setX((int)(Math.random()*700) ) ;
					    a.setY( 20 );
					    a.setVx(7);
					    a.setVy(7);
				      actors.add(a);
				}
				
				if (contador1>=452 && contador1 <=460){
				      Monster a = new MonsterBanzai(this);
				        a.setX((int)(Math.random()*700) ) ;
					    a.setY( 20 );
					    a.setVx(3);
					    a.setVy(3);
				      actors.add(a);
				}
				
				if (contador1>=470 && contador1 <=480){
				      Monster a = new MonsterDefender(this);
				        a.setX((int)(Math.random()*700) ) ;
					    a.setY( 20 );
					    a.setVx(3);
					    a.setVy(3);
				      actors.add(a);
				}
				
				if (contador1>=470 && contador1 <=480){
				      Monster a = new MonsterEstrellar(this);
				        a.setX((int)(Math.random()*700) ) ;
					    a.setY( 10 );
					    a.setVx(3);
					    a.setVy(3);
				      actors.add(a);
				}
				if (contador1>=480 && contador1 <=490){
				      Monster a = new MonsterNinja(this);
				        a.setX((int)(Math.random()*700) ) ;
					    a.setY( 10 );
					    a.setVx(3);
					    a.setVy(3);
				      actors.add(a);
				}
				
				if (contador1>=500 && contador1 <=505){
				      Monster a = new MonsterTiradorPreciso(this);
				        a.setX((int)(Math.random()*700) ) ;
					    a.setY( 10 );
					    a.setVx(3);
					    a.setVy(3);
				      actors.add(a);
				}
				
				if (contador1==510){
				      Monster a = new MonsterTiradorPreciso(this);
				        a.setX((int)(Math.random()*700) ) ;
					    a.setY( 800 );
					    a.setVx(3);
					    a.setVy(3);
				      actors.add(a);
				}
				
				if(NuevoJuego.nJugadores==2){
					if (contador1==510){
					      Monster a = new MonsterTiradorPreciso(this);
					        a.setX((int)(Math.random()*700) ) ;
						    a.setY( 800 );
						    a.setVx(3);
						    a.setVy(3);
					      actors.add(a);
					}
				}
				
			
				if (contador1>=520 && contador1 <=530){
				      Monster a = new MonsterDefender(this);
				        a.setX((int)(Math.random()*700) ) ;
					    a.setY( 20 );
					    a.setVx(3);
					    a.setVy(3);
				      actors.add(a);
				}
				
				if (contador1>=540 && contador1 <=550){
				      Monster a = new MonsterEstrellar(this);
				        a.setX((int)(Math.random()*700) ) ;
					    a.setY( 10 );
					    a.setVx(3);
					    a.setVy(3);
				      actors.add(a);
				}
				if (contador1>=560 && contador1 <=570){
				      Monster a = new MonsterNinja(this);
				        a.setX((int)(Math.random()*700) ) ;
					    a.setY( 10 );
					    a.setVx(3);
					    a.setVy(3);
				      actors.add(a);
				}
				
				if (contador1>=580 && contador1 <=590){
				      Monster a = new MonsterTiradorPreciso(this);
				        a.setX((int)(Math.random()*700) ) ;
					    a.setY( 10 );
					    a.setVx(3);
					    a.setVy(3);
				      actors.add(a);
				}	
				
				
				if(contador1==750){
					for(i=0;i<20;i++){
					PaqueteVida m = new PaqueteVida(this);
					m.setX(100);
					m.setY(20);
					m.setVx(i);
					m.setVy(i);
					actors.add(m);
					}
				}
				
				
				if(contador1==800){

					soundCache.StopSongMp3();
					soundCache.PlaySongMp3("musica/El Angel Caido.mp3",true);
					
					M.setX( 200) ;
					M.setY( 0);
					M.setVx( 0 );
					M.setVy( 0);
					actors.add(M); 
				}
				
				if(contador1>800){
					vidaMonster=M.Monsterv();
				}


				
				calcvida();

				if(vidaMonster==0 && contador2==0){
					contador2=1;
					//if(bandera==0){
						
					//}
					if(bandera==1){
						Charla.getCharla().pdamonConf();
						Charla.getCharla().setMensaje("Perfecto, has realizado toda la mision con exito, felicidades");
					}



					Actor m = new MissionFinal(this);
					m.setX(-600 ) ;
					m.setY( 200 );
					actors.add(m);
					
				


					calcpuntos();

				}		


				
				if(contador2>=1){
					contador2++;
				}
				
	
				if(contador2==100){
				Charla.getCharla().quitaMensaje();
				soundCache.StopSongMp3();
				this.limpiaMemo();
				NuevoJuego.getNuevoJuego().playComponent((Component)NuevoJuego.getNuevoJuego().SecuenciaFinalA (), 30);
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
		ocean = spriteCache.getSprite("fondos/rara.gif");
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

}