package netInvaders2;


    public class BalaPaco extends Bullet {
	protected static final int BULLET_SPEED=30;
    
    
    public BalaPaco(Stage stage,int nJugador) {
    	super(stage);
    	setSpriteNames( new String[] {"disparos/disparoPaco1.png"});
    	jugadorDispara=nJugador;
    	
  
    }
    
    public void act() {
    	super.act();
		y-=((Fase.tiempoTarda*BULLET_SPEED)/Fase.retardo)/2;
    	if (y < 0){
    		remove();
    	Paco.disparosFallados++;
    	}
    	
    }
    
    
 
	
	public int getJugador() {   return jugadorDispara; }
	


}