package ar.edu.unju.fi.tpf.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpf.entity.CiudadanoCurso;

/**
 * 
 * @author JoaquinCorimayo
 *
 * @author LuisQuispe
 */

@Service
public interface ICiudadanoCursoService {

	public CiudadanoCurso nuevoCiudadanoCurso();

	public void guardarCiudadanoCurso(CiudadanoCurso ciudadanoCurso);

	public void eliminarCiudadanoCurso(Long id);

	public void modificarCiudadanoCurso(CiudadanoCurso ciudadanoCurso);

	public List<CiudadanoCurso> listarCiudadanoCurso();

	public CiudadanoCurso buscarCiudadanoCurso(Long id);

}