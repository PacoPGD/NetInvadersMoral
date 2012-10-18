package netInvaders2;


public class MonsterGeneric2 extends Monster {

	
	public MonsterGeneric2(Stage stage) {
		super(stage);
		setSpriteNames( new String[] {"naves/genericoteleco.png"});
		setFrameSpeed (35);
		this.vida=20;
		this.puntosAObtener=1500;
		this.furiaAObtener=2;
		this.FIRING_FREQUENCY=0.15;
	}
	
	public MonsterGeneric2(Stage stage,int modo) {
		super(stage);
		setSpriteNames( new String[] {"naves/genericoteleco.png"});
		setFrameSpeed (35);
		this.vida=20;
		this.puntosAObtener=1500;
		this.furiaAObtener=2;
		this.FIRING_FREQUENCY=0.15;
		
		try{
			Mission6.bandera=1;
		}
		catch(Exception e){}
	}

	public MonsterGeneric2(Stage stage,int vida,int puntos) {
		super(stage);
		setSpriteNames( new String[] {"naves/genericoteleco.png"});
		setFrameSpeed (35);
		this.vida=20;
		this.puntosAObtener=puntos;
		this.furiaAObtener=2;
		this.FIRING_FREQUENCY=0.15;
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
			
			if(Fase.idMission==6){
				Mission6.bandera=2;
			}
			
		}
		
		if (Math.random()<FIRING_FREQUENCY)
			fire();
	}


		
	public void fire() {
		Laser m = new Laser(stage);
		m.setX(x+getWidth()/2);
		m.setY(y + getHeight());
		stage.addActor(m);
		stage.getSoundCache().playSound("sonidos/photon.wav");
	}


}