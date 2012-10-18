package netInvaders2;


public abstract class Monster extends Actor {
	
	protected int vx;
	protected int vy;
	protected int vida;
	public int puntosAObtener;
	protected int furiaAObtener;
	int selecciona;
	boolean bichoMuerto=false;
	
	
	protected static double FIRING_FREQUENCY;
	
	
	
	public Monster(Stage stage) {
		super(stage);
	}
	
	
	//public abstract void act();
	public int getVx() { return vx; }
	public void setVx(int i) {vx = i;	}
	public int getVy() { return vy; }
	public void setVy(int i) {vy = i;  }
	
	
	public int getScore(){return puntosAObtener;}
	
	
	public void collision(Actor a){
			if (a instanceof BalaPaco) {
				vida=vida-Paco.ataque;
				if(Paco.ataque==0){
					vida=vida-PacoBot.ataque;
				}
			}
			
			else
			if (a instanceof BalaJesus){
				vida=vida-Jesus.ataque;
				if(Jesus.ataque==0){
					vida=vida-JesusBot.ataque;
				}
			}
			
			else
			if (a instanceof BalaRafa){
				vida=vida-Rafa.ataque;
				if(Rafa.ataque==0){
					vida=vida-RafaBot.ataque;
				}
			}
			else
			if (a instanceof BalaAdamuz){
				vida=vida-Adamuz.ataque;
				if(Adamuz.ataque==0){
				//	vida=vida-RafaBot.ataque;
				}
			}
			else
			if (a instanceof BalaJuan){
				vida=vida-Juan.ataque;
				if(Juan.ataque==0){
					vida=vida-JuanBot.ataque;
				}
			}
			
			else
			if (a instanceof BalaLobogris){
				vida=vida-Lobogris.ataque;
				if(Lobogris.ataque==0){
					vida=vida-LobogrisBot.ataque;
				}
			}
			else
			if (a instanceof BalaAngel){
				vida=vida-Angel.ataque;
				if(Angel.ataque==0){
					vida=vida-AngelBot.ataque;
				}
			}
			
			else
			if (a instanceof BalaAdam){
				vida=vida-Adam.ataque;
				if(Adam.ataque==0){
					vida=vida-AdamBot.ataque;
				}
			}
			
			else
				if (a instanceof BalaRafaFinal){
					vida=vida-40;
				}
			
			else
				if (a instanceof BalaRafaFinal2){
					vida=vida-40;
				}
			
			else
				if (a instanceof BalaRafaFinal3){
					vida=vida-40;
					}
			
			else
				if (a instanceof BalaRafaFinal4){
					vida=vida-40;
				}
			
			else
			if (a instanceof BalaPacoFinal){
				vida=vida-50;
			}
			
			else
				if (a instanceof BalaJesusFinal){
					vida=vida-500;
				}
			
				else
					if (a instanceof BalaLobogrisFinal){
						vida=vida-Lobogris.ataque*3;
					}
			
			
			else
				if (a instanceof BalaJuanFinal){
					vida=vida-30;
				}
			
				else
					if (a instanceof Angel && Angel.invulnerable==true){
						vida=vida-500;
					}
			
			else
			if (a instanceof Bomb)
			vida = vida- 30;
	

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
			

			
			
			if(vida<=0 && bichoMuerto==false){
				bichoMuerto=true;
				
				if(!(this instanceof MonsterNinja)){
				Explosion n = new Explosion(stage);
				n.setX(x);
				n.setY(y);
				stage.addActor(n);
				}

				
				
				
				stage.getSoundCache().playSound("sonidos/explosion.wav");

				if(selecciona!=3){
				stage.getPlayer(selecciona).addFury(furiaAObtener);
				stage.getPlayer(selecciona).addScore(puntosAObtener);
				}

				remove();
			}
	
	}


	
}

