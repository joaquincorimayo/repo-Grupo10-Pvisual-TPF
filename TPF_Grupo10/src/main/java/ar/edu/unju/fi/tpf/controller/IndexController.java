package ar.edu.unju.fi.tpf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Clase que se encargada de tomar las peticiones y controlar que respuesta debe
 * ser presentada en la vista consultada
 * 
 * @author JoaquinCorimayo.
 *
 */

@Controller
public class IndexController {

	@RequestMapping("/inicio")
	public String getInicioPage(Model model) {
		return "index";
	}

	@RequestMapping("/nuevo-registro")
	public String getFormularioRegistroPage(Model model) {
		return "index_nuevo_registro";
	}

	@PostMapping("/nuevo-registro/tipo-registro")
	public String getTipoFormularioPage(@ModelAttribute("userType") String tipoRegistro) {
		if (tipoRegistro.equals("ciudadano")) {
			return "ciudadano_formulario";
		} else {
			return "empleador_formulario";
		}
	}

	@RequestMapping("/iniciar-sesion")
	public String getInicioSesionPage(Model model) {
		return "index_iniciar_sesion";
	}

	@PostMapping("/iniciar-sesion/tipo-usuario")
	public String getTipoLoginPage(@ModelAttribute("userTypeLogin") String tipoRegistro) {
		if (tipoRegistro.equals("ciudadano")) {
			return "redirect:/ciudadano/inicio";
		} else {
			return "redirect:/empleador/inicio";
		}
	}
}
