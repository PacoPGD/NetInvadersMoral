package netInvaders2;

    
public class BalaRafa extends Bullet {
	protected static final int BULLET_SPEED=30;
	 
	  
    public BalaRafa(Stage stage,int nJugador) {
    	super(stage);
    	setSpriteNames( new String[] {"disparos/fireBolt.gif"});
    	jugadorDispara=nJugador;
    	
  
    }
    
    public void act() {
    	super.act();
    	y-=((Fase.tiempoTarda*BULLET_SPEED)/Fase.retardo)/2;
    	if (y < 0){
    		remove();
    	Rafa.disparosFallados++;	
    	}
    	
    }
    
    
   
	
	
	public int getJugador() {   return jugadorDispara; }

}