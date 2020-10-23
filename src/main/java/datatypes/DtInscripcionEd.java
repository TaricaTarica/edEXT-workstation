package datatypes;

import java.util.Date;

import logica.InscripcionEd;

public class DtInscripcionEd {
	private String nombreEdicion;
	private String nicknameEstudiante;
	private Date fecha;
	private EstadoInscripcion estado;
	
	public DtInscripcionEd(String nombreEdicion, String nicknameEstudiante, Date fecha) {
		this.nombreEdicion = nombreEdicion;
		this.nicknameEstudiante = nicknameEstudiante;
		this.fecha = fecha;
	}

	public DtInscripcionEd() {
		
	}
	
	public DtInscripcionEd(InscripcionEd ied) {
		this.nombreEdicion = ied.getEdicion().getNombre();
		this.nicknameEstudiante = ied.getEstudiante().getNickname();
		this.fecha = ied.getFecha();
		this.estado = ied.getEstado();
	}

	public String getNombreEdicion() {
		return nombreEdicion;
	}

	public void setNombreEdicion(String nombreEdicion) {
		this.nombreEdicion = nombreEdicion;
	}

	public String getNicknameEstudiante() {
		return nicknameEstudiante;
	}

	public void setNicknameEstudiante(String nicknameEstudiante) {
		this.nicknameEstudiante = nicknameEstudiante;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public EstadoInscripcion getEstado() {
		return estado;
	}

	public void setEstado(EstadoInscripcion estado) {
		this.estado = estado;
	}
	
}
