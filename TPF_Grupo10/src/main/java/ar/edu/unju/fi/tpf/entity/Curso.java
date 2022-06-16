package ar.edu.unju.fi.tpf.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Permite la creacion de objetos de tipo Curso.
 * 
 * @author JoaquinCorimayo
 *
 */

@Component
public class Curso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String categoria;
	private String titulo;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String modalidad;
	private String detalles;
	private String nombreDocente;
	private List<Ciudadano> ciudadanos = new ArrayList<Ciudadano>();

	public Curso() {

	}

	public Curso(Long id, String categoria, String titulo, LocalDate fechaInicio, LocalDate fechaFin, String modalidad,
			String detalles, String nombreDocente, List<Ciudadano> ciudadanos) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.titulo = titulo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.modalidad = modalidad;
		this.detalles = detalles;
		this.nombreDocente = nombreDocente;
		this.ciudadanos = ciudadanos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	public String getNombreDocente() {
		return nombreDocente;
	}

	public void setNombreDocente(String nombreDocente) {
		this.nombreDocente = nombreDocente;
	}

	public List<Ciudadano> getCiudadanos() {
		return ciudadanos;
	}

	public void setCiudadanos(List<Ciudadano> ciudadanos) {
		this.ciudadanos = ciudadanos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", categoria=" + categoria + ", titulo=" + titulo + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", modalidad=" + modalidad + ", detalles=" + detalles + ", nombreDocente="
				+ nombreDocente + ", ciudadanos=" + ciudadanos + "]";
	}

}
