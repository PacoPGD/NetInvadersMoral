package netInvaders2;

    
public class BalaPortaBicis extends BalaEnemiga {
	protected static final int BULLET_SPEED=20;
    
	public BalaPortaBicis(Stage stage) {
		super(stage);
		setSpriteNames( new String[] {"disparos/DisparoPortaBicis.gif"});
		setFrameSpeed(10);
	}
    
    public void act() {
    	super.act();
		x+=((Fase.tiempoTarda*BULLET_SPEED)/Fase.retardo)/2;
    	if (x < 0 || x > Stage.WIDTH-32)
    		remove();
    }
}
    