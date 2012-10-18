package netInvaders2;


public class MonsterDefender extends Monster {

	
	public MonsterDefender(Stage stage) {
		super(stage);
		setSpriteNames( new String[] {"naves/defensor.gif"});
		setFrameSpeed (35);
		this.vida=100;
		this.puntosAObtener=5000;
		this.furiaAObtener=10;
		this.FIRING_FREQUENCY=0.05;
	}
	
	public void act() {
		super.act();
		x+=((Fase.tiempoTarda*vx)/Fase.retardo)/2;
		y+=((Fase.tiempoTarda*vy)/Fase.retardo)/2;
		
		if (x < 0 && vx<0){
			  vx = -vx;
			}
			if(x>Stage.WIDTH-32 && vx>0){
				vx = -vx;
			}
			
		if (y > Stage.HEIGHT || y < 0){
			remove();
		}

	}


		
	public void fire() {
	}


}