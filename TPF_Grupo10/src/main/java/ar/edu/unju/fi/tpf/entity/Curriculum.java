package ar.edu.unju.fi.tpf.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

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
	
	@OneToOne
	@JoinColumn(name = "CIU_ID")
	private Ciudadano ciudadano;
	
	@NotEmpty(message = "Este campo no puede estar vacio")
	@Column(name="CURR_CONTACTO")
	@Pattern(message = "No ingresar numeros", regexp="[^0-9]*")
	private String contacto;
	
	@NotEmpty(message = "Este campo no puede estar vacio")
	@Column(name="CURR_EDUCACION")
	@Pattern(message = "No ingresar numeros", regexp="[^0-9]*")
	private String educacion;
	
	@NotEmpty(message = "Este campo no puede estar vacio")
	@Column(name="CURR_IDIOMAS")
	@Pattern(message = "No ingresar numeros", regexp="[^0-9]*")
	private String idiomas;
	
	@NotEmpty(message = "Este campo no puede estar vacio")
	@Column(name="CURR_CONINF")
	@Pattern(message = "No ingresar numeros", regexp="[^0-9]*")
	private String conocimientosInfomaticos;
	
	@NotEmpty(message = "Este campo no puede estar vacio")
	@Column(name="CURR_EXPLAB")
	@Pattern(message = "No ingresar numeros", regexp="[^0-9]*")
	private String experienciaLaboral;
	
	@NotEmpty(message = "Este campo no puede estar vacio")
	@Column(name="CURR_DOMICILIO")
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
