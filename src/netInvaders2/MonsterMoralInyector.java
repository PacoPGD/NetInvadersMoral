package netInvaders2;

import java.util.Random;

public class MonsterMoralInyector extends JefeFinal {

		protected int vx=5;
		protected int vy;

		public MonsterMoralInyector(Stage stage) {
			super(stage);
			setSpriteNames( new String[] {"Jefes/MoralInyector.png"});
			setFrameSpeed (35);
			this.vida=15000;
			this.vidaT=15000;
			this.puntosAObtener=500000;
			this.furiaAObtener=200;
			this.FIRING_FREQUENCY=0.03;
		}
		
		public void act() {
			super.act();
			x+=((Fase.tiempoTarda*vx)/Fase.retardo)/2;
			y+=((Fase.tiempoTarda*vy)/Fase.retardo)/2;
			
			if (x < 0){
			  vx = Math.abs(vx);
		
			}
			if(x > Stage.WIDTH-this.width){
				vx=-Math.abs(vx);
			}
			if (y > Stage.HEIGHT || y < 0){
				remove();
			}
			
			if (Math.random()<FIRING_FREQUENCY)
				fire();

		}



	
		public void fire() {
    		Random aleatorio2 = new Random();
			LaserInyector m = new LaserInyector(stage,(int)((aleatorio2.nextFloat()*10)-5));
			m.setX(x+100);
			m.setY(y + getHeight()-200);
			stage.addActor(m);
			
    		Random aleatorio = new Random();
			LaserInyector g = new LaserInyector(stage,(int)((aleatorio.nextFloat()*10)-5));
			g.setX(x+getWidth()/2);
			g.setY(y + getHeight()-100);
			stage.addActor(g);

    		Random aleatorio3 = new Random();
			LaserInyector h = new LaserInyector(stage,(int)((aleatorio2.nextFloat()*10)-5));
			h.setX(x+this.width-100);
			h.setY(y + getHeight()-200);
			stage.addActor(h);

		}

	}
