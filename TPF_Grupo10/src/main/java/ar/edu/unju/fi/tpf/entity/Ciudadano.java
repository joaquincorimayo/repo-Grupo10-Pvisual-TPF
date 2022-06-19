package ar.edu.unju.fi.tpf.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

/**
 * Permite la creacion de objetos de tipo Ciudadano.
 * 
 * @author JoaquinCorimayo
 * 
 * @author LuisQuispe
 */

@Component
@Entity
@Table(name = "ciudadanos")
public class Ciudadano implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CIU_ID")
	private Long id;

	@Max(value = 99999999, message = "DNI debe ser menor que 99999999")
	@Min(value = 1000000, message = "DNI debe ser mayor que 1000000")
	@Column(name = "CIU_DNI")
	private String dni;

	@Size(min = 3, max = 100, message = "La contraseña debe tener entre 4 a 12 caracteres")
	@NotNull(message = "*Debe ingresar una contraseña")
	@Column(name = "CIU_PASSWORD")
	private String password;

	@Size(min = 10, max = 12, message = "Debe ingresar n° de 12 digitos")
	@NotNull(message = "*Debe ingresar le n° de tramite")
	@Column(name = "CIU_NROTRAMITE")
	private String numeroTramite;

	@NotEmpty(message = "El nombre no puede ser vacío")
	@Size(min = 3, max = 100, message = "El nombre debe tener entre 3 a 100 caracteres")
	@Column(name = "CIU_NOMBRE")
	private String nombre;

	@Size(min = 3, max = 100, message = "El Apellido debe tener entre 3 a 100 caracteres")
	@NotEmpty(message = "El apellido del alumno no puede ser vacío")
	@Column(name = "CIU_APELLIDO")
	private String apellido;

	@NotEmpty(message = "El email del alumno no puede ser vacío")
	@Email
	@Column(name = "ALU_EMAIL")
	private String email;

	@NotEmpty
	@Column(name = "CIU_ESTADOCIVIL")
	private String estadoCivil;

	@NotEmpty
	@Column(name = "CIU_PROVINCIA")
	private String provincia;

	@NotEmpty(message = "El n° teléfono no puede ser vacío.")
	@Column(name = "CIU_TELEFONO")
	private String telefono;

	@Column(name = "CIU_CURRICULUM")
	private Curriculum curriculum;

//	@Column(name = "CIU_CURSOS")
//	private List<Curso> cursos = new ArrayList<Curso>();

	@Column(name = "CIU_ESTADO")
	private boolean estado;

	public Ciudadano() {
		// TODO Auto-generated constructor stub
	}

	public Ciudadano(Long id,
			@Max(value = 99999999, message = "DNI debe ser menor que 99999999") @Min(value = 1000000, message = "DNI debe ser mayor que 1000000") String dni,
			@Size(min = 3, max = 100, message = "La contraseña debe tener entre 4 a 12 caracteres") @NotNull(message = "*Debe ingresar una contraseña") String password,
			@Size(min = 10, max = 12, message = "Debe ingresar n° de 12 digitos") @NotNull(message = "*Debe ingresar le n° de tramite") String numeroTramite,
			@NotEmpty(message = "El nombre no puede ser vacío") @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 a 100 caracteres") String nombre,
			@Size(min = 3, max = 100, message = "El Apellido debe tener entre 3 a 100 caracteres") @NotEmpty(message = "El apellido del alumno no puede ser vacío") String apellido,
			@NotEmpty(message = "El email del alumno no puede ser vacío") @Email String email,
			@NotEmpty String estadoCivil, @NotEmpty String provincia,
			@NotEmpty(message = "El n° teléfono no puede ser vacío.") String telefono, Curriculum curriculum,
			List<Curso> cursos, boolean estado) {
		super();
		this.id = id;
		this.dni = dni;
		this.password = password;
		this.numeroTramite = numeroTramite;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.estadoCivil = estadoCivil;
		this.provincia = provincia;
		this.telefono = telefono;
		this.curriculum = curriculum;
//		this.cursos = cursos;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNumeroTramite() {
		return numeroTramite;
	}

	public void setNumeroTramite(String numeroTramite) {
		this.numeroTramite = numeroTramite;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Curriculum getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}

//	public List<Curso> getCursos() {
//		return cursos;
//	}
//
//	public void setCursos(List<Curso> cursos) {
//		this.cursos = cursos;
//	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

//	@Override
//	public String toString() {
//		return "Ciudadano [id=" + id + ", dni=" + dni + ", password=" + password + ", numeroTramite=" + numeroTramite
//				+ ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", estadoCivil=" + estadoCivil
//				+ ", provincia=" + provincia + ", telefono=" + telefono + ", curriculum=" + curriculum + ", cursos="
//				+ cursos + ", estado=" + estado + "]";
//	}
	@Override
	public String toString() {
		return "Ciudadano [id=" + id + ", dni=" + dni + ", password=" + password + ", numeroTramite=" + numeroTramite
				+ ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", estadoCivil=" + estadoCivil
				+ ", provincia=" + provincia + ", telefono=" + telefono + ", curriculum=" + curriculum + ", estado=" + estado + "]";
	}

}