package ar.edu.unju.fi.tpf.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpf.entity.Oferta;

/**
 * Declaracion de servicios para Oferta.
 * 
 * @author JoaquinCorimayo
 * 
 * @author LuisQuispe
 */

@Service
public interface IOfertaService {
	public Oferta crearOferta();

	public void guardarOferta(Oferta oferta);

	public void borrarOferta(Long id);

	public void actualizarOferta(Oferta oferta);

	public List<Oferta> listarOfertas();

	public Oferta buscarOferta(Long id);
	
	public List<Oferta> listarOfertasId(Long id);
}
