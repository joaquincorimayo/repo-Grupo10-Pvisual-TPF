package ar.edu.unju.fi.tpf.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.tpf.entity.Ciudadano;
import ar.edu.unju.fi.tpf.entity.CiudadanoOferta;
import ar.edu.unju.fi.tpf.entity.Oferta;
import ar.edu.unju.fi.tpf.entity.Usuario;
import ar.edu.unju.fi.tpf.service.ICiudadanoOfertaService;
import ar.edu.unju.fi.tpf.service.ICiudadanoService;
import ar.edu.unju.fi.tpf.service.IOfertaService;
import ar.edu.unju.fi.tpf.service.IUsuarioService;

/**
 * 
 * @author JoaquinCorimayo
 *
 * @author LuisQuispe
 */

@Controller
@RequestMapping("/postulacion")
public class CiudadanoOfertaController {

	Logger logger = LoggerFactory.getLogger(CiudadanoOfertaController.class);

	@Autowired
	private ICiudadanoOfertaService ciudadanoOfertaService;
	@Autowired
	private ICiudadanoService ciudadanoService;
	@Autowired
	private IOfertaService ofertaService;
	@Autowired
	@Qualifier("UsuarioService")
	private IUsuarioService usuarioService;

	@GetMapping("/nuevaPostulacion/{id}")
	public String agregarPostulacion(@PathVariable(value = "id") Long id, Model model) {
		Usuario usuario = usuarioService.getUsuarioActivo();
		Long idUsuarioActivo = usuario.getIdActivo();
		
		Ciudadano ciudadano = ciudadanoService.buscarIdCiudadano(usuario.getIdActivo());
		if (ciudadano.getCurriculum() == null) {
			model.addAttribute("errorCurriculum", true);
		} else {
		
			CiudadanoOferta ciudadanoOferta = ciudadanoOfertaService.nuevoCiudadanoOferta();
	
			if (ciudadanoOfertaService.verificarPostulacion(idUsuarioActivo, id)) {
				logger.info("Method: /ciudadano/nuevaPostulacion/{id}/ Action: El ciudadano se postulo de forma correcta a curso:");
				Ciudadano ciudadano2 = ciudadanoService.buscarIdCiudadano(idUsuarioActivo);
				ciudadanoOferta.setCiudadano(ciudadano2);
				Oferta oferta = ofertaService.buscarOferta(id);
				ciudadanoOferta.setOferta(oferta);
				ciudadanoOfertaService.guardarCiudadanoOferta(ciudadanoOferta);
				return "redirect:/ciudadano/ofertas";
	
			} else {
				logger.info("Method: /ciudadano/nuevaPostulacion/{id}/ Action: El ciudadano ya se postulo");
				List<Oferta> ofertas = ofertaService.listarOfertas();
				model.addAttribute("ofertas", ofertas);
				model.addAttribute("postulado", true);
				return "ciudadano_lista_ofertas";
			}

		}
		return "ciudadano_lista_ofertas";
	
	}
}
