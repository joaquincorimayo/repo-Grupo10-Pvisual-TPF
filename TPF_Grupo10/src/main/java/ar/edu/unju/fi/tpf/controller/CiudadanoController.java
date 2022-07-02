package ar.edu.unju.fi.tpf.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.tpf.entity.Ciudadano;
import ar.edu.unju.fi.tpf.entity.Curriculum;
import ar.edu.unju.fi.tpf.entity.Oferta;
import ar.edu.unju.fi.tpf.entity.Usuario;
import ar.edu.unju.fi.tpf.entity.Curso;

import ar.edu.unju.fi.tpf.service.IOfertaService;
import ar.edu.unju.fi.tpf.service.IUsuarioService;
import ar.edu.unju.fi.tpf.service.ICiudadanoService;
import ar.edu.unju.fi.tpf.service.ICurriculumService;
import ar.edu.unju.fi.tpf.service.ICursoService;
import ar.edu.unju.fi.tpf.util.ListaConocimientosInformaticos;
import ar.edu.unju.fi.tpf.util.ListaEstadoCivil;
import ar.edu.unju.fi.tpf.util.ListaProvincias;

/**
 * Permite manejar-responder a peticiones que recibe para el objeto ciudadano
 * 
 * @author JoaquinCorimayo
 *
 * @author LuisQuispe
 */

@Controller
@RequestMapping("/ciudadano")
public class CiudadanoController {

	Logger logger = LoggerFactory.getLogger(CiudadanoController.class);

	@Autowired
	private ICiudadanoService ciudadanoService;
	@Autowired
	private IOfertaService ofertaService;
	@Autowired
	private ICurriculumService curriculumService;
	@Autowired
	private ListaConocimientosInformaticos conInf;
	@Autowired
	private ICursoService cursoService;
	@Autowired
	@Qualifier("UsuarioService")
	private IUsuarioService usuarioService;
	@Autowired
	private ListaEstadoCivil estadoCivil;
	@Autowired
	private ListaProvincias provincias;

	@GetMapping("/inicio")
	public String getInicioPage(Model model) {
		Usuario usuario = usuarioService.getUsuarioActivo();
		model.addAttribute("usuario", usuario.getUsername());
		return "ciudadano_inicio";
	}

	@GetMapping("/editar")
	public String getEditarPage(Model model) {
		return "ciudadano_formulario_editar";
	}

	@GetMapping("/crear-cv")
	public String getNuevoCVPage(Model model) {
		Usuario usuario = usuarioService.getUsuarioActivo();
		Ciudadano ciudadano = ciudadanoService.buscarIdCiudadano(usuario.getIdActivo());
		if (ciudadano.getCurriculum() != null) {
			model.addAttribute("creado", true);
			return "ciudadano_crear_cv";
		} else {
			model.addAttribute("ciudadano", ciudadano);
			Curriculum curriculum = new Curriculum();
			model.addAttribute("conInf", conInf.getConoInf());
			model.addAttribute("curriculum", curriculum);
			return "ciudadano_crear_cv";
		}
	}

	@GetMapping("/ver-cv")
	public String getCVPage(Model model) {
		Usuario usuario = usuarioService.getUsuarioActivo();
		List<Curriculum> curriculum = curriculumService.getListaCurriculum();
		Curriculum curenviar = new Curriculum();
		for (Curriculum curriculumc : curriculum) {
			if (curriculumc.getCiudadano().getId() == usuario.getIdActivo()) {
				curenviar = curriculumc;
			}
		}

		Curso curso1 = new Curso(1l, "categoria1", "titulo1", LocalDate.of(2022, 1, 1), LocalDate.of(2022, 3, 1),
				"modalidad1", "detalles1", "docente1", false);
		cursoService.guardarCurso(curso1);
		Curso curso2 = new Curso(2l, "categoria2", "titulo2", LocalDate.of(2022, 2, 2), LocalDate.of(2022, 3, 2),
				"modalidad2", "detalles2", "docente2", false);
		cursoService.guardarCurso(curso2);
		Curso curso3 = new Curso(3l, "categoria3", "titulo3", LocalDate.of(2022, 3, 3), LocalDate.of(2022, 4, 3),
				"modalidad3", "detalles3", "docente3", false);
		cursoService.guardarCurso(curso3);

		model.addAttribute("curriculum", curenviar);
		return "ciudadano_ver_cv";
	}

	@GetMapping("/cursos")
	public String getListaCursosPage(Model model) {
		List<Curso> cursos = cursoService.listarCursos();
		model.addAttribute("cursos", cursos);
		return "ciudadano_lista_cursos";
	}

	@GetMapping("/ofertas")
	public String getListaOfertasPage(Model model) {
		List<Oferta> ofertas = ofertaService.listarOfertas();
		model.addAttribute("ofertas", ofertas);
		return "ciudadano_lista_ofertas";
	}

	@GetMapping("/salir")
	public String getLogoutPage(Model model) {
		Usuario usuario = usuarioService.getUsuarioActivo();
		usuarioService.cambiarEstado(usuario);
		return "redirect:/inicio";
	}

	@GetMapping("/nuevo")
	public String getNuevoCiudadanoPage(Model model) {
		Ciudadano ciudadano = new Ciudadano();
		model.addAttribute("ciudadano", ciudadano);
		model.addAttribute("estadoCivil", estadoCivil.getEstadoCivil());
		model.addAttribute("provincias", provincias.getProvincias());
		return "ciudadano_formulario";
	}

	@PostMapping("/guardar")
	public String guardarCiudadanoPage(@Validated @ModelAttribute("ciudadano") Ciudadano ciudadano, BindingResult br,
			Model model) {

		if (br.hasErrors() || ciudadano.obtenerEdad() < 18) {
			model.addAttribute("ciudadano", ciudadano);
			model.addAttribute("estadoCivil", estadoCivil.getEstadoCivil());
			model.addAttribute("provincias", provincias.getProvincias());
			model.addAttribute("errorEdad", true);
			return "ciudadano_formulario";
		}

		try {
			ciudadanoService.guardarCiudadano(ciudadano);
		} catch (Exception e) {
			System.out.println("Error en: /ciudadano/guardar");
		}
		return "redirect:/inicio";
	}
}
