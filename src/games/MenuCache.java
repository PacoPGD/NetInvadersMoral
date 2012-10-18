package games;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class MenuCache {

	public HashMap sprites=new HashMap();
	private static MenuCache spriteCache = null;
	
	public static MenuCache getSpriteCache () {
		if  (spriteCache == null) {
			spriteCache = new MenuCache();
		}
		return spriteCache;
	}
	
	public BufferedImage loadImage(String nombre) {

		URL url=null;
		try {
			url = getClass().getClassLoader().getResource(nombre);
		return ImageIO.read(url);
		} catch (Exception e) {
		System.out.println("No se pudo cargar la imagen " + nombre +" de "+url);
		System.out.println("El error fue : "+e.getClass().getName()+" "+e.getMessage());
		System.exit(0);
		return null;
		}
	}
	public BufferedImage getSprite(String nombre) {
		BufferedImage img = (BufferedImage)sprites.get(nombre);
		if (img == null) {
			img = loadImage("res/"+nombre);
			sprites.put(nombre,img);
		}
		return img;
	}
	
	static Thread t=null;
	static boolean suena=false;
	public static void stopMenuMusic(){
		if(t!=null){
			t.stop();
			suena=false;
		}
	}
	public static void playmp3(){
		if(netInvaders2.Opciones.Preferencias.sonidoMusica && !suena){
			playmp3Thread();
			suena=true;
		}
	}
	public static void  playmp3Thread(){
		new Thread(
				new Runnable() {
					public void run() {	
						t=Thread.currentThread();
						
						String nameSong="res/musica/You Make Me Crazy.mp3";
						
						InputStream in = null;
						try {
							while(true){
								//in = new FileInputStream(f);
								in =getClass().getClassLoader().getResourceAsStream(nameSong);
								Player p =new Player(in);								
								p.play();
							}
						} catch (JavaLayerException e) {
							System.out.println("nada mp3 "+nameSong );
						}
					}
				}
		).start();
	}	
}
