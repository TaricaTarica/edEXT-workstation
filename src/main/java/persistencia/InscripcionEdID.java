package persistencia;

import java.io.Serializable;

//No es una entidad, debe implementar serializable
public class InscripcionEdID implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String estudiante;
	private String edicion;
	
	//Tiene que tener constructor por defecto
	public InscripcionEdID() {
		super();
	}


	//Tiene que implementar los getters y setters

	public String getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(String estudiante) {
		this.estudiante = estudiante;
	}
	public String getEdicion() {
		return edicion;
	}

	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}
	
	//Tiene  que tener los m�todos hashCode y equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estudiante == null) ? 0 : estudiante.hashCode());
		result = prime * result + ((edicion == null) ? 0 : edicion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InscripcionEdID other = (InscripcionEdID) obj;
		if (edicion == null) {
			if (other.edicion != null)
				return false;
		} else if (!edicion.equals(other.edicion))
			return false;
		if (estudiante == null) {
			if (other.estudiante != null)
				return false;
		} else if (!estudiante.equals(other.estudiante))
			return false;
		return true;
	}
	
}
