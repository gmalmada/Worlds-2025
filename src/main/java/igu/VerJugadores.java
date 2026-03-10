package igu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import logica.ControladoraLogica;
import logica.Jugador;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerJugadores extends JFrame {
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaJugadores;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	
	ControladoraLogica con = new ControladoraLogica();
	
	public VerJugadores() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VerJugadores.class.getResource("/images/league_of_legends_world_championship-brandlogo.net_-300x300 (2).png")));
		setTitle("Ver jugadores");
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e){
				cargarTabla();
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1006, 661);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 128, 192));
		panel.setBounds(0, 0, 993, 630);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(new Color(128, 128, 192));
		panel_1.setBounds(10, 67, 670, 552);
		panel.add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 5, 650, 470);
		panel_1.add(scrollPane);
		
		tablaJugadores = new JTable();
		scrollPane.setViewportView(tablaJugadores);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEditar.setBounds(31, 486, 160, 55);
		panel_1.add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEliminar.setBounds(244, 486, 160, 55);
		panel_1.add(btnEliminar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				MenuInicial menu = new MenuInicial();
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSalir.setBounds(476, 486, 160, 55);
		panel_1.add(btnSalir);
		
		JLabel lblLogo = new JLabel("New label");
		lblLogo.setIcon(new ImageIcon(VerJugadores.class.getResource("/images/250px-Lol_worlds_logo.png")));
		lblLogo.setBounds(711, 11, 258, 519);
		panel.add(lblLogo);
		
		JLabel lblVerJugadores = new JLabel("Ver jugadores");
		lblVerJugadores.setForeground(Color.WHITE);
		lblVerJugadores.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblVerJugadores.setBounds(445, 11, 235, 41);
		panel.add(lblVerJugadores);

	}
	
	public void cargarTabla() {
		
		DefaultTableModel modeloTabla = new DefaultTableModel() {;
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	
		String titulos[] = {"ID" , "Nombre", "Usuario", "Rol", "Puesto", "Equipo"};
		modeloTabla.setColumnIdentifiers(titulos);
		
		List<Jugador> listaJugadores = con.traerJugadores();
		
		if(listaJugadores != null) {
			for(Jugador jug : listaJugadores) {
				Object [] objeto = {jug.getIdJugador(), jug.getJugNombre(), jug.getJugUsuario(), jug.getJugRol(), jug.getJugPuesto(), jug.getJugEquipo().getEquiNombre()};
				
				modeloTabla.addRow(objeto);
			}
			
			tablaJugadores.setModel(modeloTabla);
		}
	}
	
	
}
