package ar.edu.unju.fi.tpf.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 * Permite la creacion de objetos de tipo Empleador.
 * 
 * @author JoaquinCorimayo
 *
 */

@Component
@Entity
@Table(name="EMPLEADOR")
public class Empleador implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMP_ID")
	private Long id;
	
	@Max(value = 99999999, message = "El cuit debe ser menor que 99.999.999")
	@Min(value = 1000000, message = "El cuit debe ser mayor que 1.000.000")
	@Column(name = "EMP_CUIT")
	private String cuit;
	
	@Size(min = 8, max = 100, message = "La contraseña debe tener entre 8 caracteres")
	@NotNull(message = "Ingresar contraseña")
	@Column(name = "EMP_PASSWORD")
	private String password;
	
	@NotEmpty(message = "Este campo no puede estar vacio")
	@Column(name = "EMP_R_SOCIAL")
	@Pattern(message = "No ingresar numeros", regexp="[^0-9]*")
	private String razonSocial;
	
	@NotEmpty(message = "Este campo no puede estar vacio")
	@Column(name = "EMP_N_COMERCIAL")
	@Pattern(message = "No ingresar numeros", regexp="[^0-9]*")
	private String nombreComercial;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "EMP_INICIO_ACTIVIDAD")
	private LocalDate fechaInicioActividad;
	
	@NotEmpty(message = "El email no puede ser vacío")
	@Email
	@Column(name = "EMP_EMAIL")
	private String email;
	
	@NotEmpty(message = "Este campo no puede estar vacio")
	@Column(name = "EMP_TEL")
	@Pattern(message = "No ingresar letras", regexp="[0-9]*")
	private String telefono;
	
	@NotEmpty(message = "Este campo no puede estar vacio")
	@Column(name = "EMP_DOMICILIO")
	private String domicilio;
	
	@NotEmpty(message = "Este campo no puede estar vacio")
	@Column(name = "EMP_PROVINCIA")
	private String provincia;
	
	@NotEmpty(message = "Este campo no puede estar vacio")
	@Column(name = "EMP_PAG_WEB")
	@Pattern(message = "No ingresar numeros", regexp="[^0-9]*")
	private String paginaWeb;
	
	@NotEmpty(message = "Este campo no puede estar vacio")
	@Column(name = "EMP_DESCRIPCION")
	@Pattern(message = "No ingresar numeros", regexp="[^0-9]*")
	private String descripcion;
	
	@Column(name = "EMP_ESTADO")
	private boolean estado;
	
	@OneToMany(mappedBy="empleador")
	private List<Oferta> ofertas = new ArrayList<Oferta>();

	public Empleador() {

	}

	public Empleador(Long id, String cuit, String password, String razonSocial, String nombreComercial,
			LocalDate fechaInicioActividad, String email, String telefono, String domicilio, String provincia,
			String paginaWeb, String descripcion, boolean estado, List<Oferta> ofertas) {
		super();
		this.id = id;
		this.cuit = cuit;
		this.password = password;
		this.razonSocial = razonSocial;
		this.nombreComercial = nombreComercial;
		this.fechaInicioActividad = fechaInicioActividad;
		this.email = email;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.provincia = provincia;
		this.paginaWeb = paginaWeb;
		this.descripcion = descripcion;
		this.estado = estado;
		this.ofertas = ofertas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public LocalDate getFechaInicioActividad() {
		return fechaInicioActividad;
	}

	public void setFechaInicioActividad(LocalDate fechaInicioActividad) {
		this.fechaInicioActividad = fechaInicioActividad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPaginaWeb() {
		return paginaWeb;
	}

	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public List<Oferta> getOfertas() {
		return ofertas;
	}

	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
	}

	@Override
	public String toString() {
		return "Empleador [id=" + id + ", cuit=" + cuit + ", password=" + password + ", razonSocial=" + razonSocial
				+ ", nombreComercial=" + nombreComercial + ", fechaInicioActividad=" + fechaInicioActividad + ", email="
				+ email + ", telefono=" + telefono + ", domicilio=" + domicilio + ", provincia=" + provincia
				+ ", paginaWeb=" + paginaWeb + ", descripcion=" + descripcion + ", estado=" + estado + ", ofertas="
				+ ofertas + "]";
	}

}
