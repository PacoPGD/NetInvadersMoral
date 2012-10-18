package netInvaders2;

import java.awt.Component;


public class Cargando {

	int elige;
	public Cargando(int fase) {
		super();
		elige = fase;
	}



	public void Eligiendo(){
		if(elige==1){
				NuevoJuego.getNuevoJuego().playComponent((Component) new Secuencia(),30);
		}
	}




	




}