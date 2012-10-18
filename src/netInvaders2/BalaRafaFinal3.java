package netInvaders2;
public class BalaRafaFinal3 extends Bullet {
	protected static final int BULLET_SPEED = 0;
	int tiempo=0;
	
	
	public BalaRafaFinal3(Stage stage, int nJugador) {
		super(stage);
		setSpriteNames(new String[] { "disparos/cruzrafa/cruzRafaVU1.png","disparos/cruzrafa/cruzRafaVU2.png","disparos/cruzrafa/cruzRafaVU3.png","disparos/cruzrafa/cruzRafaVU4.png","disparos/cruzrafa/cruzRafaVU5.png","disparos/cruzrafa/cruzRafaVU6.png","disparos/cruzrafa/cruzRafaVU7.png","disparos/cruzrafa/cruzRafaVU8.png","disparos/cruzrafa/cruzRafaVU9.png","disparos/cruzrafa/cruzRafaVU10.png" });
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