package netInvaders2.Opciones;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import twitter4j.TwitterException;

import Navegador.Navegador;

@SuppressWarnings("serial")
public class PanelSocialJugador extends JPanel implements ActionListener {
	public JFormattedTextField nombreT;
	public JPasswordField claveT;
	public JFormattedTextField nombreOnline;
	public JPasswordField claveOnline;
	public JButton boton = new JButton("Obtener tu pin");
	
	public PanelSocialJugador(){
		setLayout(new GridLayout(6,2,1,1));
		nombreT=new JFormattedTextField();
		
		
		nombreOnline=new JFormattedTextField();
		claveOnline=new JPasswordField();
		
		add(new JLabel("<html><h4>Subir Puntuacion a la Web Oficial</h4></html>"));
		add(new JLabel(""));
		add(new JLabel("Nick en la Web Oficial"));
		add(nombreOnline);
		add(new JLabel("Clave en la Web Oficial"));
		add(claveOnline);
		
		add(new JLabel("<html><h4>Subir Puntuacion a Twitter</h4></html>"));
		add(new JLabel(""));
		add(new JLabel("Pin de twitter"));
		add(nombreT);
		add(new JLabel("Pulsa el boton"));
		boton.addActionListener(this);
		add(boton);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==boton){
			Navegador nav = new Navegador();
		}
		
	}
}
