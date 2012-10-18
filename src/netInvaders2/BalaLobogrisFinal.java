package netInvaders2;
public class BalaLobogrisFinal extends Bullet {
	protected static final int BULLET_SPEED = 1;
	int tiempo=0;
	boolean derecha;
	int vx=10;
	
	
	public BalaLobogrisFinal(Stage stage, int nJugador,int numero,boolean direccion) {
		super(stage);
		setSpriteNames(new String[] { "disparos/especialGreyWolf/especialGreyWolf"+numero+".png" });
		jugadorDispara = nJugador;
		derecha=direccion;
	}

	public void act() {
		super.act();
		if(derecha==true){
			x+=vx;
		}
		else{
			x-=vx;
		}
		
		if (x < 0 || x > Stage.WIDTH-32){
			  vx = -vx;
		} 
			  
			  
    	y-=BULLET_SPEED;
    	
    	if (y < 0){
    		remove();
    	}
	}



	public int getJugador() {
		return jugadorDispara;
	}

}