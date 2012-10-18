package netInvaders2;
import java.util.Random;



public class MonsterTiradorPreciso extends Monster {

	Random random = new Random();
	boolean eleccion = random.nextBoolean();
	//RECUERDA PONER LA VX Y LA VY POSITIVOS, YA QUE ESTA ES A LA VELOCIDAD QUE SE MOVERA NUESTRA NAVE BANZAI
	
	public MonsterTiradorPreciso(Stage stage) {
		super(stage);
		setSpriteNames( new String[] {"naves/preciso.gif"});
		setFrameSpeed (35);
		this.vida=10;
		this.puntosAObtener=1500;
		this.furiaAObtener=2;
		this.FIRING_FREQUENCY=0.1;
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
			if(Fase.yplayer-300<y){
				y-=((Fase.tiempoTarda*vy)/Fase.retardo)/2;
			}
			if(Fase.yplayer-300>y){
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
				if(Fase.yplayer-300<y){
					y-=((Fase.tiempoTarda*vy)/Fase.retardo)/2;
				}
				if(Fase.yplayer-300>y){
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
				if(Fase.yplayer2-300<y){
					y-=((Fase.tiempoTarda*vy)/Fase.retardo)/2;
				}
				if(Fase.yplayer2-300>y){
					y+=((Fase.tiempoTarda*vy)/Fase.retardo)/2;
				}
			}
			
			
		}
		
		
		

		
	

		if (Math.random()<FIRING_FREQUENCY)
			fire();

	}



	
	
	public void fire() {
		Laser m = new Laser(stage,2);
		m.setX(x+getWidth()/2);
		m.setY(y + getHeight());
		stage.addActor(m);
		stage.getSoundCache().playSound("sonidos/photon.wav");
	}
	
	
}