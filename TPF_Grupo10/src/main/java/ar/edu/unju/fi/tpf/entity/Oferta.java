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
	private int cantidadVacantes;
	private int disponibilidadHoraria;
	private String puestoRequerido;
	private String principalesTareas;
	private String resumen;
	private String datosContacto;
	private String jornada;
	private String requisitos;
	private String beneficios;
	private boolean disponibilidad;
	private double salario;
	private List<Ciudadano> candidatos = new ArrayList<Ciudadano>();
	private Empleador empleador;

	public Oferta() {
		// TODO Auto-generated constructor stub
	}

	public Oferta(Long id, int cantidadVacantes, String puestoRequerido, String resumen, int disponibilidadHoraria,
			String principalesTareas, String datosContacto, String jornada, String requisitos, double salario,
			String beneficios, boolean disponibilidad, List<Ciudadano> candidatos, Empleador empleador) {
		super();
		this.id = id;
		this.cantidadVacantes = cantidadVacantes;
		this.puestoRequerido = puestoRequerido;
		this.resumen = resumen;
		this.disponibilidadHoraria = disponibilidadHoraria;
		this.principalesTareas = principalesTareas;
		this.datosContacto = datosContacto;
		this.jornada = jornada;
		this.requisitos = requisitos;
		this.salario = salario;
		this.beneficios = beneficios;
		this.disponibilidad = disponibilidad;
		this.candidatos = candidatos;
		this.empleador = empleador;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCantidadVacantes() {
		return cantidadVacantes;
	}

	public void setCantidadVacantes(int cantidadVacantes) {
		this.cantidadVacantes = cantidadVacantes;
	}

	public String getPuestoRequerido() {
		return puestoRequerido;
	}

	public void setPuestoRequerido(String puestoRequerido) {
		this.puestoRequerido = puestoRequerido;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public int getDisponibilidadHoraria() {
		return disponibilidadHoraria;
	}

	public void setDisponibilidadHoraria(int disponibilidadHoraria) {
		this.disponibilidadHoraria = disponibilidadHoraria;
	}

	public String getPrincipalesTareas() {
		return principalesTareas;
	}

	public void setPrincipalesTareas(String principalesTareas) {
		this.principalesTareas = principalesTareas;
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

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Oferta [id=" + id + ", cantidadVacantes=" + cantidadVacantes + ", puestoRequerido=" + puestoRequerido
				+ ", resumen=" + resumen + ", disponibilidadHoraria=" + disponibilidadHoraria + ", principalesTareas="
				+ principalesTareas + ", datosContacto=" + datosContacto + ", jornada=" + jornada + ", requisitos="
				+ requisitos + ", salario=" + salario + ", beneficios=" + beneficios + ", disponibilidad="
				+ disponibilidad + ", candidatos=" + candidatos + ", empleador=" + empleador + "]";
	}

}
