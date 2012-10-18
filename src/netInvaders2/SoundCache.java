package netInvaders2;




import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.ThreadFactory;

import netInvaders2.Opciones.Preferencias;

import com.sun.org.apache.xml.internal.utils.ThreadControllerWrapper.ThreadController;

import sun.awt.windows.ThemeReader;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javazoom.jl.player.PlayerApplet;

public class SoundCache extends ResourceCache{
	String name="musica/mision1.mp3";
	
	boolean loop;
	Thread t=null;
	public void SetSongMp3(String song){ name=song; }
	public void PlaySongMp3(String song){
		if(Preferencias.sonidoMusica){
			name=song;
			loop=false;
			playmp3();
		}
	}
	public void PlaySongMp3(String song, boolean repeat){
		if(Preferencias.sonidoMusica){
			name=song;
			loop=repeat;
			playmp3();
		}
	}
	public void hacerLoop(){ loop=true; }
	public void StopSongMp3(){
		if(t!=null){ t.stop(); } 
	}
	public void  playmp3(){
		new Thread(
				new Runnable() {
					public void run() {
						t=Thread.currentThread();
						String name2="res/"+name;

						InputStream in = null;
						try {
							while(loop){
								in =getClass().getClassLoader().getResourceAsStream(name2);
								Player p =new Player(in);
								p.play();
							}
						} catch (JavaLayerException e) {
							System.out.println("nada mp3 "+name2 );
						}

					}
				}
		).start();
	}
	
    protected Object loadResource(URL url) {
    	return Applet.newAudioClip(url); 	
	}

	public  Object getAudioClip(String name) {
		return getResource(name);
	}
	public void playSoundCharla(final String name) {
			new Thread(
					new Runnable() {
						public void run() {
							((AudioClip) getAudioClip(name)).play();
						}
					}
			).start();
	}
	public void playSound(final String name) {
		if(Preferencias.sonidoEfectos){
			new Thread(
					new Runnable() {
						public void run() {
							((AudioClip) getAudioClip(name)).play();
						}
					}
			).start();
		}
	}

	public void loopSound(final String name) {
		new Thread(
				new Runnable() {
					public void run() {
							((AudioClip) getAudioClip(name)).loop();
					}
				}
			).start();
	}
}



/*
		name="C:/JAVA/PROYECTOS/NetInvaders2/src/res/"+name;
		System.out.println("en play  "+name);
		File f=new File(name);
		InputStream in = null;
		try {
			in = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			System.out.println("nada de abrir ficheros");
			//e.printStackTrace();
		}
		try {
			Player p =new Player(in);
			p.play();
		} catch (JavaLayerException e) {
			System.out.println("nada mp3");
			//e.printStackTrace();
		}
*/

/*
public void setSongMp3(String song){
name=song;
}
public void  playmp3(){
new Thread(
		new Runnable() {
			public void run() {
				String name2=getClass().getClassLoader()+"res/"+name;
				System.out.println("en play  "+name);
				url = getClass().getClassLoader().getResource(nombre);
				File f=new File(name2);
				InputStream in = null;
				try {
					in = new FileInputStream(f);
					Player p =new Player(in);
					p.play();
				} catch (JavaLayerException e) {
					System.out.println("nada mp3 "+name2 );
				}catch (FileNotFoundException e) {
					System.out.println("nada de abrir ficheros "+name2 );
				}
			}
		}
).start();
}
*/