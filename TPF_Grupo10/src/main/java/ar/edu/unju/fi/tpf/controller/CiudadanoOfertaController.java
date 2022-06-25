package ar.edu.unju.fi.tpf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
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
	ICiudadanoOfertaService ciudadanoOfertaService;
	@Autowired
	ICiudadanoService ciudadanoService;
	@Autowired
	IOfertaService ofertaService;
	@Autowired
	@Qualifier("UsuarioService")
	private IUsuarioService usuarioService;

	@GetMapping("/nuevaPostulacion/{id}")
	public String agregarPostulacion(@PathVariable(value = "id") Long id) {
		CiudadanoOferta ciudadanoOferta = ciudadanoOfertaService.nuevoCiudadanoOferta();
		
		Usuario usuario = usuarioService.getUsuarioActivo();
		Ciudadano ciudadano = ciudadanoService.buscarIdCiudadano(usuario.getIdActivo());
		ciudadanoOferta.setCiudadano(ciudadano);
		
		Oferta oferta = ofertaService.buscarOferta(id);
		ciudadanoOferta.setOferta(oferta);
		
		ciudadanoOfertaService.guardarCiudadanoOferta(ciudadanoOferta);
		
		return "redirect:/ciudadano/ofertas";
	}

}
