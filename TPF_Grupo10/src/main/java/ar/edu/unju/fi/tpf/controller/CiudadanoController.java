package ar.edu.unju.fi.tpf.controller;

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
import ar.edu.unju.fi.tpf.service.ICiudadanoService;
import ar.edu.unju.fi.tpf.service.IOfertaService;

//import ar.edu.unju.fi.tpf.entity.Curriculum;
//import ar.edu.unju.fi.tpf.service.ICurriculumService;


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
		
//	@PostMapping("/guardar")
//	public ModelAndView guardarCiudadanoPage(@Validated @ModelAttribute("ciudadano") Ciudadano ciudadano,
//			BindingResult bindingResult) {
//		if (bindingResult.hasErrors()) {
//			logger.info("Method: guardarCiudadanoPage() - Information: Error en ingreso de datos para Ciudadano.");
//			ModelAndView mav=new ModelAndView("ciudadano_formulario");
//			mav.addObject("ciudadano", ciudadano);
//		}
//		ModelAndView mav=new ModelAndView("redirect:/ciudadano");
//		if(ciudadanoService.guardarCiudadano(ciudadano)) {
//			logger.info("Se agrego ciudadano");
//		}
//		return mav;
//	}
	
	//Guardado Provisorio
	@PostMapping("/guardar")
	public String guardarCiudadanoPage(@ModelAttribute("ciudadano") Ciudadano ciudadano) {
		try {
			ciudadanoService.guardarCiudadano(ciudadano);
		}catch (Exception e) {
			System.out.println("Error");
		}
		return "redirect:/inicio";
	}
	
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
//	
	@RequestMapping("/inicio")
	public String getInicioPage(Model model) {
		return "ciudadano_inicio";
	}
	
	@GetMapping("/crear-cv")
	public String getNuevoCVPage(Model model){
		Curriculum curriculum =new Curriculum();
//		model.addAttribute("ciudadano", ciudadanoService.getCiudadano());
		model.addAttribute("curriculum", curriculum);
		return "ciudadano_crear_cv";
	}
	
	@GetMapping("/ver-cv")
	public String getCVPage(Model model) {
	//	model.addAttribute("curriculum", curriculumService.leerCurriculum());
		return "ciudadano_ver_cv";
	}
		
	@GetMapping("/cursos")
	public String getListaCursosPage(Model model) {
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

