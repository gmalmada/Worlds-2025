package igu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

import logica.ControladoraLogica;
import logica.Jugador;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class ModificarJugador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombreJugador;
	private JTextField txtUsuario;
	private JComboBox cmbRol;
	private JComboBox cmbPuesto;
	private JComboBox cmbEquipo;
	
	ControladoraLogica con = new ControladoraLogica();
	int idJugador;
	Jugador jug;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ModificarJugador() {
		
		this.idJugador = idJugador;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1015, 748);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 128, 192));
		panel.setBounds(0, 0, 1041, 669);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(new Color(64, 132, 244));
		panel_1.setBounds(10, 11, 658, 649);
		panel.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Cargar jugador");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(238, 11, 246, 41);
		panel_1.add(lblNewLabel_1);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnGuardar.setBounds(10, 552, 170, 63);
		panel_1.add(btnGuardar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnLimpiar.setBounds(238, 552, 170, 63);
		panel_1.add(btnLimpiar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnVolver.setBounds(467, 552, 170, 63);
		panel_1.add(btnVolver);
		
		JLabel lblNombreJugador = new JLabel("Nombre completo:");
		lblNombreJugador.setForeground(Color.WHITE);
		lblNombreJugador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreJugador.setBounds(10, 70, 186, 41);
		panel_1.add(lblNombreJugador);
		
		txtNombreJugador = new JTextField();
		txtNombreJugador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNombreJugador.setColumns(10);
		txtNombreJugador.setBounds(183, 70, 442, 34);
		panel_1.add(txtNombreJugador);
		
		JLabel lblUsuarioJugador = new JLabel("Usuario:");
		lblUsuarioJugador.setForeground(Color.WHITE);
		lblUsuarioJugador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsuarioJugador.setBounds(10, 154, 186, 41);
		panel_1.add(lblUsuarioJugador);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(98, 158, 262, 34);
		panel_1.add(txtUsuario);
		
		JLabel lblRol = new JLabel("Rol:");
		lblRol.setForeground(Color.WHITE);
		lblRol.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRol.setBounds(10, 307, 81, 41);
		panel_1.add(lblRol);
		
		cmbRol = new JComboBox();
		cmbRol.setBounds(98, 311, 262, 41);
		panel_1.add(cmbRol);
		
		JLabel lblEquipo = new JLabel("Equipo:");
		lblEquipo.setForeground(Color.WHITE);
		lblEquipo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEquipo.setBounds(10, 227, 81, 41);
		panel_1.add(lblEquipo);
		
		JLabel lblPuesto = new JLabel("Puesto:");
		lblPuesto.setForeground(Color.WHITE);
		lblPuesto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPuesto.setBounds(10, 403, 81, 41);
		panel_1.add(lblPuesto);
		
		cmbPuesto = new JComboBox();
		cmbPuesto.setBounds(98, 403, 262, 41);
		panel_1.add(cmbPuesto);
		
		cmbEquipo = new JComboBox();
		cmbEquipo.setBounds(98, 227, 262, 41);
		panel_1.add(cmbEquipo);
		
		JLabel lblLogo = new JLabel("New label");
		lblLogo.setIcon(new ImageIcon(ModificarJugador.class.getResource("/images/250px-Lol_worlds_logo.png")));
		lblLogo.setBounds(709, 11, 258, 519);
		panel.add(lblLogo);
		
		cargarDatos(idJugador);

	}
	
	public void cargarDatos(int idJugador) {
		
		this.jug = con.traerJugador(idJugador);
		
		txtNombreJugador.setText(jug.getJugNombre());
		txtUsuario.setText(jug.getJugUsuario());
		
		cmbRol.setSelectedItem(jug.getJugRol());
		cmbPuesto.setSelectedItem(jug.getJugPuesto());
		cmbEquipo.setSelectedItem(jug.getJugEquipo());
		
		
	}
	
}
