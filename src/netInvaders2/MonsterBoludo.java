package netInvaders2;


public class MonsterBoludo extends Monster {

	
	public MonsterBoludo(Stage stage) {
		super(stage);
		setSpriteNames( new String[] {"naves/naveboluda.png"});
		setFrameSpeed (35);
		this.vida=100;
		this.puntosAObtener=5000;
		this.furiaAObtener=1;
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
		
		if (Math.random()<FIRING_FREQUENCY)
			fire();
	}


		
	public void fire() {
		LaserBola m = new LaserBola(stage,1);
		m.setX(x+getWidth()-30);
		m.setY(y + getHeight());
		stage.addActor(m);
		stage.getSoundCache().playSound("sonidos/photon.wav");
	}


}