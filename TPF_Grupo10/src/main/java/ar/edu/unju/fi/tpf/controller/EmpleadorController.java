package ar.edu.unju.fi.tpf.controller;

import java.util.List;

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

import ar.edu.unju.fi.tpf.entity.Ciudadano;
import ar.edu.unju.fi.tpf.entity.CiudadanoOferta;
import ar.edu.unju.fi.tpf.entity.Empleador;
import ar.edu.unju.fi.tpf.entity.Oferta;
import ar.edu.unju.fi.tpf.entity.Usuario;
import ar.edu.unju.fi.tpf.service.ICiudadanoOfertaService;
import ar.edu.unju.fi.tpf.service.ICiudadanoService;
import ar.edu.unju.fi.tpf.service.IEmpleadorService;
import ar.edu.unju.fi.tpf.service.IOfertaService;
import ar.edu.unju.fi.tpf.service.IUsuarioService;
import ar.edu.unju.fi.tpf.util.ListaClaves;
import ar.edu.unju.fi.tpf.util.ListaProvincias;

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

	@Autowired
	private ICiudadanoService ciudadanoService;

	@Autowired
	private ListaProvincias provincias;
	@Autowired
	private ListaClaves palabrasClaves;
	@Autowired
	private ICiudadanoOfertaService ciudadanoOfertaService;

	@GetMapping("/inicio")
	public String getInicioPage(Model model) {
		logger.info("Method: /empleador/inicio/ Action: Se visualiza el usuario actual");
		Usuario usuario = usuarioService.getUsuarioActivo();
		model.addAttribute("usuario", usuario.getUsername());
		return "empleador_inicio";
	}

	@GetMapping("/crear-oferta")
	public String getNuevaOfertaPage(Model model) {
		logger.info("Method: /empleador/oferta/ Action: Se envia un objeto de tipo oferta");
		Oferta oferta = new Oferta();
		model.addAttribute("oferta", oferta);
		return "empleador_crear_oferta";
	}

	@GetMapping("/ver-ofertas-creadas")
	public String getListaOfertasPage(Model model) {
		logger.info("Method: /empleador/ver-ofertas-creadas/ Action: Se visualiza la lista de ofertas del usuario actual");
		Usuario usuario = usuarioService.getUsuarioActivo();
		List<Oferta> ofertas = ofertaService.listarOfertasId(usuario.getIdActivo());
		model.addAttribute("ofertas", ofertas);
		List<Ciudadano> perfiles = ciudadanoService.getListaCiudadano();
		model.addAttribute("perfiles", perfiles);
		model.addAttribute("provincias", provincias.getProvincias());
		model.addAttribute("claves", palabrasClaves.getClaves());
		return "empleador_lista_ofertas";
	}

	@GetMapping("/salir")
	public String getLogoutPage(Model model) {
		logger.info("Method: /empleador/salir/ Action: Deslogeo de usuario empleador");
		Usuario usuario = usuarioService.getUsuarioActivo();
		usuarioService.cambiarEstado(usuario);
		return "redirect:/inicio";
	}

	@GetMapping("/nuevo")
	public String getNuevoEmpleadorPage(Model model) {
		logger.info("Method: /empleador/nuevo/ Action: Se envia un objeto empleador nuevo");
		Empleador empleador = new Empleador();
		model.addAttribute("empleador", empleador);
		model.addAttribute("provincias", provincias.getProvincias());
		return "empleador_formulario";
	}

	@PostMapping("/guardar")
	public String guardarEmpleadorPage(@Validated @ModelAttribute("empleador") Empleador empleador, BindingResult br,
			Model model) {
		
		if (br.hasErrors()) {
			logger.info("Method: /empleador/guardar/ | Error: Validacion | Action: Erro en ingreso de datos para empleador");
			model.addAttribute("empleador", empleador);
			model.addAttribute("provincias", provincias.getProvincias());
			return "empleador_formulario";
		}

		try {
			logger.info("Method: /empleador/guardar/ Action: Se almacena al nuevo empleador");
			empleadorService.guardarEmpleador(empleador);
		} catch (Exception e) {
			logger.info("Method: /empleador/guardar/ | Error: No se pudo almacenar al empleador ");
		}
		return "redirect:/inicio";
	}

	@GetMapping("/contratar/{usu}/oferta/{ofe}")
	public String contratarCiudadano(@PathVariable(value = "usu") Long idn, @PathVariable(value = "ofe") Long ido,
			Model model) {
		CiudadanoOferta ciudadanoOferta = ciudadanoOfertaService.nuevoCiudadanoOferta();
		Oferta oferta = ofertaService.buscarOferta(ido);
		if (ciudadanoOfertaService.verificarPostulacion(idn, ido) && !oferta.getCantidadVacantes().equals("0")) {
			logger.info("Method: /empleador/contratar-oferta/ | Action: Se contrata al usuario con id: " + idn + " En la oferta: "+ ido);
			Ciudadano ciudadano = ciudadanoService.buscarIdCiudadano(idn);
			ciudadanoOferta.setCiudadano(ciudadano);
			int restar = Integer.parseInt(oferta.getCantidadVacantes());
			restar--;
			oferta.setCantidadVacantes(String.valueOf(restar));
			ofertaService.actualizarOferta(oferta);
			ciudadanoOferta.setOferta(oferta);
			ciudadanoOfertaService.guardarCiudadanoOferta(ciudadanoOferta);
			return "redirect:/empleador/ver-ofertas-creadas";

		} else {
			logger.info("Method: /empleador/contratar-oferta/ | Error: se alcanzo el minimo de postulantes o ya se lo contrato");

			Usuario usuario = usuarioService.getUsuarioActivo();
			List<Oferta> ofertas = ofertaService.listarOfertasId(usuario.getIdActivo());
			model.addAttribute("ofertas", ofertas);
			List<Ciudadano> perfiles = ciudadanoService.getListaCiudadano();
			model.addAttribute("perfiles", perfiles);
			model.addAttribute("provincias", provincias.getProvincias());
			model.addAttribute("claves", palabrasClaves.getClaves());
			model.addAttribute("postulado", true);
			model.addAttribute("vacio", true);
			return "empleador_lista_ofertas";
		}
	}

	@GetMapping("/vercv/{id}")
	public String verDatosCv(@PathVariable(value = "id") Long id, Model model) {

		Ciudadano ciudadano = ciudadanoService.buscarIdCiudadano(id);
		if (ciudadano.getCurriculum() == null) {
			logger.info("Method: /empleador/vercv/{id} Action: El usuario no tiene cv");

			model.addAttribute("errorCurriculum", true);
		} else {
			logger.info("Method: /empleador/vercv/{id} Action: Se visualiza el cv de un usuario particular");

			model.addAttribute("curriculum", ciudadano.getCurriculum());
		}
		return "empleador_ver_cvs";
	}

	@GetMapping("/provincia/{provincia}/clave/{clave}")
	public String filtrarUsuarios(@PathVariable(value = "provincia") String provincia,
			@PathVariable(value = "clave") String clave, Model model) {
		logger.info("Method: /empleador/provincia/{provincia}/clave/{clave} Action: filtro de candidatos");
		Usuario usuario = usuarioService.getUsuarioActivo();
		List<Oferta> ofertas = ofertaService.listarOfertasId(usuario.getIdActivo());
		model.addAttribute("ofertas", ofertas);

		List<Ciudadano> perfiles = ciudadanoService.getListaCiudadanoProvincia(provincia);
		model.addAttribute("perfiles", perfiles);
		model.addAttribute("provincias", provincias.getProvincias());
		model.addAttribute("claves", palabrasClaves.getClaves());
		return "empleador_lista_ofertas";
	}
}
