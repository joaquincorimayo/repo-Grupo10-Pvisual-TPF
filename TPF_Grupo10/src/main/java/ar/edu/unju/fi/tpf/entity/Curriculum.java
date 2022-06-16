package ar.edu.unju.fi.tpf.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * Permite la creacion de objetos de tipo Curriculum.
 * 
 * @author JoaquinCorimayo
 *
 */

@Component
public class Curriculum implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private Ciudadano ciudadano;
	private String contacto;
	private String educacion;
	private boolean idiomas;
	private boolean conocimientosInfomaticos;
	private boolean experienciaLaboral;

	public Curriculum() {
		// TODO Auto-generated constructor stub
	}

	public Curriculum(Long id, Ciudadano ciudadano, String contacto, String educacion, boolean idiomas,
			boolean conocimientosInfomaticos, boolean experienciaLaboral) {
		super();
		this.id = id;
		this.ciudadano = ciudadano;
		this.contacto = contacto;
		this.educacion = educacion;
		this.idiomas = idiomas;
		this.conocimientosInfomaticos = conocimientosInfomaticos;
		this.experienciaLaboral = experienciaLaboral;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ciudadano getCiudadano() {
		return ciudadano;
	}

	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getEducacion() {
		return educacion;
	}

	public void setEducacion(String educacion) {
		this.educacion = educacion;
	}

	public boolean isIdiomas() {
		return idiomas;
	}

	public void setIdiomas(boolean idiomas) {
		this.idiomas = idiomas;
	}

	public boolean isConocimientosInfomaticos() {
		return conocimientosInfomaticos;
	}

	public void setConocimientosInfomaticos(boolean conocimientosInfomaticos) {
		this.conocimientosInfomaticos = conocimientosInfomaticos;
	}

	public boolean isExperienciaLaboral() {
		return experienciaLaboral;
	}

	public void setExperienciaLaboral(boolean experienciaLaboral) {
		this.experienciaLaboral = experienciaLaboral;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Curriculum [id=" + id + ", ciudadano=" + ciudadano + ", contacto=" + contacto + ", educacion="
				+ educacion + ", idiomas=" + idiomas + ", conocimientosInfomaticos=" + conocimientosInfomaticos
				+ ", experienciaLaboral=" + experienciaLaboral + "]";
	}

}
