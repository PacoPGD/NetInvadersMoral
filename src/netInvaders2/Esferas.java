package netInvaders2;

public class Esferas extends Actor {
	protected static final int BULLET_SPEED=10;
    
	public Esferas(Stage stage) {
		super(stage);
		setSpriteNames( new String[] {"disparos/esfera.gif","disparos/esfera2.gif"});
		setFrameSpeed(10);
	}
    
    public void act() {
    	super.act();
    	y+=BULLET_SPEED;
    	if (y > Stage.PLAY_HEIGHT)
    		remove();    	
    }
}