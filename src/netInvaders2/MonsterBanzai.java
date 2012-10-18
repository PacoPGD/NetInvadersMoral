package netInvaders2;
import java.util.Random;



public class MonsterBanzai extends Monster {

	Random random = new Random();
	boolean eleccion = random.nextBoolean();
	
	//RECUERDA PONER LA VX Y LA VY POSITIVOS, YA QUE ESTA ES A LA VELOCIDAD QUE SE MOVERA NUESTRA NAVE BANZAI
	
	public MonsterBanzai(Stage stage) {
		super(stage);
		setSpriteNames( new String[] {"naves/banzai.gif"});
		setFrameSpeed (35);
		this.vida=10;
		this.puntosAObtener=3000;
		this.furiaAObtener=3;
		
		
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
		

		
		if (x < 0 || x > Stage.WIDTH-32){
		  vx = -vx;
		}

		

	}


}