package netInvaders2.Opciones;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class VisorPuntuacion{
	JFrame ventanaPuntuacion;
	Vector<Perfil> VectorPerfiles=Perfiles.getPerfiles();
	JTabbedPane panelTab;
	
	public VisorPuntuacion(){
		ventanaPuntuacion = new JFrame("Visor de Puntuaciones Locales");
		ventanaPuntuacion.setLayout( new FlowLayout() );
		panelTab = new JTabbedPane(JTabbedPane.TOP);
		
		for(int i=0;i<Opciones.naves.length;i++){
			panelTab.addTab(Opciones.naves[i],/*new ImageIcon(getClass().getClassLoader().getResource("res/naves/nave"+i+".png")),*/crearTabla(i));
		}
		
		ventanaPuntuacion.add(panelTab,BorderLayout.CENTER);
		//ventanaPuntuacion.add(crearTabla(0),BorderLayout.CENTER);
		
		((JPanel)ventanaPuntuacion.getContentPane()).setPreferredSize(new Dimension(700,475));
		ventanaPuntuacion.pack();
		//ventanaPuntuacion.setSize(800,200);
		ventanaPuntuacion.setAlwaysOnTop(true);
		ventanaPuntuacion.setLocationRelativeTo(null);
		ventanaPuntuacion.setVisible(true);

	}

	
	public JScrollPane crearTabla(int idNave){
		JTable tabla;
		
		String[] tituloColumna = {"Perfil",Opciones.nombreMisiones[0],Opciones.nombreMisiones[1],Opciones.nombreMisiones[2],Opciones.nombreMisiones[3],Opciones.nombreMisiones[4],Opciones.nombreMisiones[5],Opciones.nombreMisiones[6],Opciones.nombreMisiones[7]};
		String [][]datosColumna = new String[Opciones.perfiles.getNumeroPerfiles()][Opciones.misiones.length+1];
		for(int i=0;i<datosColumna.length;i++){
			Perfil temp=(Perfil)VectorPerfiles.elementAt(i);
			datosColumna[i][0]=temp.name;
		}
		for(int i=0;i<datosColumna.length;i++){
			Perfil temp=(Perfil)VectorPerfiles.elementAt(i);
			for(int j=0;j<Opciones.misiones.length;j++){
				datosColumna[i][j+1]=""+temp.getScore(idNave,j);
			}
		}
		
		tabla=new JTable(datosColumna,tituloColumna);
		tabla.setSize(700,460);
		tabla.setEnabled(false);
		
		JScrollPane panelScroll = new JScrollPane( tabla );
		panelScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panelScroll.setSize(710,470);
		return panelScroll;
	}
	/*public JTable crearTabla(int idPerfil){
		JTable tabla;
		String[] tituloColumna = {"Puntuacion","fase 1","fase 2","fase 3","fase 4","fase 5","fase 6"};
		String [][]datosColumna = new String[Opciones.naves.length][Opciones.misiones.length+1];
		Perfil temp=(Perfil)VectorPerfiles.elementAt(idPerfil);
		for(int i=0;i<Opciones.naves.length;i++){
			datosColumna[i][0]=Opciones.naves[i];
		}
		for(int i=0;i<Opciones.naves.length;i++){
			for(int j=0;j<Opciones.misiones.length;j++){
				datosColumna[i][j+1]=""+temp.scoreFasesPasadas[i][j];
			}
		}
		tabla=new JTable(datosColumna,tituloColumna);
		tabla.setEnabled(false);

		return tabla;
	}*/
}