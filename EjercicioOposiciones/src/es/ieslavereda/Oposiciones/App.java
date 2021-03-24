package es.ieslavereda.Oposiciones;

import java.awt.EventQueue;

import es.ieslavereda.Oposiciones.controlador.ControladorOpo;
import es.ieslavereda.Oposiciones.vistas.Vista;

public class App {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista window = new Vista();
					ControladorOpo c = new ControladorOpo(window);
					c.go();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
