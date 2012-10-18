package netInvaders2;


    public class BalaAdam extends Bullet {
	protected static final int BULLET_SPEED=20;
    
    
    public BalaAdam(Stage stage,int nJugador) {
    	super(stage);
    	setSpriteNames( new String[] {"disparos/DisparokipperShip.gif"});
    	jugadorDispara=nJugador;
    	
  
    }
    
    public void act() {
    	super.act();
    	y-=((Fase.tiempoTarda*BULLET_SPEED)/Fase.retardo)/2;
    	if (y < 0){
    		remove();
    	Adam.disparosFallados++;
    	}
    	
    }
    
    
 
	
	public int getJugador() {   return jugadorDispara; }
	


}