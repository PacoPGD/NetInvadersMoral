package netInvaders2;

    
public class BalaBarco extends BalaEnemiga {
	protected static final int BULLET_SPEED=10;
    public int inclinacion;
    
	public BalaBarco(Stage stage,int inclinado) {
		super(stage);
		setSpriteNames( new String[] {"disparos/balaBarco1.gif"});
		setFrameSpeed(10);
		inclinacion=inclinado;
	}
	public BalaBarco(Stage stage,int inclinado,int alter) {
		super(stage);
		setSpriteNames( new String[] {"disparos/balaBarco2.png"});
		setFrameSpeed(10);
		inclinacion=inclinado;
	}
    public void act() {
    	super.act();
		x+=((Fase.tiempoTarda*inclinacion)/Fase.retardo)/2;
		y+=((Fase.tiempoTarda*(BULLET_SPEED - Math.abs(inclinacion)))/Fase.retardo)/2;

    	
    	
    	if (y > Stage.PLAY_HEIGHT)
    		remove();
    }
}
    