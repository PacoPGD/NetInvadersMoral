package netInvaders2;

    
public class BalaLateral extends BalaEnemiga {
	protected static final int BULLET_SPEED=10;
    boolean direccion;
	
	public BalaLateral(Stage stage, boolean derecha) {
		super(stage);
		setSpriteNames( new String[] {"disparos/balaLateral/disparo1.png","disparos/balaLateral/disparo2.png","disparos/balaLateral/disparo3.png","disparos/balaLateral/disparo4.png"});
		setFrameSpeed(10);
		direccion=derecha;
	}
    
    public void act() {
    	super.act();
    	if(direccion==true){
    		x+=((Fase.tiempoTarda*BULLET_SPEED)/Fase.retardo)/2;
 
    	}
    	else{
    		x-=((Fase.tiempoTarda*BULLET_SPEED)/Fase.retardo)/2;
    	}
    	
		if (x < 0 || x > Stage.WIDTH-32){
			  remove();
		}
    }
}
    