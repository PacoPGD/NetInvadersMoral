package netInvaders2;

public class MissionFinal extends Actor {

	int tiempo=0;
		
	public MissionFinal(Stage stage) {
		super(stage);
		setSpriteNames( new String[] {"flag/Final.png"});
	
	}
	
	
	public void act() {
		tiempo++;
		if(tiempo>100){
		super.act();
		x+=10;
		y+=0;
		}
		if(x>Stage.WIDTH){
			remove();
		}
		

	}
	
}