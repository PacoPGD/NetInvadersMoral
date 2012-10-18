package netInvaders2;
import java.util.Random;

public class MonsterBarco extends JefeFinal {

		protected int vx;
		public static int vy;
		protected static final double FIRING_FREQUENCY2 = 0.01;
		public MonsterBarco(Stage stage) {
			super(stage);
			setSpriteNames( new String[] {"Jefes/Barco2.png"});
			setFrameSpeed (35);
			this.vida=1200;
			this.vidaT=1200;
			this.puntosAObtener=50000;
			this.furiaAObtener=20;
			this.FIRING_FREQUENCY=0.03;
		}
		
		public void act() {
			super.act();
			
			x+=((Fase.tiempoTarda*vx)/Fase.retardo)/2;
			y+=((Fase.tiempoTarda*vy)/Fase.retardo)/2;
			if (x < 0 && vx<0){
				  vx = -vx;
				}
				if(x>Stage.WIDTH-282 && vx>0){
					vx = -vx;
				}
				

			
		if (Math.random()<FIRING_FREQUENCY)
				fire();

		}

		public int getVx() { return vx; }
		public void setVx(int i) {vx = i;	}
		public int getVy() { return vy; }
		public void setVy(int i) {vy = i;  }

	
	
		public void fire() {
			
			Random aleatorio = new Random();
			
			BalaBarco f = new BalaBarco(stage,(int)((aleatorio.nextFloat()*6)-3));
			//System.out.println(aleatorio.nextFloat()*3);
			f.setX(x+getWidth()-280);
			f.setY(y+getHeight()-90);
			stage.addActor(f);
			
			BalaBarco e = new BalaBarco(stage,(int)((aleatorio.nextFloat()*6)-3));
			e.setX(x+getWidth()-253);
			e.setY(y+getHeight()-88);
			stage.addActor(e);
			BalaBarco a = new BalaBarco(stage,(int)((aleatorio.nextFloat()*6)-3));
			a.setX(x+getWidth()-220);
			a.setY(y+getHeight()-90);
			stage.addActor(a);
			
			BalaBarco m = new BalaBarco(stage,(int)((aleatorio.nextFloat()*6)-3));
			m.setX(x+getWidth()-188);
			m.setY(y+getHeight()-85);
			stage.addActor(m);
			BalaBarco c = new BalaBarco(stage,(int)((aleatorio.nextFloat()*6)-3));
			c.setX(x+getWidth()-155);
			c.setY(y+getHeight()-85);
			stage.addActor(c);
			BalaBarco d = new BalaBarco(stage,(int)((aleatorio.nextFloat()*6)-3));
			d.setX(x+getWidth()-128);
			d.setY(y+getHeight()-85);
			stage.addActor(d);
			//stage.getSoundCache().playSound("sonidos/photon.wav");

		}

	}
