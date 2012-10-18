package netInvaders2;

public class Barras extends Actor {

	protected int vx;
	protected int vy;
	
	
	int bandera=0;
	public Barras(Stage stage) {
		super(stage);
		setSpriteNames( new String[] {"barra.gif"});

	}

	public void collision(Actor a){

		
			if(a instanceof Player){
				if(bandera==0){
				stage.getSoundCache().playSound("sonidos/barra.wav");
				bandera=1;
				//Mission2.Addbandera();
				stage.getPlayer(1).addScore(50);
				stage.getPlayer(1).addFury(5);
				}
			}
	}
	
	
	public void act() {
		super.act();
		x+=vx;
		y+=vy;
		
		if (x < 0 || x > Stage.WIDTH-32){
		  vx = -vx;
		  
		}
		if (y > Stage.HEIGHT || y < 0){
			remove();
		}
	}
	
	
	public int getVx() { return vx; }
	public void setVx(int i) {vx = i;	}
	public int getVy() { return vy; }
	public void setVy(int i) {vy = i;  }
	

}
