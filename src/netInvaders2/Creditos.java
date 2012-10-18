package netInvaders2;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.event.KeyEvent;


public class Creditos extends  Fase {

	public int superI;
	
	public Creditos() {
		super();
	}


	public void jugar() {
		usedTime=1000;
		//eventTime,nuevotime;
		t=0;
		int i;
		int contador1=0;  
		int contador2=0;
		int vidaMonster=1;

		
		initWorld(); 
		soundCache.PlaySongMp3("musica/Dream End.mp3",true);

		long nuevoTime = System.currentTimeMillis();
		long fichaTiempo = 0;



		while (isVisible() && !gameEnded) {
			t=t-1;
			long startTime = System.currentTimeMillis();
			updateWorld();
			checkCollisions();
			paintWorld();
			usedTime = System.currentTimeMillis()-startTime;

			eventTime = System.currentTimeMillis()-nuevoTime;

			if(fichaTiempo < (int)(eventTime/100)){
				contador1++;
				superI--;
				if(contador1==1){
					
					Actor m = new imageInvaders(this);
					m.setX(-10 ) ;
					m.setY( 0 );
					actors.add(m);
				}


				
				
				if(contador1==250){
					Bot m = new RafaBot(this);
					m.setX(285);
					m.setY(600);
					m.setVx(0);
					m.setVy(-4);
					actors.add(m);
				}
				
				if(contador1==270){
					RafaBot.vy=-2;
					RafaBot.vx=2;
				}
				if(contador1==285){
					RafaBot.vy=0;
					RafaBot.vx=0;
				}
				
				
				if(contador1==450){
					Bot m = new PacoBot(this);
					m.setX(285);
					m.setY(600);
					m.setVx(0);
					m.setVy(-4);
					actors.add(m);
				}
				
				if(contador1==470){
					PacoBot.vy=-2;
					PacoBot.vx=0;
				}
				if(contador1==480){
					PacoBot.vy=0;
					PacoBot.vx=0;
				}
				
				
				if(contador1==550){
					Bot m = new JesusBot(this);
					m.setX(485);
					m.setY(600);
					m.setVx(0);
					m.setVy(-4);
					actors.add(m);
				}
				
				if(contador1==570){
					JesusBot.vy=-2;
					JesusBot.vx=0;
				}
				if(contador1==580){
					JesusBot.vy=0;
					JesusBot.vx=0;
				}
				
				
				if(contador1==650){
					Bot m = new JuanBot(this);
					m.setX(285);
					m.setY(600);
					m.setVx(0);
					m.setVy(-4);
					actors.add(m);
				}
				
				if(contador1==660){
					JuanBot.vy=-2;
					JuanBot.vx=1;
				}
				if(contador1==670){
					JuanBot.vy=0;
					JuanBot.vx=0;
				}
				
				if(contador1==750){
					Bot m = new LobogrisBot(this);
					m.setX(485);
					m.setY(600);
					m.setVx(0);
					m.setVy(-4);
					actors.add(m);
				}
				
				if(contador1==762){
					LobogrisBot.vy=-2;
					LobogrisBot.vx=-1;
				}
				if(contador1==770){
					LobogrisBot.vy=0;
					LobogrisBot.vx=0;
				}
				
				
				if(contador1==750){
					Bot m = new LobogrisBot(this);
					m.setX(485);
					m.setY(600);
					m.setVx(0);
					m.setVy(-4);
					actors.add(m);
				}
				
				if(contador1==762){
					LobogrisBot.vy=-2;
					LobogrisBot.vx=-1;
				}
				if(contador1==770){
					LobogrisBot.vy=0;
					LobogrisBot.vx=0;
				}
				
				
				
				if(contador1==850){
					Bot m = new AngelBot(this);
					m.setX(200);
					m.setY(600);
					m.setVx(0);
					m.setVy(-8);
					actors.add(m);
					
					Bot a = new AdamBot(this);
					a.setX(550);
					a.setY(600);
					a.setVx(0);
					a.setVy(-7);
					actors.add(a);
					
				}
				
				if(contador1==860){
					AngelBot.vy=0;
					AngelBot.vx=0;
					AdamBot.vy=0;
					AdamBot.vx=0;
				}
				
				
				
				if(player.escape==true){
					soundCache.StopSongMp3();
					this.limpiaMemo();
					NuevoJuego.getNuevoJuego().playComponent((Component)NuevoJuego.getNuevoJuego().getMainMenu(), 1000);
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
		

		Charla.getCharla().paint(g);

		
		g.setFont(new Font("Arial",Font.BOLD,50));
		g.setPaint(Color.red);
		g.drawString("Muchas gracias por jugar",100,superI*2+620);
		g.setFont(new Font("Arial",Font.BOLD,25));
		g.setPaint(Color.green);
		g.drawString("Idea original creada y realizada por:",130,superI*2+680);
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.setPaint(Color.white);
		g.drawString("Pakiyopgd",130,superI*2+700);
		g.setFont(new Font("Arial",Font.BOLD,25));
		g.setPaint(Color.green);
		g.drawString("Programacion:",130,superI*2+770);
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.setPaint(Color.white);
		g.drawString("Pakiyopgd",130,superI*2+790);
		g.setFont(new Font("Arial",Font.BOLD,25));
		g.setPaint(Color.green);
		g.drawString("Artista2D:",130,superI*2+840);
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.setPaint(Color.white);
		g.drawString("Enano007jr",130,superI*2+860);
		g.setFont(new Font("Arial",Font.BOLD,25));
		g.setPaint(Color.green);
		g.drawString("Música:",130,superI*2+910);
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.setPaint(Color.white);
		g.drawString("Peergynt Lobogris",130,superI*2+930);
		
		g.setFont(new Font("Arial",Font.BOLD,25));
		g.setPaint(Color.green);
		g.drawString("Programación adicional:",130,superI*2+980);
		
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.setPaint(Color.white);
		g.drawString("Rafael Muñoz",130,superI*2+1000);
		
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.setPaint(Color.white);
		g.drawString("Enano007jr",130,superI*2+1020);
		
		g.setFont(new Font("Arial",Font.BOLD,25));
		g.setPaint(Color.green);
		g.drawString("Desarrollo del sitio web:",130,superI*2+1060);
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.setPaint(Color.white);
		g.drawString("www.netinvaders.isgreat.org por Enano007jr",130,superI*2+1080);
		
		
		g.setFont(new Font("Arial",Font.BOLD,25));
		g.setPaint(Color.green);
		g.drawString("Doblaje:",130,superI*2+1200);
		
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.setPaint(Color.white);
		g.drawString("RedStar: Quero ",130,superI*2+1220);
		g.drawString("Cless Trake: Pakiyopgd ",130,superI*2+1240);
		g.drawString("Xavier L: Enano007jr ",130,superI*2+1260);
		g.drawString("John J Snaug: Juan Loki ",130,superI*2+1280);
		g.drawString("Angel Blacksmith: FourRoses ",130,superI*2+1300);
		g.drawString("Adam West: Adam",130,superI*2+1320);
		g.drawString("Peergynt GreyWolf: Peergynt Lobogris",130,superI*2+1340);
		g.drawString("Pdamon: Pakiyopgd ",130,superI*2+1360);
		g.drawString("Salvador: Rafa Amaro",130,superI*2+1380);
		g.drawString("Joaquin: Llongueras",130,superI*2+1400);
		g.drawString("Adrog: Enano007jr ",130,superI*2+1420);
		g.drawString("Adamuz: Bongo",130,superI*2+1440);
		g.drawString("Programador .net 1: >J.C<",130,superI*2+1460);
		g.drawString("Programador .net 2: Gabi Wxp ",130,superI*2+1480);
		g.drawString("Teleco: Pakiyopgd ",130,superI*2+1500);
		
		g.setFont(new Font("Arial",Font.BOLD,25));
		g.setPaint(Color.green);
		g.drawString("Edicion de sonido:",130,superI*2+1550);
		
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.setPaint(Color.white);
		g.drawString("Pakiyopgd",130,superI*2+1570);
		
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.setPaint(Color.white);
		g.drawString("Enano007jr",130,superI*2+1590);
		
		g.setFont(new Font("Arial",Font.BOLD,25));
		g.setPaint(Color.green);
		g.drawString("Agradecimientos:",130,superI*2+1640);
		
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.setPaint(Color.white);
		g.drawString("Programadores Pelirrojos",130,superI*2+1660);
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.setPaint(Color.white);
		g.drawString("Elotrolado.net",130,superI*2+1680);
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.setPaint(Color.white);
		g.drawString("El rincon del C",130,superI*2+1700);
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.setPaint(Color.white);
		g.drawString("El hacker",130,superI*2+1720);
		
		for (int i = 0; i < actors.size(); i++) {
			
			Actor m = (Actor)actors.get(i);
			m.paint(g);
		}

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