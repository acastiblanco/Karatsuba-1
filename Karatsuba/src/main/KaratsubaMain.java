package main;

import karatsuba.KaratsubaAlgoritmo;
import controlador.KaratsubaControlador;
import interfazgrafica.KaratsubaUI;

public class KaratsubaMain {

	/**
	 * M�todo de inicio de la aplicaci�n
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Se crean los objetos de la aplicaci�n
		KaratsubaAlgoritmo operador = new KaratsubaAlgoritmo();
		KaratsubaUI interfazGraficaUsuario = new KaratsubaUI(operador);
		@SuppressWarnings("unused")
		KaratsubaControlador controlador =new KaratsubaControlador(interfazGraficaUsuario, operador);

		interfazGraficaUsuario.setVisible(true);
	}

}
