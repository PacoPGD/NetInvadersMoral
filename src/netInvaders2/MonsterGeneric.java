package netInvaders2;


public class MonsterGeneric extends Monster {

	
	public MonsterGeneric(Stage stage) {
		super(stage);
		setSpriteNames( new String[] {"naves/generico.png"});
		setFrameSpeed (35);
		this.vida=10;
		this.puntosAObtener=500;
		this.furiaAObtener=1;
		this.FIRING_FREQUENCY=0.05;
	}
	
	public MonsterGeneric(Stage stage,int frecuencia) {
		super(stage);
		setSpriteNames( new String[] {"naves/generico.png"});
		setFrameSpeed (35);
		this.vida=10;
		this.puntosAObtener=500;
		this.furiaAObtener=1;
		this.FIRING_FREQUENCY=frecuencia;
	}
	
	public MonsterGeneric(Stage stage,int frecuencia,int puntos) {
		super(stage);
		setSpriteNames( new String[] {"naves/generico.png"});
		setFrameSpeed (35);
		this.vida=10;
		this.puntosAObtener=puntos;
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
		Laser m = new Laser(stage,1);
		m.setX(x+getWidth()/2);
		m.setY(y + getHeight());
		stage.addActor(m);
		stage.getSoundCache().playSound("sonidos/photon.wav");
	}


}