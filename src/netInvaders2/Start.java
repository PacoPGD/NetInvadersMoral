package netInvaders2;

public class Start extends Actor {

	int tiempo=0;
		
	public Start(Stage stage) {
		super(stage);
		setSpriteNames( new String[] {"flag/Start.png"});
	
	}
	
	
	public void act() {
		tiempo++;
		if(tiempo>100){
		super.act();
		x+=0;
		y+=7;
		}
		if(y>Stage.HEIGHT){
			remove();
		}
		

	}
	
}
