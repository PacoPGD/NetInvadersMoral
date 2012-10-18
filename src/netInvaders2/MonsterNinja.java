package netInvaders2;

import java.util.Random;


public class MonsterNinja extends Monster {
	
	Random random = new Random();
	boolean eleccion = random.nextBoolean();
	int devuelveVy=vy;
	int tiempoAtaque = 18;
	static boolean atacando = false;
	int tiempoAtaqueActual = tiempoAtaque;

	public MonsterNinja(Stage stage) {
		super(stage);
		setSpriteNames( new String[] {"naves/ninja/ninja1.gif","naves/ninja/ninja2.gif"});
		setFrameSpeed (3);
		this.vida=22;
		this.puntosAObtener=750;
		this.furiaAObtener=2;
		this.FIRING_FREQUENCY=0.05;
	}
	
	public MonsterNinja(Stage stage, int valor) {
		super(stage);
		setSpriteNames( new String[] {"naves/ninja/ninja1.gif","naves/ninja/ninja2.gif"});
		setFrameSpeed (3);
		this.vida=22;
		this.puntosAObtener=valor;
		this.furiaAObtener=2;
		this.FIRING_FREQUENCY=0.05;
	}
	
	
	public void act() {
		super.act();
		
		
		if(NuevoJuego.nJugadores==1){
			
			
			if(Fase.xplayer>x){
				x+=((Fase.tiempoTarda*vx)/Fase.retardo)/2;
				
			}
			if(Fase.xplayer<x){
				x-=((Fase.tiempoTarda*vx)/Fase.retardo)/2;
			}
			if(Fase.yplayer<y){
				y-=((Fase.tiempoTarda*vy)/Fase.retardo)/2;
			}
			if(Fase.yplayer>y){
				y+=((Fase.tiempoTarda*vy)/Fase.retardo)/2;
			}
		
			if (y > Stage.HEIGHT || y < 0){
				remove();
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
					x+=((Fase.tiempoTarda*vx)/Fase.retardo)/2;
					
				}
				if(Fase.xplayer<x){
					x-=((Fase.tiempoTarda*vx)/Fase.retardo)/2;
					
				}
				if(Fase.yplayer<y){
					y-=((Fase.tiempoTarda*vy)/Fase.retardo)/2;
				}
				if(Fase.yplayer>y){
					y+=((Fase.tiempoTarda*vy)/Fase.retardo)/2;
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
					x+=((Fase.tiempoTarda*vx)/Fase.retardo)/2;
				}
				if(Fase.xplayer2<x){
					x-=((Fase.tiempoTarda*vx)/Fase.retardo)/2;
				}
				if(Fase.yplayer2<y){
					y-=((Fase.tiempoTarda*vy)/Fase.retardo)/2;
				}
				if(Fase.yplayer2>y){
					y+=((Fase.tiempoTarda*vy)/Fase.retardo)/2;
				}
			}
			
			
		}
		
		
			

		
		if(atacando==false){
			if (eleccion){
				if ((x == Fase.xplayer  )  ){
					if(y == Fase.yplayer-10){
					fire();
					}
				}
			}
			else{
				if ((x == Fase.xplayer2  )  ){
					if(y == Fase.yplayer2-10){
					fire();
					}
				}
			}
		}
		
		else{
			tiempoAtaqueActual--;
			if(tiempoAtaqueActual==0){
				fireoff();
			}
		}
		
		
	}


		
	public void fire() {
		atacando=true;
		y=y-20;
		//vy=2;
		try{
		setFrameSpeed (3);
		setSpriteNames( new String[] {"naves/ninja/ninjaAtaque1.gif","naves/ninja/ninjaAtaque2.gif","naves/ninja/ninjaAtaque3.gif"});

		}
		catch(Exception e){
			
		}
	}
	
	public void fireoff(){
		atacando=false;
		//vy=devuelveVy;
		try{
		setFrameSpeed (3);
		setSpriteNames( new String[] {"naves/ninja/ninja1.gif","naves/ninja/ninja2.gif"});
		}
		catch(Exception e){
		}
		tiempoAtaqueActual=tiempoAtaque;
		
	}


}