package netInvaders2;

import java.util.Random;


public class MonsterBicicleta extends Monster {

	
	Random random = new Random();
	boolean eleccion = random.nextBoolean();
	//RECUERDA PONER LA VX Y LA VY POSITIVOS, YA QUE ESTA ES A LA VELOCIDAD QUE SE MOVERA NUESTRA NAVE BANZAI
	
	public MonsterBicicleta(Stage stage) {
		super(stage);
		setSpriteNames( new String[] {"naves/joaquin/joaquin.png"});
		setFrameSpeed (35);
		this.vida=10;
		this.puntosAObtener=3500;
		this.furiaAObtener=5;

	}
	
	public MonsterBicicleta(Stage stage,int puntos) {
		super(stage);
		setSpriteNames( new String[] {"naves/joaquin/joaquin.png"});
		setFrameSpeed (35);
		this.vida=10;
		this.puntosAObtener=0;
		this.furiaAObtener=5;

	}
	
	public void act() {
		super.act();
		
		
		if(NuevoJuego.nJugadores==1){
			
			
			if(Fase.xplayer>x-10){
				setSpriteNames( new String[] {"naves/joaquin/joaquinderecha.png"});
				x+=((Fase.tiempoTarda*vx)/Fase.retardo)/2;
				
			}
			if(Fase.xplayer<x+10){
				x-=((Fase.tiempoTarda*vx)/Fase.retardo)/2;
				setSpriteNames( new String[] {"naves/joaquin/joaquinizquierda.png"});
			}
			if(Fase.xplayer>=x-10 && Fase.xplayer<=x+10){
				setSpriteNames( new String[] {"naves/joaquin/joaquin.png"});
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
				
				
				
				
				if(Fase.xplayer>x-10){
					setSpriteNames( new String[] {"naves/joaquin/joaquinderecha.png"});
					x+=((Fase.tiempoTarda*vx)/Fase.retardo)/2;
					
				}
				if(Fase.xplayer<x+10){
					x-=((Fase.tiempoTarda*vx)/Fase.retardo)/2;
					setSpriteNames( new String[] {"naves/joaquin/joaquinizquierda.png"});
				}
				if(Fase.xplayer>=x-10 && Fase.xplayer<=x+10){
					setSpriteNames( new String[] {"naves/joaquin/joaquin.png"});
				}

			}
			
			else{
				if(Fase.segundoVivo==0){
			        eleccion=true;
					}
				
				if(Fase.primeroVivo==0){
					eleccion=false;
				}
				
				
				if(Fase.xplayer2>x-10){
					setSpriteNames( new String[] {"naves/joaquin/joaquinderecha.png"});
					x+=((Fase.tiempoTarda*vx)/Fase.retardo)/2;
				
				}
				if(Fase.xplayer2<x+10){
					x-=((Fase.tiempoTarda*vx)/Fase.retardo)/2;
					
					setSpriteNames( new String[] {"naves/joaquin/joaquinizquierda.png"});
				}
				if(Fase.xplayer2>=x-10 && Fase.xplayer2<=x+10){
					setSpriteNames( new String[] {"naves/joaquin/joaquin.png"});
				}

			}
			
		}

		
		if (x < 0 || x > Stage.WIDTH-32){
		  vx = -vx;
		}


		if (y > Stage.HEIGHT || y < 0){
			remove();
		}
		
		y+=((Fase.tiempoTarda*vy)/Fase.retardo)/2;

	}



}