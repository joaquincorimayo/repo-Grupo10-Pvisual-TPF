package ar.edu.unju.fi.tpf.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpf.entity.Curriculum;

/**
 * Declaracion de servicios para Curriculum.
 * 
 * @author JoaquinCorimayo
 * 
 * @author LuisQuispe
 */
@Service
public interface ICurriculumService {

	public Curriculum getCurriculum();

	public void guardarCurriculum(Curriculum curriculum);

	public void modificarCurriculum(Curriculum curriculum);

	public void eliminarCurriculum(Long id);

	public List<Curriculum> getListaCurriculum();

	public Curriculum buscarCurriculum(Long id);

}
