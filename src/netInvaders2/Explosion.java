package netInvaders2;


public class Explosion extends Actor {

	int tiempo;
	public Explosion(Stage stage) {
		super(stage);
		setSpriteNames( new String[] {"Explosion/explosion1.png","Explosion/explosion2.png","Explosion/explosion3.png","Explosion/explosion4.png","Explosion/explosion5.png","Explosion/explosion6.png"});
		setFrameSpeed (8);



	}
	
	public void act() {
		super.act();
		tiempo++;
		y=y+5;
		if (tiempo==45)
			remove();
	}
	


}