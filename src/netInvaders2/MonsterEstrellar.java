package netInvaders2;

import java.util.Random;


public class MonsterEstrellar extends Monster {

	Boolean comportamiento = false;
	
	Random random = new Random();
	
	boolean eleccion = random.nextBoolean();
	public MonsterEstrellar(Stage stage) {
		super(stage);
		setSpriteNames( new String[] {"naves/nave18/nave1.png"});
		setFrameSpeed (35);
		this.vida=20;
		this.puntosAObtener=4000;
		this.furiaAObtener=6;
		this.FIRING_FREQUENCY=0.08;
	}
	
	public void act() {
		super.act(); 

		if(comportamiento==false){
		
			if(NuevoJuego.nJugadores==1){
	
				if(Fase.xplayer>x){
					x+=vx;
					setSpriteNames( new String[] {"naves/nave18/nave2.png"});
				}
				if(Fase.xplayer<x){
					x-=vx;
					setSpriteNames( new String[] {"naves/nave18/nave3.png"});
				}
				
				if(Fase.xplayer==x){
					setSpriteNames( new String[] {"naves/nave18/nave1.png"});
					y+=vy;
				}
				

	
			}
	
	
			else{
				if(eleccion){
					if(Fase.segundoVivo==0){
						eleccion=true;
					}
					if(Fase.primeroVivo==0){
						eleccion=false;
					}
	
					if(Fase.xplayer>x){
						x+=vx;
						setSpriteNames( new String[] {"naves/nave18/nave2.png"});
					}
					if(Fase.xplayer<x){
						x-=vx;
						setSpriteNames( new String[] {"naves/nave18/nave3.png"});
					}
					
					if(Fase.xplayer==x){
						setSpriteNames( new String[] {"naves/nave18/nave1.png"});
						y+=vy;
					}

				}
	
				else{
					if(Fase.segundoVivo==0){
						eleccion=true;
					}
					if(Fase.primeroVivo==0){
						eleccion=false;
					}
	
					if(Fase.xplayer2>x){
						x+=vx;
						setSpriteNames( new String[] {"naves/nave18/nave2.png"});
					}
					if(Fase.xplayer2<x){
						x-=vx;
						setSpriteNames( new String[] {"naves/nave18/nave3.png"});
					}
					
					
					if(Fase.xplayer2==x){
						setSpriteNames( new String[] {"naves/nave18/nave1.png"});
						y+=vy;
					}

				}
			}


		}


		else{
			y+=vy;
		}
		
		
		
		if (x < 0 || x > Stage.WIDTH-32){
			vx = -vx;
		}

		if (Fase.xplayer==x || Fase.xplayer2==x)
			fire();

	}


		
	public void fire() {
		vy=vy+20;
		comportamiento=true;
	}


}