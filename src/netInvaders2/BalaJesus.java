package netInvaders2;

    
public class BalaJesus extends Bullet {
	protected static final int BULLET_SPEED=20;
   
    
    public BalaJesus(Stage stage,int nJugador) {
    	super(stage);
    	setSpriteNames( new String[] {"disparos/jesusBala/jesusBala1.png","disparos/jesusBala/jesusBala2.png"});
    	setFrameSpeed(5);
    	jugadorDispara=nJugador;
  
    }
    
    public void act() {
    	super.act();
    	y-=((Fase.tiempoTarda*BULLET_SPEED)/Fase.retardo)/2;
    	if (y < 0){
    		remove();
    	Jesus.disparosFallados++;	
    	}
    	
    }
    
    

	
	public int getJugador() {   return jugadorDispara; }

}