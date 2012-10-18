package netInvaders2;
import games.MenuCache;
import games.PlayableCanvas;

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



public abstract class Fase extends  Canvas implements Stage, KeyListener ,PlayableCanvas{
	public BufferStrategy strategy;
	public SpriteCache spriteCache;
	public SoundCache soundCache;
	public long usedTime;
	public long eventTime;
	public long nuevoTime;
	
	
	long startTime=System.currentTimeMillis();
	static long tiempoTarda;
	public static int framesPorSegundo=60;
	static int retardo=1000/framesPorSegundo;


	
	
	public int t;
	public BufferedImage ocean;
	public ArrayList actors;
	public Player player;
	public Player player2;
	public boolean gameEnded=false;
	public int constanteMedida = 20;

	
	public int VidaUno;
	public int VidaDos;
	
	
	public static int primeroVivo;
	public static int segundoVivo;
	
	public int jefeVivo=1;
	
	public static int bandera=1;
	
	
	
	
	public static int xplayer;
	public static int yplayer;
	public static int xplayer2;
	public static int yplayer2;
	public static int identidad1=0;
	public static int identidad2=0;
	
	public static int idMission;
	
	
	public Fase() {
		primeroVivo=1;
		
		if(NuevoJuego.nJugadores==2){
			segundoVivo=1;
		}
		
		spriteCache = new SpriteCache();
		soundCache = new SoundCache(); 


		setBounds(0,0,Stage.WIDTH,Stage.HEIGHT);
		addKeyListener(this);
		setIgnoreRepaint(true);
	}
	
	

	public abstract void paintWorld();
	
	public void initWorld() {
		strategy = getBufferStrategy();
		requestFocus();
	    actors = new ArrayList();
	     
	    switch(NuevoJuego.naveJ1){
	    case 1: player=new Rafa(this,1); break; 
	    case 2: player=new Paco(this,1); break;
	    case 3: player=new Jesus(this,1); break;
	    case 4: player=new Juan(this,1); break;
	    case 5: player=new Lobogris(this,1); break;
	    case 6: player=new Adam(this,1); break;
	    case 7: player=new Angel(this,1); break;
	    case 8: player=new Adamuz(this,1); break;
	    }
	    
	    player.setX(Stage.WIDTH/2);
	    player.setY(Stage.HEIGHT - 2*player.getHeight());
	    player.setVx(0);
	    player.setVy(0);
	    identidad1=player.getNumero();
	    
	    if(NuevoJuego.nJugadores==2){
	    	switch(NuevoJuego.naveJ2){
		    case 1: player2=new Rafa(this,2); break; 
		    case 2: player2=new Paco(this,2); break;
		    case 3: player2=new Jesus(this,2); break;
		    case 4: player2=new Juan(this,2); break;
		    case 5: player2=new Lobogris(this,2); break;
		    case 6: player2=new Adam(this,2); break;
		    case 7: player2=new Angel(this,2); break;
		    case 8: player2=new Adamuz(this,2); break;
	    	}
	    
	    	player2.setX(Stage.WIDTH/2+30);
			player2.setY(Stage.HEIGHT - 2*player2.getHeight());
			player2.setVx(0);
			player2.setVy(0);
			identidad2=player2.getNumero();

	    }
	    
	   
	    
	    
	}
	
	public void calcpuntos(){
		player.precision= (int) ((player.disparosRealizados - player.disparosFallados)/(float)player.disparosRealizados*100);
		player.precision= (player.precision-50)*1000;
		player.score=player.score + player.precision +(VidaUno*1000);
		
		//ESCRIBIR PUNTUACIONES EN BASE DE DATOS LOCAL
		//if(Perfiles.getPerfil(Opciones.perfilJ1).getScore(player.numero-1,idMission-1) < player.score){
		//Perfiles.getPerfil(Opciones.perfilJ1).actualizarScore(player.numero-1,idMission-1 , player.score);
		//}


		
		if(NuevoJuego.nJugadores==2){
			player2.precision= (int) ((player2.disparosRealizados - (float)player2.disparosFallados)/player2.disparosRealizados*100);
			player2.precision= (player2.precision-50)*1000;
			player2.score=player2.score + player2.precision +(VidaDos*1000);	
			
			//if(Perfiles.getPerfil(Opciones.perfilJ2).getScore(player2.numero-1,idMission-1) < player2.score){
			//Perfiles.getPerfil(Opciones.perfilJ2).actualizarScore(player2.numero-1,idMission-1 , player2.score);
			//}
		}


	
		mensajesTwitter(1);
	}
	
	

	
	
	
	public void calcvida(){
		if(primeroVivo==0){
			if(NuevoJuego.nJugadores==2){
				if(segundoVivo==0){
					paintGameOver();
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						soundCache.StopSongMp3();
						NuevoJuego.getNuevoJuego().playComponent((Component)NuevoJuego.getNuevoJuego().getMainMenu(), 1000);
						NuevoJuego.getNuevoJuego().playGame();
					
					gameEnded=true;
				}
			}
			else{
				paintGameOver();
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					soundCache.StopSongMp3();
					NuevoJuego.getNuevoJuego().playComponent((Component)NuevoJuego.getNuevoJuego().getMainMenu(), 1000);
					NuevoJuego.getNuevoJuego().playGame();
				
				gameEnded=true;
			}

		}
	}
	
	
	
	public void paintGameOver() {
		soundCache.StopSongMp3();
		soundCache.PlaySongMp3("musica/Game Over.mp3",true);

		
		Graphics2D g = (Graphics2D)strategy.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0,0,getWidth(),getHeight());
		
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.setPaint(Color.red);
		g.drawString("Game over",Stage.WIDTH/2,Stage.PLAY_HEIGHT/2);
		
		paintStatus(g);
		strategy.show();
		
		mensajesTwitter(2);
	}
	public  void updateWorld(){
		
		xplayer = player.getX();
		yplayer = player.getY();
		
		primeroVivo = player.getStat();
		
		if(NuevoJuego.nJugadores==2){
			xplayer2 = player2.getX();
			yplayer2 = player2.getY();
			segundoVivo=player2.getStat();
		}
		int i = 0;
	 
	    
		while (i < actors.size()) {
			Actor m = (Actor)actors.get(i);
			if (m.isMarkedForRemoval()) {
				actors.remove(i);
			} else {
				m.act();
				i++;
			}
		}
		
		if(primeroVivo==1){
		player.act();
		}
		
		if(NuevoJuego.nJugadores==2){
			if(segundoVivo==1){
				player2.act();
			}
		}
		
	}
	public  void paintShields(Graphics2D g){
		int i;
		
		//g.setPaint(Color.red);
		//g.drawString(player.getShields()+"",230,Stage.PLAY_HEIGHT  + constanteMedida);
		
		VidaUno= (int)((player.shields/(float)player.MAX_SHIELDS)*100);

		
		for(i=0;i<VidaUno;i++){
		g.drawImage(MenuCache.getSpriteCache().getSprite("vida.gif"),null,393+i,530);
		}
		
		g.setPaint(Color.red);
		g.fillArc(85, Stage.PLAY_HEIGHT+15, 30, 30, 0, player.getFuryAngle());

		
		
		if(NuevoJuego.nJugadores==2){	
			VidaDos= (int)((player2.shields/(float)player2.MAX_SHIELDS)*100);

			
			for(i=0;i<VidaDos;i++){
			g.drawImage(MenuCache.getSpriteCache().getSprite("vida.gif"),null,393+i,578);
			}
			
			
			
			
		g.setPaint(Color.red);
		g.fillArc(85, Stage.PLAY_HEIGHT+63, 30, 30, 0, player2.getFuryAngle());
		}


	}
	public void paintScore(Graphics2D g){
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.setPaint(Color.red);
		g.drawString(player.getScore()+"",225,Stage.PLAY_HEIGHT  + constanteMedida+18);
		
		if(NuevoJuego.nJugadores==2){
			g.setFont(new Font("Arial",Font.BOLD,20));
			g.setPaint(Color.red);
			g.drawString(player2.getScore()+"",225,Stage.PLAY_HEIGHT  + constanteMedida+68);
		}
	}
	
	public  void paintAmmo(Graphics2D g){

		
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.setPaint(Color.red);
		g.drawString("x"+player.getClusterBombs(),640,Stage.PLAY_HEIGHT  + constanteMedida+18);
		
		if(NuevoJuego.nJugadores==2){
			g.setFont(new Font("Arial",Font.BOLD,20));
			g.setPaint(Color.red);
			g.drawString("x"+player2.getClusterBombs(),640,Stage.PLAY_HEIGHT  + constanteMedida+68);
		}
	}
	public  void paintfps(Graphics2D g){
		g.setFont( new Font("Arial",Font.BOLD,12));
		g.setColor(Color.white);
		
		try {
			tiempoTarda=System.currentTimeMillis()-startTime;
			if(tiempoTarda<retardo){
				Thread.sleep(retardo-tiempoTarda);
			}
		} catch (InterruptedException e) {}
		startTime = System.currentTimeMillis();
		
		
		if (tiempoTarda > 0)
			g.drawString(String.valueOf(1000/tiempoTarda)+" fps",Stage.WIDTH-50,Stage.PLAY_HEIGHT);
		else
			g.drawString("--- fps",Stage.WIDTH-50,Stage.PLAY_HEIGHT);
	}
	


	
	
	public void paintStatus(Graphics2D g){
		
		g.drawImage(MenuCache.getSpriteCache().getSprite("placa.png"),null,0,500);
		
		if(NuevoJuego.nJugadores==2){
			g.drawImage(MenuCache.getSpriteCache().getSprite("placa.png"),null,0,548);
		}
		
		
		paintScore(g);
		paintAmmo(g);
		paintShields(g);
		paintfps(g);  
	}
	public synchronized void checkCollisions(){
		
		

			Rectangle playerBounds = player.getBounds();
			for (int i = 0; i < actors.size(); i++) {
				Actor a1 = (Actor)actors.get(i);
				Rectangle r1 = a1.getBounds();
				if (r1.intersects(playerBounds)) {
					player.collision(a1);
					a1.collision(player);
				}
				
				for (int j = i+1; j < actors.size(); j++) {
					Actor a2 = (Actor)actors.get(j);
					Rectangle r2 = a2.getBounds();
					if (r1.intersects(r2)) {
						a1.collision(a2);
						a2.collision(a1);
					}
				}
			}

		
		if(NuevoJuego.nJugadores==2){
			
			if(segundoVivo==1){
				Rectangle playerBounds2 = player2.getBounds();
				for (int i = 0; i < actors.size(); i++) {
					Actor a1 = (Actor)actors.get(i);
					Rectangle r1 = a1.getBounds();
					if (r1.intersects(playerBounds2)) {
						player2.collision(a1);
						a1.collision(player2);
					}

				}
			}
			
			
		}
		
	}
	public  void addActor(Actor a){
		actors.add(a);
	}
	public void gameOver (){
		gameEnded = true;
	}


	public void keyPressed(KeyEvent e){
		player.keyPressed(e);
		
		if(NuevoJuego.nJugadores==2){
			player2.keyPressed(e);
		}
	}
	public void keyReleased(KeyEvent e){
		player.keyReleased(e);
		if(NuevoJuego.nJugadores==2){
			player2.keyReleased(e);
		}
	}

	public void keyTyped(KeyEvent e) {

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
	
	
	public void play() {
		jugar();
	}

	public abstract void jugar();
	
	public void limpiaMemo(){
		actors.clear();
		this.getSpriteCache().limpiarCache();
	}
	
	public void mensajesTwitter(int variable){
		if (variable==1){
			try {
				Opciones.twitter1.updateStatus("He vencido en "+Opciones.nombreMisiones[idMission-1]+" con la nave "+ Opciones.naves[player.numero-1]+" con "+ player.score+" puntos");
			} catch (TwitterException e) {
			}
			if(NuevoJuego.nJugadores==2){
				try {
					Opciones.twitter2.updateStatus("He vencido en "+Opciones.nombreMisiones[idMission-1]+" con la nave "+ Opciones.naves[player2.numero-1]+" con "+ player2.score+" puntos");
				} catch (TwitterException e) {
				}
			}
		}
		if(variable==2){
			try {
				Opciones.twitter1.updateStatus("Me han machacado en "+Opciones.nombreMisiones[idMission-1]+" con la nave "+ Opciones.naves[player.numero-1]+" con "+ player.score+" puntos");
			} catch (TwitterException e) {
			}
			
			if(NuevoJuego.nJugadores==2){
				try {
					Opciones.twitter2.updateStatus("Me han machacado en "+Opciones.nombreMisiones[idMission-1]+" con la nave "+ Opciones.naves[player2.numero-1]+" con "+ player2.score+" puntos");
				} catch (TwitterException e) {
				}
			}
		}
	}
	
}