package netInvaders2;


public class MonsterLateral extends Monster {
	boolean direccion;
	
	public MonsterLateral(Stage stage,boolean derecha) {
		super(stage);
		if(derecha==true){
		setSpriteNames( new String[] {"naves/naveLateral/naveLateral1.png","naves/naveLateral/naveLateral2.png","naves/naveLateral/naveLateral3.png","naves/naveLateral/naveLateral4.png"});
		}
		else{
		setSpriteNames( new String[] {"naves/naveLateral/izquierdo1.png","naves/naveLateral/izquierdo2.png","naves/naveLateral/izquierdo3.png","naves/naveLateral/izquierdo4.png"});
		}
		this.vida=30;
		this.puntosAObtener=3000;
		this.furiaAObtener=5;
		this.FIRING_FREQUENCY=0.07;
		direccion=derecha;
	}
	
	public void act() {
		super.act();
		y+=((Fase.tiempoTarda*vy)/Fase.retardo)/2;
		
		if(direccion==true){
			x=0;
		}
		else{
			x=Stage.WIDTH-50;
		}


		if (y > Stage.HEIGHT-200 || y < 0){
			vy=-vy;
		}
		
		if (y<0 && vy<0){
			  vy = -vy;
			}
		
			if(y>Stage.HEIGHT-200 && vy>0){
				vy = -vy;
			}
		
		
		if (Math.random()<FIRING_FREQUENCY)
			fire();
	}


		
	public void fire() {
		BalaEnemiga m = new BalaLateral(stage,direccion);
		if(direccion==true){
		m.setX(x+getWidth()/2);
		m.setY(y + getHeight());
		}
		else{
			m.setX(x-20+getWidth()/2);
			m.setY(y + getHeight());
		}
		stage.addActor(m);
		stage.getSoundCache().playSound("sonidos/photon.wav");
	}


}