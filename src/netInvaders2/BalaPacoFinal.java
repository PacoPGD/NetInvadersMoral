package netInvaders2;
public class BalaPacoFinal extends Bullet {
	protected static final int BULLET_SPEED = 0;
	int tiempo=0;
	
	public BalaPacoFinal(Stage stage, int nJugador) {
		super(stage);
		setSpriteNames(new String[] { "disparos/especialPako/especialNavePaco7.png" });
		jugadorDispara = nJugador;

	}

	public void act() {
		super.act();
		tiempo++;
		if (tiempo==10)
			remove();
	}

	public void collision(Actor a) {

	}

	public int getJugador() {
		return jugadorDispara;
	}

}