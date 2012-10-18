package netInvaders2;

public class PaqueteCombustible extends Actor {
	protected static final int BULLET_SPEED=10;
    public int vx;
    public int vy;
	
	public PaqueteCombustible(Stage stage) {
		super(stage);
		Mission4.totales++;
		setSpriteNames( new String[] {"bola1.png"});
		setFrameSpeed(10);
	}
    
    public void act() {
    	super.act();
		x+=((Fase.tiempoTarda*vx)/Fase.retardo)/2;
		y+=((Fase.tiempoTarda*vy)/Fase.retardo)/2;
    	
		
		if (x < 0 || x > Stage.WIDTH-32)
		  vx = -vx;
    	
    	
    	if (y > Stage.PLAY_HEIGHT)
    		remove();
    }
    
    
    public void setVx(int i) {vx = i;	}
    public void setVy(int i) {vy = i;  }
}

