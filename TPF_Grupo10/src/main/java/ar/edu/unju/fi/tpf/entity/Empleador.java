package ar.edu.unju.fi.tpf.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 * Permite la creacion de objetos de tipo Empleador.
 * 
 * @author JoaquinCorimayo
 *
 */

@Component
public class Empleador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String cuit;
	private String password;
	private String razonSocial;
	private String nombreComercial;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaInicioActividad;
	private String email;
	private String telefono;
	private String domicilio;
	private String provincia;
	private String paginaWeb;
	private String descripcion;
	private boolean estado;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
