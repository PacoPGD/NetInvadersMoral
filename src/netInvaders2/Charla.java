package netInvaders2;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.net.URL;
import java.util.Random;

import netInvaders2.Opciones.Preferencias;

import sun.font.FontManager;


/**
 * 
 * @author Jesus Rodriguez Perez
 * @version 1.2
 * 
 * <dt>Charla</dt><dd>Muestra dialogos con avatares y sonidos</dd>
 * <dt>Modo de uso</dt>
 * <dd>
 * <pre>Construir un objeto charla de la sigiente manera donde g es Graphics2D
 * <code>Charla.getCharla().paint(g);<code></pre>
 * <pre>Cuando se quiera mostrar un mensaje:
 * <code>Charla.getCharla().setMensaje("mensaje de Jesús");<code></pre>
 * <pre>Tambien se pueden modificar la gran malloria de las variables utilizando por ejemplo
 * <code>Charla.getCharla().setFuente(new Font("Arial",Font.BOLD,20));
 * Charla.getCharla().setColores(Color.blue, Color.RED);<code></pre>
 * </dd>
 *
 */

public class Charla implements ImageObserver{
	private SpriteCache spriteCache = new SpriteCache();;
	private SoundCache soundCache = new SoundCache();
	private int i=0;
	private int tiempoPorCaracter=70;
	private int timeMode=2;//0 no time	1 manual	2 automatico TO-DO!
	private String avatar="personajes/Pdamon.gif";
	private Color ColorFondo=(Color.ORANGE);
	private Font fuente=new Font("Arial",Font.BOLD,12);	
	long startTime;
	private boolean banderaSalir=false;
	private boolean sonidoActivo=Preferencias.sonidoCharla;
	private boolean soloTexto=false;
	StringBuffer mensaje = new StringBuffer("");
	private static Charla charla = null;
	int iTrans;
	private Random rand = new Random();
	private int y=490;
	private int xTexto= 140;
	private int interlineado=15;
	private int yTexto=y+22+interlineado;
	private int caracteresPorLinea=60;
	private String cajaCharla="personajes/cajaCharla.gif";
	private String imgagenSuperior="personajes/cajaCharlaPorEncima.gif";
	//private Color ColorTexto=new Color(0x2e6c00);
	private Color ColorTexto=new Color(0xFFFFFF);
	
	public Charla() {	}
	
	public static Charla getCharla() {
		if (charla == null) {
			charla = new Charla();
		}
		return charla;
	}
	
	public void setY(int y){ this.y=y; }
	public void setXTexto(int x){ xTexto=x; }
	public void setFuente(Font newFont){ fuente=newFont; }
	public void setAvatar(String img){ avatar=img; }
	public void setSonido(boolean onOf){ sonidoActivo=onOf; }
	public void soloTexto(boolean onOf){ soloTexto=onOf; }
	public void setColores(Color texto, Color fondo){
		ColorTexto=texto;
		ColorFondo=fondo;
	}
	

	public void setMensaje (String msj) {
		msj=adapta(msj);
		mensaje = new StringBuffer (msj);
		i = 0;
		startTime = System.currentTimeMillis();
		banderaSalir=false;
	}
	
	private String adapta(String msj) {
		try{
			for(int fila=1; fila<(msj.length()/caracteresPorLinea)+1;fila++){
				//detecto que hay corte
				if((msj.length()>caracteresPorLinea*fila) && (msj.charAt(caracteresPorLinea*fila-1)!=' ' && msj.charAt(caracteresPorLinea*fila)!=' ')){
					int k=caracteresPorLinea*fila-1;
					//detecto donde esta la palabra que corta
					while(k>(caracteresPorLinea*fila-10) && !((msj.charAt(k)==' ') )){ k--; /*print(""+k);*/ }
					String anadido = "";
					if(msj.charAt(k)!=' '){
						anadido="-";
					}
					//introduzco los espacios en blanco necesarios
					msj=msj.substring(0, k)+anadido+dameEspacios(caracteresPorLinea*fila-k-1)+ msj.substring(k, msj.length());
				}
			}
		}catch(Exception e){
			//print("ERROR AL INTENTAR TRANSFORMAR CADENA");
			return "ERROR AL INTENTAR TRANSFORMAR CADENA en la clase charla";
		}
		return msj;
	}

	private String dameEspacios(int n){
		String espacios="";
		for(int i=0;i<n;i++){
			espacios+=" ";
		}		
		return espacios;
	}
	
	public void addMensaje (String msj) {
		mensaje.append(msj);
		banderaSalir=false;
	}
	
	public void paint(Graphics2D g){
		if (!mensaje.equals("") && i <= mensaje.length() && mensaje.length()>0 && banderaSalir==false) {
			if(!soloTexto){
				g.drawImage( spriteCache.getSprite(cajaCharla),0,y,charla);
				g.drawImage( spriteCache.getSprite(avatar), 45,y+16,charla);
			}
			
			g.setFont(fuente);
			g.setColor(ColorTexto);
			
			for(int principio=0,finalSub=i,fila=1; fila<=(i/caracteresPorLinea)+1; fila++){
				
				principio=(fila*caracteresPorLinea)-caracteresPorLinea;

				if(i>caracteresPorLinea/fila){ finalSub=(fila*caracteresPorLinea); }
				if(fila*caracteresPorLinea>i){ finalSub=i; }
				
				g.drawString(mensaje.substring(principio, finalSub),xTexto, yTexto+interlineado*fila);
			}
			
			long nowTime=System.currentTimeMillis();
			

			if( (nowTime-startTime)>(mensaje.length()*tiempoPorCaracter) ){
					banderaSalir=true;
			}
			else{
				if(i < mensaje.length()){
					if(Preferencias.sonidoCharla && i%3==0){
						diLetra(mensaje.charAt(i));
					}
					i++;
				}
				if(!soloTexto){//efectos especiales
					g.drawString(avatar.substring(11, avatar.length()-4), 155, y+25);
					//g.drawImage( spriteCache.getSprite(imgagenSuperior), 35,y+10,charla);
					g.drawString(get01Aleatorios(13), 655, y+70);
					g.drawString(get01Aleatorios(13), 655, y+80);
					g.drawString(get01Aleatorios(13), 655, y+90);
				}
			}
		}
	}
	
	public String get01Aleatorios(int numeroCaracteres){
		String cadena="";
		
		for(int i=0;i<numeroCaracteres;i++){
			if(rand.nextBoolean()){
				cadena=cadena+"1";
			}
			else{
				cadena=cadena+"0";
			}
		}
		return cadena;
	}
	
	
	public int getAutoTime(){
		return (mensaje.length()*tiempoPorCaracter);
	}
	
	public void diLetra(char c){
		if( (c>='a' && c<='z'  || (c>=0 || c<=9) || (c>='A' && c<='Z'))){ //if( c!=' ')
			//print("personajes/sonidos/"+avatar.substring(11,avatar.length()-4) + ((int)(c%5)+1)+".wav");
			soundCache.playSoundCharla("personajes/sonidos/"+avatar.substring(11,avatar.length()-4) + ((int)(c%5)+1)+".wav");
		}
	}

	public void print(String frase){ System.out.println(frase); }
	
	public void transDesaperecerUp(){
		y-=2;
		yTexto-=2;
	}
	public void quitaMensaje(){ banderaSalir=true; defaultConf(); }
	
	public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3,
			int arg4, int arg5) {
		return false;
	}
	
	
	
	public void defaultConf(){
		i=0;
		avatar="personajes/RedStar.gif";
		ColorTexto=(Color.WHITE);
		fuente=new Font("Arial",Font.BOLD,12);	
		banderaSalir=false;
		mensaje = new StringBuffer("");
	}
	
	
	public void TelecoConf(){
		avatar="personajes/Teleco.gif";
		fuente=new Font("Arial",Font.BOLD,12);	
		banderaSalir=false;
		mensaje = new StringBuffer("");
	}
	
	public void Net2Conf(){
		avatar="personajes/Net2.gif";
		fuente=new Font("Arial",Font.BOLD,12);	
		banderaSalir=false;
		mensaje = new StringBuffer("");
	}
	
	public void NetConf(){
		avatar="personajes/Net.gif";
		fuente=new Font("Arial",Font.BOLD,12);	
		banderaSalir=false;
		mensaje = new StringBuffer("");
	}
	
	public void GordaConf(){
		avatar="personajes/Adrog.gif";
		fuente=new Font("Arial",Font.BOLD,12);	
		banderaSalir=false;
		mensaje = new StringBuffer("");
	}
	
	public void loboConf(){
		avatar="personajes/Lobogris.gif";
		fuente=new Font("Arial",Font.BOLD,12);	
		banderaSalir=false;
		mensaje = new StringBuffer("");
	}
	public void jesusConf(){
		avatar="personajes/Xavier.gif";
		fuente=new Font("Arial",Font.BOLD,12);	
		banderaSalir=false;
		mensaje = new StringBuffer("");
	}
	public void pacoConf(){
		avatar="personajes/Cless.gif";
		soloTexto=false;
		fuente=new Font("Arial",Font.BOLD,12);
		mensaje = new StringBuffer("");
	}
	public void pdamonConf(){
		avatar="personajes/Pdamon.gif";
		soloTexto=false;
		fuente=new Font("Arial",Font.BOLD,12);
		mensaje = new StringBuffer("");
	}
	
	public void adamuzConf(){
		avatar="personajes/Adamuz.gif";
		soloTexto=false;
		fuente=new Font("Arial",Font.BOLD,12);
		mensaje = new StringBuffer("");
	}
	
	
	public void adamuzOscuroConf(){
		avatar="personajes/AdamuzOscuro.png";
		soloTexto=false;
		fuente=new Font("Arial",Font.BOLD,12);
		mensaje = new StringBuffer("");
	}
	
	
	public void juanConf(){
		avatar="personajes/John.gif";
		soloTexto=false;
		fuente=new Font("Arial",Font.BOLD,12);
		mensaje = new StringBuffer("");
	}
	
	public void angelConf(){
		avatar="personajes/Angel.gif";
		soloTexto=false;
		fuente=new Font("Arial",Font.BOLD,12);
		mensaje = new StringBuffer("");
	}
	
	public void adamConf(){
		avatar="personajes/Adam.gif";
		soloTexto=false;
		fuente=new Font("Arial",Font.BOLD,12);
		mensaje = new StringBuffer("");
	}
	public void salvaConf(){
		avatar="personajes/Salva.gif";
		soloTexto=false;
		fuente=new Font("Arial",Font.BOLD,12);
		mensaje = new StringBuffer("");
	}	
	
	
	public void joaquinConf(){
		avatar="personajes/Joaquin.gif";
		soloTexto=false;
		fuente=new Font("Arial",Font.BOLD,12);
		mensaje = new StringBuffer("");
		banderaSalir=false;
	}		
}
