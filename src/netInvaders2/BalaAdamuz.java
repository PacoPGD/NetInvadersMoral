package netInvaders2;

    
public class BalaAdamuz extends Bullet {
	protected static final int BULLET_SPEED=30;

	  
    public BalaAdamuz(Stage stage,int nJugador) {
    	super(stage);
    	setSpriteNames( new String[] {"disparos/shuriken/shuriken1.png","disparos/shuriken/shuriken2.png","disparos/shuriken/shuriken3.png"});
    	jugadorDispara=nJugador;
  
    }
    
    public void act() {
    	super.act();
    	y-=((Fase.tiempoTarda*BULLET_SPEED)/Fase.retardo)/2;
    	if (y < 0){
    		remove();
    	Adamuz.disparosFallados++;	
    	}
    	
    }
    

	
	public int getJugador() {   return jugadorDispara; }

}