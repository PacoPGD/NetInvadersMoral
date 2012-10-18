package netInvaders2;


public class Lobogris extends Player {
	public static int ataque;
	int i=1;
	int tiempo=0;

	public Lobogris(Stage stage,int jugador) {
		super(stage);
		setSpriteNames( new String[] {"naves/GreyWolf.png"});
		nJugador=jugador;
		//setFrameSpeed (1);
		this.ataque=5;
		this.PLAYER_SPEED = 5 * 2;
		this.MAX_SHIELDS = 8 * 100;
		this.clusterBombs=0 * 2;
		this.clusterMax=0;
		this.numero=5;

		
		shields = MAX_SHIELDS;
	}

	
	
	public void act() {
		super.act();
		if(vx>0){
			setSpriteNames( new String[] {"naves/GreyWolfGiroDer.png"});
		}
		if(vx<0){
			setSpriteNames( new String[] {"naves/GreyWolfGiroIzq.png"});
		}
		if(vx==0){
			setSpriteNames( new String[] {"naves/GreyWolf.png"});
		}
		
		if(tiempo>20){
			if(tiempo%20==0){
			Bullet b = new BalaLobogrisFinal(stage,nJugador,i,true);
			b.setX(x);
			b.setY(y - b.getHeight());
			stage.addActor(b);
			stage.getSoundCache().playSound("sonidos/jesusshot.wav");
			
			Bullet a = new BalaLobogrisFinal(stage,nJugador,i,false);
			a.setX(x);
			a.setY(y - b.getHeight());
			stage.addActor(a);
			stage.getSoundCache().playSound("sonidos/jesusshot.wav");
			i++;
			}

			tiempo--;
		}
		
		if(tiempo==20){
			i=1;
		}
		
	}
	
	public void special(){
		if(fuegoDisponible==1){
			tiempo = 200;

		}
	}
	
	public void fire() {
		if(fuegoDisponible==1){
			int i;
			int j=combo;

			if(tiempodisparo>=4){
				tiempodisparo=0;
				for(i=0;i<combo;i++){
					disparosRealizados++;
					Bullet b = new BalaLobogris(stage,nJugador);
					b.setX((x+13-((i+j)*2))+i*7);
					b.setY(y - b.getHeight());
					stage.addActor(b);
					stage.getSoundCache().playSound("sonidos/jesusshot.wav");		
				}
			}
		}
	}

}
