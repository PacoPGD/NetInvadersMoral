package netInvaders2;


public class Chispas extends Actor {

	int tiempo;
	public Chispas(Stage stage) {
		super(stage);
		setSpriteNames( new String[] {"Explosion/chispas0.png","Explosion/chispas1.png"});
		setFrameSpeed (4);



	}
	
	public void act() {
		super.act();
		tiempo++;
		y=y+5;
		if (tiempo==4)
			remove();
	}
	


}