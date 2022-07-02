package ar.edu.unju.fi.tpf.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpf.entity.Oferta;
import ar.edu.unju.fi.tpf.repositorty.IOfertaRepository;
import ar.edu.unju.fi.tpf.service.IOfertaService;

/**
 * Implementacion de servicios.
 * 
 * @author JoaquinCorimayo
 * 
 * @author LuisQuispe
 */

@Service("OfertaService")
public class OfertaServiceImp implements IOfertaService {
	Logger logger = LoggerFactory.getLogger(OfertaServiceImp.class);

	@Autowired
	private IOfertaRepository ofertaRepository;

	@Override
	public Oferta crearOferta() {
		return new Oferta();
	}

	@Override
	public void guardarOferta(Oferta oferta) {
		oferta.setEstado(true);
		ofertaRepository.save(oferta);
	}

	@Override
	public void borrarOferta(Long id) {
		Oferta ofertaBorrar = buscarOferta(id);
		ofertaBorrar.setEstado(false);
		ofertaRepository.save(ofertaBorrar);
	}

	@Override
	public void actualizarOferta(Oferta oferta) {
		Oferta ofertaNueva = buscarOferta(oferta.getId());
		mapearOferta(oferta, ofertaNueva);
		ofertaRepository.save(ofertaNueva);
	}

	public void mapearOferta(Oferta desde, Oferta hacia) {
		// Mas opciones segun formulario para modificar
		hacia.setCantidadVacantes(desde.getCantidadVacantes());
		hacia.setDisponibilidadHoraria(desde.getDisponibilidadHoraria());
		hacia.setPuestoRequerido(desde.getPuestoRequerido());
		hacia.setPrincipalesTareas(desde.getPrincipalesTareas());
		hacia.setResumen(desde.getResumen());
		hacia.setDatosContacto(desde.getDatosContacto());
		hacia.setJornada(desde.getJornada());
		hacia.setRequisitos(desde.getRequisitos());
		hacia.setBeneficios(desde.getBeneficios());
		hacia.setDisponibilidad(desde.getDisponibilidad());
		hacia.setSalario(desde.getSalario());
	}

	@Override
	public List<Oferta> listarOfertas() {
		return ofertaRepository.findAll();
	}

	@Override
	public Oferta buscarOferta(Long id) {
		Oferta oferta = new Oferta();
		for (int i = 0; i < ofertaRepository.findAll().size(); i++) {
			if (ofertaRepository.findAll().get(i).getId() == id) {
				oferta = ofertaRepository.findAll().get(i);
			}
		}
		return oferta;
	}

	@Override
	public List<Oferta> listarOfertasId(Long id) {
		List<Oferta> aux_ofertas = new ArrayList<Oferta>();

		for (Oferta oferta : ofertaRepository.findAll()) {
			if (oferta.getEmpleador().getId() == id) {
				aux_ofertas.add(oferta);
			}
		}

		return aux_ofertas;
	}

}
