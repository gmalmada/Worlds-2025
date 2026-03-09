package igu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import logica.ControladoraLogica;
import logica.Equipo;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerEquipos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaEquipos;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	
	ControladoraLogica con = new ControladoraLogica();
	
	public VerEquipos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VerEquipos.class.getResource("/images/league_of_legends_world_championship-brandlogo.net_-300x300 (2).png")));
		setTitle("Ver equipos");
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e){
				cargarTabla();
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1009, 669);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 192));
		panel.setBounds(0, 0, 993, 630);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 192));
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(10, 67, 670, 552);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 5, 650, 470);
		panel_1.add(scrollPane);
		
		tablaEquipos = new JTable();
		scrollPane.setViewportView(tablaEquipos);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(tablaEquipos.getRowCount() > 0) {
					if(tablaEquipos.getSelectedRow() != -1) {
						int idEquipo = Integer.parseInt(String.valueOf(tablaEquipos.getValueAt(tablaEquipos.getSelectedRow(), 0)));
						
						ModificarEquipo pantallaModif = new ModificarEquipo(idEquipo);
						pantallaModif.setVisible(true);
						pantallaModif.setLocationRelativeTo(null);
						
						dispose();
					}else {
						mostrarMensaje("No seleccionó ningun equipo", "Error", "Error al modificar");
					}
				}else {
					mostrarMensaje("No hay nada en la tabla", "Error", "Error al modificar");
				}
				
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEditar.setBounds(31, 486, 160, 55);
		panel_1.add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(tablaEquipos.getRowCount() > 0) {
					if(tablaEquipos.getSelectedRow() != -1) {
						int idEquipo = Integer.parseInt(String.valueOf(tablaEquipos.getValueAt(tablaEquipos.getSelectedRow(), 0)));
				
				
				con.borrarEquipo(idEquipo);
				
				mostrarMensaje("Equipo eliminado exitosamente", "Info", "Borrado exitoso");
				cargarTabla();
						
			}else {mostrarMensaje("No seleccionó ningun equipo", "Error", "Error al eliminar");
			}
		}else {
			mostrarMensaje("No hay nada en la tabla", "Error", "Error al eliminar");
		}
				}
			});
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEliminar.setBounds(244, 486, 160, 55);
		panel_1.add(btnEliminar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				MenuInicial pantalla = new MenuInicial();
				pantalla.setVisible(true);
				pantalla.setLocationRelativeTo(null);
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSalir.setBounds(476, 486, 160, 55);
		panel_1.add(btnSalir);
		
		JLabel lblLogo = new JLabel("New label");
		lblLogo.setIcon(new ImageIcon(VerEquipos.class.getResource("/images/250px-Lol_worlds_logo.png")));
		lblLogo.setBounds(711, 11, 258, 519);
		panel.add(lblLogo);
		
		JLabel lblNewLabel_1 = new JLabel("Ver equipos");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(445, 11, 235, 41);
		panel.add(lblNewLabel_1);

	}
	
	public void mostrarMensaje(String mensaje, String tipo, String titulo) {
		JOptionPane optionPane = new JOptionPane(mensaje);
		if(tipo.equals("Info")) { //Elegimos distintos tipos de error
		optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			if(tipo.equals("Error")) {
				optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
			}
		}
		JDialog dialog = optionPane.createDialog(titulo);
		dialog.setAlwaysOnTop(true);
		dialog.setVisible(true);
		
	}
	
	protected void cargarTabla() {
		
		DefaultTableModel modeloTabla = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	
	String titulos[] = {"ID","Nombre", "TAG", "Region", "Seed", "Fase de Inicio"};
	modeloTabla.setColumnIdentifiers(titulos);
	
	//Cargar los datos desde la BDD
	List<Equipo> listaEquipos = con.traerEquipos();
	
	//Recorrer la lista y mostrar los elementos en la tabla
	if(listaEquipos != null) {
		for(Equipo equi : listaEquipos) {
			Object[] objeto = {equi.getIdEquipo(), equi.getEquiNombre(), equi.getEquiTag(), equi.getEquiRegion(), equi.getEquiSeed(), equi.getEquiFaseInicio()};
			
			modeloTabla.addRow(objeto);
		}
		
		tablaEquipos.setModel(modeloTabla);
	}
}
	
}
