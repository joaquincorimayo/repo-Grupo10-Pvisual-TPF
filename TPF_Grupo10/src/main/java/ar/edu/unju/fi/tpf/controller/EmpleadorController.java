package ar.edu.unju.fi.tpf.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.tpf.entity.Empleador;
import ar.edu.unju.fi.tpf.entity.Oferta;
import ar.edu.unju.fi.tpf.entity.Usuario;
import ar.edu.unju.fi.tpf.service.IEmpleadorService;
import ar.edu.unju.fi.tpf.service.IOfertaService;
import ar.edu.unju.fi.tpf.service.IUsuarioService;

/**
 * Permite manejar-responder a peticiones que recibe para el objeto Empleador
 * 
 * @author JoaquinCorimayo
 */

@Controller
@RequestMapping("/empleador")
public class EmpleadorController {

	Logger logger = LoggerFactory.getLogger(EmpleadorController.class);

	@Autowired
	@Qualifier("EmpleadorService")
	private IEmpleadorService empleadorService;

	@Autowired
	@Qualifier("OfertaService")
	private IOfertaService ofertaService;

	@Autowired
	@Qualifier("UsuarioService")
	private IUsuarioService usuarioService;

	@GetMapping("/inicio")
	public String getInicioPage(Model model) {
		Usuario usuario = usuarioService.getUsuarioActivo();
		model.addAttribute("usuario", usuario.getUsername());
		return "empleador_inicio";
	}

	@GetMapping("/crear-oferta")
	public String getNuevaOfertaPage(Model model) {
		Oferta oferta = new Oferta();
		model.addAttribute("oferta", oferta);
		return "empleador_crear_oferta";
	}

	@GetMapping("/ver-ofertas-creadas")
	public String getListaOfertasPage(Model model) {
		List<Oferta> ofertas = ofertaService.listarOfertas();
		model.addAttribute("ofertas", ofertas);
		return "empleador_lista_ofertas";
	}

	@GetMapping("/salir")
	public String getLogoutPage(Model model) {
		Usuario usuario = usuarioService.getUsuarioActivo();
		usuarioService.cambiarEstado(usuario);
		return "redirect:/inicio";
	}

	@PostMapping("/guardar")
	public String guardarEmpleadorPage(@ModelAttribute("empleador") Empleador empleador) {
		try {
			empleadorService.guardarEmpleador(empleador);
		} catch (Exception e) {
			System.out.println("Error en: /empleador/guardar");
		}
		return "redirect:/inicio";
	}

}
