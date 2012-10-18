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


public class Mission7 extends  Fase {


	public Mission7() {
		super();
	}


	public void jugar() {
		usedTime=1000;
		//eventTime,nuevotime;
		t=0;
		idMission=7;
		int i;
		int contador1=-30;  
		//int contador1=3445;
		int contador2=0;
		int vidaMonster=1;
		JefeFinal M= new MonsterMoralInyector(this);


		initWorld(); 
		soundCache.PlaySongMp3("musica/Al otro lado.mp3",true);

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

				if(contador1==-29){

					Charla.getCharla().pdamonConf();
					Charla.getCharla().setMensaje("La base .net, acabemos de una vez por todas con estos programadores");
				}

				if(contador1==0){
					Charla.getCharla().defaultConf();
					Charla.getCharla().setMensaje("Con este golpe la victoria está asegurada");
				}

				if(contador1==50){
					Charla.getCharla().adamConf();
					Charla.getCharla().setMensaje("El terror recorre mi mis venas");
				}
				
				if(contador1==100){
					Charla.getCharla().juanConf();
					Charla.getCharla().setMensaje("Hagamos esto rapido... tengo los pelos de punta");
				}
				
				if(contador1==150){
					Charla.getCharla().angelConf();
					Charla.getCharla().setMensaje("Rapido es mi segundo nombre... vamos a por ellos");
				}
				
				if(contador1==200){
					Charla.getCharla().pacoConf();
					Charla.getCharla().setMensaje("Ya sabeis lo planeado... atacamos desde diferentes puntos y al final derrotamos al moral inyector");
				}
				
				if(contador1==240){
					Charla.getCharla().jesusConf();
					Charla.getCharla().setMensaje("¿Como sabemos de su existencia si no hemos hablado de ello?");
				}
				
				if(contador1==280){
					Charla.getCharla().pacoConf();
					Charla.getCharla().setMensaje("Porque eso es lo que pasa en los juegos de bajo presupuesto");
				}
				
				if(contador1==300){
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

				if(contador1==320){
					Charla.getCharla().TelecoConf();
					Charla.getCharla().setMensaje("Comenzad el ataque, no dejeis programadores java vivos");
				}
				
				if(contador1>=320 && contador1<=400 && contador1%5==0){
					Monster m = new MonsterGeneric(this);
					m.setX(400 ) ;
					m.setY( 20+ (int)(Math.random()*20) );
					if(contador1%2==0){
					m.setVx(6);
					}
					else{
					m.setVx(-6);
					}
					m.setVy( 3);
					actors.add(m);
				}
				
				
				
				if(contador1==350){
					Monster m = new MonsterBoludo(this);
					m.setX(400 ) ;
					m.setY( 20+ (int)(Math.random()*20) );
					m.setVx(3);
					m.setVy( 0);
					actors.add(m);
					Monster a = new MonsterBoludo(this);
					a.setX(400 ) ;
					a.setY( 20+ (int)(Math.random()*20) );
					a.setVx(-3);
					a.setVy( 0);
					actors.add(a);
				}
				

				if(contador1>=400 && contador1<=450 && contador1%10==0){
					Monster m = new MonsterLateral(this,false);
					m.setY( 20+ (int)(Math.random()*20) );
					m.setVy( 3);
					actors.add(m);
					
					
					Monster a = new MonsterLateral(this,true);
					a.setY( 20+ (int)(Math.random()*20) );
					a.setVy( 3);
					actors.add(a);
				}
				
				if(contador1>=550 && contador1<=600 && contador1%10==0){
					PaqueteVida m = new PaqueteVida(this);
					m.setX(100);
					m.setY(20);
					m.setVx(2);
					m.setVy(2);
					actors.add(m);
				}
	
				
				if(contador1>=620 && contador1<=700 && contador1%5==0){
					Monster m = new MonsterGeneric(this);
					m.setX(400 ) ;
					m.setY( 20 );
					if(contador1%2==0){
					m.setVx(6);
					}
					else{
					m.setVx(-6);
					}
					m.setVy( 3);
					actors.add(m);
				}
				
				if(contador1>=620 && contador1<=700 && contador1%20==0){
					Monster m = new MonsterBanzai(this);
					m.setX(600) ;
					m.setY( 20);
					m.setVx(5);
					m.setVy(5);
					actors.add(m);
				}
				
				if(contador1==750 && contador1<=800 && contador1%25==0){
					for(i=0;i<3;i++){
					Monster m = new MonsterBanzai(this);
					m.setX(0) ;
					m.setY( 150*i+1);
					m.setVx(5);
					m.setVy(5);
					actors.add(m);
					}
					
					for(i=0;i<3;i++){
						Monster m = new MonsterBanzai(this);
						m.setX(700) ;
						m.setY( 150*i+1);
						m.setVx(5);
						m.setVy(5);
						actors.add(m);
						}

				}
				
		
				if(contador1==850){
					Monster m = new MonsterBoludo(this);
					m.setX(400 ) ;
					m.setY( 20+ (int)(Math.random()*20) );
					m.setVx(3);
					m.setVy( 0);
					actors.add(m);
				}
				
				if(contador1>=900 && contador1<=1100 ){
					for(i=0;i<1;i++){
				      Monster m = new Piedra(this);
				        m.setX((int)(Math.random()*790) ) ;
					    m.setY( 20 );
					    m.setVx(  0);
					    m.setVy( 10);
				      actors.add(m);
					}
				}
				
				if(contador1>=900 && contador1<=1100 && contador1%10==0){
					Monster m = new MonsterGeneric(this);
					m.setX(400 ) ;
					m.setY( 20 );
					if(contador1%20==0){
					m.setVx(6);
					}
					else{
					m.setVx(-6);
					}
					m.setVy( 3);
					actors.add(m);
				}
				
				if(contador1>=1200 && contador1<=1250 && contador1%10==0){
					PaqueteVida m = new PaqueteVida(this);
					m.setX(100);
					m.setY(20);
					m.setVx(2);
					m.setVy(2);
					actors.add(m);
				}
				
				if(contador1==1230){
					Monster m = new MonsterHuevo(this);
					m.setX(100);
					m.setY(20);
					m.setVx(2);
					m.setVy(5);
					actors.add(m);
				}
				
				if(contador1>=1250 && contador1<=1350 && contador1%10==0){
				Monster m = new MonsterEstrellar(this);
				m.setX(20+50 ) ;
				m.setY( 20+ (int)(Math.random()*20) );
				m.setVx( 10 );
				m.setVy( 0);
				actors.add(m);
				}
				
				if(contador1>=1300 && contador1<=1400 && contador1%5==0){
					Monster m = new MonsterGeneric(this);
					m.setX(400 ) ;
					m.setY( 20 );
					if(contador1%2==0){
					m.setVx(12);
					}
					else{
					m.setVx(-12);
					}
					m.setVy(2);
					actors.add(m);
				}
				
				if (contador1==1400){
					Charla.getCharla().Net2Conf();
					Charla.getCharla().setMensaje("Desgraciados, os tengo jajaja");
					
					JefeFinal m= new MonsterSuperNet(this);
					m.setX(400 ) ;
					m.setY( 20 );
					m.setVx(4);
					actors.add(m);
				}
				

			
				if(contador1>=1400 && contador1<=3500 && contador1%20==0){
					Monster m = new MonsterGeneric(this);
					m.setX(400 ) ;
					m.setY( 20 );
					if(contador1%20==0){
					m.setVx(12);
					}
					else{
					m.setVx(-12);
					}
					m.setVy(2);
					actors.add(m);
				}
				
				
				if(Fase.identidad1!=1 && Fase.identidad2!=1){
					if(contador1==3450){
						Bot.fuegoDisponible=1;
						Bot m = new RafaBot(this);
						m.setX(200);
						m.setY(600);
						m.setVx(0);
						m.setVy(-2);
						actors.add(m);
					}
					
					
					if(contador1==3485){
							RafaBot.vy=0;	
					}	
				
				}
				
				if(Fase.identidad1!=2 && Fase.identidad2!=2){
					if(contador1==3450){
						Bot m = new PacoBot(this);
						m.setX(400);
						m.setY(600);
						m.setVx(0);
						m.setVy(-2);
						actors.add(m);
					}
					
					
					if(contador1==3485){
							PacoBot.vy=0;	
					}	
				}
				
				if(Fase.identidad1!=3 && Fase.identidad2!=3){
					if(contador1==3450){
						Bot m = new JesusBot(this);
						m.setX(600);
						m.setY(600);
						m.setVx(0);
						m.setVy(-2);
						actors.add(m);
					}
					
					
					if(contador1==3485){
							JesusBot.vy=0;		
					}
				}
				

				
				
				if(Fase.identidad1!=4 && Fase.identidad2!=4){
					if(contador1==3450){
						Bot m = new JuanBot(this);
						m.setX(220);
						m.setY(600);
						m.setVx(0);
						m.setVy(-3);
						actors.add(m);
					}
					
					
					if(contador1==3485){
							JuanBot.vy=0;	
					}	
				}
				
				
				if(Fase.identidad1!=4 && Fase.identidad2!=4){
					if(contador1==3450){
						Bot m = new LobogrisBot(this);
						m.setX(388);
						m.setY(600);
						m.setVx(0);
						m.setVy(-3);
						actors.add(m);
					}
					
					
					if(contador1==3485){
							LobogrisBot.vy=0;	
					}	
				}
				
				
				if(Fase.identidad1!=5 && Fase.identidad2!=5){
					if(contador1==3450){
						Bot m = new AdamBot(this);
						m.setX(622);
						m.setY(600);
						m.setVx(0);
						m.setVy(-3);
						actors.add(m);
					}
					
					if(contador1==3485){
						AdamBot.vy=0;	
					}	
				}
				
				if(Fase.identidad1!=6 && Fase.identidad2!=6){
					if(contador1==3450){
						Bot m = new AngelBot(this);
						m.setX(100);
						m.setY(600);
						m.setVx(0);
						m.setVy(-4);
						actors.add(m);
					}
					if(contador1==3460){
						AngelBot.vy=2;
					}
					if(contador1==3470){
						AngelBot.vy=-4;
					}
					if(contador1==3475){
						AngelBot.vy=2;
					}
					if(contador1==3485){
						AngelBot.vy=-8;
					}
					if(contador1==3495){
						AngelBot.vy=0;	
					}	
				}
				
				
				if(contador1==3496){
					RafaBot.vx=8;
					PacoBot.vx=-10;
					JesusBot.vx=12;
					JuanBot.vx=-8;
					LobogrisBot.vx=10;
					AdamBot.vx=-8;
					AngelBot.vx=18;
				}
				
				
				if(contador1==3500){
					for(i=0;i<20;i++){
					PaqueteVida m = new PaqueteVida(this);
					m.setX(100);
					m.setY(20);
					m.setVx(i);
					m.setVy(3);
					actors.add(m);
					}
				}

				
				if(contador1==3600){
					soundCache.StopSongMp3();
					soundCache.PlaySongMp3("musica/After Touch.mp3",true);
					M.setX(200);
					actors.add(M);	
				}
				
				
				if(contador1>3600){
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
				NuevoJuego.getNuevoJuego().playComponent((Component)NuevoJuego.getNuevoJuego().SecuenciaFinalB (), 30);
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
		ocean = spriteCache.getSprite("fondos/metal2.gif");
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