package es.ieslavereda.Oposiciones.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import es.ieslavereda.Oposiciones.modelo.Bola;
import es.ieslavereda.Oposiciones.modelo.Bombo;
import es.ieslavereda.Oposiciones.vistas.Vista;

public class ControladorOpo implements ActionListener {

// Para coger el valor del spinner es spinner.getValue();	

// Para limpiar el textField de los temas estudiados y guardarlos en un vector
// array = texto.replaceAll(" ", "").split(',');
	private Vista vista;
	private ArrayList<Integer> temasEstudiados;
	private Bombo bombo;
	private ArrayList<Bola> temasExamen;

	public ControladorOpo(Vista vista) {
		super();
		this.vista = vista;
		this.bombo = null;
		temasEstudiados = new ArrayList<Integer>();
		temasExamen = new ArrayList<Bola>();

		inicializar();
		go();
	}

	public void inicializar() {

		// Add ActionListener
		vista.getBtnSimular().addActionListener(this);
		// Set ActionCommand
		vista.getBtnSimular().setActionCommand("Simular");

		vista.getSliderValue().setText(String.valueOf(vista.getSlider().getValue()));

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		String comando = arg0.getActionCommand();

		if (comando.equals("Simular")) {
			simular();
		}
	}

	public void go() {
		vista.setVisible(true);
	}

	public void simular() {

		int simulaciones;
		simulaciones = vista.getSlider().getValue();

		for (int i = 1; i <= simulaciones; i++) {
			if (comprobarTemasEstudiados()) {
				guardarTemas();
				if (comprobarExtraer()) {
					bombo = new Bombo(vista.getComboBoxBolas().getSelectedIndex() + 1);
					temasExamen.add(bombo.extraer());
					insertarColumna();
				}
			}
		}

	}

	// Hace la comprobacion de que hay almenos un tema estudiado en el txtField
	public boolean comprobarTemasEstudiados() {
		if (temasEstudiados.size() > 0) {
			System.out.println("true");
			return true;
		} else {
			System.out.println("false");
			return false;
		}
	}

	// Comprueba que el numero de bolas a extraer, es menor que el total de bolas
	public boolean comprobarExtraer() {
		if ((int) (vista.getSpinnerBolasExtraer().getValue()) > 0
				&& vista.getComboBoxBolas().getSelectedIndex() + 1 > (int) (vista.getSpinnerBolasExtraer().getValue()))
			return true;
		else
			return false;
	}

	// Guarda los temas estudiados del txtField en la lista de temasEstudiados
	public void guardarTemas() {
		String temas = vista.getTextFieldTemas().getText();

		try {
			String[] texto = temas.replaceAll(" ", "").split(",");
			for (String t : texto) {
				int tema = Integer.parseInt(t);
				temasEstudiados.add(tema);
			}
		} catch (Exception E) {

		}
	}

	public void insertarColumna() {
		int repeticiones = (int) (vista.getSpinnerBolasExtraer().getValue());

		vista.getDtm().addColumn("Simulacion nº");
		for (int i = 1; i <= repeticiones; i++) {
			vista.getDtm().addColumn("Bola " + String.valueOf(i));
		}
		vista.getDtm().addColumn("Exito");
		vista.getDtm().addColumn("Nº de aciertos");

	}

}
