package ar.edu.unju.fi.tpf.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Component
@Entity
public class CiudadanoCurso implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="CUR_ID")
	private Curso curso;
	
	@ManyToOne
	@JoinColumn(name="CIU_ID")
	private Ciudadano ciudadano;

	public CiudadanoCurso() {
	}
	
	public CiudadanoCurso(Long id, Curso curso, Ciudadano ciudadano) {
		super();
		this.id = id;
		this.curso = curso;
		this.ciudadano = ciudadano;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Ciudadano getCiudadano() {
		return ciudadano;
	}

	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}

	@Override
	public String toString() {
		return "CiudadanoCurso [id=" + id + ", curso=" + curso + ", ciudadano=" + ciudadano + "]";
	}

}
