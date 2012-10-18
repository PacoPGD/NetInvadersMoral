package netInvaders2;


public class Adam extends Player {
	public static int ataque;
	public Adam(Stage stage,int jugador) {
		super(stage);
		setSpriteNames( new String[] {"naves/KipperShip.png"});
		nJugador=jugador;
		//setFrameSpeed (1);
		this.ataque=4;
		this.PLAYER_SPEED = 4 * 2;
		this.MAX_SHIELDS = 5 * 100;
		this.clusterBombs=5 * 2;
		
		this.clusterMax=10;
		this.numero=6;
		
		
		shields = MAX_SHIELDS;
	}

	
	
	public void act() {
		super.act();
		
		if(vx>0){
			setSpriteNames( new String[] {"naves/KipperShipGiroDer.png"});
		}
		if(vx<0){
			setSpriteNames( new String[] {"naves/KipperShipGiroIzq.png"});
		}
		if(vx==0){
			setSpriteNames( new String[] {"naves/KipperShip.png"});
		}
	}
	
	public void special(){
		if(fuegoDisponible==1){
			clusterBombs++;
			clusterBombs++;
			clusterBombs++;
			clusterBombs++;
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
					Bullet b = new BalaAdam(stage,nJugador);
					b.setX((x+13-((i+j)*2))+i*7);
					b.setY(y - b.getHeight());
					stage.addActor(b);
					stage.getSoundCache().playSound("sonidos/jesusshot.wav");		
				}
			}
		}
	}

}