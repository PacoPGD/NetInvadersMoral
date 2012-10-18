package netInvaders2;

    
public class LaserArriba extends BalaEnemiga {
	protected static final int BULLET_SPEED=10;
    
	public LaserArriba(Stage stage) {
		super(stage);
			setSpriteNames( new String[] {"disparos/balaPeque/Arriba.png"});
	}
    

	
	
    public void act() {
    	super.act();
		y-=((Fase.tiempoTarda*BULLET_SPEED)/Fase.retardo)/2;
    	if (y < 0)
    		remove();
    }
}
    