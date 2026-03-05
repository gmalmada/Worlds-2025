package logica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Jugador {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private String jugNombre;
	private String jugUsuario;
	private String jugRol;
	private String jugPuesto;
	@OneToOne
	private String jugEquipo;
	
	public Jugador() {
		super();
	}

	public Jugador(String jugNombre, String jugUsuario, String jugEquipo, String jugRol, String jugPuesto) {
		super();
		this.jugNombre = jugNombre;
		this.jugUsuario = jugUsuario;
		this.jugEquipo = jugEquipo;
		this.jugRol = jugRol;
		this.jugPuesto = jugPuesto;
	}

	public String getJugNombre() {
		return jugNombre;
	}

	public void setJugNombre(String jugNombre) {
		this.jugNombre = jugNombre;
	}

	public String getJugUsuario() {
		return jugUsuario;
	}

	public void setJugUsuario(String jugUsuario) {
		this.jugUsuario = jugUsuario;
	}

	public String getJugEquipo() {
		return jugEquipo;
	}

	public void setJugEquipo(String jugEquipo) {
		this.jugEquipo = jugEquipo;
	}

	public String getJugRol() {
		return jugRol;
	}

	public void setJugRol(String jugRol) {
		this.jugRol = jugRol;
	}

	public String getJugPuesto() {
		return jugPuesto;
	}

	public void setJugPuesto(String jugPuesto) {
		this.jugPuesto = jugPuesto;
	}

}
