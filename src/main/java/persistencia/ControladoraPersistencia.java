package persistencia;

import java.util.List;

import logica.Equipo;
import logica.Jugador;

public class ControladoraPersistencia {
	
	EquipoJpaController equiJpa = new EquipoJpaController();
	JugadorJpaController jugJpa = new JugadorJpaController();
	
	public void guardarEquipo(Equipo equi) {
		equiJpa.create(equi);
		
	}
	
	public List<Equipo> traerEquipos(){
		return equiJpa.findEquipoEntities();
	}

	public void guardarJugador(Jugador jug) {
		jugJpa.create(jug);
		
	}

	public void borrarEquipo(int idEquipo) {
		try {
			equiJpa.destroy(idEquipo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	

}
