package ar.edu.unju.fi.tpf.service;

import ar.edu.unju.fi.tpf.entity.Empleador;

/**
 * Declaracion de servicios para Empleador.
 * 
 * @author JoaquinCorimayo
 */

public interface IEmpleadorService {
	public Empleador crearCiudadano();
	public void leerEmpleador();
	public void actualizarEmpleador();
	public void borrarEmpleador();
	public void insertarEmpleador();
	public void obtenerEmpleador();	
}
