package ar.edu.unju.fi.tpf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpf.entity.Curso;

@Service
public interface ICursoService {

	public void guardarCurso(Curso curso);
	public List<Curso> listarCursos();
	public Optional<Curso> buscarCurso(Long id);
	
}
