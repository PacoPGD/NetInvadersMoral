package netInvaders2;
public class Humano extends Monster {


	
	public Humano(Stage stage) {
		super(stage);
		setSpriteNames( new String[] {"naves/navecivil.jpg"});
		setFrameSpeed (35);
		setFrameSpeed (35);
		this.vida=1;
		this.puntosAObtener=-25;
		this.furiaAObtener=1;
		this.FIRING_FREQUENCY=0.01;
	}
	
	public void act() {
		super.act();
		x+=vx;
		y+=vy;
		
		if (x < 0 || x > Stage.WIDTH-570){
		  vx = -vx;
		  
		}
		if (y > Stage.HEIGHT || y < 0){
			remove();
		}
		
	if (Math.random()<FIRING_FREQUENCY)
			fire();
	}

	public int getVx() { return vx; }
	public void setVx(int i) {vx = i;	}
	public int getVy() { return vy; }
	public void setVy(int i) {vy = i;  }

		
	public void fire() {
		PaqueteVida m = new PaqueteVida(stage);
		m.setX(x+getWidth()/2);
		m.setY(y + getHeight());
		stage.addActor(m);
		stage.getSoundCache().playSound("sonidos/photon.wav");
	}
	
	
	
	public void collision(Actor a){
		
		if (a instanceof BalaPaco) 
			vida=vida-6;
		
		else
		if (a instanceof BalaJesus)
			vida=vida-3;
		
		else
		if (a instanceof BalaRafa)
			vida=vida-5;
		
		else
		if (a instanceof BalaAdamuz)
			vida=vida-10;
		
		else
		if (a instanceof BalaJuan)
			vida=vida-8;
		
		
		else
		if (a instanceof BalaPacoFinal){
			vida=vida-500;
		}
		
		else
			if (a instanceof BalaJesusFinal){
				vida=vida-100;
			}
		
		else
			if (a instanceof BalaJuanFinal){
				vida=vida-200;
			}
		else
			if (a instanceof Laser){
				vida=vida-10;
			}
		
		else
		if (a instanceof Bomb)
		vida = vida- 30;

		
		if(vida<=0){
			remove();
			stage.getSoundCache().playSound("sonidos/explosion.wav");
		
			
			try{
				Bullet b;
				b = (Bullet)a ;
				selecciona = b.jugadorDispara;
			}
			catch(Exception e){
			}
			
			stage.getPlayer(selecciona).addScore(puntosAObtener);
			stage.getPlayer(selecciona).addFury(furiaAObtener);
		}
	
	
	
}
	
	
	
	
}
