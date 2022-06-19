package ar.edu.unju.fi.tpf.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * Permite la creacion de objetos de tipo Oferta.
 * 
 * @author JoaquinCorimayo
 *
 */

@Component
@Entity
@Table(name = "OFERTA")
public class Oferta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OFE_ID")
	private Long id;
	
	@Column(name = "OFE_VACANTES")
	private String cantidadVacantes;
	@Column(name = "OFE_DISP_HORARIA")
	private String disponibilidadHoraria;
	@Column(name = "OFE_PUESTO_REQ")
	private String puestoRequerido;
	@Column(name = "OFE_TAREAS")
	private String principalesTareas;
	@Column(name = "OFE_RESUMEN")
	private String resumen;
	@Column(name = "OFE_CONTACTO")
	private String datosContacto;
	@Column(name = "OFE_JORNADA")
	private String jornada;
	@Column(name = "OFE_REQ")
	private String requisitos;
	@Column(name = "OFE_BENEFICIOS")
	private String beneficios;
	@Column(name = "OFE_DISPONIBILIDAD")
	private String disponibilidad;
	@Column(name = "OFE_SALARIO")
	private String salario;
	@Column(name = "OFE_ESTADO")
	private boolean estado;

	public Oferta() {

	}

	public Oferta(Long id, String cantidadVacantes, String disponibilidadHoraria, String puestoRequerido,
			String principalesTareas, String resumen, String datosContacto, String jornada, String requisitos,
			String beneficios, String disponibilidad, String salario, boolean estado) {
		super();
		this.id = id;
		this.cantidadVacantes = cantidadVacantes;
		this.disponibilidadHoraria = disponibilidadHoraria;
		this.puestoRequerido = puestoRequerido;
		this.principalesTareas = principalesTareas;
		this.resumen = resumen;
		this.datosContacto = datosContacto;
		this.jornada = jornada;
		this.requisitos = requisitos;
		this.beneficios = beneficios;
		this.disponibilidad = disponibilidad;
		this.salario = salario;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCantidadVacantes() {
		return cantidadVacantes;
	}

	public void setCantidadVacantes(String cantidadVacantes) {
		this.cantidadVacantes = cantidadVacantes;
	}

	public String getDisponibilidadHoraria() {
		return disponibilidadHoraria;
	}

	public void setDisponibilidadHoraria(String disponibilidadHoraria) {
		this.disponibilidadHoraria = disponibilidadHoraria;
	}

	public String getPuestoRequerido() {
		return puestoRequerido;
	}

	public void setPuestoRequerido(String puestoRequerido) {
		this.puestoRequerido = puestoRequerido;
	}

	public String getPrincipalesTareas() {
		return principalesTareas;
	}

	public void setPrincipalesTareas(String principalesTareas) {
		this.principalesTareas = principalesTareas;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public String getDatosContacto() {
		return datosContacto;
	}

	public void setDatosContacto(String datosContacto) {
		this.datosContacto = datosContacto;
	}

	public String getJornada() {
		return jornada;
	}

	public void setJornada(String jornada) {
		this.jornada = jornada;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public String getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}

	public String getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Oferta [id=" + id + ", cantidadVacantes=" + cantidadVacantes + ", disponibilidadHoraria="
				+ disponibilidadHoraria + ", puestoRequerido=" + puestoRequerido + ", principalesTareas="
				+ principalesTareas + ", resumen=" + resumen + ", datosContacto=" + datosContacto + ", jornada="
				+ jornada + ", requisitos=" + requisitos + ", beneficios=" + beneficios + ", disponibilidad="
				+ disponibilidad + ", salario=" + salario + ", estado=" + estado + "]";
	}

}
