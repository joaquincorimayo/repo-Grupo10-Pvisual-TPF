package ar.edu.unju.fi.tpf.service;

import ar.edu.unju.fi.tpf.entity.Curriculum;

/**
 * Declaracion de servicios para Curriculum.
 * 
 * @author JoaquinCorimayo
 */

public interface ICurriculumService {
	public Curriculum crearCurriculum();
	public void leerCurriculum();
	public void actualizarCurriculum();
	public void borrarCurriculum();
	public void insertarCurriculum();
	public void obtenerCurriculum();	
}
