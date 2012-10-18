package netInvaders2;


public class MonsterBiciInicio extends Monster {

	//RECUERDA PONER LA VX Y LA VY POSITIVOS, YA QUE ESTA ES A LA VELOCIDAD QUE SE MOVERA NUESTRA NAVE BANZAI
	int tiempo=0;
	public MonsterBiciInicio(Stage stage) {
		super(stage);
		setSpriteNames( new String[] {"naves/joaquin/joaquin1.png","naves/joaquin/joaquin2.png","naves/joaquin/joaquin3.png","naves/joaquin/joaquin4.png","naves/joaquin/joaquin5.png","naves/joaquin/joaquin6.png","naves/joaquin/joaquin7.png","naves/joaquin/joaquin8.png","naves/joaquin/joaquin9.png","naves/joaquin/joaquin10.png","naves/joaquin/joaquin11.png","naves/joaquin/joaquin12.png","naves/joaquin/joaquin13.png","naves/joaquin/joaquin14.png","naves/joaquin/joaquin15.png","naves/joaquin/joaquin16.png","naves/joaquin/joaquin17.png","naves/joaquin/joaquin18.png"});
		setFrameSpeed (5);
		this.vida=10;
		this.puntosAObtener=0;
		this.furiaAObtener=5;

	}
	
	public void act() {
		super.act();
		tiempo++;
		if(tiempo==87){
			remove();
			Monster f = new MonsterBicicleta(stage,0);
			f.x=x+300;
			f.y=y+70;
			f.vx=15;
			f.vy=15;
			stage.addActor(f);
		}
	}

	

	public void collision(Actor a){
		
	}



}