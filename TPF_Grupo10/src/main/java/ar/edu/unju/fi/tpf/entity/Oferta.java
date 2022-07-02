package ar.edu.unju.fi.tpf.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

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

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OFE_ID")
	private Long id;
	
	@NotEmpty(message = "Este campo no puede estar vacio")
	@Column(name = "OFE_VACANTES")
	@Pattern(message = "No ingresar letras", regexp="[0-9]*")
	private String cantidadVacantes;
	
	@NotEmpty(message = "Este campo no puede estar vacio")
	@Column(name = "OFE_DISP_HORARIA")
	@Pattern(message = "No ingresar numeros", regexp="[^0-9]*")
	private String disponibilidadHoraria;
	
	@NotEmpty(message = "Este campo no puede estar vacio")
	@Column(name = "OFE_PUESTO_REQ")
	@Pattern(message = "No ingresar numeros", regexp="[^0-9]*")
	private String puestoRequerido;
	
	@NotEmpty(message = "Este campo no puede estar vacio")
	@Column(name = "OFE_TAREAS")
	@Pattern(message = "No ingresar numeros", regexp="[^0-9]*")
	private String principalesTareas;
	
	@NotEmpty(message = "Este campo no puede estar vacio")
	@Column(name = "OFE_RESUMEN")
	@Pattern(message = "No ingresar numeros", regexp="[^0-9]*")
	private String resumen;
	
	@NotEmpty(message = "Este campo no puede estar vacio")
	@Column(name = "OFE_CONTACTO")
	@Pattern(message = "No ingresar numeros", regexp="[^0-9]*")
	private String datosContacto;
	
	@NotEmpty(message = "Este campo no puede estar vacio")
	@Column(name = "OFE_JORNADA")
	@Pattern(message = "No ingresar numeros", regexp="[^0-9]*")
	private String jornada;
	
	@NotEmpty(message = "Este campo no puede estar vacio")
	@Column(name = "OFE_REQ")
	@Pattern(message = "No ingresar numeros", regexp="[^0-9]*")
	private String requisitos;
	
	@NotEmpty(message = "Este campo no puede estar vacio")
	@Column(name = "OFE_BENEFICIOS")
	@Pattern(message = "No ingresar numeros", regexp="[^0-9]*")
	private String beneficios;
	
	@NotEmpty(message = "Este campo no puede estar vacio")
	@Column(name = "OFE_DISPONIBILIDAD")
	@Pattern(message = "No ingresar numeros", regexp="[^0-9]*")
	private String disponibilidad;
	
	@NotEmpty(message = "Este campo no puede estar vacio")
	@Column(name = "OFE_SALARIO")
	@Pattern(message = "No ingresar letras", regexp="[0-9]*")
	private String salario;
	
	@Column(name = "OFE_ESTADO")
	private boolean estado;
	
	@ManyToOne
	@JoinColumn(name = "EMP_ID")
	private Empleador empleador;

	public Oferta() {

	}

	public Oferta(Long id, String cantidadVacantes, String disponibilidadHoraria, String puestoRequerido,
			String principalesTareas, String resumen, String datosContacto, String jornada, String requisitos,
			String beneficios, String disponibilidad, String salario, boolean estado, Empleador empleador) {
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
		this.empleador = empleador;
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

	public Empleador getEmpleador() {
		return empleador;
	}

	public void setEmpleador(Empleador empleador) {
		this.empleador = empleador;
	}

	@Override
	public String toString() {
		return "Oferta [id=" + id + ", cantidadVacantes=" + cantidadVacantes + ", disponibilidadHoraria="
				+ disponibilidadHoraria + ", puestoRequerido=" + puestoRequerido + ", principalesTareas="
				+ principalesTareas + ", resumen=" + resumen + ", datosContacto=" + datosContacto + ", jornada="
				+ jornada + ", requisitos=" + requisitos + ", beneficios=" + beneficios + ", disponibilidad="
				+ disponibilidad + ", salario=" + salario + ", estado=" + estado + ", empleador=" + empleador + "]";
	}

}