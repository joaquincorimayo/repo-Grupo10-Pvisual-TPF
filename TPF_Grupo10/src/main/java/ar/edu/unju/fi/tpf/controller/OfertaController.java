package ar.edu.unju.fi.tpf.controller;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.tpf.entity.Empleador;
import ar.edu.unju.fi.tpf.entity.Oferta;
import ar.edu.unju.fi.tpf.entity.Usuario;
import ar.edu.unju.fi.tpf.service.IEmpleadorService;
import ar.edu.unju.fi.tpf.service.IOfertaService;
import ar.edu.unju.fi.tpf.service.IUsuarioService;
import ar.edu.unju.fi.tpf.util.ListaClaves;
import ar.edu.unju.fi.tpf.util.ListaDisponibilidad;
import ar.edu.unju.fi.tpf.util.ListaJornada;
import ar.edu.unju.fi.tpf.util.ListaModalidad;
import ar.edu.unju.fi.tpf.util.ListaTareas;

/**
 * Clase controladora de Ofertas
 * 
 * @author JoaquinCorimayo.
 * 
 * @author LuisQuispe
 */

@Controller
@RequestMapping("/oferta")
public class OfertaController {

	Logger logger = LoggerFactory.getLogger(OfertaController.class);

	@Autowired
	@Qualifier("OfertaService")
	private IOfertaService ofertaService;
	@Autowired
	@Qualifier("UsuarioService")
	private IUsuarioService usuarioService;
	@Autowired
	@Qualifier("EmpleadorService")
	private IEmpleadorService empleadorService;
	@Autowired
	private ListaClaves palabrasClaves;
	@Autowired
	private ListaTareas listaTareas;
	@Autowired
	private ListaJornada listaJornada;
	@Autowired
	private ListaDisponibilidad listaDisponibilidad;
	@Autowired
	private ListaModalidad listaModalidad;

	@PostMapping("/guardar")
	public String guardarOfertaNueva(@Validated @ModelAttribute("oferta") Oferta oferta, BindingResult br,
			Model model) {

		if (br.hasErrors()) {
			model.addAttribute("oferta", oferta);
			model.addAttribute("claves", palabrasClaves.getClaves());
			model.addAttribute("tareas", listaTareas.getTareas());
			model.addAttribute("jornadas", listaJornada.getJornada());
			model.addAttribute("disponiblidades", listaDisponibilidad.getDisponibilidad());
			model.addAttribute("modalidades", listaModalidad.getModalidad());
			return "empleador_crear_oferta";
		}

		try {
			Usuario usuario = usuarioService.getUsuarioActivo();
			Empleador empleador = empleadorService.buscarEmpleador(usuario.getIdActivo());
			oferta.setEmpleador(empleador);
			ofertaService.guardarOferta(oferta);
		} catch (Exception e) {
			System.out.println("Error en: /oferta/guardar");
		}

		return "redirect:/empleador/inicio";
	}

	@GetMapping("/editar/{id}")
	public String getEditarOfertaPage(@PathVariable(value = "id") Long id, Model model) {
		Oferta oferta = ofertaService.buscarOferta(id);
		model.addAttribute("oferta", oferta);
		return "empleador_editar_oferta";
	}

	@PostMapping("/modificar")
	public String editarOferta(@Validated @ModelAttribute("oferta") Oferta oferta, BindingResult br, Model model) {
		if (br.hasErrors()) {
			System.out.println("error en /oferta/guardar -> "+ br.getAllErrors());
			model.addAttribute("oferta", oferta);
			return "empleador_editar_oferta";
		}
		ofertaService.actualizarOferta(oferta);
		return "redirect:/empleador/ver-ofertas-creadas";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarOferta(@PathVariable(value = "id") Long id) {
		ofertaService.borrarOferta(id);
		return "redirect:/empleador/ver-ofertas-creadas";
	}

}
