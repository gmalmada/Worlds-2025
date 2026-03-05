package logica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Equipo {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private String equiNombre;
	private String equiTag;
	private String equiRegion;
	
	public Equipo() {
		super();
	}

	public Equipo(String equiNombre, String equiTag, String equiRegion) {
		super();
		this.equiNombre = equiNombre;
		this.equiTag = equiTag;
		this.equiRegion = equiRegion;
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
	
	

}
