package netInvaders2.Opciones;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Vector;

public class Perfiles implements Serializable{
	private static final long serialVersionUID = 1L;
	public static Vector<Perfil> perfiles;
	String ruta="";
	URL url=null;
	String fileSaveGame="NetInavders2SaveGame.dat";
	
	File saveGame=new File(ruta+fileSaveGame);
	private DataOutputStream salida;
	private DataInputStream entrada;
	
	public Perfiles(){ perfiles = new Vector<Perfil>(); }
	
	public boolean existePerfil(String nombre) {
		String[] nombresDePerfiles=Opciones.perfiles.getPerfilesNames();
		for(int i=0;i<nombresDePerfiles.length;i++){
			if(nombre.equalsIgnoreCase(nombresDePerfiles[i])){
				return true;
			}
		}
		return false;
	}

	public static Vector<Perfil> getPerfiles(){return perfiles;}
	
	public void addPerfil(Perfil perfil){ perfiles.add(perfil);guardarFichero();}
	public void add(Perfil perfil) {perfiles.add(perfil);guardarFichero();}
	
	public void borrarPerfil(int id){
		perfiles.remove(id);
		guardarFichero();
	}
	public void borrarPerfil(String nombre){
		perfiles.remove(getIdPerfil(nombre));
		guardarFichero();
	}
	public void guardarFichero(){
		try {
			//Object outStream=getClass().getClassLoader().getResourceAsStream(fileSaveGame);
			//salida = new DataOutputStream( (OutputStream) outStream );
			salida = new DataOutputStream(new FileOutputStream(saveGame));
			salida.writeLong(serialVersionUID);
			salida.writeChars("No modifiques este fichero, no nos hacemos reponsables de los daños derivados de la modificacion de este archivo");
			salida.writeChar('\n');
			for (int i = 0; i < perfiles.size(); i ++){
				Perfil temp=(Perfil)perfiles.get(i);
				
				for(int j=0;j<temp.scoreFasesPasadas.length;j++){
					for(int k=0;k<temp.scoreFasesPasadas[j].length;k++){
						salida.writeInt(temp.scoreFasesPasadas[j][k]);
						salida.writeChar('\t');
					}
					salida.writeChar('\t');
				}
				salida.writeBytes(/*encrip*/(temp.name));
				salida.writeChar('\n');
			}
			salida.close();
		} catch (FileNotFoundException e) {
			System.out.println("EL fichero de perfiles no se puede guardar");
		} catch (IOException e) {
			System.out.println("EL fichero de perfiles no encontrado");
		}
	}	
	
	@SuppressWarnings("deprecation")
	public void cargarFichero(){
		try {
			entrada= new DataInputStream(new FileInputStream(saveGame));
			try{
				if(serialVersionUID!=entrada.readLong()){
					System.out.print("Aviso de diferentes versiones");
					//Exportador de partidas guardadas de versiones anteriores
				}
				entrada.readLine();
				while (true){
					Perfil temp = new Perfil();
					for(int i=0; i<Opciones.naves.length; i++){
						for(int j=0;j<Opciones.misiones.length;j++){
							temp.scoreFasesPasadas[i][j]= entrada.readInt();
							entrada.readChar();
						}
						entrada.readChar();
						//System.out.println("va "+i+ " y "+ temp.scoreFasesPasadas[i]);
					}
					temp.name = entrada.readLine();
					temp.name=/*descrip*/(temp.name.substring(0, temp.name.length()-1));
					//System.out.println(temp.name);
					perfiles.add(temp);
				}
			}
			catch (EOFException e) {
				//System.out.println("Fin del fichero");
				if(perfiles.size()==0){
					add(new Perfil("Player1"));
					add(new Perfil("Player2"));
					guardarFichero();
				}
				if(Perfiles.getPerfiles().size()==1){
					add(new Perfil("Player2"));
					guardarFichero();
				}
			}
			entrada.close();
		} catch (FileNotFoundException e) {
			System.out.println("EL fichero de perfiles no existe, se creará uno nuevo");
			try {
				salida = new DataOutputStream(new FileOutputStream(saveGame));
				cargarFichero();
			} catch (FileNotFoundException e1) {
				System.out.println("EL fichero de perfiles no se pudo crear");
			}
			
		} catch (IOException e) {
			System.out.println("EL fichero de perfiles no encontrado");
		}
	}
	
	
	/*private final int c1[]={88,424,54,966,442,112,235,744,223,234};
	private final int c2[]={4,6,6,8,4,2,2,4,2,8};	
	private final int c3[]={27,87,123,32,43,13,89,171,191};*/
	private final String cs="Raf@+Kdemux()2007o";
	
	/*private int[] encrip(int n,int i){
		int b=(c2[i]/2)+c3[i]*2+3;
		int crip[]={ ((n+(c1[i]+2))*b)/c3[i] ,src((n+(c1[i]+2))*b,c3[i])};
		return crip;
	}
	private int descrip(int n,int src,int i){
		int b=(c2[i]/2)+c3[i]*2+3;
		return ((n*c3[i]+src)/b)-(c1[i]+2);
	}
	private int src(int n,int c){ return n%c; }*/
	
	/*private String encrip(String cadena){
		String cadenaEn = "";
		for(int i=0;i<cadena.length();i++){
			cadenaEn+=(char)((int)cadena.charAt(i)+(int)cs.charAt(i));
		}
		return cadenaEn;
	}*/
	/*private String descrip(String cadena){
		String cadenaDes = "";
		for(int i=0;i<cadena.length();i++){
			cadenaDes+=(char)((int)cadena.charAt(i)-(int)cs.charAt(i));
		}
		return cadenaDes;
	}*/
	
	
	
	
	public int getIdPerfil(String nombre){
		int i;
		for(i=0;i<perfiles.size();i++){
			Perfil temp=(Perfil)perfiles.get(i);
			if(temp.name.equals(nombre)){
				return i;
			}
		}
		return -1;
	}
	public String[] getPerfilesNames(){
		String []nombresDePerfiles=new String[perfiles.size()];
		Perfil temp;
		for(int i=0;i<perfiles.size();i++){
			temp=(Perfil)perfiles.get(i);
			nombresDePerfiles[i]=temp.getName();
		}
		return nombresDePerfiles;
	}
	public Perfil getPerfil(int id){
		if(id>=0 && id<perfiles.size()){
			return perfiles.elementAt(id);
		}
		return null;
	}
	public int getNumeroPerfiles(){return perfiles.size();}
	public Perfil getPerfilDeJugador(int numeroDeJugador){
		if(numeroDeJugador==1){
			getPerfil(Opciones.perfilJ1);
		}
		else{
			if(numeroDeJugador==2){
				return getPerfil(Opciones.perfilJ2);
			}
			else{
				return null;
			}
		}
		return null;
	}
	public void setPerfilName(int id,String nombre){
		perfiles.get(id).name=nombre;
		guardarFichero();
	}
}

class Perfil implements Serializable{
	private static final long serialVersionUID = 1L;
	String name,twiter,online;
	int idOnline=0;
	public boolean fasesDisponibles[][]=new boolean[Opciones.naves.length][Opciones.misiones.length];
	public int scoreFasesPasadas[][]=new int[Opciones.naves.length][Opciones.misiones.length];
	
	
	public Perfil(){ name="Default"; }
	public Perfil(String nombre){
		if(nombre!="" || nombre!=" "){
			name=nombre;
		}
		else{
			name="Default";
		}
		resetearPuntuaciones();
	}
	
	private void resetearPuntuaciones() {
		for(int i=0;i<scoreFasesPasadas.length;i++) {
			for(int j=0;j<scoreFasesPasadas[i].length;j++){
				scoreFasesPasadas[i][j]=0/*i*100+j*/;
				fasesDisponibles[i][j]=false;
			}
			fasesDisponibles[i][0]=true;
		}
	}
	

	public void setScore(int nave,int[] score){
		scoreFasesPasadas[nave]=score;
		guardar();
	}
	public void actualizarScore(int nave,int fase,int score){
		scoreFasesPasadas[nave][fase]=score;
		//darExp(score);
		guardar();
	}
	
	public String getName(){return name;}
	public void setName(String nombre){name=nombre; guardar();}
	
	public int[][] getScore(){return scoreFasesPasadas; }
	public int[] getScore(int nave){return scoreFasesPasadas[nave]; }
	public int getScore(int nave,int fase){return scoreFasesPasadas[nave][fase]; }
	public void setScore(int[][]puntos){scoreFasesPasadas=puntos; guardar(); }
	public void setScore(int[]puntos,int nave){scoreFasesPasadas[nave]=puntos; guardar(); }
	public void setScore(int puntos,int nave,int fase){scoreFasesPasadas[nave][fase]=puntos; guardar(); }
	
	public int getNextMissionId(int nave){
		int ultima=0;
		if(nave<fasesDisponibles.length){
			for(int i=0;i<fasesDisponibles[nave].length;i++){
				if(fasesDisponibles[nave][i]==true){
					ultima=i;
				}
			}
		}
		return ultima;
	}
	public int getPorcentajeCompletado(){
		int misionesCompletadas=0;
		int misionesTotales=Opciones.naves.length*Opciones.misiones.length;
		for(int i=0;i<scoreFasesPasadas.length;i++) {
			for(int j=0;j<scoreFasesPasadas[i].length;j++){
				if(scoreFasesPasadas[i][j]!=0){
					misionesCompletadas++;
				}
			}
		}
		
		return (int)((misionesCompletadas*100+1)/misionesTotales);
	}
	
	public Object[] getFasesDisponibles(){
		/*int numeroFasesJugables=0;
		for(int i=0;i<fasesDisponibles.length;i++){
			if(fasesDisponibles[Opciones.listaNavesJ1.getSelectedIndex()][i]==true){
				numeroFasesJugables++;
			}
		}*/
		ArrayList<String>disponibles=new ArrayList<String>();
		
		int naveSeleccionada=Opciones.listaNavesJ1.getSelectedIndex();
		
		for(int i=0;i<=fasesDisponibles.length;i++){
			/*System.out.println("e "+fasesDisponibles[naveSeleccionada][i]);
			if(fasesDisponibles[naveSeleccionada][i]==true){
				System.out.print("eee");
				disponibles.add(Opciones.nombreMisiones[i]);
			}*/
			disponibles.add(Opciones.nombreMisiones[i]);
		}
		
		return disponibles.toArray();
	}
	
	
	public Object[] getNavesDisponibles(){
		ArrayList<String>disponibles=new ArrayList<String>();
		int naveSeleccionada=Opciones.listaNavesJ1.getSelectedIndex();
		
		for(int i=0;i<Opciones.naves.length;i++){
			disponibles.add(Opciones.naves[i]);
		}
		
		return disponibles.toArray();
	}
	
	public synchronized void guardar(){
		Opciones.perfiles.guardarFichero();
	}
	
	
}