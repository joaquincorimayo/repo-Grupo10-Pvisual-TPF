package ar.edu.unju.fi.tpf.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Permite la creacion de objetos de tipo Oferta.
 * 
 * @author JoaquinCorimayo
 *
 */

@Component
public class Oferta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String cantidadVacantes;
	private String disponibilidadHoraria;
	private String puestoRequerido;
	private String principalesTareas;
	private String resumen;
	private String datosContacto;
	private String jornada;
	private String requisitos;
	private String beneficios;
	private String disponibilidad;
	private String salario;
	private boolean estado;
	private List<Ciudadano> candidatos = new ArrayList<Ciudadano>();
	private Empleador empleador;

	public Oferta() {

	}

	public Oferta(Long id, String cantidadVacantes, String disponibilidadHoraria, String puestoRequerido,
			String principalesTareas, String resumen, String datosContacto, String jornada, String requisitos,
			String beneficios, String disponibilidad, String salario, boolean estado, List<Ciudadano> candidatos,
			Empleador empleador) {
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
		this.candidatos = candidatos;
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

	public List<Ciudadano> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<Ciudadano> candidatos) {
		this.candidatos = candidatos;
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
				+ disponibilidad + ", salario=" + salario + ", estado=" + estado + ", candidatos=" + candidatos
				+ ", empleador=" + empleador + "]";
	}
}
