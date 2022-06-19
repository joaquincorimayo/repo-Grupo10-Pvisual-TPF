package ar.edu.unju.fi.tpf.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

/**
 * Permite la creacion de objetos de tipo Curriculum.
 * 
 * @author JoaquinCorimayo
 *
 * @author LuisQuispe
 */

@Component
@Entity
@Table(name="CURRICULUM")
public class Curriculum implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CUR_ID")
	private Long id;
	
	private Ciudadano ciudadano;
	
	@Column(name="CUR_CONTACTO")
	private String contacto;
	
	@Column(name="CUR_EDUCACION")
	private String educacion;
	
	@Column(name="CUR_IDIOMAS")
	private boolean idiomas;
	
	@Column(name="CUR_CONINF")
	private boolean conocimientosInfomaticos;
	
	@Column(name="CUR_EXPLAB")
	private boolean experienciaLaboral;
	
	@Column(name="CUR_ESTADO")
	private boolean estado;

	public Curriculum() {
		// TODO Auto-generated constructor stub
	}

	public Curriculum(Long id, Ciudadano ciudadano, String contacto, String educacion, boolean idiomas,
			boolean conocimientosInfomaticos, boolean experienciaLaboral, boolean estado) {
		super();
		this.id = id;
		this.ciudadano = ciudadano;
		this.contacto = contacto;
		this.educacion = educacion;
		this.idiomas = idiomas;
		this.conocimientosInfomaticos = conocimientosInfomaticos;
		this.experienciaLaboral = experienciaLaboral;
		this.estado = estado;
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

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Curriculum [id=" + id + ", ciudadano=" + ciudadano + ", contacto=" + contacto + ", educacion="
				+ educacion + ", idiomas=" + idiomas + ", conocimientosInfomaticos=" + conocimientosInfomaticos
				+ ", experienciaLaboral=" + experienciaLaboral + ", estado=" + estado + "]";
	}

}
