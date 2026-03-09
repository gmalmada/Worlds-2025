package logica;

import java.util.List;

import persistencia.ControladoraPersistencia;

public class ControladoraLogica {
	
	ControladoraPersistencia conPersis = new ControladoraPersistencia();

	public void guardar(String nomEqui, String tagEqui, String regiEqui, String seedEqui, String iniEqui) {
		
		Equipo equi = new Equipo();
		
		equi.setEquiNombre(nomEqui);
		equi.setEquiTag(tagEqui);
		equi.setEquiRegion(regiEqui);
		equi.setEquiSeed(seedEqui);
		equi.setEquiFaseInicio(iniEqui);
		
		conPersis.guardarEquipo(equi);
		
	}

	public void guardarJ(String nomJug, String usuJug, String rolJug, String puestoJug, String equipoJug) {
		Jugador jug = new Jugador();
		
		jug.setJugNombre(nomJug);
		jug.setJugUsuario(usuJug);
		jug.setJugRol(rolJug);
		jug.setJugPuesto(puestoJug);
		
		List<Equipo> listaEquipos = conPersis.traerEquipos();
		
		Equipo equipoAsignado = null;
		
		//Busco el equipo que coincide con el dato cargado del jugador
		for(Equipo equi : listaEquipos) {
			if(equi.getEquiNombre().equals(equipoJug)) {
				equipoAsignado = equi;
				break; //Corta el ciclo al encontrar
			}
		}
		
		jug.setJugEquipo(equipoAsignado);
		
		conPersis.guardarJugador(jug);
		
	}
	
	public List<Equipo> traerEquipos(){
		return conPersis.traerEquipos();
	}

	public void borrarEquipo(int idEquipo) {
		conPersis.borrarEquipo(idEquipo);
		
	}

	public Equipo traerEquipo(int idEquipo) {
		
		return conPersis.traerEquipo(idEquipo);
	}

	public void modificarEquipo(Equipo equi, String nomEqui, String tagEqui, String regiEqui, String seedEqui, String iniEqui) {
		
		equi.setEquiNombre(nomEqui);
		equi.setEquiTag(tagEqui);
		equi.setEquiRegion(regiEqui);
		equi.setEquiSeed(seedEqui);
		equi.setEquiFaseInicio(iniEqui);
		
		conPersis.modificarEquipo(equi);
		
	}

	public Jugador traerJugador(int idJugador) {
		
		return conPersis.traerJugador(idJugador);
	}

}
