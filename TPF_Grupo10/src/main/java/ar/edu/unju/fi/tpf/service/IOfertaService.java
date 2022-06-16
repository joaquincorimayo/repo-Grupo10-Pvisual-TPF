package ar.edu.unju.fi.tpf.service;

import ar.edu.unju.fi.tpf.entity.Oferta;

/**
 * Declaracion de servicios para Oferta.
 * 
 * @author JoaquinCorimayo
 */

public interface IOfertaService {
	public Oferta crearOferta();
	public void leerOferta();
	public void actualizarOferta();
	public void borrarOferta();
	public void insertarOferta();
	public void obtenerOferta();	
}
