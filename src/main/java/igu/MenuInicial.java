package igu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class MenuInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuInicial frame = new MenuInicial();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuInicial() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuInicial.class.getResource("/images/league_of_legends_world_championship-brandlogo.net_-300x300 (2).png")));
		setTitle("Menu principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 688);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 192));
		panel.setBounds(0, 0, 785, 649);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MenuInicial.class.getResource("/images/250px-Lol_worlds_logo.png")));
		lblNewLabel.setBounds(511, 71, 252, 417);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(64, 132, 244));
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(25, 27, 457, 594);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnCargarEquipo = new JButton("Cargar equipo");
		btnCargarEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				CargarEquipo pantalla = new CargarEquipo();
				pantalla.setVisible(true);
				pantalla.setLocationRelativeTo(null);
			}
		});
		btnCargarEquipo.setBackground(new Color(255, 255, 255));
		btnCargarEquipo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnCargarEquipo.setBounds(53, 28, 341, 70);
		panel_1.add(btnCargarEquipo);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setBackground(new Color(255, 255, 255));
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnSalir.setBounds(53, 524, 341, 59);
		panel_1.add(btnSalir);
		
		JButton btnCargarJugador = new JButton("Cargar jugador");
		btnCargarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				CargarJugador pantalla = new CargarJugador();
				pantalla.setVisible(true);
				pantalla.setLocationRelativeTo(null);
			}
		});
		btnCargarJugador.setBackground(new Color(255, 255, 255));
		btnCargarJugador.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnCargarJugador.setBounds(53, 124, 341, 70);
		panel_1.add(btnCargarJugador);
		
		JButton btnVerEquipos = new JButton("Ver equipos");
		btnVerEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
				VerEquipos pantalla = new VerEquipos();
				pantalla.setVisible(true);
				pantalla.setLocationRelativeTo(null);		
			}
		});
		btnVerEquipos.setBackground(new Color(255, 255, 255));
		btnVerEquipos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnVerEquipos.setBounds(53, 225, 341, 70);
		panel_1.add(btnVerEquipos);
		
		JButton btnVerJugadores = new JButton("Ver jugadores");
		btnVerJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
				VerJugadores pantalla = new VerJugadores();
				pantalla.setVisible(true);
				pantalla.setLocationRelativeTo(null);
			}
		});
		btnVerJugadores.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnVerJugadores.setBackground(Color.WHITE);
		btnVerJugadores.setBounds(53, 324, 341, 70);
		panel_1.add(btnVerJugadores);

	}
}
