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

import ar.edu.unju.fi.tpf.entity.Curriculum;
import ar.edu.unju.fi.tpf.service.ICurriculumService;

@Controller
@RequestMapping("/curriculum")
public class CurriculumController {
	Logger logger = LoggerFactory.getLogger(OfertaController.class);
	
	@Autowired
	@Qualifier("CurriculumService")
	private ICurriculumService curriculumService;
	
	@PostMapping("/guardar")
	public String guardarNuevoCurriculum(@ModelAttribute("curriculum") Curriculum curriculum) {
		try {
			curriculumService.guardarCurriculum(curriculum);
		} catch (Exception e) {
			System.out.println("Error");
		}
		return "redirect:/ciudadano/inicio";
	}
	
	@GetMapping("/editar/{id}")
	public String getEditarCurriculumPage(@PathVariable(value="id") Long id, Model model) {
		Curriculum curriculum = curriculumService.buscarCurriculum(id);
		model.addAttribute("curriculum", curriculum);
		return "ciudadano_editar_cv";
	}
	
	@RequestMapping("/modificar")
	public String editarCurriculum(Model model) {
		return "redirect:/ciudadano/inicio";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarCurriculum(@PathVariable(value="id")Long id) {
		curriculumService.eliminarCurriculum(id);
		return "redirect:/ciudadano/inicio";
	}
	
}
