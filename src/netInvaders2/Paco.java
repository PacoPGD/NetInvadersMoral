package netInvaders2;

import java.awt.event.KeyEvent;

public class Paco extends Player {
	
	public static int ataque;
	
	
	public Paco(Stage stage,int jugador) {
		super(stage);
		setSpriteNames( new String[] {"naves/WhiteGaleon.png"});
		nJugador=jugador;
		//setFrameSpeed (1);
		this.ataque=7;
		this.PLAYER_SPEED = 5 * 2;
		this.MAX_SHIELDS = 6 * 100;
		this.clusterBombs=0 * 2;
		this.clusterMax=0;
		this.numero=2;
		
		
		shields = MAX_SHIELDS;
	}

	
	
	public void act() {
		super.act();
		
		if(vx>0){
			setSpriteNames( new String[] {"naves/WhiteGaleonGiroDer.png"});
		}
		if(vx<0){
			setSpriteNames( new String[] {"naves/WhiteGaleonGiroIzq.png"});
		}
		if(vx==0){
			setSpriteNames( new String[] {"naves/WhiteGaleon.png"});
		}
	}
	
	public void special(){
		if(fuegoDisponible==1){
		Bullet b = new BalaPacoFinal(stage,nJugador);
		b.setX(x-90);
		b.setY(y - b.getHeight());
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
					Bullet b = new BalaPaco(stage,nJugador);
					b.setX((x+13-((i+j)*2))+i*7);
					b.setY(y - b.getHeight());
					stage.addActor(b);
					stage.getSoundCache().playSound("sonidos/jesusshot.wav");		
				}
			}
		}
	}

}
