package netInvaders2;


import java.awt.image.ImageObserver;

public interface Stage extends ImageObserver {
	public static final int WIDTH=800;
	public static final int HEIGHT=640;
	public static final int SPEED=10;
	public static final int PLAY_HEIGHT = 500;
	public SpriteCache getSpriteCache();
	public SoundCache getSoundCache();
	public void addActor(Actor a);
	public Player getPlayer(int jugador);
	public void gameOver();

}