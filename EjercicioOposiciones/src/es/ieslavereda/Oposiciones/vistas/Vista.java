package es.ieslavereda.Oposiciones.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.JComboBox;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ChangeEvent;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class Vista extends JFrame {

	private JFrame frame;
	private JComboBox comboBoxBolas;
	private DefaultComboBoxModel dcm;
	private JSpinner spinnerBolasExtraer;
	private JSlider slider;
	private JButton btnSimular;
	private JTextField textFieldTemas;
	private JTable table;
	private DefaultTableModel dtm;
	private JLabel sliderValue;

	/**
	 * Create the application.
	 */
	public Vista() {
		initialize();
		setBounds(400, 400, 850, 700);
		JPanel panel = new JPanel();

		JPanel panel_1 = new JPanel();

		JPanel panel_2 = new JPanel();

		btnSimular = new JButton("Simular");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 670,
												Short.MAX_VALUE)
										.addComponent(btnSimular)))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(btnSimular).addContainerGap(19, Short.MAX_VALUE)));
		panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lblIteraciones = new JLabel("Iteraciones:");
		panel_2.add(lblIteraciones);

		JLabel lblIteracionesTotal = new JLabel("0");
		panel_2.add(lblIteracionesTotal);

		JLabel lblExito = new JLabel("Exito:");
		panel_2.add(lblExito);

		JLabel lblExitoTotal = new JLabel("0");
		panel_2.add(lblExitoTotal);

		JLabel lblNewLabel_2 = new JLabel("Fracaso:");
		panel_2.add(lblNewLabel_2);

		JLabel label = new JLabel("0");
		panel_2.add(label);

		JLabel lblNewLabel_3 = new JLabel("Numero de temas:");
		panel_2.add(lblNewLabel_3);

		JLabel lblTemasTotal = new JLabel("0");
		panel_2.add(lblTemasTotal);

		JLabel lblNewLabel_4 = new JLabel("Temas estudiados:");
		panel_2.add(lblNewLabel_4);

		JLabel lblEstudiadosTotal = new JLabel("0");
		panel_2.add(lblEstudiadosTotal);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);
		panel.setLayout(new MigLayout("", "[][][grow]", "[][][]"));

		dtm = new DefaultTableModel();
		table.setModel(dtm);

		JLabel lblNewLabel = new JLabel("Numero de bolas");
		panel.add(lblNewLabel, "cell 0 0");

		comboBoxBolas = new JComboBox();
		panel.add(comboBoxBolas, "cell 1 0");

		Vector<Integer> numeros = new Vector<Integer>();
		for (int i = 1; i <= 100; i++)
			numeros.add(i);
		dcm = new DefaultComboBoxModel<Integer>(numeros);
		comboBoxBolas.setModel(dcm);

		JLabel lblTemasEstudiados = new JLabel("Temas estudiados");
		panel.add(lblTemasEstudiados, "flowx,cell 2 0");

		textFieldTemas = new JTextField();
		panel.add(textFieldTemas, "cell 2 0,growx");
		textFieldTemas.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Bolas a extraer");
		panel.add(lblNewLabel_1, "cell 0 2");

		spinnerBolasExtraer = new JSpinner();
		panel.add(spinnerBolasExtraer, "cell 1 2,alignx left");
		SpinnerNumberModel spn = new SpinnerNumberModel(50, 0, 100, 1);
		spinnerBolasExtraer.setModel(spn);

		JLabel lblS = new JLabel("Simulaciones");
		panel.add(lblS, "flowx,cell 2 2");

		sliderValue = new JLabel("50");
		panel.add(sliderValue, "cell 2 2");

		slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				sliderValue.setText(String.valueOf(slider.getValue()));
			}
		});
		slider.setBackground(Color.WHITE);
		panel.add(slider, "cell 2 2,growx");
		getContentPane().setLayout(groupLayout);
		initialize();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(25);
		slider.setMinorTickSpacing(5);
		slider.setPaintLabels(true);
		slider.setMinimum(0);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// GETTER AND SETTERS
	public JComboBox getComboBoxBolas() {
		return comboBoxBolas;
	}

	public void setComboBoxBolas(JComboBox comboBoxBolas) {
		this.comboBoxBolas = comboBoxBolas;
	}

	public JSpinner getSpinnerBolasExtraer() {
		return spinnerBolasExtraer;
	}

	public void setSpinnerBolasExtraer(JSpinner spinnerBolasExtraer) {
		this.spinnerBolasExtraer = spinnerBolasExtraer;
	}

	public JSlider getSlider() {
		return slider;
	}

	public void setSlider(JSlider slider) {
		this.slider = slider;
	}

	public JButton getBtnSimular() {
		return btnSimular;
	}

	public JTextField getTextFieldTemas() {
		return textFieldTemas;
	}

	public JLabel getSliderValue() {
		return sliderValue;
	}

	public void setSliderValue(JLabel sliderValue) {
		this.sliderValue = sliderValue;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public DefaultTableModel getDtm() {
		return dtm;
	}

	public DefaultComboBoxModel getDcm() {
		return dcm;
	}
	
	

}
