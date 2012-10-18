package netInvaders2;


public class MonsterDesplazable extends Monster {

	
	public MonsterDesplazable(Stage stage) {
		super(stage);
		setSpriteNames( new String[] {"Jefes/Jefazo/desplazable.gif"});
		setFrameSpeed (35);
		this.vida=3000;
		this.puntosAObtener=0;
		this.furiaAObtener=0;
		this.FIRING_FREQUENCY=0.05;
	}
	

	
	public void act() {
		super.act();
		x+=((Fase.tiempoTarda*vx)/Fase.retardo)/2;
		y+=((Fase.tiempoTarda*vy)/Fase.retardo)/2;
		
		if (x < 250 && vx<0){
		  vx = -vx;
		}
		if(x>500 && vx>0){
			vx = -vx;
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