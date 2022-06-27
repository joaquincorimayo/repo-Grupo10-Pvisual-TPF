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
	
	@Column(name = "EMP_CUIT")
	private String cuit;
	@Column(name = "EMP_PASSWORD")
	private String password;
	@Column(name = "EMP_R_SOCIAL")
	private String razonSocial;
	@Column(name = "EMP_N_COMERCIAL")
	private String nombreComercial;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "EMP_INICIO_ACTIVIDAD")
	private LocalDate fechaInicioActividad;
	@Column(name = "EMP_EMAIL")
	private String email;
	@Column(name = "EMP_TEL")
	private String telefono;
	@Column(name = "EMP_DOMICILIO")
	private String domicilio;
	@Column(name = "EMP_PROVINCIA")
	private String provincia;
	@Column(name = "EMP_PAG_WEB")
	private String paginaWeb;
	@Column(name = "EMP_DESCRIPCION")
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
