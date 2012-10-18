package netInvaders2;

public class JuanBot extends Bot {
	
	static int orden=0;
	int i;
	public static int vx;
	public static int vy;
	public static int ataque=8;
	public JuanBot(Stage stage) {
		super(stage);
		setSpriteNames( new String[] {"naves/GreenSnaug.png"});
		setFrameSpeed (35);

		
		for(i=1;i<=13;i++){
			spriteCache.getSprite("disparos/especialLoki/especialNaveLoki"+i+".gif");
			}
	}


	
	public void act() {
		super.act();
		x+=((Fase.tiempoTarda*vx)/Fase.retardo)/2;
		y+=((Fase.tiempoTarda*vy)/Fase.retardo)/2;
		
		if (x < 0 && vx<0){
			  vx = -vx;
			}
			if(x>Stage.WIDTH-32 && vx>0){
				vx = -vx;
			}
		if (y > Stage.HEIGHT || y < 0){
			remove();
		}
		
		if(vx>0){
			setSpriteNames( new String[] {"naves/GreenSnaugGiroDer.png"});
		}
		if(vx<0){
			setSpriteNames( new String[] {"naves/GreenSnaugGiroIzq.png"});
		}
		if(vx==0){
			setSpriteNames( new String[] {"naves/GreenSnaug.png"});
		}
		
		
		if (Math.random()<FIRING_FREQUENCY){
			fire();
		}
		if(orden==1){
			special();
		}
	}
	
	
	public int getVx() { return vx; }
	public void setVx(int i) {vx = i;	}
	public int getVy() { return vy; }
	public void setVy(int i) {vy = i;  }

		
	public void fire() {
		if(fuegoDisponible==1){
			int i;
			int j=combo;


				for(i=0;i<combo;i++){
					Bullet b = new BalaJuan(stage,nJugador);
					b.setX((x+20-((i+j)*2))+i*7);
					b.setY(y - b.getHeight());
					stage.addActor(b);
					stage.getSoundCache().playSound("sonidos/jesusshot.wav");		
				}
			
		}
	}
	
	
	public void special(){
		if(fuegoDisponible==1){
		Bullet b = new BalaJuanFinal(stage,nJugador);
		b.setX(x-240);
		b.setY(y - b.getHeight()+250);
		stage.addActor(b);
		stage.getSoundCache().playSound("sonidos/jesusshot.wav");
		}
	}
	
	
	
}