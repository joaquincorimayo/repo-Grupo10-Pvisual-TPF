package ar.edu.unju.fi.tpf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Permite manejar-responder a peticiones que recibe para
 * el objeto ciudadano
 * 
 * @author JoaquinCorimayo
 *
 */

@Controller
@RequestMapping("/ciudadano")
public class CiudadanoController {
	
	Logger logger = LoggerFactory.getLogger(CiudadanoController.class);
	
	@RequestMapping("/inicio")
	public String getInicioPage(Model model) {
		return "ciudadano_inicio";
	}
	
	@RequestMapping("/crear-cv")
	public String getNuevoCVPage(Model model) {
		return "ciudadano_crear_cv";
	}
	@RequestMapping("/ver-cv")
	public String getCVPage(Model model) {
		return "ciudadano_ver_cv";
	}
	@RequestMapping("/cursos")
	public String getListaCursosPage(Model model) {
		return "ciudadano_lista_cursos";
	}
	@RequestMapping("/ofertas")
	public String getListaOfertasPage(Model model) {
		return "ciudadano_lista_ofertas";
	}
	@RequestMapping("/salir")
	public String getLogoutPage(Model model) {
		return "redirect:/inicio";
	}
	
}
