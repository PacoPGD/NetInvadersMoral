package netInvaders2;

    
public class Laser extends BalaEnemiga {
	protected static final int BULLET_SPEED=10;
    
	public Laser(Stage stage) {
		super(stage);
		setSpriteNames( new String[] {"disparos/disparo3.gif"});
		setFrameSpeed(10);
	}
    
	public Laser(Stage stage,int color) {
		super(stage);
		if(color==1){
		setSpriteNames( new String[] {"disparos/balaPeque/Bala1.png"});
		}
		if(color==2){
			setSpriteNames( new String[] {"disparos/balaPeque/Abajo.png"});
		}
	}
	
    public void act() {
    	super.act();
		y+=((Fase.tiempoTarda*BULLET_SPEED)/Fase.retardo)/2;
    	if (y > Stage.PLAY_HEIGHT)
    		remove();
    }
}
    