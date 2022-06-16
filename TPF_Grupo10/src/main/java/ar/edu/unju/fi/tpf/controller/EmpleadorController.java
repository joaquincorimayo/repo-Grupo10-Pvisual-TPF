package ar.edu.unju.fi.tpf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
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
	
	
}	
