package netInvaders2;

    
public class BalaJefe extends BalaEnemiga {
	protected static final int BULLET_SPEED=12;
    
	public BalaJefe(Stage stage) {
		super(stage);
		setSpriteNames( new String[] {"disparos/balajefe.gif"});
		setFrameSpeed(10);
	}
    
	
    public void act() {
    	super.act();
		y+=((Fase.tiempoTarda*BULLET_SPEED)/Fase.retardo)/2;
    	if (y > Stage.PLAY_HEIGHT)
    		remove();
    }
}
    