package ar.edu.unju.fi.tpf.service;

import ar.edu.unju.fi.tpf.entity.Ciudadano;

/**
 * Declaracion de servicios para Ciudadano.
 * 
 * @author JoaquinCorimayo
 */

public interface ICiudadanoService {
	public Ciudadano crearCiudadano();
	public void leerCiudadano();
	public void actualizarCiudadano();
	public void borrarCiudadano();
	public void insertarCiudadano();
	public void obtenerCiudadano();	
}
