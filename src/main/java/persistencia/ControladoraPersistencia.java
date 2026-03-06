package persistencia;

import logica.Equipo;

public class ControladoraPersistencia {
	
	EquipoJpaController equiJpa = new EquipoJpaController();
	JugadorJpaController jugJpa = new JugadorJpaController();
	
	public void guardarEquipo(Equipo equi) {
		
		equiJpa.create(equi);
		
	}
	
	
	
	
	
	

}
