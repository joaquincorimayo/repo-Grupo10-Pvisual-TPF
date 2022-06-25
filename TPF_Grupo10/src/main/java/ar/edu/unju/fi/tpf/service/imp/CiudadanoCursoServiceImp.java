package ar.edu.unju.fi.tpf.service.imp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpf.entity.CiudadanoCurso;
import ar.edu.unju.fi.tpf.repositorty.ICiudadanoCursoRepository;
import ar.edu.unju.fi.tpf.service.ICiudadanoCursoService;

/**
 * Implementacion de servicios.
 * 
 * @author JoaquinCorimayo
 * 
 * @author LuisQuispe
 */

@Service
public class CiudadanoCursoServiceImp implements ICiudadanoCursoService {

	Logger logger = LoggerFactory.getLogger(CiudadanoCursoServiceImp.class);

	@Autowired
	ICiudadanoCursoRepository ciudadanoCursoRepository;

	@Override
	public CiudadanoCurso nuevoCiudadanoCurso() {
		return new CiudadanoCurso();
	}

	@Override
	public void guardarCiudadanoCurso(CiudadanoCurso ciudadanoCurso) {
		ciudadanoCursoRepository.save(ciudadanoCurso);

	}

	@Override
	public void eliminarCiudadanoCurso(Long id) {
	}

	@Override
	public void modificarCiudadanoCurso(CiudadanoCurso ciudadanoCurso) {
	}

	@Override
	public List<CiudadanoCurso> listarCiudadanoCurso() {
		return null;
	}

	@Override
	public CiudadanoCurso buscarCiudadanoCurso(Long id) {
		return null;
	}

}
