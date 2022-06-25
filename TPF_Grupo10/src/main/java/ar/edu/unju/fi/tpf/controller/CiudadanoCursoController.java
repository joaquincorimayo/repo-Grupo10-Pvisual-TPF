package ar.edu.unju.fi.tpf.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.tpf.entity.Ciudadano;
import ar.edu.unju.fi.tpf.entity.CiudadanoCurso;
import ar.edu.unju.fi.tpf.entity.Curso;
import ar.edu.unju.fi.tpf.service.ICiudadanoCursoService;
import ar.edu.unju.fi.tpf.service.ICiudadanoService;
import ar.edu.unju.fi.tpf.service.ICursoService;

/**
 * 
 * @author JoaquinCorimayo
 *
 * @author LuisQuispe
 */

@Controller
@RequestMapping("/inscripcion")
public class CiudadanoCursoController {

	Logger logger = LoggerFactory.getLogger(CiudadanoOfertaController.class);

	@Autowired
	ICiudadanoCursoService ciudadanoCursoService;
	@Autowired
	ICiudadanoService ciudadanoService;
	@Autowired
	ICursoService cursoService;

	@GetMapping("/nuevaInscripcion/{id}")
	public String agregarInscripcion(@PathVariable(value = "id") Long id) {

		//modificar cuando se implementa logeo
//		Ciudadano ciudadano = usuario.getUsuario(); 
		Ciudadano ciudadano = ciudadanoService.buscarIdCiudadano(1l);
		CiudadanoCurso ciudadanoCurso = ciudadanoCursoService.nuevoCiudadanoCurso();
//		System.out.println("\n\n "+ciudadano.getId());
		ciudadanoCurso.setCiudadano(ciudadano);
		
		Optional<Curso> curso= cursoService.buscarCurso(id);
		curso.get().setContador(true);
		cursoService.guardarCurso(curso.get());
		ciudadanoCurso.setCurso(curso.get());
		
		ciudadanoCursoService.guardarCiudadanoCurso(ciudadanoCurso);

		return "redirect:/ciudadano/cursos";
	}

}