package netInvaders2;

    
public class LaserAdamuz extends BalaEnemiga {
	protected static final int BULLET_SPEED=10;
    int tiempo;
	public LaserAdamuz(Stage stage) {
		super(stage);
		setSpriteNames( new String[] {"disparos/rayoHielo.png"});
		setFrameSpeed(5);
	}
    
    public void act() {
    	super.act();

    	tiempo++;
    	if(tiempo==20){
    		remove();
    	}
    }
}
    