package netInvaders2;

    
public class LaserMultipleShuriken extends BalaEnemiga {
	protected static final int BULLET_SPEED=16;
    int cosa;
	public LaserMultipleShuriken(Stage stage,int direccion) {
		super(stage);
		setSpriteNames( new String[] {"disparos/shuriken/shuriken1.png","disparos/shuriken/shuriken2.png","disparos/shuriken/shuriken3.png"});
		setFrameSpeed(10);
		cosa=direccion;
	}
    
    public void act() {
    	super.act();
    	
    	if(cosa==1){
    		y+=((Fase.tiempoTarda*BULLET_SPEED)/Fase.retardo)/2;
    		
        	if (y > Stage.PLAY_HEIGHT || y < 0)
        		remove();
    	}
    	
    	if(cosa==2){
    		y+=((Fase.tiempoTarda*BULLET_SPEED/2)/Fase.retardo)/2;
    		x-=((Fase.tiempoTarda*BULLET_SPEED/2)/Fase.retardo)/2;
        	if (y > Stage.PLAY_HEIGHT || y < 0)
        		remove();
    		
        	if (x > Stage.WIDTH || x < 0)
        		remove();
    	}
    	
    	if(cosa==3){
    		x-=((Fase.tiempoTarda*BULLET_SPEED)/Fase.retardo)/2;
    		
        	if (x > Stage.WIDTH || x < 0)
        		remove();
    	}
    	
    	if(cosa==4){
    		y-=((Fase.tiempoTarda*BULLET_SPEED/2)/Fase.retardo)/2;
    		x-=((Fase.tiempoTarda*BULLET_SPEED/2)/Fase.retardo)/2;
        	if (y > Stage.PLAY_HEIGHT || y < 0)
        		remove();
        	
        	if (x > Stage.WIDTH || x < 0)
        		remove();
    		
    	}
    	
       	if(cosa==5){
    		y-=((Fase.tiempoTarda*BULLET_SPEED)/Fase.retardo)/2;
    		
        	if (y > Stage.PLAY_HEIGHT || y < 0)
        		remove();
    	}
       	
    	if(cosa==6){
    		y-=((Fase.tiempoTarda*BULLET_SPEED/2)/Fase.retardo)/2;
    		x+=((Fase.tiempoTarda*BULLET_SPEED/2)/Fase.retardo)/2;
        	if (y > Stage.PLAY_HEIGHT || y < 0)
        		remove();
    		
        	if (x > Stage.WIDTH || x < 0)
        		remove();
    	}
    	
    	if(cosa==7){
    		x+=((Fase.tiempoTarda*BULLET_SPEED)/Fase.retardo)/2;
    		
        	if (x > Stage.WIDTH || x < 0)
        		remove();
    	}
    	
    	if(cosa==8){
    		y+=((Fase.tiempoTarda*BULLET_SPEED/2)/Fase.retardo)/2;
    		x+=((Fase.tiempoTarda*BULLET_SPEED/2)/Fase.retardo)/2;
        	if (y > Stage.PLAY_HEIGHT || y < 0)
        		remove();
        	
        	if (x > Stage.WIDTH || x < 0)
        		remove();
    		
    	}
    	
    }
}
    