package ar.edu.unju.fi.tpf.service;

import ar.edu.unju.fi.tpf.entity.Curriculum;

/**
 * Declaracion de servicios para Curriculum.
 * 
 * @author JoaquinCorimayo
 * 
 * @author LuisQuispe
 */

public interface ICurriculumService {
	public Curriculum crearCurriculum();
	public void leerCurriculum();
	public void actualizarCurriculum(Curriculum curriculum);
	public void borrarCurriculum();
	public void insertarCurriculum(Curriculum curriculum);
	public void obtenerCurriculum();	
}
