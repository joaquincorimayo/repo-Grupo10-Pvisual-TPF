package ar.edu.unju.fi.tpf.entity;

import java.io.Serializable;
import java.time.LocalDate;
//import java.util.ArrayList;
import java.time.Period;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
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
@Table(name = "CIUDADANO")
public class Ciudadano implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CIU_ID")
	private Long id;

	@Max(value = 99999999, message = "El dni debe ser menor que 99.999.999")
	@Min(value = 1000000, message = "El dni debe ser mayor que 1.000.000")
	@Column(name = "CIU_DNI")
	private String dni;

	@Size(min = 8, max = 1000, message = "La contraseña debe tener entre 8 caracteres")
	@NotNull(message = "Ingresar contraseña")
	@Column(name = "CIU_PASSWORD")
	private String password;

	@Size(min = 10, max = 12, message = "El numero de tramite tiene que tener 12 digitos")
	@NotNull(message = "Tenes que ingresar el numero de tramite")
	@Column(name = "CIU_NROTRAMITE")
	private String numeroTramite;

	@NotEmpty(message = "El nombre no puede estar vacio")
	@Size(min = 3, max = 100, message = "El nombre debe tener entre 3 a 100 caracteres")
	@Column(name = "CIU_NOMBRE")
	private String nombre;

	@Size(min = 3, max = 100, message = "El Apellido debe tener entre 3 a 100 caracteres")
	@NotEmpty(message = "El apellido no puede ser vacío")
	@Column(name = "CIU_APELLIDO")
	private String apellido;

	@NotEmpty(message = "El email no puede ser vacío")
	@Email
	@Column(name = "ALU_EMAIL")
	private String email;

	@NotEmpty
	@Column(name = "CIU_ESTADOCIVIL")
	private String estadoCivil;

	@NotEmpty
	@Column(name = "CIU_PROVINCIA")
	private String provincia;

	@NotEmpty(message = "Tenes que ingresar un numero de telefono")
	@Column(name = "CIU_TELEFONO")
	private String telefono;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "CIU_FECNAC")
	@Past(message = "La fecha no puede ser mayo a la actual")
	private LocalDate fechaNac;

	@Column(name = "CIU_ESTADO")
	private boolean estado;

	@OneToOne(mappedBy = "ciudadano", cascade = CascadeType.ALL)
	private Curriculum curriculum;

	public Ciudadano() {
	}

	public Ciudadano(Long id, String dni, String password, String numeroTramite, String nombre, String apellido,
			String email, String estadoCivil, String provincia, String telefono, LocalDate fechaNac,
			Curriculum curriculum, boolean estado) {
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
		this.fechaNac = fechaNac;
		this.curriculum = curriculum;
		this.estado = estado;
	}
	
	public int obtenerEdad() {
		LocalDate ahora = LocalDate.now();

		Period periodo = Period.between(fechaNac, ahora);
		return periodo.getYears();
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

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Curriculum getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Ciudadano [id=" + id + ", dni=" + dni + ", password=" + password + ", numeroTramite=" + numeroTramite
				+ ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", estadoCivil=" + estadoCivil
				+ ", provincia=" + provincia + ", telefono=" + telefono + ", fechaNac=" + fechaNac + ", estado="
				+ estado + ", curriculum=" + curriculum + "]";
	}

}