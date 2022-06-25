package ar.edu.unju.fi.tpf.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.tpf.entity.Ciudadano;
import ar.edu.unju.fi.tpf.entity.CiudadanoCurso;
import ar.edu.unju.fi.tpf.entity.Curso;
import ar.edu.unju.fi.tpf.entity.Usuario;
import ar.edu.unju.fi.tpf.service.ICiudadanoCursoService;
import ar.edu.unju.fi.tpf.service.ICiudadanoService;
import ar.edu.unju.fi.tpf.service.ICursoService;
import ar.edu.unju.fi.tpf.service.IUsuarioService;

/**
 * 
 * @author JoaquinCorimayo
 *
 * @author LuisQuispe
 */

@Controller
@RequestMapping("/inscripcion")
public class CiudadanoCursoController {

	Logger logger = LoggerFactory.getLogger(CiudadanoCursoController.class);

	@Autowired
	ICiudadanoCursoService ciudadanoCursoService;
	@Autowired
	ICiudadanoService ciudadanoService;
	@Autowired
	ICursoService cursoService;
	@Autowired
	@Qualifier("UsuarioService")
	private IUsuarioService usuarioService;

	@GetMapping("/nuevaInscripcion/{id}")
	public String agregarInscripcion(@PathVariable(value = "id") Long id) {

		CiudadanoCurso ciudadanoCurso = ciudadanoCursoService.nuevoCiudadanoCurso();

		Usuario usuario = usuarioService.getUsuarioActivo();
		Ciudadano ciudadano = ciudadanoService.buscarIdCiudadano(usuario.getIdActivo());
		ciudadanoCurso.setCiudadano(ciudadano);

		Optional<Curso> curso = cursoService.buscarCurso(id);
		curso.get().setContador(true);
		cursoService.guardarCurso(curso.get());
		ciudadanoCurso.setCurso(curso.get());

		ciudadanoCursoService.guardarCiudadanoCurso(ciudadanoCurso);

		return "redirect:/ciudadano/cursos";
	}

}