package igu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

public class CargarEquipo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombreEquipo;
	private JTextField txtTagEquipo;
	private JTextField txtFaseInicio;
	private JComboBox cmbRegion;
	private JComboBox cmbSeed;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public CargarEquipo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CargarEquipo.class.getResource("/images/league_of_legends_world_championship-brandlogo.net_-300x300 (2).png")));
		setTitle("Cargar equipo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 710);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 992, 671);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(10, 11, 658, 649);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Cargar equipo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(238, 11, 170, 41);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNombreEquipo = new JLabel("Nombre:");
		lblNombreEquipo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreEquipo.setBounds(10, 71, 94, 31);
		panel_1.add(lblNombreEquipo);
		
		JLabel lblRegion = new JLabel("Region:");
		lblRegion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRegion.setBounds(10, 218, 94, 31);
		panel_1.add(lblRegion);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnGuardar.setBounds(10, 552, 170, 63);
		panel_1.add(btnGuardar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNombreEquipo.setText("");
				txtTagEquipo.setText("");
				cmbRegion.setSelectedIndex(0);
				cmbSeed.setSelectedIndex(0);
				txtFaseInicio.setText("");
			}
		});
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnLimpiar.setBounds(238, 552, 170, 63);
		panel_1.add(btnLimpiar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setBounds(467, 552, 170, 63);
		panel_1.add(btnVolver);
		
		txtNombreEquipo = new JTextField();
		txtNombreEquipo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNombreEquipo.setBounds(95, 72, 504, 37);
		panel_1.add(txtNombreEquipo);
		txtNombreEquipo.setColumns(10);
		
		cmbRegion = new JComboBox();
		cmbRegion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmbRegion.setModel(new DefaultComboBoxModel(new String[] {"-", "BR", "CN", "EUW", "JP", "KR", "LAT", "NA", "OCE", "PCS", "TUK", "TWN", "VTN"}));
		cmbRegion.setBounds(95, 220, 265, 34);
		panel_1.add(cmbRegion);
		
		cmbRegion.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				
				//Obtengo la seleccion, parseandola a String (Ya que inicialmente es un item)
				String region = (String) cmbRegion.getSelectedItem();
				
				//Limpio el cmbRegion para evitar acumulaciones
				cmbSeed.removeAllItems();
				
				//Reseteo si selecciona el guion
				if(region.equals("-")) {
					cmbSeed.setEnabled(false);
					txtFaseInicio.setText("");
					return;
				}
				
				//Logica Tier S
				if(region.equals("LAT") || region.equals("KR") || region.equals("CN") || region.equals("NA")) {
					cmbSeed.setEnabled(false);
					txtFaseInicio.setText("Fase de Grupos");
				}else if(region.equals("EUW") || region.equals("VTN") || region.equals("PCS") || region.equals("TUK")) {
					cmbSeed.setEnabled(true);//Desbloqueo menu Seed
					cmbSeed.addItem("Seed 1");
					cmbSeed.addItem("Seed 2");
					cmbSeed.addItem("Seed 3");
					txtFaseInicio.setText("Fase de Grupos / Play-In");
				}else {
					cmbSeed.setEnabled(true);
					cmbSeed.addItem("Seed 1");
					cmbSeed.addItem("Seed 2");
					txtFaseInicio.setText("Fase de Grupos / Play-In");
				}
			} 
		});
		
		JLabel lblTagEquipo = new JLabel("Tag (Tres letras):");
		lblTagEquipo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTagEquipo.setBounds(10, 145, 170, 31);
		panel_1.add(lblTagEquipo);
		
		txtTagEquipo = new JTextField();
		txtTagEquipo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTagEquipo.setColumns(10);
		txtTagEquipo.setBounds(190, 142, 125, 37);
		panel_1.add(txtTagEquipo);
		
		JLabel lblSeed = new JLabel("Seed:");
		lblSeed.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSeed.setBounds(10, 308, 94, 31);
		panel_1.add(lblSeed);
		
		cmbSeed = new JComboBox();
		cmbSeed.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmbSeed.setBounds(95, 310, 137, 34);
		panel_1.add(cmbSeed);
		
		JLabel lblFaseInicio = new JLabel("Fase de inicio:");
		lblFaseInicio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFaseInicio.setBounds(10, 393, 137, 31);
		panel_1.add(lblFaseInicio);
		
		txtFaseInicio = new JTextField();
		txtFaseInicio.setEditable(false);
		txtFaseInicio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtFaseInicio.setColumns(10);
		txtFaseInicio.setBounds(154, 387, 300, 37);
		panel_1.add(txtFaseInicio);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(CargarEquipo.class.getResource("/images/250px-Lol_worlds_logo.png")));
		lblNewLabel.setBounds(700, 11, 258, 519);
		panel.add(lblNewLabel);

	}
}
