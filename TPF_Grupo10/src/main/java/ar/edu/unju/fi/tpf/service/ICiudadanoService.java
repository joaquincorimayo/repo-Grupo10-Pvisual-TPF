package ar.edu.unju.fi.tpf.service;

import java.util.List;

import ar.edu.unju.fi.tpf.entity.Ciudadano;

/**
 * Declaracion de servicios para Ciudadano.
 * 
 * @author JoaquinCorimayo
 * 
 * @author LuisQuispe
 */

public interface ICiudadanoService {

	public Ciudadano getCiudadano();

	public void guardarCiudadano(Ciudadano ciudadano);

	public void modificarCiudadano(Ciudadano ciudadano);

	public void eliminarCiudadano(String dni);

	public List<Ciudadano> getListaCiudadano();

	public Ciudadano buscarCiudadano(String dni);

	public Ciudadano buscarIdCiudadano(Long id);

	public boolean existeCiudadano(String dni);

	public List<Ciudadano> getListaCiudadanoProvincia(String provincia);

	public List<Ciudadano> getListaCiudadanoClave(String clave);

	public List<Ciudadano> getListaCiudadanoProvinciaClave(String provincia, String clave);

}
