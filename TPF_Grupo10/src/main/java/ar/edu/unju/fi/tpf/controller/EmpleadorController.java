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
import ar.edu.unju.fi.tpf.service.IEmpleadorService;
import ar.edu.unju.fi.tpf.service.IOfertaService;

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

	@GetMapping("/login-empleador")
	public String getLoginPage(Model model) {
		Empleador empleadorNuevo = empleadorService.crearEmpleador();
		model.addAttribute("empleador", empleadorNuevo);
		return "empleador_login";
	}
	
	@PostMapping("/login-empleador-login")
	public String verificarEmpleadoLogeado(@ModelAttribute("empleador") Empleador empleador) {
		// if-else (VERIFICAR DNI - PASSWORD) V->Entrar /empleador/inicio F->/iniciar-sesion
		return "redirect:/iniciar-sesion";
	}
	
	@GetMapping("/inicio")
	public String getInicioPage(Model model) {
		return "empleador_inicio";
	}

	@PostMapping("/guardar")
	public String guardarEmpleadorPage(@ModelAttribute("empleador") Empleador empleador) {
		System.out.println("Datos ingresados para empleador: " + empleador.toString());
		// Error de validacion / reenviar

		// try-catch: guardar / reenviar
		try {
			empleadorService.guardarEmpleador(empleador);
		} catch (Exception e) {
			System.out.println("Error");
		}

		return "redirect:/inicio";
	}

	@GetMapping("/crear-oferta")
	public String getNuevaOfertaPage(Model model) {
		Oferta oferta = new Oferta();
		model.addAttribute("oferta", oferta);
		
//		Oferta test_ofe_1 = new Oferta(1l, "12", "disponibilidadHoraria1", "puestoRequerido1", "principalesTareas1",
//				"resumen1", "datosContacto1", "jornada1", "requisitos1", "beneficios1", "disponibilidad1", "1", true);
//		ofertaService.guardarOferta(test_ofe_1);
//		Oferta test_ofe_2 = new Oferta(2l, "13",
//				"disponibilidadHoraria2", "puestoRequerido2", "principalesTareas2",
//				"resumen2", "datosContacto2", "jornada2", "requisitos1", "beneficios2", "disponibilidad2", "2", true);
//		ofertaService.guardarOferta(test_ofe_2);
//		Oferta test_ofe_3 = new Oferta(3l, "14", "disponibilidadHoraria3", "puestoRequerido3", "principalesTareas3",
//				"resumen3", "datosContacto3", "jornada3", "requisitos3", "beneficios3", "disponibilidad3", "3", true);
//		ofertaService.guardarOferta(test_ofe_3);
//		Oferta test_ofe_4 = new Oferta(4l, "15", "disponibilidadHoraria4", "puestoRequerido4", "principalesTareas4",
//				"resumen4", "datosContacto4", "jornada4", "requisitos4", "beneficios4", "disponibilidad4", "4", true);
//		ofertaService.guardarOferta(test_ofe_4);
//		Oferta test_ofe_5 = new Oferta(5l, "16", "disponibilidadHoraria5", "puestoRequerido5", "principalesTareas5",
//				"resumen5", "datosContacto5", "jornada5", "requisitos5", "beneficios5", "disponibilidad5", "5", true);
//		ofertaService.guardarOferta(test_ofe_5);
//		Oferta test_ofe_6 = new Oferta(6l, "17", "disponibilidadHoraria6", "puestoRequerido6", "principalesTareas6",
//				"resumen6", "datosContacto6", "jornada6", "requisitos6", "beneficios6", "disponibilidad6", "6", true);
//		ofertaService.guardarOferta(test_ofe_6);
		
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
		return "redirect:/inicio";
	}

}
