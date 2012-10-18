package netInvaders2;
public class BalaRafaFinal extends Bullet {
	protected static final int BULLET_SPEED = 0;
	int tiempo=0;
	
	public BalaRafaFinal(Stage stage, int nJugador) {
		super(stage);
		setSpriteNames(new String[] { "disparos/cruzrafa/cruzRafaHD1.png","disparos/cruzrafa/cruzRafaHD2.png","disparos/cruzrafa/cruzRafaHD3.png","disparos/cruzrafa/cruzRafaHD4.png","disparos/cruzrafa/cruzRafaHD5.png","disparos/cruzrafa/cruzRafaHD6.png","disparos/cruzrafa/cruzRafaHD7.png","disparos/cruzrafa/cruzRafaHD8.png","disparos/cruzrafa/cruzRafaHD9.png","disparos/cruzrafa/cruzRafaHD10.png" });
		//setFrameSpeed(1);
		jugadorDispara = nJugador;

	}

	public void act() {
		super.act();
		tiempo++;
		if (tiempo==9)
			remove();
	}

	public void collision(Actor a) {

	}

	public int getJugador() {
		return jugadorDispara;
	}

}