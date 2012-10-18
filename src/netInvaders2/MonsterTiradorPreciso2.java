package netInvaders2;
import java.util.Random;



public class MonsterTiradorPreciso2 extends Monster {


	boolean eleccion;
	//RECUERDA PONER LA VX Y LA VY POSITIVOS, YA QUE ESTA ES A LA VELOCIDAD QUE SE MOVERA NUESTRA NAVE BANZAI
	
	public MonsterTiradorPreciso2(Stage stage,boolean elegir) {
		super(stage);
		setSpriteNames( new String[] {"naves/preciso2.gif"});
		setFrameSpeed (35);
		this.vida=10;
		this.puntosAObtener=1500;
		this.furiaAObtener=2;
		this.FIRING_FREQUENCY=0.1;
		eleccion=elegir;
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
			if(Fase.yplayer+220<y){
				y-=((Fase.tiempoTarda*vy)/Fase.retardo)/2;
			}
			if(Fase.yplayer+220>y){
				y+=((Fase.tiempoTarda*vy)/Fase.retardo)/2;
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
				if(Fase.yplayer+220<y){
					y-=((Fase.tiempoTarda*vy)/Fase.retardo)/2;
				}
				if(Fase.yplayer+220>y){
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
				if(Fase.yplayer2+220<y){
					y-=((Fase.tiempoTarda*vy)/Fase.retardo)/2;
				}
				if(Fase.yplayer2+220>y){
					y+=((Fase.tiempoTarda*vy)/Fase.retardo)/2;
				}
			}
			
			
		}
		
		
		

		


		if (Math.random()<FIRING_FREQUENCY)
			fire();

	}



	
	
	public void fire() {
		LaserArriba m = new LaserArriba(stage);
		m.setX(x+getWidth()/2);
		m.setY(y );
		stage.addActor(m);
		stage.getSoundCache().playSound("sonidos/photon.wav");
	}
	
	public void collision(Actor a){

		
		if(vida<=0 && bichoMuerto==false){
			bichoMuerto=true;
			
			Explosion n = new Explosion(stage);
			n.setX(x);
			n.setY(y);

			stage.addActor(n);
			
			
			stage.getSoundCache().playSound("sonidos/explosion.wav");

			if(selecciona!=3){
			stage.getPlayer(selecciona).addFury(furiaAObtener);
			stage.getPlayer(selecciona).addScore(puntosAObtener);
			}

			remove();
		}
	}

}
