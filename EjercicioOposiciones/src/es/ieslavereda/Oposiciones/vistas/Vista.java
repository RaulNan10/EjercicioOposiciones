package es.ieslavereda.Oposiciones.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Color;

public class Vista extends JFrame{

	private JFrame frame;
	private JComboBox comboBoxBolas;
	private JSpinner spinnerBolasExtraer;
	private JSlider slider;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista window = new Vista();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Vista() {
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(347, Short.MAX_VALUE))
		);
		panel.setLayout(new MigLayout("", "[][][grow]", "[][][]"));
		
		JLabel lblNewLabel = new JLabel("Numero de bolas");
		panel.add(lblNewLabel, "cell 0 0");
		
		comboBoxBolas = new JComboBox();
		panel.add(comboBoxBolas, "cell 1 0");
		
		JLabel lblTemasEstudiados = new JLabel("Temas estudiados");
		panel.add(lblTemasEstudiados, "flowx,cell 2 0");
		
		JTextField textFieldTemas = new JTextField();
		panel.add(textFieldTemas, "cell 2 0,growx");
		textFieldTemas.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Bolas a extraer");
		panel.add(lblNewLabel_1, "cell 0 2");
		
		
		
		spinnerBolasExtraer = new JSpinner();
		panel.add(spinnerBolasExtraer, "cell 1 2,alignx left");
		SpinnerNumberModel spn= new SpinnerNumberModel(50,0,100, 1);
		spinnerBolasExtraer.setModel(spn);
		                
		
		JLabel lblS = new JLabel("Simulaciones");
		panel.add(lblS, "flowx,cell 2 2");
		
		JLabel sliderValue = new JLabel("0");
		panel.add(sliderValue, "cell 2 2");
		
		slider = new JSlider();
		slider.setBackground(Color.WHITE);
		panel.add(slider, "cell 2 2,growx");
		getContentPane().setLayout(groupLayout);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//GETTER AND SETTERS
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
	
	
}
