package ar.edu.unju.fi.tpf.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	@Column(name="CURR_ID")
	private Long id;
	
	@OneToOne(mappedBy = "curriculum", cascade = CascadeType.ALL)
	private Ciudadano ciudadano;
	
	@Column(name="CURR_CONTACTO")
	private String contacto;
	
	@Column(name="CURR_EDUCACION")
	private String educacion;
	
	@Column(name="CURR_IDIOMAS")
	private String idiomas;
	
	@Column(name="CURR_CONINF")
	private String conocimientosInfomaticos;
	
	@Column(name="CURR_EXPLAB")
	private String experienciaLaboral;
	
	@Column(name="CUR_DOMICIOLIO")
	private String domicilio;
	
	@Column(name="CURR_ESTADO")
	private boolean estado;

	public Curriculum() {
		// TODO Auto-generated constructor stub
	}

	public Curriculum(Long id, Ciudadano ciudadano, String contacto, String educacion, String idiomas,
			String conocimientosInfomaticos, String experienciaLaboral, String domicilio, boolean estado) {
		super();
		this.id = id;
		this.ciudadano = ciudadano;
		this.contacto = contacto;
		this.educacion = educacion;
		this.idiomas = idiomas;
		this.conocimientosInfomaticos = conocimientosInfomaticos;
		this.experienciaLaboral = experienciaLaboral;
		this.domicilio = domicilio;
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

	public String getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}

	public String getConocimientosInfomaticos() {
		return conocimientosInfomaticos;
	}

	public void setConocimientosInfomaticos(String conocimientosInfomaticos) {
		this.conocimientosInfomaticos = conocimientosInfomaticos;
	}

	public String getExperienciaLaboral() {
		return experienciaLaboral;
	}

	public void setExperienciaLaboral(String experienciaLaboral) {
		this.experienciaLaboral = experienciaLaboral;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Curriculum [id=" + id + ", ciudadano=" + ciudadano + ", contacto=" + contacto + ", educacion="
				+ educacion + ", idiomas=" + idiomas + ", conocimientosInfomaticos=" + conocimientosInfomaticos
				+ ", experienciaLaboral=" + experienciaLaboral + ", domicilio=" + domicilio + ", estado=" + estado
				+ "]";
	}

}
