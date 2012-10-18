package netInvaders2;
import java.util.Random;

public class MonsterPortaBicis extends JefeFinal {
		int tiempo=0;
		int i;
		int j;
		protected int vx;
		public static int vy;
		protected static final double FIRING_FREQUENCY2 = 0.01;
		public MonsterPortaBicis(Stage stage) {
			super(stage);
			setSpriteNames( new String[] {"Jefes/portabicis/portaBicis1.gif","Jefes/portabicis/portaBicis2.gif","Jefes/portabicis/portaBicis3.gif","Jefes/portabicis/portaBicis4.gif","Jefes/portabicis/portaBicis5.gif"});
			setFrameSpeed (35);
			this.vida=4000;
			this.vidaT=4000;
			this.puntosAObtener=120000;
			this.furiaAObtener=20;
			this.FIRING_FREQUENCY=0.02;
		}
		
		public void act() {
			super.act();
			x+=((Fase.tiempoTarda*vx)/Fase.retardo)/2;
			y+=((Fase.tiempoTarda*vy)/Fase.retardo)/2;
			tiempo++;
			
			if(tiempo==150){
				for(j=0;j<3;j++){
					for(i=0;i<5;i++){
					BalaEnemiga f = new BalaPortaBicis(stage);
					f.x=x+300-j*40;
					f.y=y+i*40;
					stage.addActor(f);
					}
				}
				tiempo=0;
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

			if(aleatorio.nextFloat()<=0.49){
			Monster f = new MonsterBiciInicio(stage);
			f.x=x+30;
			f.y=y-35;
			stage.addActor(f);
			}
			else{
			Monster g = new MonsterBiciInicio(stage);
			g.x=x+30;
			g.y=y+85;
			stage.addActor(g);
			}
		}

	}