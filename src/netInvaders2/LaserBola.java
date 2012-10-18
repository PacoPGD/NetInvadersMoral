package netInvaders2;

import java.util.Random;

    

public class LaserBola extends BalaEnemiga {
	protected static final int BULLET_SPEED=10;
	Boolean comportamiento = false;
	Random random = new Random();
	boolean eleccion = random.nextBoolean();
	
	public LaserBola(Stage stage) {
		super(stage);
		setSpriteNames( new String[] {"disparos/disparoDisco/disparo1.png","disparos/disparoDisco/disparo2.png","disparos/disparoDisco/disparo3.png","disparos/disparoDisco/disparo4.png"});
		setFrameSpeed(10);
	}
	public LaserBola(Stage stage,int diseño) {
		super(stage);
		setSpriteNames( new String[] {"disparos/balaRoja/1.png","disparos/balaRoja/2.png"});
		setFrameSpeed(10);
	}
	
    public void act() {
    	super.act();
		y+=((Fase.tiempoTarda*BULLET_SPEED)/Fase.retardo)/2;
    	
    	if(NuevoJuego.nJugadores==1){
	    	if(Fase.xplayer>x){
		    	x+=3;
		    	}
		    	else{
		    	x-=3;
		    	}
    	}
    	else{
    		if(eleccion){
				if(Fase.segundoVivo==0){
					eleccion=true;
				}
				if(Fase.primeroVivo==0){
					eleccion=false;
				}
				
		    	if(Fase.xplayer>x){
			    	x+=BULLET_SPEED/2;
			    	}
			    	else{
			    	x-=BULLET_SPEED/2;
			    	}
				
				
    		}
    		else{
				if(Fase.segundoVivo==0){
					eleccion=true;
				}
				if(Fase.primeroVivo==0){
					eleccion=false;
				}
				
		    	if(Fase.xplayer2>x){
			    	x+=BULLET_SPEED/2;
			    	}
			    	else{
			    	x-=BULLET_SPEED/2;
			    	}
				
				
    		}
    		
    	}
    	
    	
    	if (y > Stage.PLAY_HEIGHT)
    		remove();
    }
}
    
    