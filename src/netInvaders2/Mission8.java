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


public class Mission8 extends  Fase {


	public Mission8() {
		super();
	}


	public void jugar() {
		usedTime=1000;
		//eventTime,nuevotime;
		t=0;
		idMission=8;
		int i;
		//int contador1=-30;  
		int contador1=2980;  
		int banderaenemigo=1;
		int contador2=0;
		int vidaMonster=1;
		JefeFinal M= new MonsterJefazo(this);


		initWorld(); 
		soundCache.PlaySongMp3("musica/Dios del trueno.mp3",true);

		long nuevoTime = System.currentTimeMillis();
		long fichaTiempo = 0;

		player.fuegoDisponible=1;

		while (isVisible() && !gameEnded) {
			
			t=t+20;
			long startTime = System.currentTimeMillis();
			updateWorld();
			checkCollisions();
			if(contador1<100000){
			paintWorld();
			}
			else{
				paintWorld2();
			}
			
			
			usedTime = System.currentTimeMillis()-startTime;

			eventTime = System.currentTimeMillis()-nuevoTime;

			if(fichaTiempo < (int)(eventTime/100)){
				contador1++;

				if(contador1==-29){

					Charla.getCharla().defaultConf();
					Charla.getCharla().setMensaje("Esta es la ultima mision, ahora o nunca");
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

				if(banderaenemigo==1 && contador1%20==0 && contador1<=3000){
					Monster m = new MonsterGeneric2(this);
					m.setX(400 ) ;
					m.setY( 20+ (int)(Math.random()*20) );
					m.setVx( 5 );
					m.setVy( 2);
					actors.add(m);
					
					Monster a = new MonsterGeneric2(this);
					a.setX(400 ) ;
					a.setY( 20+ (int)(Math.random()*20) );
					a.setVx( -5 );
					a.setVy( 2);
					actors.add(a);
				}

	
				
				if(Fase.identidad1!=1 && Fase.identidad2!=1){
					if(contador1==30){
						Bot.fuegoDisponible=1;
						Bot m = new RafaBot(this);
						m.setX(200);
						m.setY(600);
						m.setVx(0);
						m.setVy(-2);
						actors.add(m);
					}
					
					
					if(contador1==70){
							RafaBot.vy=0;	
					}	
				
				}
				
				if(Fase.identidad1!=2 && Fase.identidad2!=2){
					if(contador1==50){
						Bot m = new PacoBot(this);
						m.setX(400);
						m.setY(600);
						m.setVx(0);
						m.setVy(-2);
						actors.add(m);
					}
					
					
					if(contador1==90){
							PacoBot.vy=0;	
					}	
				}
				
				if(Fase.identidad1!=3 && Fase.identidad2!=3){
					if(contador1==70){
						Bot m = new JesusBot(this);
						m.setX(600);
						m.setY(600);
						m.setVx(0);
						m.setVy(-2);
						actors.add(m);
					}
					
					
					if(contador1==110){
							JesusBot.vy=0;		
					}
				}
				
				if(contador1==110){
					Charla.getCharla().defaultConf();
					Charla.getCharla().setMensaje("Primera linea de combate lista");
				}
				
				
				if(contador1==150){
						Charla.getCharla().defaultConf();
						Charla.getCharla().setMensaje("Preparaos la segunda linea de combate");	
				}
				
				
				if(Fase.identidad1!=4 && Fase.identidad2!=4){
					if(contador1==130){
						Bot m = new JuanBot(this);
						m.setX(220);
						m.setY(600);
						m.setVx(0);
						m.setVy(-3);
						actors.add(m);
					}
					
					
					if(contador1==170){
							JuanBot.vy=0;	
					}	
				}
				
				
				if(Fase.identidad1!=4 && Fase.identidad2!=4){
					if(contador1==150){
						Bot m = new LobogrisBot(this);
						m.setX(388);
						m.setY(600);
						m.setVx(0);
						m.setVy(-3);
						actors.add(m);
					}
					
					
					if(contador1==190){
							LobogrisBot.vy=0;	
					}	
				}
				
				
				if(Fase.identidad1!=5 && Fase.identidad2!=5){
					if(contador1==170){
						Bot m = new AdamBot(this);
						m.setX(622);
						m.setY(600);
						m.setVx(0);
						m.setVy(-3);
						actors.add(m);
					}
					
					if(contador1==210){
						AdamBot.vy=0;	
					}	
				}
				
				if(Fase.identidad1!=6 && Fase.identidad2!=6){
					if(contador1==170){
						Bot m = new AngelBot(this);
						m.setX(100);
						m.setY(600);
						m.setVx(0);
						m.setVy(-4);
						actors.add(m);
					}
					if(contador1==180){
						AngelBot.vy=2;
					}
					if(contador1==190){
						AngelBot.vy=-4;
					}
					if(contador1==195){
						AngelBot.vy=2;
					}
					if(contador1==205){
						AngelBot.vy=-8;
					}
					if(contador1==210){
						AngelBot.vy=0;	
					}	
				}
				
				
				if(contador1==210){
					RafaBot.vx=8;
					PacoBot.vx=-10;
					JesusBot.vx=12;
					JuanBot.vx=-8;
					LobogrisBot.vx=10;
					AdamBot.vx=-8;
					AngelBot.vx=18;
				}
				
				
				if(contador1==250){
					JefeFinal l= new MonsterBarco(this);
					l.setX( 20) ;
					l.setY( -200 );
					l.setVx( 5 );
					l.setVy( 2);
					actors.add(l);  
					
					Charla.getCharla().salvaConf();
					Charla.getCharla().setMensaje("Malditos, os pararé con mi barco DJ");	
				}
				
				if(contador1==280){
					MonsterBarco.vy=0;
				}
				
				if(contador1==500){
					JefeFinal l= new MonsterPortaBicis(this);
					l.setX( 0) ;
					l.setY( 0 );
					l.setVx( 0 );
					l.setVy(0);
					actors.add(l);  
					
					Charla.getCharla().joaquinConf();
					Charla.getCharla().setMensaje("Te ayudaré salvador, eras mal alumno, pero buen .net");	
				}
				
				if(contador1==1200){
					JefeFinal l= new MonsterFinal(this);
					l.setX( 0) ;
					l.setY( 0 );
					l.setVx( 5 );
					l.setVy(0);
					actors.add(l);  
					
					Charla.getCharla().GordaConf();
					Charla.getCharla().setMensaje("Malditos programadores, estais muertos jajaja");	
				}

				
				if(contador1==2000){
					for(i=0;i<2;i++){
						JefeFinal l= new MonsterSuperNet(this);
						l.setX( 0) ;
						l.setY(i*60 );
						l.setVx(2+i);
						l.setVy(0);
						actors.add(l);  
						Charla.getCharla().Net2Conf();
						Charla.getCharla().setMensaje("¿A que no esperabas esto?");	
					}
				}
				
				if(contador1==2950){
				for(i=0;i<20;i++){
					PaqueteVida m = new PaqueteVida(this);
					
					m.setY( 20+ (int)(Math.random()*20) );
					m.setX(i*20);
					m.setVx(5);
					m.setVy( 2);
					actors.add(m);
					}
				}
				

				
				
				if(contador1==3000){
					banderaenemigo=0;
					soundCache.StopSongMp3();
					soundCache.PlaySongMp3("musica/Elissa Final Cut.mp3",true);
					M.setX(50);
					M.setY(-20);
					actors.add(M);

				}
				if(contador1>3000){
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
				NuevoJuego.getNuevoJuego().playComponent((Component)NuevoJuego.getNuevoJuego().SecuenciaFinalC (), 30);
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
		ocean = spriteCache.getSprite("fondos/metal1.gif");
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
	
	
	public void paintWorld2() {
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


}