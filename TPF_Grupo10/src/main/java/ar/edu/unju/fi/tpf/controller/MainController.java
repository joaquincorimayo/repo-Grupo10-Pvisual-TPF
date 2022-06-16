package ar.edu.unju.fi.tpf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Clase que se encargada de tomar las peticiones y controlar que respuesta debe
 * ser presentada en la vista consultada
 * (vistas: buscarPatente - buscarTripulante - buscarVehiculos /.html).
 * 
 * @author JoaquinCorimayo.
 *
 */
@Controller
public class MainController {

	@RequestMapping("/home")
	public String main(Model model) {
		return "index";
	}
	
	@RequestMapping("/ciudadanos")
	public String getFormCiudadano(Model model) {
		return "index"; //
	}
	
	@GetMapping({"/","/login"})
	public String getIngresoPage(Model model) {
		return "login";
	}

}
