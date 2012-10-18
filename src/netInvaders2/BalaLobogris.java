package netInvaders2;


    public class BalaLobogris extends Bullet {
	protected static final int BULLET_SPEED=30;
    
    
    public BalaLobogris(Stage stage,int nJugador) {
    	super(stage);
    	setSpriteNames( new String[] {"disparos/disparoLobogris/disparoLoboGris1.png","disparos/disparoLobogris/disparoLoboGris2.png","disparos/disparoLobogris/disparoLoboGris3.png","disparos/disparoLobogris/disparoLoboGris4.png"});
    	jugadorDispara=nJugador;
    	
  
    }
    
    public void act() {
    	super.act();
    	y-=((Fase.tiempoTarda*BULLET_SPEED)/Fase.retardo)/2;
    	if (y < 0){
    		remove();
    	Lobogris.disparosFallados++;
    	}
    	
    }
    
    
 
	
	public int getJugador() {   return jugadorDispara; }
	


}