package logica;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Equipo {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idEquipo;
	private String equiNombre;
	private String equiTag;
	private String equiRegion;
	private String equiSeed;
	private String equiFaseInicio;
	
	@OneToMany(mappedBy="jugEquipo")
	private List<Jugador> listaJug = new LinkedList<Jugador>();
	
	public Equipo() {
		super();
	}

	public Equipo(int idEquipo, String equiNombre, String equiTag, String equiRegion, String equiSeed,
			String equiFaseInicio, LinkedList<Jugador> listaJug) {
		super();
		this.idEquipo = idEquipo;
		this.equiNombre = equiNombre;
		this.equiTag = equiTag;
		this.equiRegion = equiRegion;
		this.equiSeed = equiSeed;
		this.equiFaseInicio = equiFaseInicio;
		this.listaJug = listaJug;
	}

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getEquiNombre() {
		return equiNombre;
	}

	public void setEquiNombre(String equiNombre) {
		this.equiNombre = equiNombre;
	}

	public String getEquiTag() {
		return equiTag;
	}

	public void setEquiTag(String equiTag) {
		this.equiTag = equiTag;
	}

	public String getEquiRegion() {
		return equiRegion;
	}

	public void setEquiRegion(String equiRegion) {
		this.equiRegion = equiRegion;
	}

	public String getEquiSeed() {
		return equiSeed;
	}

	public void setEquiSeed(String equiSeed) {
		this.equiSeed = equiSeed;
	}

	public String getEquiFaseInicio() {
		return equiFaseInicio;
	}

	public void setEquiFaseInicio(String equiFaseInicio) {
		this.equiFaseInicio = equiFaseInicio;
	}

	public List<Jugador> getListaJug() {
		return listaJug;
	}

	public void setListaJug(LinkedList<Jugador> listaJug) {
		this.listaJug = listaJug;
	}

	
}
