package netInvaders2;
public class BalaJesusFinal extends Bullet {
	protected static final int BULLET_SPEED = 0;
	int tiempo=0;
	
	public BalaJesusFinal(Stage stage, int nJugador) {
		super(stage);
		setSpriteNames(new String[] { "disparos/especialJesus/especialNaveJesus1.png","disparos/especialJesus/especialNaveJesus2.png","disparos/especialJesus/especialNaveJesus3.png","disparos/especialJesus/especialNaveJesus4.png","disparos/especialJesus/especialNaveJesus5.png" });
		setFrameSpeed(10);
		jugadorDispara = nJugador;
		Jesus.choqueDisponible=0;
	}

	public void act() {
		super.act();
		if(Fase.identidad1==3){
		x=Fase.xplayer-32;
		y=Fase.yplayer-32;
		}
		else{
		x=Fase.xplayer2-19;
		y=Fase.yplayer2-20;
		}
		tiempo++;
		if (tiempo==100)
			Jesus.choqueDisponible=1;
			remove();
	}

	public void collision(Actor a) {
		if (a instanceof BalaEnemiga) {
			a.remove();
		}

	}

	public int getJugador() {
		return jugadorDispara;
	}

}