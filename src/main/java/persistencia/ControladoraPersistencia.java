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

	public Equipo traerEquipo(int idEquipo) {
		
		return equiJpa.findEquipo(idEquipo);
	}

	public void modificarEquipo(Equipo equi) {
		try {
			equiJpa.edit(equi);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Jugador traerJugador(int idJugador) {
		
		return jugJpa.findJugador(idJugador);
	}

	public List<Jugador> traerJugadores() {
		
		return jugJpa.findJugadorEntities();
	}

	public void borrarJugador(int idJugador) {
		try {
			jugJpa.destroy(idJugador);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void modificarJugador(Jugador jug) {
		try {
			jugJpa.edit(jug);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	
	
	
	
	

}
