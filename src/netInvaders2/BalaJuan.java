package netInvaders2;


    public class BalaJuan extends Bullet {
	protected static final int BULLET_SPEED=30;
    
    
    public BalaJuan(Stage stage,int nJugador) {
    	super(stage);
    	setSpriteNames( new String[] {"disparos/disparoLoki/disparo1.png","disparos/disparoLoki/disparo2.png","disparos/disparoLoki/disparo3.png","disparos/disparoLoki/disparo4.png","disparos/disparoLoki/disparo5.png","disparos/disparoLoki/disparo6.png"});
    	jugadorDispara=nJugador;
    	
  
    }
    
    public void act() {
    	super.act();
    	y-=((Fase.tiempoTarda*BULLET_SPEED)/Fase.retardo)/2;
    	if (y < 0){
    		remove();
    	Juan.disparosFallados++;	
    	}
    	
    }
    
 
	
	public int getJugador() {   return jugadorDispara; }
	


}