package netInvaders2;

import java.awt.event.KeyEvent;

public class Jesus extends Player {

	public static int ataque;
	public Jesus(Stage stage,int jugador) {
		super(stage);
		setSpriteNames( new String[] {"naves/BlueFang.png"});
		//spriteCache.getSprite("naves/naveJesus.png");


		nJugador=jugador;
		this.ataque=5;
		this.PLAYER_SPEED = 6 * 2;
		this.MAX_SHIELDS = 7 * 100;
		this.clusterBombs=0 * 2;
		this.clusterMax=0;
		this.numero=3;
	
		shields = MAX_SHIELDS;
	}

	public void act() {
		super.act();
		if(vx>0){
			setSpriteNames( new String[] {"naves/BlueFangGiroDer.png"});
		}
		if(vx<0){
			setSpriteNames( new String[] {"naves/BlueFangGiroIzq.png"});
		}
		if(vx==0){
			setSpriteNames( new String[] {"naves/BlueFang.png"});
		}
	}
	

	public void special(){
		if(fuegoDisponible==1){
		Bullet b = new BalaJesusFinal(stage,nJugador);
		b.setX(x-19);
		b.setY(y-20);
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
					Bullet b = new BalaJesus(stage,nJugador);
					b.setX((x+13-((i+j)*2))+i*7);
					b.setY(y - b.getHeight());
					stage.addActor(b);
					stage.getSoundCache().playSound("sonidos/jesusshot.wav");		
				}
			}
		}
	}


	
	

	
	

}
