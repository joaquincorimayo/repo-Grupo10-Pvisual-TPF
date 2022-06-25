package ar.edu.unju.fi.tpf.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpf.entity.Curso;
import ar.edu.unju.fi.tpf.repositorty.ICursoRepository;
import ar.edu.unju.fi.tpf.service.ICursoService;

/**
 * Implementacion de servicios.
 * 
 * @author JoaquinCorimayo
 * 
 * @author LuisQuispe
 */

@Service
public class CursoServiceImp implements ICursoService{
	@Autowired
	private ICursoRepository cursoRepository; 
	
	@Override
	public void guardarCurso(Curso curso) {
		cursoRepository.save(curso);
	}

	@Override
	public List<Curso> listarCursos() {
		return cursoRepository.findAll();
	}

	@Override
	public Optional<Curso> buscarCurso(Long id) {
		return cursoRepository.findById(id);
	}
	
}