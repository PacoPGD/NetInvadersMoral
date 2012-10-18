package netInvaders2;


public class MonsterHuevo extends Monster {

	int i;
	boolean bichoMuerto=false;
	public MonsterHuevo(Stage stage) {
		super(stage);
		setSpriteNames( new String[] {"huevo1.gif"});
		setFrameSpeed (35);
		this.vida=2;
		this.puntosAObtener=5000;
		this.furiaAObtener=30;
		this.FIRING_FREQUENCY=0.05;
	}
	
	public void act() {
		super.act();
		x+=((Fase.tiempoTarda*vx)/Fase.retardo)/2;
		y+=((Fase.tiempoTarda*vy)/Fase.retardo)/2;
		if(vida==1){
			setSpriteNames( new String[] {"huevo2.gif"});
		}
		
		
		if (x < 0 && vx<0){
			  vx = -vx;
			}
			if(x>Stage.WIDTH-32 && vx>0){
				vx = -vx;
			}
			
		if (y > Stage.HEIGHT || y < 0){
			remove();
		}
	}


		
	public void fire() {
	}


	
	
	public void collision(Actor a){
		
		if (a instanceof BalaPaco) 
			vida=vida-1;
		
		else
		if (a instanceof BalaJesus)
			vida=vida-1;
		
		else
		if (a instanceof BalaRafa)
			vida=vida-1;
		
		else
		if (a instanceof BalaAdamuz)
			vida=vida-1;
		
		else
		if (a instanceof BalaJuan)
			vida=vida-1;
		
		else
			if (a instanceof BalaLobogris)
				vida=vida-1;
		
			else
				if (a instanceof BalaAngel)
					vida=vida-1;
		
		else
			if (a instanceof BalaRafaFinal){
				vida=vida-1;
			}
		
		else
		if (a instanceof BalaPacoFinal){
			vida=vida-1;
		}

		
			else
				if (a instanceof BalaLobogrisFinal){
					vida=vida-1;
				}
		
		
		else
			if (a instanceof BalaJuanFinal){
				vida=vida-1;
			}

		
		else
		if (a instanceof Bomb)
			vida=vida-1;


		try{
			Bullet b;
			b = (Bullet)a ;
			selecciona = b.jugadorDispara;
		}
		catch(Exception e){
			try{
				Player c;
				c =(Player)a;
				selecciona=c.nJugador;
			}
			catch(Exception g){}
		}
		
		if(a instanceof Bullet && vida>0){
		Chispas chispa = new Chispas(stage);
		chispa.setX(x);
		chispa.setY(y);

		stage.addActor(chispa);
		}
		
		
		if(vida<=0 && bichoMuerto==false){
			bichoMuerto=true;
			
			JefeFinal n = new MonsterBarco(stage);
			n.setX(x);
			n.setY(y);
			n.setVx(1);
			n.setVy(0);
			stage.addActor(n);
			
			/*for(i=0;i<50;i++){
			Monster n = new MonsterBanzai(stage);
			n.setX(x+i*5);
			n.setY(y+i);
			n.setVx(i);
			n.setVy(i);
			stage.addActor(n);
			}*/

			
			
			
			stage.getSoundCache().playSound("sonidos/explosion.wav");

			if(selecciona!=3){
			stage.getPlayer(selecciona).addFury(furiaAObtener);
			stage.getPlayer(selecciona).addScore(puntosAObtener);
			}

			remove();
		}

}


	
	
}