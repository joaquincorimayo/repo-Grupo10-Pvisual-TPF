package ar.edu.unju.fi.tpf.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.tpf.entity.Ciudadano;
import ar.edu.unju.fi.tpf.entity.Curriculum;
import ar.edu.unju.fi.tpf.entity.Oferta;
import ar.edu.unju.fi.tpf.entity.Curso;
import ar.edu.unju.fi.tpf.repositorty.ICiudadanoRepository;

import ar.edu.unju.fi.tpf.service.IOfertaService;
import ar.edu.unju.fi.tpf.service.ICiudadanoService;
import ar.edu.unju.fi.tpf.service.ICurriculumService;
import ar.edu.unju.fi.tpf.service.ICursoService;
import ar.edu.unju.fi.tpf.util.ListaConocimientosInformaticos;

/**
 * Permite manejar-responder a peticiones que recibe para
 * el objeto ciudadano
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
	ListaConocimientosInformaticos conInf;
	@Autowired
	private ICiudadanoRepository ciudadanoRepository;
	@Autowired
	private ICursoService cursoService; 
	
	@PostMapping("/guardar")
	public String guardarCiudadanoPage(@ModelAttribute("ciudadano") Ciudadano ciudadano) {
		try {
			ciudadanoService.guardarCiudadano(ciudadano);
		}catch (Exception e) {
			System.out.println("Error");
		}
		return "redirect:/inicio";
	}
	
	@RequestMapping("/editar")
	public String getEditarPage(Model model) {
		return "ciudadano_formulario_editar";
	}
	
	//DESACTIVADO HASTA SOLUCIONAR PROBLEMA DE LOGIN
//	@GetMapping("/editar/{dni}")
//	public ModelAndView getEditarCiudadanoPage(@PathVariable(value="dni") String dni) {
//		ModelAndView mav=new ModelAndView("ciudadano_formulario_editar");
//		mav.addObject("ciudadano", ciudadanoService.buscarCiudadano(dni));
//		return mav;
//	}
	
//	@PostMapping("/modificar")
//	public ModelAndView editarDatosCiudadano(@Validated @ModelAttribute("ciudadano") Ciudadano ciudadano,
//			BindingResult bindingResult) {
//		if(bindingResult.hasErrors()) {
//			logger.info("Error al editar ciudadano");
//			ModelAndView mav= new ModelAndView("ciudadano_formulario_editar");
//			mav.addObject("ciudadano", ciudadano);
//			return mav;
//		}
//		ModelAndView mav=new ModelAndView("redirect:/ciudadano");
//		ciudadanoService.modificarCiudadano(ciudadano);
//		return mav;
//	}
	
//	@GetMapping("/eliminar/{dni}")
//	public ModelAndView getEliminarAlumno(@PathVariable(value="dni")String dni) {
//		ModelAndView mav=new ModelAndView("redirect:/ciudadano/inicio");
//		ciudadanoService.eliminarCiudadano(dni);
//		return mav;
//	}
	
	@GetMapping("/inicio")
	public String getInicioPage(Model model) {
		return "ciudadano_inicio";
	}
	
	@GetMapping("/crear-cv")
	public String getNuevoCVPage(Model model){
//		Long idCiudadano = usuario.getId();
		// cambiar "1l" por el usuario actual
		Ciudadano ciudadano= ciudadanoService.buscarIdCiudadano(1l);
		model.addAttribute("ciudadano", ciudadano);
		Curriculum curriculum =new Curriculum();
		model.addAttribute("conInf", conInf.getConoInf());
		model.addAttribute("curriculum", curriculum);
		return "ciudadano_crear_cv";
	}

	@GetMapping("/ver-cv")
	public String getCVPage(Model model) {
//		Long idCiudadano = usuario.getId();
		List<Curriculum> curriculum = curriculumService.getListaCurriculum();
		Curriculum curenviar = new Curriculum();
		for (Curriculum curriculumc : curriculum) {
			// cambiar "1l" por el usuario actual (idciudadano)
			if(curriculumc.getCiudadano().getId()==1l) {
				curenviar = curriculumc;
			}
		}
		
		Curso curso1 = new Curso(1l, "cc", "cc", LocalDate.of(2022, 1, 1), LocalDate.of(2022, 3, 1), "cc", "ccc", "ccc", false);
		cursoService.guardarCurso(curso1);
		Curso curso2 = new Curso(2l, "dd", "dd", LocalDate.of(2022, 2, 2), LocalDate.of(2022, 3, 2), "dd", "ddd", "ddd", false);
		cursoService.guardarCurso(curso2);
		Curso curso3 = new Curso(3l, "ee", "ee", LocalDate.of(2022, 3, 3), LocalDate.of(2022, 4, 3), "ee", "eee", "eee", false);
		cursoService.guardarCurso(curso3);
		
		model.addAttribute("curriculum", curenviar);
		return "ciudadano_ver_cv";
	}
		
	@GetMapping("/cursos")
	public String getListaCursosPage(Model model) {
//		Curso curso1 = new Curso(1l, "cc", "cc", LocalDate.of(2022, 1, 1), LocalDate.of(2022, 3, 1), "cc", "ccc", "ccc");
//		cursoService.guardarCurso(curso1);
//		Curso curso2 = new Curso(2l, "dd", "dd", LocalDate.of(2022, 2, 2), LocalDate.of(2022, 3, 2), "dd", "ddd", "ddd");
//		cursoService.guardarCurso(curso2);
//		Curso curso3 = new Curso(3l, "ee", "ee", LocalDate.of(2022, 3, 3), LocalDate.of(2022, 4, 3), "ee", "eee", "eee");
//		cursoService.guardarCurso(curso3);
		
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
	
	@RequestMapping("/salir")
	public String getLogoutPage(Model model) {
		return "redirect:/inicio";
	}
}
