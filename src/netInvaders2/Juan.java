package netInvaders2;

import java.awt.event.KeyEvent;

public class Juan extends Player {
	public static int ataque;
	int i;
	
	public Juan(Stage stage,int jugador) {
		super(stage);
		setSpriteNames( new String[] {"naves/GreenSnaug.png"});
		nJugador=jugador;
		//setFrameSpeed (1);
		this.ataque=8;
		this.PLAYER_SPEED = 4 * 2;
		this.MAX_SHIELDS = 5 * 100;
		this.clusterBombs=1 * 2;
		
		this.clusterMax=2;
		this.numero=4;
		shields = MAX_SHIELDS;
		
		for(i=1;i<=13;i++){
		spriteCache.getSprite("disparos/especialLoki/especialNaveLoki"+i+".gif");
		}
	}

	public void act() {
		super.act();
		if(vx>0){
			setSpriteNames( new String[] {"naves/GreenSnaugGiroDer.png"});
		}
		if(vx<0){
			setSpriteNames( new String[] {"naves/GreenSnaugGiroIzq.png"});
		}
		if(vx==0){
			setSpriteNames( new String[] {"naves/GreenSnaug.png"});
		}
		
		
	}

	public void special(){
		if(fuegoDisponible==1){
		Bullet b = new BalaJuanFinal(stage,nJugador);
		b.setX(x-240);
		b.setY(y - b.getHeight()+250);
		stage.addActor(b);
		stage.getSoundCache().playSound("sonidos/jesusshot.wav");
		}
	}

	public void fire() {
		if(fuegoDisponible==1){
			int i;
			int j=combo;

			if(tiempodisparo>=4){
				tiempodisparo=0;
				for(i=0;i<combo;i++){
					disparosRealizados++;
					Bullet b = new BalaJuan(stage,nJugador);
					b.setX((x+20-((i+j)*2))+i*7);
					b.setY(y - b.getHeight());
					stage.addActor(b);
					stage.getSoundCache().playSound("sonidos/jesusshot.wav");		
				}
			}
		}
	}

}
