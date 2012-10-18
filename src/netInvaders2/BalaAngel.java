package netInvaders2;


    public class BalaAngel extends Bullet {
	protected static final int BULLET_SPEED=30;
    
    
    public BalaAngel(Stage stage,int nJugador) {
    	super(stage);
    	setSpriteNames( new String[] {"disparos/disparoSonic.png"});
    	jugadorDispara=nJugador;
    	
  
    }
    
    public void act() {
    	super.act();
    	y-=((Fase.tiempoTarda*BULLET_SPEED)/Fase.retardo)/2;
    	if (y < 0){
    		remove();
    	Angel.disparosFallados++;
    	}
    	
    }
    
    
 
	
	public int getJugador() {   return jugadorDispara; }
	


}