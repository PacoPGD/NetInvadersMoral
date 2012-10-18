package Navegador;


import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;

import netInvaders2.Opciones.Opciones;
public class Navegador extends JFrame {
   private JTextField campoIntroducir;
   private JEditorPane areaContenido;
   public Navegador()
   {

      Container contenedor = getContentPane();
 
      campoIntroducir = new JTextField(Opciones.requestToken.getAuthorizationURL());
      campoIntroducir.addActionListener(
         new ActionListener() {
            
            public void actionPerformed( ActionEvent evento )
            {
               obtenerLaPagina( evento.getActionCommand() );
            }
         } 

      ); 
      contenedor.add( campoIntroducir, BorderLayout.NORTH );
      
      areaContenido = new JEditorPane();
      areaContenido.setEditable( false );
      areaContenido.addHyperlinkListener(
         new HyperlinkListener() {
       
            public void hyperlinkUpdate( HyperlinkEvent evento )
            {
               if ( evento.getEventType() ==
                    HyperlinkEvent.EventType.ACTIVATED )
                  obtenerLaPagina( evento.getURL().toString() );
            }
         } 
      ); 

      contenedor.add( new JScrollPane( areaContenido ),
         BorderLayout.CENTER );
		
		this.setBounds(400, 50, 500, 500);
		obtenerLaPagina(Opciones.requestToken.getAuthorizationURL());
		System.out.println(Opciones.requestToken.getAuthorizationURL());
      setVisible( true );

   } 

   private void obtenerLaPagina( String ubicacion )
   {
      try {
         areaContenido.setPage( ubicacion );
         campoIntroducir.setText( ubicacion );
      }
      catch ( IOException excepcionES ) {
         JOptionPane.showMessageDialog( this,
            "Error al recuperar el URL especificado", "URL incorrecto",
            JOptionPane.ERROR_MESSAGE );
      }

   } 
} 