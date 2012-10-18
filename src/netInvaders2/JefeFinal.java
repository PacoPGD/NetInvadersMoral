package netInvaders2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public abstract class JefeFinal extends Actor {

	public int vx;
	public int vy;
	public int vida;
	public int vidaT;
	public int puntosAObtener;
	public int furiaAObtener;
	public int selecciona;
	public  double FIRING_FREQUENCY;
	boolean bichoMuerto=false;
	public int vivo=1;
	
	public JefeFinal(Stage stage) {
		super(stage);
	}
	
	
	//public abstract void act();
	public int getVx() { return vx; }
	public void setVx(int i) {vx = i;	}
	public int getVy() { return vy; }
	public void setVy(int i) {vy = i;  }
	
	public void paint(Graphics2D g){
			super.paint(g);
			
			g.setFont(new Font("Arial",Font.BOLD,20));
			g.setPaint(Color.red);
			g.drawString((int)(100* vida/(float)vidaT)+"%",650,Stage.PLAY_HEIGHT );
	}
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
				vida=vida-1;
			}
		
			else
				if (a instanceof BalaLobogrisFinal){
					vida=vida-10;
				}
		
		
		else
			if (a instanceof BalaJuanFinal){
				vida=vida-20;
			}
		
			else
				if (a instanceof Angel && Angel.invulnerable==true){
					vida=vida-1;
				}
		
		
		else
		if (a instanceof Bomb)
		vida = vida- 30;
		
		
		/*
		if(a instanceof Bullet && vida>0){
			Chispas chispa = new Chispas(stage);
			chispa.setX(x);
			chispa.setY(y);

			stage.addActor(chispa);
			}
		*/
		
		if(a instanceof Bullet && vida>0){
			Chispas chispa = new Chispas(stage);
			chispa.setX(x);
			chispa.setY(y);

			//stage.addActor(chispa);
			}
			
		
			
			if(vida<=0 && bichoMuerto==false){
				bichoMuerto=true;
				
				Explosion n = new Explosion(stage);
				n.setX(x);
				n.setY(y);
				stage.addActor(n);
		
				
				
				
				remove();
				stage.getSoundCache().playSound("sonidos/explosion.wav");
				
				
				if(NuevoJuego.nJugadores==1){
				stage.getPlayer(1).addScore(puntosAObtener);
				stage.getPlayer(1).addFury(furiaAObtener);
				}
				else{
					try{
					stage.getPlayer(1).addScore(puntosAObtener/2);
					stage.getPlayer(1).addFury(furiaAObtener/2);
				
					
						stage.getPlayer(2).addScore(puntosAObtener/2);
						stage.getPlayer(2).addFury(furiaAObtener/2);
					}
					catch(Exception e){
					}
				}

			}
		
		
		
	}

	
	public int Monsterv(){
		
		if(vida<=0){
			return 0;
		}else{
			return 1;
		}
	}
}
