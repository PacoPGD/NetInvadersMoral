package netInvaders2;

import java.util.Random;

    
public class LaserInyector extends BalaEnemiga {
	protected static final int BULLET_SPEED=0;
    int time=15;
    int numero;
	public LaserInyector(Stage stage,int num) {
		super(stage);
		numero=num;
		setSpriteNames( new String[] {"disparos/MoralShot.png"});
		setFrameSpeed(10);
	}
    

	
    public void act() {
    	super.act();
    	time--;
    	if(time==0){
    		remove();
    	}
    	if(time==12){
    		
			LaserInyector m = new LaserInyector(stage,numero);
			m.setX(x+numero);
			m.setY(y+getHeight());
			stage.addActor(m);
    	}
    	
    	if (y > Stage.PLAY_HEIGHT)
    		remove();
    }
}
    