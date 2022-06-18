package ar.edu.unju.fi.tpf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Permite manejar-responder a peticiones que recibe para
 * el objeto Empleador
 * 
 * @author JoaquinCorimayo
 *
 */

@Controller
@RequestMapping("/empleador")
public class EmpleadorController {
	
	Logger logger = LoggerFactory.getLogger(EmpleadorController.class);
	
	@RequestMapping("/inicio")
	public String getInicioPage(Model model) {
		return "empleador_inicio";
	}
	
	@RequestMapping("/crear-oferta")
	public String getNuevaOfertaPage(Model model) {
		return "empleador_crear_oferta";
	}
	
	@RequestMapping("/ver-ofertas-creadas")
	public String getListaOfertasPage(Model model) {
		return "empleador_lista_ofertas";
	}
	
	@RequestMapping("/salir")
	public String getLogoutPage(Model model) {
		return "redirect:/inicio";
	}
	
}	
