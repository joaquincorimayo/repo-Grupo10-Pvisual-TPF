package ar.edu.unju.fi.tpf.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpf.entity.CiudadanoOferta;

/**
 * 
 * @author JoaquinCorimayo
 *
 * @author LuisQuispe
 */

@Service
public interface ICiudadanoOfertaService {
	
	public CiudadanoOferta nuevoCiudadanoOferta();
	public void guardarCiudadanoOferta(CiudadanoOferta ciudadanoOferta);
	public void eliminarCiudadanoOferta(Long id);
	public void modificarCiudadanoOferta(CiudadanoOferta ciudadanoOferta);
	public List<CiudadanoOferta> listarCiudadanoOferta();
	public CiudadanoOferta buscarCiudadanoOferta(Long id);

}