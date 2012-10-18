package netInvaders2;

public class LobogrisBot extends Bot  {

	public static int vx;
	public static int vy;
	public static int ataque=5;
	
	
	public LobogrisBot(Stage stage) {
		super(stage);
		setSpriteNames( new String[] {"naves/GreyWolf.png"});
		setFrameSpeed (35);
		this.FIRING_FREQUENCY=0.1;
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
		

		
		
		if(vx>0){
			setSpriteNames( new String[] {"naves/GreyWolfGiroDer.png"});
		}
		if(vx<0){
			setSpriteNames( new String[] {"naves/GreyWolfGiroIzq.png"});
		}
		if(vx==0){
			setSpriteNames( new String[] {"naves/GreyWolf.png"});
		}
		
		if (Math.random()<FIRING_FREQUENCY)
			fire();
	}
	
	
	public int getVx() { return vx; }
	public void setVx(int i) {vx = i;	}
	public int getVy() { return vy; }
	public void setVy(int i) {vy = i;  }

		
	public void fire() {
		if(fuegoDisponible==1){
			int i;
			int j=combo;

				for(i=0;i<combo;i++){
					Bullet b = new BalaLobogris(stage,3);
					b.setX((x+13-((i+j)*2))+i*7);
					b.setY(y - b.getHeight());
					stage.addActor(b);
					stage.getSoundCache().playSound("sonidos/jesusshot.wav");		
				}
			
		}
	}
	
}