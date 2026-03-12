package logica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Jugador {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idJugador;
	private String jugNombre;
	private String jugUsuario;
	private String jugRol;
	private String jugPuesto;
	@ManyToOne
	@JoinColumn(name="id_equipo")
	private Equipo jugEquipo;
	
	public Jugador() {
		super();
	}

	public Jugador(int idJugador, String jugNombre, String jugUsuario, String jugRol, String jugPuesto,
			Equipo jugEquipo) {
		super();
		this.idJugador = idJugador;
		this.jugNombre = jugNombre;
		this.jugUsuario = jugUsuario;
		this.jugRol = jugRol;
		this.jugPuesto = jugPuesto;
		this.jugEquipo = jugEquipo;
	}

	public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
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

	public Equipo getJugEquipo() {
		return jugEquipo;
	}

	public void setJugEquipo(Equipo jugEquipo) {
		this.jugEquipo = jugEquipo;
	}

	

	
}
