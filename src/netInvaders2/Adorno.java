package netInvaders2;

public class Adorno extends Actor {

	public Adorno(Stage stage,String palabra) {
		super(stage);
		setSpriteNames( new String[] {"decoracion/"+palabra});
	}
	
	public Adorno(Stage stage,String palabra, int vel) {
		super(stage);
		setSpriteNames( new String[] {palabra});
		setFrameSpeed(vel);
	}
	
	
}
