package ar.edu.unju.fi.tpf.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpf.entity.Curriculum;
import ar.edu.unju.fi.tpf.repositorty.ICurriculumRepository;
import ar.edu.unju.fi.tpf.service.ICurriculumService;

/**
 * Implementacion de servicios para Curriculum.
 * 
 * @author JoaquinCorimayo
 */

@Service
public class CurriculumServiceImp implements ICurriculumService {

	@Autowired
	private ICurriculumRepository curriculumRepository;

	@Override
	public Curriculum getCurriculum() {
		return new Curriculum();
	}

	@Override
	public void guardarCurriculum(Curriculum curriculum) {
		curriculum.setEstado(true);
		curriculumRepository.save(curriculum);
	}

	@Override
	public void modificarCurriculum(Curriculum curriculum) {
		Curriculum cuNuevo= buscarCurriculum(curriculum.getId());
		actulizarCurriculum(curriculum, cuNuevo);
		curriculumRepository.save(curriculum);	
	}
	public void actulizarCurriculum(Curriculum desde, Curriculum hacia) {
		hacia.setContacto(desde.getContacto());
		hacia.setEducacion(desde.getEducacion());
		hacia.setIdiomas(desde.getIdiomas());
		hacia.setConocimientosInfomaticos(desde.getConocimientosInfomaticos());
		hacia.setExperienciaLaboral(desde.getExperienciaLaboral());
		hacia.setDomicilio(desde.getDomicilio());
	}

	@Override
	public void eliminarCurriculum(Long id) {
		Curriculum curriculum = buscarCurriculum(id);
		curriculum.setEstado(false);
		curriculumRepository.save(curriculum);
	}

	@Override
	public List<Curriculum> getListaCurriculum() {
		return curriculumRepository.findAll();
	}

	@Override
	public Curriculum buscarCurriculum(Long id) {
		Curriculum curriculum = new Curriculum();
		for (int i=0; i<curriculumRepository.findAll().size();i++) {
			if (curriculumRepository.findAll().get(i).getId()==id);
				curriculum = curriculumRepository.findAll().get(i);
		}
		return curriculum;
	}
	
}
