package netInvaders2;
public class BalaJuanFinal extends Bullet {
	protected static final int BULLET_SPEED = 0;
	int tiempo=0;
	int i;
	
	public BalaJuanFinal(Stage stage, int nJugador) {
		super(stage);
		setSpriteNames(new String[] { "disparos/especialLoki/especialNaveLoki1.gif","disparos/especialLoki/especialNaveLoki2.gif","disparos/especialLoki/especialNaveLoki3.gif","disparos/especialLoki/especialNaveLoki4.gif","disparos/especialLoki/especialNaveLoki5.gif","disparos/especialLoki/especialNaveLoki6.gif","disparos/especialLoki/especialNaveLoki7.gif","disparos/especialLoki/especialNaveLoki8.gif","disparos/especialLoki/especialNaveLoki9.gif","disparos/especialLoki/especialNaveLoki10.gif","disparos/especialLoki/especialNaveLoki11.gif","disparos/especialLoki/especialNaveLoki12.gif","disparos/especialLoki/especialNaveLoki13.gif" });
		setFrameSpeed(1);
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