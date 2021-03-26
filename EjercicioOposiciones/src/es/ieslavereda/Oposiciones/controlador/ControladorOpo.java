package es.ieslavereda.Oposiciones.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import es.ieslavereda.Oposiciones.modelo.Bola;
import es.ieslavereda.Oposiciones.modelo.Bombo;
import es.ieslavereda.Oposiciones.vistas.Vista;

public class ControladorOpo implements ActionListener {

	private Vista vista;
	private ArrayList<Integer> temasEstudiados;
	private Bombo bombo;
	private ArrayList<Bola> temasExamen;
	private DefaultTableModel dtm;

	public ControladorOpo(Vista vista) {
		super();
		this.vista = vista;
		this.bombo = null;
		temasEstudiados = new ArrayList<Integer>();
		temasExamen = new ArrayList<Bola>();
		dtm = null;

		inicializar();
		go();
	}

	public void go() {
		vista.setVisible(true);
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

	public void simular() {

		int simulaciones;
		simulaciones = vista.getSlider().getValue();

		for (int i = 1; i <= simulaciones; i++) {

			guardarTemas();
			if (comprobarExtraer()) {
				bombo = new Bombo(vista.getComboBoxBolas().getSelectedIndex() + 1);
				temasExamen.add(bombo.extraer());
				insertarColumna();
				generarFilas(i);

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

	// Comprueba que el numero de bolas a extraer, es menor que el total de bolas
	public boolean comprobarExtraer() {
		if ((int) (vista.getSpinnerBolasExtraer().getValue()) > 0
				&& vista.getComboBoxBolas().getSelectedIndex() + 1 > (int) (vista.getSpinnerBolasExtraer().getValue()))
			return true;
		else
			return false;
	}

	public void insertarColumna() {

		int repeticiones = (int) (vista.getSpinnerBolasExtraer().getValue());
		dtm = new DefaultTableModel();
		vista.getTable().setModel(dtm);

		dtm.addColumn("Simulacion nº");
		for (int i = 1; i <= repeticiones; i++) {
			dtm.addColumn("Bola " + String.valueOf(i));
		}
		dtm.addColumn("Exito");
		dtm.addColumn("Nº de aciertos");

		

	}
	// Numero es para indicar el numero de simulacion que se esta realizando
	private void generarFilas(int numero) {
		int aciertos = 0;
		boolean exito = false;
		Vector<String> v = null;
		
		
		for(Bola b : temasExamen) {
			for(Integer i : temasEstudiados) {
				if(b.getNumero()==i) {
					aciertos ++;
					exito = true;
					
					(int)(numero);
				}
			}
			
		}
		
	}
}
