package ar.edu.unju.fi.tpf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.tpf.entity.CiudadanoOferta;
import ar.edu.unju.fi.tpf.service.ICiudadanoOfertaService;
import ar.edu.unju.fi.tpf.service.ICiudadanoService;
import ar.edu.unju.fi.tpf.service.IOfertaService;

/**
 * 
 * @author JoaquinCorimayo
 *
 */

@Controller
@RequestMapping("/inscripcion")
public class CiudadanoOfertaController {

	Logger logger = LoggerFactory.getLogger(CiudadanoOfertaController.class);

	@Autowired
	ICiudadanoOfertaService ciudadanoOfertaService;
	@Autowired
	ICiudadanoService ciudadanoService;
	@Autowired
	IOfertaService ofertaService;

	@GetMapping("/nuevaInscripcion/{id}")
	public String agregarInscripcion(@PathVariable(value = "id") Long id) {
		// 
		return "";
	}

	@PostMapping("/guardarInscripcion")
	public String guardarInscripcion(@ModelAttribute("unaInscripcion") CiudadanoOferta ciudadanoOferta) {
		return "";
	}

}
