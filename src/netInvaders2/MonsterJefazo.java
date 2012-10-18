package netInvaders2;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

public class MonsterJefazo extends JefeFinal {
		Random random = new Random();
		int i;
		int j;
		int bandera=0;
		protected String[] ventilador;
		protected String[] canon;
		protected String[] cuadro;
		protected String[] via;
		protected String[] torreta;
		protected int vx;
		public static int vy;
		protected static final double FIRING_FREQUENCY2 = 0.02;
		protected static final double FIRING_FREQUENCY3 = 0.02;
		
		public MonsterJefazo(Stage stage) {
			super(stage);
			pinta();
			
			setSpriteNames( new String[] {"Jefes/Jefazo/JefeJefe.gif"});
			setFrameSpeed (35);
			this.vida=20;
			this.vidaT=20000;
			this.puntosAObtener=1000000;
			this.furiaAObtener=20;
			this.FIRING_FREQUENCY=0.02;
		}
		
		public void act() {
			
			super.act();
			x+=((Fase.tiempoTarda*vx)/Fase.retardo)/2;
			y+=((Fase.tiempoTarda*vy)/Fase.retardo)/2;

		if(bandera==0){
			MonsterDesplazable q = new MonsterDesplazable(stage);
			q.setX(x+getWidth()/2);
			q.setY(y+220);
			q.setVx(10);
			q.setVy(0);
			stage.addActor(q);
			bandera=1;
		}
			
		if (Math.random()<FIRING_FREQUENCY)
				fire();

		if(vida<15000){
			if (Math.random()<FIRING_FREQUENCY2)
					fire2();
		}
		
		if(vida<10000){
			if (Math.random()<FIRING_FREQUENCY3)
				fire3();
		}
		}

		public int getVx() { return vx; }
		public void setVx(int i) {vx = i;	}
		public int getVy() { return vy; }
		public void setVy(int i) {vy = i;  }

	
		public void fire3(){
			BalaJefe m = new BalaJefe(stage);
			m.setX(x+270);
			m.setY(y-200);
			stage.addActor(m);
		}
		
		
		public void fire2(){
			int aux;
			aux=(int)(random.nextFloat()*2);
			Random aleatorio = new Random();
			if(aux==0){
			BalaBarco e = new BalaBarco(stage,(int)((aleatorio.nextFloat()*6)-3),0);
			e.setX(x+135);
			e.setY(y+260);
			stage.addActor(e);
			}
			else{
			BalaBarco a = new BalaBarco(stage,(int)((aleatorio.nextFloat()*6)-3),0);
			a.setX(x+535);
			a.setY(y+260);
			stage.addActor(a);
			}
		}
		
		
		public void fire() {
			int aux;
			aux=(int)(random.nextFloat()*6);

			if(aux==0){
				MonsterGeneric n = new MonsterGeneric(stage,0,0);
				n.setX(x+230);
				n.setY(y+25);
				n.setVx(10);
				n.setVy(3);
				stage.addActor(n);
			}
			else{
				if(aux==1){
					MonsterGeneric n = new MonsterGeneric(stage,0,0);
					n.setX(x+410);
					n.setY(y+25);
					n.setVx(-10);
					n.setVy(3);
					stage.addActor(n);
				}
				else{
					if(aux==2){
						MonsterGeneric n = new MonsterGeneric(stage,0,0);
						n.setX(x+230);
						n.setY(y+80);
						n.setVx(8);
						n.setVy(5);
						stage.addActor(n);
					}
					else{
						if(aux==3){
							MonsterGeneric n = new MonsterGeneric(stage,0,0);
							n.setX(x+410);
							n.setY(y+80);
							n.setVx(-8);
							n.setVy(5);
							stage.addActor(n);
						}
						else{
							if(aux==4){
								MonsterGeneric n = new MonsterGeneric(stage,0,0);
								n.setX(x+230);
								n.setY(y+135);
								n.setVx(5);
								n.setVy(7);
								stage.addActor(n);
							}
							else{
								MonsterGeneric n = new MonsterGeneric(stage,0,0);
								n.setX(x+410);
								n.setY(y+135);
								n.setVx(-5);
								n.setVy(7);
								stage.addActor(n);
							}
						}
					}
				}
			}

		}
		

		
		public void paint(Graphics2D g){
			super.paint(g);
			g.drawImage( spriteCache.getSprite(spriteNames[currentFrame]), (int)x,(int)y, stage );
		
			g.drawImage( spriteCache.getSprite(ventilador[currentFrame]), (int)x+105,(int)y+80, stage );
			g.drawImage( spriteCache.getSprite(ventilador[currentFrame]), (int)x+500,(int)y+80, stage );
			g.drawImage( spriteCache.getSprite(canon[currentFrame]), (int)x+310,(int)y, stage );
			g.drawImage( spriteCache.getSprite(cuadro[currentFrame]), (int)x+230,(int)y+20, stage );
			g.drawImage( spriteCache.getSprite(cuadro[currentFrame]), (int)x+230,(int)y+80, stage );
			g.drawImage( spriteCache.getSprite(cuadro[currentFrame]), (int)x+230,(int)y+140, stage );
			
			g.drawImage( spriteCache.getSprite(cuadro[currentFrame]), (int)x+410,(int)y+20, stage );
			g.drawImage( spriteCache.getSprite(cuadro[currentFrame]), (int)x+410,(int)y+80, stage );
			g.drawImage( spriteCache.getSprite(cuadro[currentFrame]), (int)x+410,(int)y+140, stage );
			
			
			g.drawImage( spriteCache.getSprite(torreta[currentFrame]), (int)x+100,(int)y+200, stage );
			g.drawImage( spriteCache.getSprite(torreta[currentFrame]),(int)x+495,(int)y+200, stage );
			
			g.drawImage( spriteCache.getSprite(via[currentFrame]), (int)x+225,(int)y+220, stage );
		}
		
		
		public void pinta() { 
			ventilador = new String[] {"Jefes/Jefazo/ventiladores1.png","Jefes/Jefazo/ventiladores2.png","Jefes/Jefazo/ventiladores3.png","Jefes/Jefazo/ventiladores4.png"};
			for (int i = 0; i < ventilador.length; i++) {
				BufferedImage image = spriteCache.getSprite(ventilador[i]);
			}
			
			canon = new String[] {"Jefes/Jefazo/ultraCanon.png"};
			for (int i = 0; i < canon.length; i++) {
				BufferedImage image = spriteCache.getSprite(canon[i]);
			}
			
			cuadro = new String[] {"Jefes/Jefazo/lanzador.png"};
			for (int i = 0; i < cuadro.length; i++) {
				BufferedImage image = spriteCache.getSprite(cuadro[i]);
			}
			via = new String[] {"Jefes/Jefazo/rail.png"};
			for (int i = 0; i < via.length; i++) {
				BufferedImage image = spriteCache.getSprite(via[i]);
			}
			
			torreta = new String[] {"Jefes/Jefazo/torreta.png"};
			for (int i = 0; i < torreta.length; i++) {
				BufferedImage image = spriteCache.getSprite(torreta[i]);
			}
		}	

		
	}