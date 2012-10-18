package netInvaders2;

import java.awt.event.KeyEvent;

public class Rafa extends Player {

	public static int ataque;

	public Rafa(Stage stage,int jugador) {
		super(stage);
		setSpriteNames( new String[] {"naves/MasinguerJava.png"});
		nJugador=jugador;
		this.ataque=5;
		this.PLAYER_SPEED = 4 * 2;
		this.MAX_SHIELDS = 6 * 100;
		this.clusterBombs=3 * 2;
		
		this.clusterMax=3;
		
		this.numero=1;
		
		shields = MAX_SHIELDS;
		
		for(int i=1;i<11;i++){
			spriteCache.getSprite("disparos/cruzrafa/cruzRafaHD"+i+".png");
			spriteCache.getSprite("disparos/cruzrafa/cruzRafaHL"+i+".png");
			spriteCache.getSprite("disparos/cruzrafa/cruzRafaVU"+i+".png");
			spriteCache.getSprite("disparos/cruzrafa/cruzRafaVD"+i+".png");
		}
	}

	public void act() {
		super.act();
		
		if(vx>0){
			setSpriteNames( new String[] {"naves/MasinguerJavaGiroDer.png"});
		}
		if(vx<0){
			setSpriteNames( new String[] {"naves/MasinguerJavaGiroIzq.png"});
		}
		if(vx==0){
			setSpriteNames( new String[] {"naves/MasinguerJava.png"});
		}
	}

	public void special(){
		if(fuegoDisponible==1){
			
		Bullet HD = new BalaRafaFinal(stage,nJugador);
		HD.setX(x-25);
		HD.setY(y-17);
		stage.addActor(HD);
		stage.getSoundCache().playSound("sonidos/jesusshot.wav");
		
		Bullet HL = new BalaRafaFinal2(stage,nJugador);
		HL.setX(x-725);
		HL.setY(y -17);
		stage.addActor(HL);

		
		Bullet VU = new BalaRafaFinal3(stage,nJugador);
		VU.setX(x-25);
		VU.setY(y -783);
		stage.addActor(VU);

		
		Bullet VD = new BalaRafaFinal4(stage,nJugador);
		VD.setX(x-25);
		VD.setY(y +18);
		stage.addActor(VD);
		}
	}
	

	public void fire() {
		if(fuegoDisponible==1){
			int i;
			int j=combo;

			if(tiempodisparo>=4){
				tiempodisparo=0;
				for(i=0;i<combo;i++){
					disparosRealizados++;
					Bullet b = new BalaRafa(stage,nJugador);
					b.setX((x+12-((i+j)*2))+i*7);
					b.setY(y - b.getHeight());
					stage.addActor(b);
					stage.getSoundCache().playSound("sonidos/jesusshot.wav");		
				}
			}
		}
	}


	
	

}

