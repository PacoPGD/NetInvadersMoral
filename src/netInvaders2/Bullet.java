package netInvaders2;

    
public abstract class Bullet extends Actor {
	protected static final int BULLET_SPEED=30;
	public int jugadorDispara;
	
	
    public Bullet(Stage stage) {
    	super(stage);
    	//setSpriteNames( new String[] {"disparos/disparo.gif"});
    	
  
    }
    
    public void act() {
    	super.act();

    }
    
	public void collision(Actor a) {
		if (a instanceof Monster || a instanceof JefeFinal) {
			Chispas chispa = new Chispas(stage);
			chispa.setX(x);
			chispa.setY(y);

			stage.addActor(chispa);
			
			remove();
		}
	}   
	
	public abstract int getJugador();

}
  