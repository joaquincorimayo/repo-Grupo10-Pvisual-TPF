package ar.edu.unju.fi.tpf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.tpf.service.IUsuarioService;
import ar.edu.unju.fi.tpf.util.ListaProvincias;
import ar.edu.unju.fi.tpf.util.ListaEstadoCivil;

/**
 * Clase que se encarga de tomar las peticiones y controlar que respuesta debe
 * ser presentada en la vista consultada
 * 
 * @author JoaquinCorimayo.
 * @author LuisQuispe
 */

@Controller
public class IndexController {
	Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	ListaEstadoCivil estadoCivil;

	@Autowired
	ListaProvincias provincias;
	
	@Autowired
	@Qualifier("UsuarioService")
	IUsuarioService usuarioService;

	@GetMapping("/inicio")
	public String getInicioPage(Model model) {
		usuarioService.cerrarSesionesError();
		return "index";
	}

	@GetMapping("/nuevo-registro")
	public String getFormularioRegistroPage(Model model) {
		return "index_nuevo_registro";
	}

	@GetMapping("/login")
	public String getLoginPageTest(Model model) {
		return "login";
	}

}
