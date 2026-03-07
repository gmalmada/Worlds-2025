package logica;

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
		jug.setJugEquipo();
		
	}

}
