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


public class Mission2 extends  Fase {


	public Mission2() {
		super();
	}


	public void jugar() {
		usedTime=1000;
		//eventTime,nuevotime;
		t=0;
		idMission=2;
		int i;
		int contador1=-30;  
		//int contador1=2490;
		int contador2=0;
		int vidaMonster=1;
		JefeFinal M= new MonsterPortaBicis(this);


		initWorld(); 
		soundCache.PlaySongMp3("musica/Livin On The Mystic Side.mp3",true);

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
					Charla.getCharla().setMensaje("Bien, busca al que esta mandando a todos esos .net hacia la tierra y destruyele");
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
					for(i=0;i<5;i++){
						Monster m = new MonsterGeneric(this);
						if(contador1%50==0){
						m.setX(20) ;
						}
						else{
						m.setX(750);
						}
						m.setY(20+i*30);
						m.setVx(10);
						m.setVy(0);
						actors.add(m);
					}
				}

				if(contador1>=270 && contador1<=400 && contador1%25==0){
					for(i=0;i<5;i++){
						Monster m = new Piedra(this);
						if(contador1%50==0){
						m.setX(20) ;
						}
						else{
						m.setX(750);
						}
						m.setY(400+i*30);
						
						m.setVx(10);
						m.setVy(-2);
						actors.add(m);
					}
				}

				if(contador1>=400 && contador1<=500 && contador1%10==0){
					for(i=0;i<5;i++){
						Monster m = new MonsterBicicleta(this);
						m.setX(20+i*100);
						m.setY(20);
						m.setVx(5);
						m.setVy(15);
						actors.add(m);
					}
				}

				if(contador1>=521 && contador1<=560 && contador1%20==0){
						PaqueteVida m = new PaqueteVida(this);
						m.setX(5);
						m.setY(200);
						m.setVx(5);
						m.setVy(1);
						actors.add(m);
				}
				
				
				if(contador1>=600 && contador1<=700 && contador1%20==0){
					for(i=0;i<5;i++){
						Monster m = new MonsterBicicleta(this);
						m.setX(100+i*100);
						m.setY(20);
						m.setVx(7);
						m.setVy(15);
						actors.add(m);
					}
				}
					if(contador1>=600 && contador1<=700 && contador1%20==0){
						for(i=0;i<5;i++){
							Monster m = new Piedra(this);
							m.setX(5);
							m.setY(20+i*30);
							m.setVx(5);
							m.setVy(5);
							actors.add(m);
						}
					}
			
					
				if(contador1==750){
					for(i=0;i<5;i++){
						Monster m = new MonsterDefender(this);
						m.setX(50+i*30);
						m.setY(50);
						m.setVx(1);
						m.setVy(0);
						actors.add(m);
					}
					for(i=0;i<5;i++){
						Monster m = new MonsterGeneric(this);
						m.setX(50+i*30);
						m.setY(20);
						m.setVx(1);
						m.setVy(0);
						actors.add(m);
					}
				}
				
				
				if(contador1==850){
					for(i=0;i<8;i++){
						Monster m = new MonsterDefender(this);
						m.setX(50+i*100);
						m.setY(50);
						m.setVx(0);
						m.setVy(20);
						actors.add(m);
					}
					
				}
				
				
				if(contador1==855){
					for(i=0;i<8;i++){
						Monster m = new MonsterDefender(this);
						m.setX(20+i*100);
						m.setY(650);
						m.setVx(0);
						m.setVy(-10);
						actors.add(m);
					}
					
				}
				
				
				if(contador1==870){
					PaqueteVida m = new PaqueteVida(this);
					m.setX(5);
					m.setY(200);
					m.setVx(5);
					m.setVy(1);
					actors.add(m);
				}
				
				if(Fase.identidad1!=2 && Fase.identidad2!=2){
					if(contador1==900){
						Charla.getCharla().pacoConf();
						Charla.getCharla().setMensaje("¡¡aqui llega la caballeria!! ¡observa como mato a estos .net!");
						
						
						
						Bot.fuegoDisponible=1;
						Bot m = new PacoBot(this);
						m.setX(200);
						m.setY(600);
						m.setVx(0);
						m.setVy(-1);
						actors.add(m);
					}
					
					
					if(contador1==950){
							PacoBot.vy=0;	
					}	
					
					if(contador1==1000){
						Charla.getCharla().pacoConf();
						Charla.getCharla().setMensaje("Jajajaja, debiluchos... vamos a por ellos");
						PacoBot.vx=5;
					}
					
					
					
					
					if(contador1==950){
						for(i=0;i<5;i++){
							Monster m = new MonsterGeneric(this);
							m.setX(200);
							m.setY(20+i*30);
							m.setVx(0);
							m.setVy(3);
							actors.add(m);
						}
					}
					
					
				}
				

				
				
				if(contador1==1050){
					for(i=0;i<5;i++){
						Monster m = new MonsterGeneric(this);
						m.setX(600);
						m.setY(20+i*30);
						m.setVx(-3);
						m.setVy(0);
						actors.add(m);
					}
				}
				
				if(contador1==1100){
					for(i=0;i<10;i++){
						Monster m = new Piedra(this);
						m.setX(20);
						m.setY(20);
						m.setVx(i*2);
						m.setVy(20-i*2);
						actors.add(m);
					}
				}
				
				if(contador1==1150){
					for(i=0;i<10;i++){
						Monster m = new Piedra(this);
						m.setX(20);
						m.setY(20);
						m.setVx(i*2);
						m.setVy(20-i*2);
						actors.add(m);
					}
				}
				
				
				if(contador1==1200){
					PaqueteVida m = new PaqueteVida(this);
					m.setX(5);
					m.setY(200);
					m.setVx(5);
					m.setVy(1);
					actors.add(m);
				}
				
				if(Fase.identidad1!=2 && Fase.identidad2!=2){
					if(contador1==1250){
						Charla.getCharla().pacoConf();
						Charla.getCharla().setMensaje("Bien, suerte con la mision, yo tengo que hacer un salto javaespacial, no dejemos ni uno compañero");
						PacoBot.vy=-10;
						PacoBot.vx=0;
					}
				}
				
				
				
				if(contador1==1300){
					Charla.getCharla().joaquinConf();
					Charla.getCharla().setMensaje("Malditos programadores en java, retiraos si no quereis sufrir la ira de mis bicicletas asesinas");
				}
				
				if(contador1==1350){
					Charla.getCharla().pdamonConf();
					Charla.getCharla().setMensaje("Sa tu puñetera madre... programadores java, acabad con ese maldito descerebrado");
				}
				if(contador1==1400){
					Charla.getCharla().joaquinConf();
					Charla.getCharla().setMensaje("Gracias a el ASP puedo hacer estas bicicletas de tremendo poder... morid programadores java");
				}
				
				if(contador1==1450){
				if(identidad1==1){
					Charla.getCharla().defaultConf();
					Charla.getCharla().setMensaje("Jamas... la luna sera tu tumba... maldito lunatico con barbas");
				}
				if(identidad1==2){
					Charla.getCharla().pacoConf();
					Charla.getCharla().setMensaje("Todo esto es imposible... ¿El tambien ha caido?");
				}
				}
				
				
				
				if(contador1==1500){
					for(i=0;i<5;i++){
						Monster m = new MonsterBicicleta(this);
						m.setX(100+i*100);
						m.setY(20);
						m.setVx(7);
						m.setVy(15);
						actors.add(m);
					}
				}
				
				if(contador1==1530){
					for(i=0;i<12;i++){
						Monster m = new MonsterGeneric(this);
						m.setX(100+i*100);
						m.setY(20);
						m.setVx(7);
						m.setVy(0);
						actors.add(m);
					}
				}
				if(contador1==1550){
					for(i=0;i<2;i++){
						Monster m = new MonsterGeneric(this);
						m.setX(1);
						m.setY(60+i*40);
						m.setVx(20);
						m.setVy(0);
						actors.add(m);
					}
				}
					
				
				if(contador1==1600){
					for(i=0;i<20;i++){
						Monster m = new MonsterTiradorPreciso(this);
						m.setX(i*20);
						m.setY(1);
						m.setVx(2);
						m.setVy(2);
						actors.add(m);
					}
				}
					
				
				
				if(contador1==1700){
					for(i=0;i<5;i++){
						Monster m = new MonsterDefender(this);
						m.setX(1);
						m.setY(50+i*100);
						m.setVx(20);
						m.setVy(0);
						actors.add(m);
					}
					
				}
				
				
				if(contador1==1705){
					for(i=0;i<5;i++){
						Monster m = new MonsterDefender(this);
						m.setX(700);
						m.setY(1+i*100);
						m.setVx(-10);
						m.setVy(0);
						actors.add(m);
					}
					
				}
				
				
				if(contador1==1800){
					for(i=0;i<5;i++){
						Monster m = new MonsterGeneric(this);
						m.setX(700);
						m.setY(1+i*100);
						m.setVx(-10);
						m.setVy(0);
						actors.add(m);
					}
				}
				
				
				if(contador1==1850){
					PaqueteVida m = new PaqueteVida(this);
					m.setX(5);
					m.setY(200);
					m.setVx(5);
					m.setVy(1);
					actors.add(m);
				}
				if(contador1==1900){
					PaqueteVida m = new PaqueteVida(this);
					m.setX(5);
					m.setY(200);
					m.setVx(5);
					m.setVy(1);
					actors.add(m);
				}
				
				if(contador1==1900){
					for(i=0;i<5;i++){
						Monster m = new MonsterGeneric(this);
						m.setX(700);
						m.setY(1+i*100);
						m.setVx(-10);
						m.setVy(0);
						actors.add(m);
					}
				}
				
				
				if(contador1==1950){
					for(i=0;i<5;i++){
						Monster m = new MonsterGeneric(this);
						m.setX(700);
						m.setY(1+i*100);
						m.setVx(-10);
						m.setVy(0);
						actors.add(m);
					}
				}
				if(contador1==1950){
					for(i=0;i<3;i++){
						Monster m = new MonsterBicicleta(this);
						m.setX(700);
						m.setY(1+i*100);
						m.setVx(10);
						m.setVy(10);
						actors.add(m);
					}
					for(i=0;i<3;i++){
						Monster m = new MonsterBicicleta(this);
						m.setX(1);
						m.setY(50+i*100);
						m.setVx(10);
						m.setVy(10);
						actors.add(m);
					}
				}
				
				
				if(contador1==2000){
					for(i=0;i<5;i++){
						Monster m = new MonsterGeneric(this);
						m.setX(700);
						m.setY(1+i*100);
						m.setVx(-10);
						m.setVy(0);
						actors.add(m);
					}
				}
				
				if(contador1==2050){
					for(i=0;i<5;i++){
						Monster m = new MonsterGeneric(this);
						m.setX(700);
						m.setY(1+i*100);
						m.setVx(-10);
						m.setVy(0);
						actors.add(m);
					}
				}
				
				if(contador1==2100){
					for(i=0;i<5;i++){
						Monster m = new MonsterGeneric(this);
						m.setX(700);
						m.setY(1+i*100);
						m.setVx(-10);
						m.setVy(0);
						actors.add(m);
					}
				}
				if(contador1==2150){
					for(i=0;i<5;i++){
						Monster m = new MonsterGeneric(this);
						m.setX(700);
						m.setY(1+i*100);
						m.setVx(-10);
						m.setVy(0);
						actors.add(m);
					}
				}
				if(contador1==2150){
					for(i=0;i<3;i++){
						Monster m = new MonsterBicicleta(this);
						m.setX(700);
						m.setY(1+i*100);
						m.setVx(10);
						m.setVy(10);
						actors.add(m);
					}
					for(i=0;i<3;i++){
						Monster m = new MonsterBicicleta(this);
						m.setX(1);
						m.setY(50+i*100);
						m.setVx(10);
						m.setVy(10);
						actors.add(m);
					}
				}
				
				if(contador1==2250){

						PaqueteVida m = new PaqueteVida(this);
						m.setX(700);
						m.setY(100);
						m.setVx(5);
						m.setVy(3);
						actors.add(m);
					

						PaqueteVida p = new PaqueteVida(this);
						p.setX(1);
						p.setY(50+100);
						p.setVx(3);
						p.setVy(3);
						actors.add(p);
					
				}
				
				
				if(contador1==2500){
					soundCache.StopSongMp3();
					soundCache.PlaySongMp3("musica/Come Back Time.mp3",true);
					
					M.setX( 0) ;
					M.setY( 0 );
					M.setVx( 0 );
					M.setVy( 0);
					actors.add(M);      
				}


				if(contador1>2500){
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
					/*
					Perfiles.getPerfil(Opciones.perfilJ1).fasesDisponibles[player.numero-1][3-1]=true;
					
					if(NuevoJuego.nJugadores==2){
					Perfiles.getPerfil(Opciones.perfilJ2).fasesDisponibles[player2.numero-1][3-1]=true;
					}*/
					
				}		


				
				if(contador2>=1){
					contador2++;
				}
				
				
				if(contador2==100){
				Charla.getCharla().quitaMensaje();
				soundCache.StopSongMp3();
				this.limpiaMemo();
				NuevoJuego.getNuevoJuego().playComponent((Component)NuevoJuego.getNuevoJuego().Secuencia3 (), 30);
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
		ocean = spriteCache.getSprite("fondos/luna.gif");
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