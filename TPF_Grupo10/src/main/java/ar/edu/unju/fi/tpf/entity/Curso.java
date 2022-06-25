package ar.edu.unju.fi.tpf.entity;

import java.io.Serializable;
import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * Permite la creacion de objetos de tipo Curso.
 * 
 * @author JoaquinCorimayo
 *
 */

@Component
@Entity
@Table(name = "CURSO")
public class Curso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUR_ID")
	private Long id;
	@Column(name = "CUR_CATEGORIA")
	private String categoria;
	@Column(name = "CUR_TITULO")
	private String titulo;
	@Column(name = "CUR_FECHAINICIO")
	private LocalDate fechaInicio;
	@Column(name = "CUR_FECHAFIN")	
	private LocalDate fechaFin;
	@Column(name = "CUR_MODALIDAD")
	private String modalidad;
	@Column(name = "CUR_DETALLES")
	private String detalles;
	@Column(name = "CUR_NOMBREDOCENTE")
	private String nombreDocente;
	@Column(name="CUR_INSCRIPTOS")
	private boolean contador;
	
//	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//	@JoinTable(	name = "CURSO_CIUDADANO",
//				joinColumns = @JoinColumn(name = "CUR_ID"),
//				inverseJoinColumns = @JoinColumn(name = "CIU_ID")
//				)
//	private List<Ciudadano> ciudadanos = new ArrayList<Ciudadano>();

	public Curso() {

	}

//	public Curso(Long id, String categoria, String titulo, LocalDate fechaInicio, LocalDate fechaFin, String modalidad,
//			String detalles, String nombreDocente, List<Ciudadano> ciudadanos) {
	public Curso(Long id, String categoria, String titulo, LocalDate fechaInicio, LocalDate fechaFin, String modalidad,
				String detalles, String nombreDocente, boolean contador) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.titulo = titulo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.modalidad = modalidad;
		this.detalles = detalles;
		this.nombreDocente = nombreDocente;
		this.contador = contador;
//		this.ciudadanos = ciudadanos;
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

//	public List<Ciudadano> getCiudadanos() {
//		return ciudadanos;
//	}
//
//	public void setCiudadanos(List<Ciudadano> ciudadanos) {
//		this.ciudadanos = ciudadanos;
//	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public boolean isContador() {
		return contador;
	}

	public void setContador(boolean contador) {
		this.contador = contador;
	}

	//	@Override
//	public String toString() {
//		return "Curso [id=" + id + ", categoria=" + categoria + ", titulo=" + titulo + ", fechaInicio=" + fechaInicio
//				+ ", fechaFin=" + fechaFin + ", modalidad=" + modalidad + ", detalles=" + detalles + ", nombreDocente="
//				+ nombreDocente + ", ciudadanos=" + ciudadanos + "]";
//	}
	@Override
	public String toString() {
		return "Curso [id=" + id + ", categoria=" + categoria + ", titulo=" + titulo + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", modalidad=" + modalidad + ", detalles=" + detalles + ", nombreDocente="
				+ nombreDocente + "]";
	}

}
