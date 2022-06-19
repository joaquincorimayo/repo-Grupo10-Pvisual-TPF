package ar.edu.unju.fi.tpf.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.stereotype.Component;

/**
 * 
 * @author JoaquinCorimayo
 *
 */

@Component
@Entity
public class CiudadanoOferta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OFE_ID")
	private Oferta oferta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CIU_ID")
	private Ciudadano ciudadano;
	
	public CiudadanoOferta() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	public Ciudadano getCiudadano() {
		return ciudadano;
	}

	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}

	public CiudadanoOferta(Long id, Oferta oferta, Ciudadano ciudadano) {
		super();
		this.id = id;
		this.oferta = oferta;
		this.ciudadano = ciudadano;
	}

	@Override
	public String toString() {
		return "CiudadanoOferta [id=" + id + ", oferta=" + oferta + ", ciudadano=" + ciudadano + "]";
	}
	
	

}
