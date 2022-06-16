package ar.edu.unju.fi.tpf.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Permite la creacion de objetos de tipo Ciudadano.
 * 
 * @author JoaquinCorimayo
 *
 */

@Component
public class Ciudadano implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String dni;
	private String password;
	private String numeroTramite;
	private String nombre;
	private String apellido;
	private String email;
	private String estadoCivil;
	private String provincia;
	private String telefono;
	private Curriculum curriculum;
	private List<Curso> cursos = new ArrayList<Curso>();
	private List<Oferta> ofertas = new ArrayList<Oferta>();

	public Ciudadano() {
		// TODO Auto-generated constructor stub
	}

	public Ciudadano(Long id, String dni, String password, String numeroTramite, String nombre, String apellido,
			String email, String estadoCivil, String provincia, String telefono, Curriculum curriculum,
			List<Curso> cursos, List<Oferta> ofertas) {
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
		this.cursos = cursos;
		this.ofertas = ofertas;
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

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Oferta> getOfertas() {
		return ofertas;
	}

	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Ciudadano [id=" + id + ", dni=" + dni + ", password=" + password + ", numeroTramite=" + numeroTramite
				+ ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", estadoCivil=" + estadoCivil
				+ ", provincia=" + provincia + ", telefono=" + telefono + ", curriculum=" + curriculum + ", cursos="
				+ cursos + ", ofertas=" + ofertas + "]";
	}

}
