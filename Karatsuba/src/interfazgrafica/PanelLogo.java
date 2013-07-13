package interfazgrafica;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * 
 * C�digo modificado de http://swing-facil.blogspot.com/2011/06/jpanel-transparente-jpanel-con-imagen.html
 *
 */
public class PanelLogo extends JPanel {

	//Definici�n de los atributos de la clase
	private static final long serialVersionUID = 1L;
	private Image imagenLogo;

	/**
	 * M�todo constructor
	 */
	public PanelLogo() {
		super();
	}
	
	/**
	 * M�todo que obtiene la im�gen indicada en la 
	 * ruta recibida como par�metro
	 * 
	 * @param path La ruta donde se encuentra la im�gen
	 * @return La im�gen obtenida
	 */
	public void crearImagen(String rutaArchivo) {
		//Se arma la URL de la ubicaci�n de la im�gen
		URL imgURL = getClass().getResource(rutaArchivo);
		if (imgURL != null) {
			//Se asigna la im�gen al atributo de la clase
			imagenLogo = new ImageIcon(imgURL).getImage();
		} else {
			System.err.println("No se encuentra el archivo: " + rutaArchivo);
		}
	}

	@Override
	public void paint(Graphics g) {
		//Se dibuja la im�gen
		if (imagenLogo != null) {
			g.drawImage(imagenLogo, 0, 0, null);
		}
	}
}
