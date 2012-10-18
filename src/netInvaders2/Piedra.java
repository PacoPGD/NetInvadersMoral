package netInvaders2;



public class Piedra extends Monster {

	
	public Piedra(Stage stage) {
		super(stage);
		setSpriteNames( new String[] {"naves/meteorito1.gif","naves/meteorito2.gif","naves/meteorito3.gif","naves/meteorito4.gif","naves/meteorito5.gif"});

		setFrameSpeed (2);
		this.vida=5;
		this.puntosAObtener=100;
		this.furiaAObtener=1;
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
			
			
			
		if (y > Stage.PLAY_HEIGHT+10 || y < 0){
			remove();
		}
		
	}

	public int getVx() { return vx; }
	public void setVx(int i) {vx = i;	}
	public int getVy() { return vy; }
	public void setVy(int i) {vy = i;  }


		

}