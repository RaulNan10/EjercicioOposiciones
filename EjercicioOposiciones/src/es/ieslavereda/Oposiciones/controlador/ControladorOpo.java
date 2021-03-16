package es.ieslavereda.Oposiciones.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import es.ieslavereda.Oposiciones.modelo.Bola;
import es.ieslavereda.Oposiciones.vistas.Vista;

public class ControladorOpo implements ActionListener {

	private Vista vista;
	private ArrayList<Bola> bolas;

	public ControladorOpo(Vista vista) {
		super();
		this.vista = vista;
		bolas = new ArrayList<Bola>();

		inicializar();
		go();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void inicializar() {

		// Add ActionListener
		vista.getComboBoxBolas().addActionListener(this);
		// vista.getSpinnerBolasExtraer();

		// Set ActionCommand
		vista.getComboBoxBolas().setActionCommand("");

	}

	public void go() {
		vista.setVisible(true);
	}

}
