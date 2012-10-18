package netInvaders2;

import games.Game;

import java.awt.event.KeyEvent;

public class Angel extends Player {
	public static int ataque;
	public static boolean invulnerable = false;
	public static int tiemposonic = 0;
	public Angel(Stage stage,int jugador) {
		super(stage);
		setSpriteNames( new String[] {"naves/Supersonic.png"});
		nJugador=jugador;
		//setFrameSpeed (1);
		this.ataque=5;
		this.PLAYER_SPEED = 9 * 2;
		this.MAX_SHIELDS = 4 * 100;
		this.clusterBombs=0 * 2;
		
		this.clusterMax=0;
		this.numero=7;

		
		shields = MAX_SHIELDS;
	}

	
	
	public void act() {
		super.act();
		if(tiemposonic!=0){tiemposonic--;}
		else{
			PLAYER_SPEED=9*2;
			ataque=5;
			invulnerable=false;

			
			if(vx>0){
				setSpriteNames( new String[] {"naves/SupersonicGiroDer.png"});
			}
			if(vx<0){
				setSpriteNames( new String[] {"naves/SupersonicGiroIzq.png"});
			}
			if(vx==0){
				setSpriteNames( new String[] {"naves/Supersonic.png"});
			}
			
		}
	}
	
	public void special(){
		if(fuegoDisponible==1){
			PLAYER_SPEED=18*2;
			ataque=10;
			invulnerable=true;
			setSpriteNames( new String[] {"naves/Supersonicreal.png"});
			tiemposonic=200;
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
					Bullet b = new BalaAngel(stage,nJugador);
					b.setX((x+13-((i+j)*2))+i*7);
					b.setY(y - b.getHeight());
					stage.addActor(b);
					stage.getSoundCache().playSound("sonidos/jesusshot.wav");		
				}
			}
		}
	}

	
	
	public void collision(Actor a) {
		
			if ((a instanceof Monster)  &&  !(a instanceof Humano) && !(a instanceof MonsterBiciInicio) && !(a instanceof MonsterHuevo)&& !(a instanceof MonsterTiradorPreciso2)&& !(a instanceof MonsterNinja)) {
				
					a.remove();
				
					
				addScore(0);
				if(invulnerable==false){
				addShields(-50);
				addFury(+5);
				}
				else{
				//DARLE PUNTOS DE MONSTRUO A ANGEL
					//dar furia a angel
				}
				
				
				
			}
			
			if(a instanceof JefeFinal){
				if(invulnerable==false){
				addShields(-1);
				addFury(+1);
				}
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