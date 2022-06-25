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

import ar.edu.unju.fi.tpf.entity.Ciudadano;
import ar.edu.unju.fi.tpf.entity.Curriculum;
import ar.edu.unju.fi.tpf.entity.Usuario;
import ar.edu.unju.fi.tpf.service.ICiudadanoService;
import ar.edu.unju.fi.tpf.service.ICurriculumService;
import ar.edu.unju.fi.tpf.service.IUsuarioService;

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

	@PostMapping("/guardar")
	public String guardarNuevoCurriculum(@ModelAttribute("curriculum") Curriculum curriculum) {

		Usuario usuario = usuarioService.getUsuarioActivo();
		Ciudadano ciudadano = ciudadanoService.buscarIdCiudadano(usuario.getIdActivo());

		try {
			curriculum.setCiudadano(ciudadano);
			curriculumService.guardarCurriculum(curriculum);
		} catch (Exception e) {
			System.out.println("Error en: /curriculum/guardar");
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
