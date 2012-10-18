package netInvaders2;



public abstract class Boton extends Actor {

	public Boton(Stage stage) {
		super(stage);
	}
	
	
	
	public abstract void cellClicked();
	

	
	public abstract int getX();
	public abstract int getY();
	public abstract int getWidth();
	public abstract int getHeight();



	
	
}
