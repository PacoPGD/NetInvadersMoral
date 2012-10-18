package netInvaders2;
public class BalaRafaFinal2 extends Bullet {
	protected static final int BULLET_SPEED = 0;
	int tiempo=0;
	
	
	public BalaRafaFinal2(Stage stage, int nJugador) {
		super(stage);
		setSpriteNames(new String[] { "disparos/cruzrafa/cruzRafaHL1.png","disparos/cruzrafa/cruzRafaHL2.png","disparos/cruzrafa/cruzRafaHL3.png","disparos/cruzrafa/cruzRafaHL4.png","disparos/cruzrafa/cruzRafaHL5.png","disparos/cruzrafa/cruzRafaHL6.png","disparos/cruzrafa/cruzRafaHL7.png","disparos/cruzrafa/cruzRafaHL8.png","disparos/cruzrafa/cruzRafaHL9.png","disparos/cruzrafa/cruzRafaHL10.png" });
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