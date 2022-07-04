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

import ar.edu.unju.fi.tpf.entity.Ciudadano;
import ar.edu.unju.fi.tpf.entity.Curriculum;
import ar.edu.unju.fi.tpf.entity.Usuario;
import ar.edu.unju.fi.tpf.service.ICiudadanoService;
import ar.edu.unju.fi.tpf.service.ICurriculumService;
import ar.edu.unju.fi.tpf.service.IUsuarioService;
import ar.edu.unju.fi.tpf.util.ListaClaves;
import ar.edu.unju.fi.tpf.util.ListaIdiomas;

@Controller
@RequestMapping("/curriculum")
public class CurriculumController {

	Logger logger = LoggerFactory.getLogger(CurriculumController.class);

	@Autowired
	private ICurriculumService curriculumService;
	@Autowired
	private ICiudadanoService ciudadanoService;
	@Autowired
	@Qualifier("UsuarioService")
	private IUsuarioService usuarioService;
	@Autowired
	private ListaClaves listaClaves;
	@Autowired
	private ListaIdiomas listaIdiomas;

	@PostMapping("/guardar")
	public String guardarNuevoCurriculum(@Validated @ModelAttribute("curriculum") Curriculum curriculum,
			BindingResult br, Model model) {
		Usuario usuario = usuarioService.getUsuarioActivo();
		Ciudadano ciudadano = ciudadanoService.buscarIdCiudadano(usuario.getIdActivo());

		if (br.hasErrors()) {
			logger.info("Method: /curriculum/guardar/ | Error: Validacion | Action: Error creacion curriculum");
			model.addAttribute("ciudadano", ciudadano);
			model.addAttribute("conInf", listaClaves.getClaves());
			model.addAttribute("idiomas", listaIdiomas.getIdiomas());
			model.addAttribute("curriculum", curriculum);
			return "ciudadano_crear_cv";

		}

		try {
			logger.info("Method: /curriculum/guardar/ Action: Se almacena nuevo curriculum");
			curriculum.setCiudadano(ciudadano);
			curriculumService.guardarCurriculum(curriculum);
		} catch (Exception e) {
			logger.info("Method: /curriculum/guardar/ | Error: No se pudo almacenar al nuevo curriculum");
		}

		return "redirect:/ciudadano/inicio";
	}

	@GetMapping("/editar-cv/{id}")
	public String getEditarCurriculumPage(@PathVariable(value = "id") Long id, Model model) {
		Curriculum curriculum = curriculumService.buscarCurriculum(id);
		model.addAttribute("curriculum", curriculum);
		return "ciudadano_editar_cv";
	}

	@RequestMapping("/modificar-cv")
	public String editarCurriculum(Model model) {
		return "redirect:/ciudadano/inicio";
	}

	@GetMapping("/eliminar-cv/{id}")
	public String eliminarCurriculum(@PathVariable(value = "id") Long id) {
		curriculumService.eliminarCurriculum(id);
		return "redirect:/ciudadano/inicio";
	}

}
