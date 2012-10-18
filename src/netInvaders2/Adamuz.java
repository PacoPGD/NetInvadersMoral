package netInvaders2;

import java.awt.event.KeyEvent;

public class Adamuz extends Player {
	
	public static int ataque;
	
	
	public Adamuz(Stage stage,int jugador) {
		super(stage);
		setSpriteNames( new String[] {"naves/AdamuzSurfer.png"});
		nJugador=jugador;
		//setFrameSpeed (1);
		this.ataque=10;
		this.PLAYER_SPEED = 10 * 2;
		this.MAX_SHIELDS = 10 * 100;
		this.clusterBombs=5 * 2;
		this.clusterMax=10;
		
		this.numero=10;
		
		
		shields = MAX_SHIELDS;
	}

	
	
	public void act() {
		super.act();
	}
	
	public void special(){
		if(fuegoDisponible==1){

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
					Bullet b = new BalaAdamuz(stage,nJugador);
					b.setX((x+13-((i+j)*2))+i*7);
					b.setY(y - b.getHeight());
					stage.addActor(b);
					stage.getSoundCache().playSound("sonidos/jesusshot.wav");		
				}
			}
		}
	}

}