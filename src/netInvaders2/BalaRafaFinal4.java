package netInvaders2;
public class BalaRafaFinal4 extends Bullet {
	protected static final int BULLET_SPEED = 0;
	int tiempo=0;
	
	
	public BalaRafaFinal4(Stage stage, int nJugador) {
		super(stage);
		setSpriteNames(new String[] { "disparos/cruzrafa/cruzRafaVD1.png","disparos/cruzrafa/cruzRafaVD2.png","disparos/cruzrafa/cruzRafaVD3.png","disparos/cruzrafa/cruzRafaVD4.png","disparos/cruzrafa/cruzRafaVD5.png","disparos/cruzrafa/cruzRafaVD6.png","disparos/cruzrafa/cruzRafaVD7.png","disparos/cruzrafa/cruzRafaVD8.png","disparos/cruzrafa/cruzRafaVD9.png","disparos/cruzrafa/cruzRafaVD10.png" });
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