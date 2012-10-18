package netInvaders2;
public class MonsterSuperNet extends JefeFinal {

		public static double FIRING_FREQUENCY2 = 0.005;
		public MonsterSuperNet(Stage stage) {
			super(stage);
			setSpriteNames( new String[] {"Jefes/net/nave1.png"});
			setFrameSpeed (35);
			this.vida=4000;
			this.vidaT=4000;
			this.puntosAObtener=250000;
			this.furiaAObtener=50;
			this.FIRING_FREQUENCY=0.05;
		}
		

		public void act() {
			super.act();
			x+=((Fase.tiempoTarda*vx)/Fase.retardo)/2;
			y+=((Fase.tiempoTarda*vy)/Fase.retardo)/2;
			
			if (x < 0 && vx<0){
				  vx = -vx;
				}
				if(x>Stage.WIDTH-100 && vx>0){
					vx = -vx;
				}
				
			if (y > Stage.HEIGHT || y < 0){
				remove();
			}
			
		if (Math.random()<FIRING_FREQUENCY)
				fire();
		if (Math.random()<FIRING_FREQUENCY2)
			duplicado();
		}



	
		public void fire() {
			LaserBola m = new LaserBola(stage);
			m.setX(x+getWidth()-40);
			m.setY(y + getHeight());
			stage.addActor(m);
			stage.getSoundCache().playSound("sonidos/photon.wav");

			
		}
		public void duplicado(){
			MonsterGeneric n = new MonsterGeneric(stage,0,0);
			n.setX(x+100);
			n.setY(y+50);
			n.setVx(10);
			n.setVy(1);
			stage.addActor(n);

		} 
	}
