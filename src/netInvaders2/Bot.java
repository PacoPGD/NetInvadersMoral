package netInvaders2;


public abstract class Bot extends Actor {
	


	
	protected static double FIRING_FREQUENCY=0.1;
	
	
	public Bot(Stage stage) {
		super(stage);
	}
	
	public void collision(Actor a) {
		if ((a instanceof Monster)  &&  !(a instanceof Humano) && !(a instanceof MonsterBiciInicio) && !(a instanceof MonsterHuevo)) {
		a.remove();
		}

		if (a instanceof BalaEnemiga && !(a instanceof LaserInyector)){
		a.remove();
		}

	} 
		

	//public abstract void act();
	public abstract int getVx();
	public abstract void setVx(int i);
	public abstract int getVy();
	public abstract void setVy(int i);
	public static int fuegoDisponible=0;
	public int combo = 1;
	int tiempodisparo=10;
	public int nJugador=3;
	


}