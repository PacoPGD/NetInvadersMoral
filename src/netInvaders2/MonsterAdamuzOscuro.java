package netInvaders2;
import java.util.Random;

public class MonsterAdamuzOscuro extends JefeFinal {
	
		Random aleatorio = new Random();
		protected int vx;
		public static int vy;
		int comportamiento=1;
		public MonsterAdamuzOscuro(Stage stage) {
			super(stage);
			setSpriteNames( new String[] {"Jefes/adamuzSurfer100.gif"});
			setFrameSpeed (35);
			this.vida=5000;
			this.vidaT=5000;
			this.puntosAObtener=500000;
			this.furiaAObtener=20;
			this.FIRING_FREQUENCY=0.03;
		}
		
		public void act() {
			super.act();
			
			
			
			x+=((Fase.tiempoTarda*vx)/Fase.retardo)/2;
			y+=((Fase.tiempoTarda*vy)/Fase.retardo)/2;

				
			if(vida>=4000){
				if (x < 0 && vx<0){
					  vx = -vx;
					}
					if(x>Stage.WIDTH-200 && vx>0){
						vx = -vx;
					}
					
				if(comportamiento==1){
					vx=2;
					vy=0;
					comportamiento=2;
				}
				if (Math.random()<FIRING_FREQUENCY)
				fire();
			}
			
			
			if(vida>=3000 && vida<4000){
				
				if(comportamiento==2){
					vx=0;
					vy=0;
					comportamiento=3;
				}
				if (Math.random()<FIRING_FREQUENCY/2){
					teleport();
					shurikenShots();
				}
			}
			
			if(vida>=2000 && vida <3000){
				if(comportamiento==3){
					vx=14;
					comportamiento=4;
				}
				
				
				if (x < 0 && vx<0){
					y=(int)((aleatorio.nextFloat()*300));
					  vx = -vx;
					}
					if(x>Stage.WIDTH-100 && vx>0){
						y=(int)((aleatorio.nextFloat()*300));
						vx = -vx;
					}

					
				if (Math.random()<FIRING_FREQUENCY){
					shurikenShots();
				}
	
			}
			
			if(vida>=1000 && vida <2000){
				if(comportamiento==4){
					Charla.getCharla().adamuzOscuroConf();
					Charla.getCharla().setMensaje("NO ME PUEDES VENCER, ¡SOY ADAMUZ OSCURO!");
					vx=0;
					x=350;
					y=0;
					comportamiento=5;
				}

				if (Math.random()<FIRING_FREQUENCY*2){
					shurikenShots();
				}
				if (Math.random()<FIRING_FREQUENCY){
					fire();
				}
				if (Math.random()<FIRING_FREQUENCY){
					generaNinja();
				}
				
			}
			
			if(vida>0 && vida <1000){
				
				if (x < 0 && vx<0){
					y=(int)((aleatorio.nextFloat()*300));
					  vx = -vx;
					}
					if(x>Stage.WIDTH-100 && vx>0){
						y=(int)((aleatorio.nextFloat()*300));
						vx = -vx;
					}
				
				
				if(comportamiento==5){
					vx=10;
					Charla.getCharla().adamuzOscuroConf();
					Charla.getCharla().setMensaje("GRRRRAAAAAAAAAAAAAAAAAAARGGG");
					comportamiento=6;
				}
				if (Math.random()<FIRING_FREQUENCY*1){
					fire();
				}
				if (Math.random()<FIRING_FREQUENCY*2){
					shurikenShots();
				}
				if (Math.random()<FIRING_FREQUENCY){
					generaNinja();
				}
			}
		}

		public int getVx() { return vx; }
		public void setVx(int i) {vx = i;	}
		public int getVy() { return vy; }
		public void setVy(int i) {vy = i;  }

	
	
		public void fire() {
			LaserAdamuz f = new LaserAdamuz(stage);
			f.setX(x+getWidth()-70);
			f.setY(y+getHeight());
			stage.addActor(f);
		}
		
		public void teleport() {
			
			x=(int)((aleatorio.nextFloat()*400)+100);
			y=(int)((aleatorio.nextFloat()*200));
		}
		
		public void shurikenShots(){
			int i;
			for(i=0;i<8;i++){
			LaserMultipleShuriken m = new LaserMultipleShuriken(stage,i+1);
			m.setX(x-20+getWidth()/2);
			m.setY(y-20 + getHeight());
			stage.addActor(m);
			}			
		}
		
		public void generaNinja(){
			MonsterNinja m = new MonsterNinja(stage,0);
			m.setX((int)(Math.random()*700));
			m.setY(500);
			m.setVx(5);
			m.setVy(5);
			stage.addActor(m);
		}
	}
