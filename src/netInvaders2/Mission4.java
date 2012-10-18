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


public class Mission4 extends  Fase {

	public static int contador3=0;
	public static int totales=0;
	public Mission4() {
		super();
	}


	public void jugar() {
		usedTime=1000;
		//eventTime,nuevotime;
		t=0;
		idMission=4;
		int i;
		int contador1=-30;
		int contador2=0;
		
		int vidaMonster=1;

		
		JefeFinal M= new MonsterFinal(this);


		initWorld(); 
		
		soundCache.PlaySongMp3("musica/Cronicles of Evolution.mp3",true);

		long nuevoTime = System.currentTimeMillis();
		long fichaTiempo = 0;



		while (isVisible() && !gameEnded) {
			t=t+15;
			long startTime = System.currentTimeMillis();
			updateWorld();
			checkCollisions();
			paintWorld();
			

			eventTime = System.currentTimeMillis()-nuevoTime;

			if(fichaTiempo < (int)(eventTime/100)){
				contador1++;

				if(contador1==-29){

					Charla.getCharla().pdamonConf();
					Charla.getCharla().setMensaje("Si que hay .nets aqui... acaba con todos los que encuentres a tu paso");
				}


				if(contador1==0){
					Charla.getCharla().pdamonConf();
					Charla.getCharla().setMensaje("Recoge las bolas brillantes de combustible java para poder escapar de la masa gravitatoria");
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


				if(contador1==0){
					Monster m = new MonsterLateral(this,false);
					m.setY( 20+ (int)(Math.random()*20) );
					m.setVy( 3);
					actors.add(m);
					
					
					Monster a = new MonsterLateral(this,true);
					a.setY( 20+ (int)(Math.random()*20) );
					a.setVy( 3);
					actors.add(a);
				}


				if(contador1==1){
					Monster m = new MonsterEstrellar(this);
					m.setX(20+50 ) ;
					m.setY( 20+ (int)(Math.random()*20) );
					m.setVx( 10 );
					m.setVy( 0);
					actors.add(m);
				}
				
				if(contador1==2){
					/*
					MonsterHuevo m = new MonsterHuevo(this);
					m.setX(200 ) ;
					m.setY( 2 );
					m.setVx( 0 );
					m.setVy( 2);
					actors.add(m);*/
				}
				
				if(contador1==10){
					for(i=0;i<10;i++){
					Monster m = new MonsterGeneric(this);
					m.setX(20 ) ;
					m.setY( 1 );
					m.setVx( 1+i );
					m.setVy( 11-i);
					actors.add(m);
					}
				}

				
				if(contador1==15){
					for(i=0;i<10;i++){
					Monster m = new MonsterGeneric(this);
					m.setX(600 ) ;
					m.setY( 1 );
					m.setVx( 1-i );
					m.setVy( 11-i);
					actors.add(m);
					}
				}
				
				if(contador1==20){
					for(i=0;i<10;i++){
						Monster m = new MonsterGeneric(this);
						m.setX(20 ) ;
						m.setY( 1 );
						m.setVx( 1+i );
						m.setVy( 11-i);
						actors.add(m);
						}
				}
				
				
				if(contador1==25){
					for(i=0;i<10;i++){
					Monster m = new MonsterGeneric(this);
					m.setX(600 ) ;
					m.setY(1 );
					m.setVx( 1-i );
					m.setVy( 11-i);
					actors.add(m);
					}
				}
				
				if(contador1==30){
					for(i=0;i<10;i++){
					Monster m = new MonsterGeneric(this);
					m.setX(600 ) ;
					m.setY( 1 );
					m.setVx( 1-i );
					m.setVy( 11-i);
					actors.add(m);
					}
				}
				
				if(contador1==40){
				PaqueteVida m = new PaqueteVida(this);
				m.setX(5);
				m.setY(200);
				m.setVx(5);
				m.setVy(1);
				actors.add(m);
				}
				
				if(contador1==50){
					MonsterHuevo m = new MonsterHuevo(this);
					m.setX(5);
					m.setY(0);
					m.setVx(1);
					m.setVy(2);
					actors.add(m);
					}
				

				if(contador1==60){
					Monster m = new MonsterLateral(this,false);
				
					m.setY( 20+ (int)(Math.random()*20) );

					m.setVy( 3);
					actors.add(m);
					
					
					Monster a = new MonsterLateral(this,true);
					
					a.setY( 20+ (int)(Math.random()*20) );

					a.setVy( 3);
					actors.add(a);
				}
				
				
				if(contador1==65){
					Monster m = new MonsterEstrellar(this);
					m.setX(20+50 ) ;
					m.setY( 20+ (int)(Math.random()*20) );
					m.setVx( 10 );
					m.setVy( 0);
					actors.add(m);
				}
				if(contador1==70){
					Monster m = new MonsterEstrellar(this);
					m.setX(20+50 ) ;
					m.setY( 20+ (int)(Math.random()*20) );
					m.setVx( 10 );
					m.setVy( 0);
					actors.add(m);
				}
				if(contador1==75){
					Monster m = new MonsterEstrellar(this);
					m.setX(20+50 ) ;
					m.setY( 20+ (int)(Math.random()*20) );
					m.setVx( 10 );
					m.setVy( 0);
					actors.add(m);
				}
				
				
				if(contador1==150){
					for(i=0;i<3;i++){
					Monster m = new MonsterDefender(this);
					
					m.setY( 20+ (int)(Math.random()*20) );
					m.setX(i*50);
					m.setVx(25);
					m.setVy( 4);
					actors.add(m);
					}
				}
				
				if(contador1==200){
					for(i=0;i<3;i++){
					PaqueteVida m = new PaqueteVida(this);
					m.setY( 20+ (int)(Math.random()*20) );
					m.setX(i*50);
					m.setVx(5);
					m.setVy( 2);
					actors.add(m);
					}
				}
				
				
				
				if(contador1==200){
					Charla.getCharla().GordaConf();
					Charla.getCharla().setMensaje("Os tengo donde queria programadores java jujujujuju, jijiji");
				}
				
				if(contador1==250 && (identidad1==4 || identidad2==4)){
					Charla.getCharla().juanConf();
					Charla.getCharla().setMensaje("Maldita, esa es a la que le hice de taxista hace unos años cuando aprendiamos java");
				}
				
				if(contador1==270){
					PaqueteCombustible m = new PaqueteCombustible(this);
					m.setX(20);
					m.setY(20);
					m.setVx(5);
					m.setVy(4);
					actors.add(m);
				}
				
				if(contador1==250 &&(identidad1!=4 || identidad2!=4)){
					Bot.fuegoDisponible=1;
					Bot m = new JuanBot(this);
					m.setX(200);
					m.setY(600);
					m.setVx(0);
					m.setVy(-1);
					actors.add(m);
				}
				
				if(contador1==300 &&(identidad1!=4 || identidad2!=4)){
					JuanBot.vy=0;	
					Charla.getCharla().juanConf();
					Charla.getCharla().setMensaje("Una gran gorda conlleva una gran responsabilidad");
				}	
				
				if(contador1==350 && (identidad1!=4 || identidad2!=4)){
					Charla.getCharla().juanConf();
					Charla.getCharla().setMensaje("Tranquilo, que aqui se va a acabar el cachondeito");
					JuanBot.vy=-7;
					JuanBot.vx=4;
				}

				
				if(contador1==350){
					PaqueteCombustible m = new PaqueteCombustible(this);
					m.setX(400);
					m.setY(20);
					m.setVx(8);
					m.setVy(4);
					actors.add(m);
				}
				
				if(contador1==360){
					JuanBot.vy=0;
					JuanBot.vx=0;
				}
				
				if(contador1==380){
					PaqueteCombustible m = new PaqueteCombustible(this);
					m.setX(400);
					m.setY(20);
					m.setVx(3);
					m.setVy(7);
					actors.add(m);
				}
				
				if(contador1==410){
					JuanBot.orden=1;
				}
				if(contador1==411){
					JuanBot.orden=0;
				}
				if(contador1==400){
					for(i=0;i<5;i++){
						Monster m = new MonsterDefender(this);
						
						m.setY( 20+ (int)(Math.random()*20) );
						m.setX(i*50);
						m.setVx(25);
						m.setVy( 2);
						actors.add(m);
						}
				}
				
				if(contador1==499 && contador1==700){
					JuanBot.vy=1;
					JuanBot.vx=1;
				}
				
				if(contador1>=500 && contador1%20==0 && contador1<700){
					JuanBot.vy=-JuanBot.vy;
					JuanBot.vx=-JuanBot.vx;
				}

				
				if(contador1==525){
					Monster m = new MonsterEstrellar(this);
					m.setX(20+50 ) ;
					m.setY( 20+ (int)(Math.random()*20) );
					m.setVx( 10 );
					m.setVy( 0);
					actors.add(m);
				}
				if(contador1==530){
					Monster m = new MonsterEstrellar(this);
					m.setX(20+50 ) ;
					m.setY( 20+ (int)(Math.random()*20) );
					m.setVx( 10 );
					m.setVy( 0);
					actors.add(m);
				}
				if(contador1==535){
					Monster m = new MonsterEstrellar(this);
					m.setX(20+50 ) ;
					m.setY( 20+ (int)(Math.random()*20) );
					m.setVx( 10 );
					m.setVy( 0);
					actors.add(m);
				}
				
				if(contador1==540){
					Monster m = new MonsterEstrellar(this);
					m.setX(20+50 ) ;
					m.setY( 20+ (int)(Math.random()*20) );
					m.setVx( 10 );
					m.setVy( 0);
					actors.add(m);
				}
				if(contador1==545){
					Monster m = new MonsterEstrellar(this);
					m.setX(20+50 ) ;
					m.setY( 20+ (int)(Math.random()*20) );
					m.setVx( 10 );
					m.setVy( 0);
					actors.add(m);
				}
				if(contador1==550){
					Monster m = new MonsterEstrellar(this);
					m.setX(20+50 ) ;
					m.setY( 20+ (int)(Math.random()*20) );
					m.setVx( 10 );
					m.setVy( 0);
					actors.add(m);
				}
				if(contador1==565){
					Monster m = new MonsterEstrellar(this);
					m.setX(20+50 ) ;
					m.setY( 20+ (int)(Math.random()*20) );
					m.setVx( 10 );
					m.setVy( 0);
					actors.add(m);
				}
				if(contador1==570){
					Monster m = new MonsterEstrellar(this);
					m.setX(20+50 ) ;
					m.setY( 20+ (int)(Math.random()*20) );
					m.setVx( 10 );
					m.setVy( 0);
					actors.add(m);
				}
				if(contador1==575){
					Monster m = new MonsterEstrellar(this);
					m.setX(20+50 ) ;
					m.setY( 20+ (int)(Math.random()*20) );
					m.setVx( 10 );
					m.setVy( 0);
					actors.add(m);
				}
				
				
				if(contador1==550){
					Monster m = new MonsterLateral(this,false);
					
					m.setY( 20+ (int)(Math.random()*20) );

					m.setVy( 3);
					actors.add(m);
					
					
					Monster a = new MonsterLateral(this,true);
					
					a.setY( 20+ (int)(Math.random()*20) );

					a.setVy( 3);
					actors.add(a);
					
					
					for(i=0;i<10;i++){
						Monster c = new MonsterGeneric(this);
						c.setX(20 ) ;
						c.setY( 20 );
						c.setVx( 10+i );
						c.setVy( 0);
						actors.add(c);
						}
				}
				
				
				if(contador1==700 && (identidad1!=4 || identidad2!=4)){
					JuanBot.vy=4;
					Charla.getCharla().juanConf();
					Charla.getCharla().setMensaje("Bien, sigue hacia el norte, yo dare otro volteo por el sur para acabar con todos los .net restantes");
				}
				
				if(contador1==730){
					
					for(i=0;i<5;i++){
						Monster c = new MonsterHuevo(this);
						c.setX(20 ) ;
						c.setY( 20 );
						c.setVx( 3+i );
						c.setVy( 5);
						actors.add(c);
						}
				}

				
				if(contador1==750){
					Charla.getCharla().GordaConf();
					Charla.getCharla().setMensaje("Pronto estareis destruidos, ya falta poco jujujujijijiji");
				}
				
				
				if(contador1==735){
					Monster m = new MonsterLateral(this,false);
					
					m.setY( 20+ (int)(Math.random()*20) );

					m.setVy( 3);
					actors.add(m);
					
					
					Monster a = new MonsterLateral(this,true);
					
					a.setY( 20+ (int)(Math.random()*20) );

					a.setVy( 3);
					actors.add(a);
				}
				
				if(contador1==745){
					Monster m = new MonsterLateral(this,false);
					
					m.setY( 20+ (int)(Math.random()*20) );

					m.setVy( 3);
					actors.add(m);
					
					
					Monster a = new MonsterLateral(this,true);
					
					a.setY( 20+ (int)(Math.random()*20) );

					a.setVy( 3);
					actors.add(a);
				}
				
				if(contador1==755){
					Monster m = new MonsterLateral(this,false);
					
					m.setY( 20+ (int)(Math.random()*20) );

					m.setVy( 3);
					actors.add(m);
					
					
					Monster a = new MonsterLateral(this,true);
					
					a.setY( 20+ (int)(Math.random()*20) );

					a.setVy( 3);
					actors.add(a);
				}
				
				
				if(contador1==745){
					for(i=0;i<10;i++){
						Monster m = new MonsterGeneric(this);
						m.setX(300 ) ;
						m.setY( 1 );
						m.setVx( -10+i*2 );
						m.setVy( 5);
						actors.add(m);
						}
				}
				if(contador1==750){
					for(i=0;i<10;i++){
						Monster m = new MonsterGeneric(this);
						m.setX(300 ) ;
						m.setY( 1 );
						m.setVx( -10+i*2 );
						m.setVy( 5);
						actors.add(m);
						}
				}
				if(contador1==755){
					for(i=0;i<10;i++){
						Monster m = new MonsterGeneric(this);
						m.setX(300 ) ;
						m.setY( 1 );
						m.setVx( -10+i*2 );
						m.setVy( 5);
						actors.add(m);
						}
				}
				
				
				if(contador1==800){
					for(i=0;i<2;i++){
					PaqueteVida m = new PaqueteVida(this);
					
					m.setY( 20+ (int)(Math.random()*20) );
					m.setX(i*50);
					m.setVx(5);
					m.setVy( 2);
					actors.add(m);
					}
				}
				
				if(contador1==810){
					for(i=0;i<5;i++){
					Monster m = new MonsterDefender(this);
					
					m.setY( 20+ (int)(Math.random()*20) );
					m.setX(i*50);
					m.setVx(8);
					m.setVy( 2);
					actors.add(m);
					}
					
					for(i=0;i<5;i++){
						Monster m = new MonsterDefender(this);
						
						m.setY( 20+ (int)(Math.random()*20) );
						m.setX(550-(i*50));
						m.setVx(-8);
						m.setVy( 2);
						actors.add(m);
						}
				}
				
				
				if(contador1==820){
					for(i=0;i<5;i++){
					Monster m = new MonsterBanzai(this);
					
					m.setY( 20+ (int)(Math.random()*20) );
					m.setX(i*200);
					m.setVx(5);
					m.setVy( 5);
					actors.add(m);
					}
				}
				
				if(contador1==830){
					for(i=0;i<5;i++){
					Monster m = new MonsterBanzai(this);
					
					m.setY( 20+ (int)(Math.random()*20) );
					m.setX(i*200);
					m.setVx(5);
					m.setVy( 5);
					actors.add(m);
					}
				}
				
				if(contador1==840){
					for(i=0;i<5;i++){
					Monster m = new MonsterBanzai(this);
					
					m.setY( 20+ (int)(Math.random()*20) );
					m.setX(i*200);
					m.setVx(5);
					m.setVy( 5);
					actors.add(m);
					}
				}
				
				if(contador1==850){
					for(i=0;i<5;i++){
					Monster m = new MonsterBanzai(this);
					
					m.setY( 20+ (int)(Math.random()*20) );
					m.setX(i*200);
					m.setVx(5);
					m.setVy( 5);
					actors.add(m);
					}
				}
				
				if(contador1==840){
					for(i=0;i<3;i++){
					Monster m = new MonsterEstrellar(this);
					
					m.setY( 20+ (int)(Math.random()*20) );
					m.setX(i*200);
					m.setVx(2);
					m.setVy( 0);
					actors.add(m);
					}
				}
				
				if(contador1==900){
					for(i=0;i<3;i++){
					Monster m = new MonsterEstrellar(this);
					
					m.setY( 20+ (int)(Math.random()*20) );
					m.setX(i*200);
					m.setVx(2);
					m.setVy( 0);
					actors.add(m);
					}
				}
				
				
				
				if(contador1==950){
					Monster m = new MonsterLateral(this,false);
					
					m.setY( 20+ (int)(Math.random()*20) );

					m.setVy( 3);
					actors.add(m);
					
					
					Monster a = new MonsterLateral(this,true);
					
					a.setY( 20+ (int)(Math.random()*20) );

					a.setVy( 3);
					actors.add(a);
				}
				if(contador1==960){
					Monster m = new MonsterLateral(this,false);
					
					m.setY( 20+ (int)(Math.random()*20) );

					m.setVy( 3);
					actors.add(m);
					
					
					Monster a = new MonsterLateral(this,true);
					
					a.setY( 20+ (int)(Math.random()*20) );

					a.setVy( 3);
					actors.add(a);
				}
				if(contador1==970){
					Monster m = new MonsterLateral(this,false);
					
					m.setY( 20+ (int)(Math.random()*20) );

					m.setVy( 3);
					actors.add(m);
					
					
					Monster a = new MonsterLateral(this,true);
					
					a.setY( 20+ (int)(Math.random()*20) );

					a.setVy( 3);
					actors.add(a);
				}
				if(contador1==980){
					Monster m = new MonsterLateral(this,false);
					
					m.setY( 20+ (int)(Math.random()*20) );

					m.setVy( 3);
					actors.add(m);
					
					
					Monster a = new MonsterLateral(this,true);
					
					a.setY( 20+ (int)(Math.random()*20) );

					a.setVy( 3);
					actors.add(a);
				}
				
				
				
				if(contador1==980 || contador1==985 || contador1==990){
					for(i=0;i<5;i++){
						Monster m = new MonsterGeneric(this);
						m.setX(700);
						m.setY(1);
						m.setVx(-10);
						m.setVy(0);
						actors.add(m);
					}
				}
				
				
				
				if(contador1==1000){
					for(i=0;i<1;i++){
					PaqueteVida m = new PaqueteVida(this);
					
					m.setY( 20+ (int)(Math.random()*20) );
					m.setX(i*50);
					m.setVx(5);
					m.setVy( 2);
					actors.add(m);
					}
				}
				
				if(contador1==1050 || contador1==1057 || contador1==1064 || contador1==1071){
					for(i=0;i<10;i++){
						Monster m = new MonsterGeneric(this);
						m.setX(1+i*80);
						m.setY(1);
						m.setVx(0);
						m.setVy(2);
						actors.add(m);
					}
				}
				
				if(contador1==1100){
					Charla.getCharla().pdamonConf();
					Charla.getCharla().setMensaje("Voy a cargar los escudos convenientemente");
					for(i=0;i<20;i++){
						PaqueteVida m = new PaqueteVida(this);
						
						m.setY( 20+ (int)(Math.random()*20) );
						m.setX(i*20);
						m.setVx(5);
						m.setVy( 2);
						actors.add(m);
						}
					
				}
				
				if(contador1==1200){
					Charla.getCharla().GordaConf();
					Charla.getCharla().setMensaje("Que empiece la batalla... PROGRAMADORES JAVA");
					
					soundCache.StopSongMp3();
					soundCache.PlaySongMp3("musica/Come Back Time.mp3",true);
					
					M.setX( 200) ;
					M.setY( 0);
					M.setVx( 5 );
					M.setVy( 0);
					actors.add(M); 
	
				}
				
				if(contador1>1200){
					vidaMonster=M.Monsterv();
				}


				
				calcvida();

				if(vidaMonster==0 && contador2==0){
					contador2=1;
					//if(bandera==0){
						
					//}
					if(totales==contador3){
						Charla.getCharla().pdamonConf();
						Charla.getCharla().setMensaje("Perfecto, has realizado toda la mision con exito, felicidades");
					}
					else{
						Charla.getCharla().pdamonConf();
						Charla.getCharla().setMensaje("Mierda sin el combustible necesario no podemos seguir TRAZA UNA RUTA DE EMERGENCIA");
					}

					
					Actor m = new MissionFinal(this);
					m.setX(-600 ) ;
					m.setY( 200 );
					actors.add(m);
					
				


					calcpuntos();
/*
					if(totales==contador3){
						Perfiles.getPerfil(Opciones.perfilJ1).fasesDisponibles[player.numero-1][6-1]=true;
						
						if(NuevoJuego.nJugadores==2){
						Perfiles.getPerfil(Opciones.perfilJ2).fasesDisponibles[player2.numero-1][6-1]=true;
						}
						
						}
						else{
							Perfiles.getPerfil(Opciones.perfilJ1).fasesDisponibles[player.numero-1][5-1]=true;
							
							if(NuevoJuego.nJugadores==2){
							Perfiles.getPerfil(Opciones.perfilJ2).fasesDisponibles[player2.numero-1][5-1]=true;
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
				if(totales==contador3){
				NuevoJuego.getNuevoJuego().playComponent((Component)NuevoJuego.getNuevoJuego().Secuencia6(), 30);
				}
				else{
				NuevoJuego.getNuevoJuego().playComponent((Component)NuevoJuego.getNuevoJuego().Secuencia5(), 30);
				}
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
		ocean = spriteCache.getSprite("fondos/marte.gif");
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