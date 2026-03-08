package igu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

import logica.ControladoraLogica;
import logica.Equipo;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ModificarEquipo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombreEquipo;
	private JTextField txtTagEquipo;
	private JTextField txtFaseInicio;
	private JComboBox cmbRegion;
	private JComboBox cmbSeed;
	
	ControladoraLogica con = new ControladoraLogica();
	int idEquipo;
	Equipo equi;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ModificarEquipo(int idEquipo) {
		
		this.idEquipo = idEquipo;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificarEquipo.class.getResource("/images/league_of_legends_world_championship-brandlogo.net_-300x300 (2).png")));
		setTitle("Modificar equipo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1009, 662);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(new Color(64, 132, 244));
		panel_1.setBounds(10, 11, 658, 601);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Modificar equipo");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(238, 11, 221, 41);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNombreEquipo = new JLabel("Nombre:");
		lblNombreEquipo.setForeground(Color.WHITE);
		lblNombreEquipo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreEquipo.setBounds(10, 71, 85, 31);
		panel_1.add(lblNombreEquipo);
		
		JLabel lblRegion = new JLabel("Region:");
		lblRegion.setForeground(Color.WHITE);
		lblRegion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRegion.setBounds(10, 218, 79, 31);
		panel_1.add(lblRegion);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnGuardar.setBounds(10, 513, 170, 63);
		panel_1.add(btnGuardar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnLimpiar.setBounds(238, 513, 170, 63);
		panel_1.add(btnLimpiar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnVolver.setBounds(467, 513, 170, 63);
		panel_1.add(btnVolver);
		
		txtNombreEquipo = new JTextField();
		txtNombreEquipo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNombreEquipo.setColumns(10);
		txtNombreEquipo.setBounds(95, 72, 504, 37);
		panel_1.add(txtNombreEquipo);
		
		cmbRegion = new JComboBox();
		cmbRegion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmbRegion.setBounds(95, 220, 265, 34);
		panel_1.add(cmbRegion);
		
		JLabel lblTagEquipo = new JLabel("Tag (Tres letras):");
		lblTagEquipo.setForeground(Color.WHITE);
		lblTagEquipo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTagEquipo.setBounds(10, 145, 170, 31);
		panel_1.add(lblTagEquipo);
		
		txtTagEquipo = new JTextField();
		txtTagEquipo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTagEquipo.setColumns(10);
		txtTagEquipo.setBounds(190, 142, 125, 37);
		panel_1.add(txtTagEquipo);
		
		JLabel lblSeed = new JLabel("Seed:");
		lblSeed.setForeground(Color.WHITE);
		lblSeed.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSeed.setBounds(10, 308, 66, 31);
		panel_1.add(lblSeed);
		
		cmbSeed = new JComboBox();
		cmbSeed.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmbSeed.setBounds(95, 310, 137, 34);
		panel_1.add(cmbSeed);
		
		JLabel lblFaseInicio = new JLabel("Fase de inicio:");
		lblFaseInicio.setForeground(Color.WHITE);
		lblFaseInicio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFaseInicio.setBounds(10, 393, 134, 31);
		panel_1.add(lblFaseInicio);
		
		txtFaseInicio = new JTextField();
		txtFaseInicio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtFaseInicio.setEditable(false);
		txtFaseInicio.setColumns(10);
		txtFaseInicio.setBounds(154, 387, 300, 37);
		panel_1.add(txtFaseInicio);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ModificarEquipo.class.getResource("/images/250px-Lol_worlds_logo.png")));
		lblNewLabel.setBounds(710, 11, 258, 519);
		contentPane.add(lblNewLabel);
		
		cargarDatos(idEquipo);
	}
	
	public void cargarDatos(int idEquipo) {
		
		this.equi = con.traerEquipo(idEquipo);
		
		txtNombreEquipo.setText(equi.getEquiNombre());
		txtTagEquipo.setText(equi.getEquiTag());
		txtFaseInicio.setText(equi.getEquiFaseInicio());
		
		System.out.println("Región que llega de la BD: " + equi.getEquiRegion());
		
		cmbRegion.setSelectedItem(equi.getEquiRegion());
		cmbSeed.setSelectedItem(equi.getEquiSeed());
		
		
	}

}
