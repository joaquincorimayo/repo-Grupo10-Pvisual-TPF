package ar.edu.unju.fi.tpf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.tpf.entity.Oferta;
import ar.edu.unju.fi.tpf.service.IOfertaService;

/**
 * Clase controladora de Ofertas
 * 
 * @author JoaquinCorimayo.
 */

@Controller
@RequestMapping("/oferta")
public class OfertaController {
	Logger logger = LoggerFactory.getLogger(OfertaController.class);
	@Autowired
	@Qualifier("OfertaService")
	private IOfertaService ofertaService;

	@PostMapping("/guardar")
	public String guardarOfertaNueva(@ModelAttribute("oferta") Oferta oferta) {
		// validacion
		// try-catch
		try {
			ofertaService.guardarOferta(oferta);
		} catch (Exception e) {
			System.out.println("error");
		}

		return "redirect:/empleador/inicio";
	}
	
	@GetMapping("/editar/{id}")
	public String getEditarOfertaPage(@PathVariable(value = "id") Long id, Model model) {
		// Validacion
		Oferta oferta = ofertaService.buscarOferta(id);
		model.addAttribute("oferta", oferta);
		return "empleador_editar_oferta";
	}
	
	@PostMapping("/modificar")
	public String editarOferta(@ModelAttribute("oferta") Oferta oferta) {
		// VALIDACION
		// modificacion
//		Oferta Modif = ofertaService.buscarOferta(oferta.getId());
//		ofertaService.actualizarOferta(Modif);
		ofertaService.actualizarOferta(oferta);
		return "redirect:/empleador/ver-ofertas-creadas";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarOferta(@PathVariable(value = "id") Long id) {
		ofertaService.borrarOferta(id);
		return "redirect:/empleador/ver-ofertas-creadas";
	}

}
