package netInvaders2;

import games.Game;

import java.awt.event.KeyEvent;

import netInvaders2.Opciones.Preferencias;

public abstract class Player extends Actor {
	
	public static int disparosRealizados=0;
	public static int disparosFallados=0;
	
	
	
	public int vx;
	public int vy;
	public boolean up, down, left, right, escape;
	public int score;
	
	public int shields;
	public int precision;
	
	
	public int nJugador;
	public int combo = 1;
	int tiempo=500;
	int tiempodisparo=10;
	public int vivo=1;
	public  int fury = 0;
	public int numero;


	public int PLAYER_SPEED;
	public int MAX_SHIELDS;
	public int clusterBombs;
	public int clusterMax;
	public static int fuegoDisponible=1;
	public static int choqueDisponible=1;



	public Player(Stage stage) {
		super(stage);
	}
	
	
	public void act() {
		super.act();
		if(vx!=0){
			score--;
		}
		if(vy!=0){
			score--;
		}
		

		x+=((Fase.tiempoTarda*vx)/Fase.retardo)/2;
		y+=((Fase.tiempoTarda*vy)/Fase.retardo)/2;
		

		
		tiempo++;
		tiempodisparo++;
		
		if (x < 0 ) 
			x = 0;
		if (x > Stage.WIDTH - getWidth()-5)
			x = Stage.WIDTH - getWidth()-5;
		if (y < 0 )
			y = 0;
		if ( y > Stage.PLAY_HEIGHT -getHeight())
			y = Stage.PLAY_HEIGHT - getHeight();
		
		
		
		
	}
	
	
	
	public abstract void special();
	
	
	
	public int getVx() { return vx; }
	public void setVx(int i) {vx = i; }
	public int getVy() { return vy; }
	public void setVy(int i) {vy = i; }

	
	

	protected void updateSpeed() {
		vx=0;vy=0;
		if (down) vy = PLAYER_SPEED;
		if (up) vy = -PLAYER_SPEED;
		if (left) vx = -PLAYER_SPEED;
		if (right) vx = PLAYER_SPEED;
	} 


	public abstract void fire();
	
	public void fireCluster() {
		if(fuegoDisponible==1){
			if (clusterBombs == 0)
				return;


			if(tiempo>=70){
				tiempo=0;
				clusterBombs--;
				stage.addActor( new Bomb(stage, Bomb.UP_LEFT, (int)x,(int)y,nJugador));
				stage.addActor( new Bomb(stage, Bomb.UP,(int)x,(int)y,nJugador));
				stage.addActor( new Bomb(stage, Bomb.UP_RIGHT,(int)x,(int)y,nJugador));
				stage.addActor( new Bomb(stage, Bomb.LEFT,(int)x,(int)y,nJugador));
				stage.addActor( new Bomb(stage, Bomb.RIGHT,(int)x,(int)y,nJugador));
				stage.addActor( new Bomb(stage, Bomb.DOWN_LEFT,(int)x,(int)y,nJugador));
				stage.addActor( new Bomb(stage, Bomb.DOWN,(int)x,(int)y,nJugador));
				stage.addActor( new Bomb(stage, Bomb.DOWN_RIGHT,(int)x,(int)y,nJugador));
			}
		}
	}
	
	
	public int getScore() {   return score; }
	public void setScore(int i) { score = i;  }
	   
	public int getNumero() {   return numero; }
	public int getFury() {   return fury; }
	public void setFury(int i) { fury = i;  }
	
	public int getCombo() {   return combo; }
	public void setCombo(int i) { combo = i;  }
	


	
	public int getShields() { return shields; }
	public void setShields(int i) { shields = i;  }	

	public int getClusterBombs() { return clusterBombs; }
	public void setClusterBombs(int i) { clusterBombs = i;  }	
	
	
	public int getStat(){ return vivo;}
	
	public void addCombo (int increase){
		combo += increase;
	}
	
	public void addFury (int increase){
		fury += increase;
	}
	
	public void addScore(int increase) {
		score += increase;
	}

	public void addShields(int increase) {
		shields += increase;
	}	
	
	
	
	
	
	
	
	public int getFuryAngle() {   
		float angulo;
		int devuelve;
		angulo= (float) (fury * 3.6);
		devuelve = (int)angulo;
		return devuelve; 
		}
	
	
	
	public void collision(Actor a) {
		if(choqueDisponible==1){
			if ((a instanceof Monster)  &&  !(a instanceof Humano) && !(a instanceof MonsterBiciInicio) && !(a instanceof MonsterHuevo) && !(a instanceof MonsterTiradorPreciso2) && !(a instanceof MonsterNinja)) {
				
				Explosion n = new Explosion(stage);
				n.setX(a.x);
				n.setY(a.y);
				stage.addActor(n);
				a.remove();

				addScore(0);
				addShields(-50);
				addFury(+5);
				

			}
			
			if(a instanceof JefeFinal){
				addShields(-1);
				addFury(+1);
			}
			
			if(a instanceof PaqueteCombo){
			combo++;
			a.remove();
			}
			
			
			if(a instanceof PaqueteVida ){
				int vidatiene;
				vidatiene=getShields();
				if (vidatiene!=MAX_SHIELDS){
				
					if(vidatiene>=MAX_SHIELDS-50){
						addShields(-vidatiene+1);
						addShields(MAX_SHIELDS-1);
						a.remove();
					}
					else{
							addShields(+50);
							a.remove();
					}
				}
			}
			
			if(a instanceof PaqueteCombustible){
				Mission4.contador3++;
				stage.getSoundCache().playSound("sonidos/barra.wav");		
				a.remove();
			}
			
			if(a instanceof MonsterNinja){
				if(MonsterNinja.atacando==true){
					addShields(-10);
				}
			}
			
			if (a instanceof BalaEnemiga){
				
				Game.vibra(4,4,10);
			
				if (a instanceof Laser ) {
					addShields(-10);
					addFury(+2);
					a.remove();
				}
				if (a instanceof LaserAdamuz ) {
					addShields(-1);
				}
				
				if (a instanceof LaserMultipleShuriken ) {
					addShields(-10);
					addFury(+2);
					a.remove();
				}
				if (a instanceof LaserBola ) {
					addShields(-40);
					addFury(+5);
					a.remove();
				}
				
				if (a instanceof LaserArriba ) {
					addShields(-10);
					addFury(+2);
					a.remove();
				}
				if (a instanceof BalaBarco) {
					addShields(-20);
					addFury(+3);
					a.remove();
				}
				if (a instanceof BalaPortaBicis) {
					addShields(-30);
					addFury(+5);
					a.remove();
				}
				if (a instanceof BalaLateral) {
					addShields(-15);
					addFury(+3);
					a.remove();
				}
				if (a instanceof LaserInyector) {
					addShields(-5);
					addFury(+3);
				}
				if (a instanceof BalaJefe) {
					addShields(-5);
					addFury(+3);
				}
			}
			if (getShields() <= 0){	
				vivo=0;
				x=1000;
				y=1000;
				remove();
			}
		}
	} 
	
	
	

	
	public void keyReleased(KeyEvent e) {
		
		if(nJugador==1){
			if(Preferencias.controlesJ1[0]==e.getKeyCode()){
				up=false;
			}
			if(Preferencias.controlesJ1[1]==e.getKeyCode()){
				down=false;
			}	
			if(Preferencias.controlesJ1[2]==e.getKeyCode()){
				left=false;
			}	
			if(Preferencias.controlesJ1[3]==e.getKeyCode()){
				right=false;
			}	
			
		}
		else{
			if(Preferencias.controlesJ2[0]==e.getKeyCode()){
				up=false;
			}
			if(Preferencias.controlesJ2[1]==e.getKeyCode()){
				down=false;
			}	
			if(Preferencias.controlesJ2[2]==e.getKeyCode()){
				left=false;
			}	
			if(Preferencias.controlesJ2[3]==e.getKeyCode()){
				right=false;
			}
		}
			
			
		
		updateSpeed();
	}

	public void keyPressed(KeyEvent e) {
		if(vivo==1){
			if(nJugador==1){
				
				if(KeyEvent.VK_ESCAPE==e.getKeyCode()){
					escape=true;
				}
				
				if(Preferencias.controlesJ1[0]==e.getKeyCode()){
					up=true;
				}
				if(Preferencias.controlesJ1[1]==e.getKeyCode()){
					down=true;
				}	
				if(Preferencias.controlesJ1[2]==e.getKeyCode()){
					left=true;
				}	
				if(Preferencias.controlesJ1[3]==e.getKeyCode()){
					right=true;
				}
				if(Preferencias.controlesJ1[4]==e.getKeyCode()){
					fire();
				}
				if(Preferencias.controlesJ1[5]==e.getKeyCode()){
					fireCluster();
				}
	
				if(Preferencias.controlesJ1[6]==e.getKeyCode()){
					if(fuegoDisponible==1){
						if(fury>=100){
							special();
							fury=0;
						}
					}
				}

		
		
	

				
			}

			else{
				
				if(Preferencias.controlesJ2[0]==e.getKeyCode()){
					up=true;
				}
				if(Preferencias.controlesJ2[1]==e.getKeyCode()){
					down=true;
				}	
				if(Preferencias.controlesJ2[2]==e.getKeyCode()){
					left=true;
				}	
				if(Preferencias.controlesJ2[3]==e.getKeyCode()){
					right=true;
				}
				if(Preferencias.controlesJ2[4]==e.getKeyCode()){
					fire();
				}
				if(Preferencias.controlesJ2[5]==e.getKeyCode()){
					fireCluster();
				}
	
				if(Preferencias.controlesJ2[6]==e.getKeyCode()){
					if(fuegoDisponible==1){
						if(fury>=100){
							special();
							fury=0;
						}
					}
				}
			}
		}
		updateSpeed();
	}    
	
}
