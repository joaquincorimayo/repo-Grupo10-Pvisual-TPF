package ar.edu.unju.fi.tpf.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpf.entity.Oferta;
import ar.edu.unju.fi.tpf.service.IOfertaService;
import ar.edu.unju.fi.tpf.util.ListaOfertas;

/**
 * Implementacion de servicios para Ofertas.
 * 
 * @author JoaquinCorimayo
 */
@Service("OfertaService")
public class OfertaServiceImp implements IOfertaService {

	@Autowired
	private ListaOfertas lista;
	// @Autowired
	// private IOfertaRepository ofertaRepository;

	@Override
	public Oferta crearOferta() {
		return new Oferta();
	}

	@Override
	public void guardarOferta(Oferta oferta) {
		oferta.setEstado(true);
		lista.getOfertas().add(oferta);
		// REPO
	}

	@Override
	public void borrarOferta(Long id) {
		for (int i = 0; i < lista.getOfertas().size(); i++) {
			if (lista.getOfertas().get(i).getId() == id) {
				lista.getOfertas().get(i).setEstado(false);
				// REPO
			}
		}
	}

	@Override
	public void actualizarOferta(Oferta oferta) {
		for (int i = 0; i < lista.getOfertas().size(); i++) {
			if (lista.getOfertas().get(i).getId() == oferta.getId()) {
				oferta.setEstado(true); // Solo pruebas
				lista.getOfertas().set(i, oferta);
				// REPO
			}
		}
	}

	@Override
	public List<Oferta> listarOfertas() {
		List<Oferta> aux_ofertas = new ArrayList<Oferta>();
		// REPO
		for (int i = 0; i < lista.getOfertas().size(); i++) {
			if (lista.getOfertas().get(i).isEstado() == true) {
				aux_ofertas.add(lista.getOfertas().get(i));
			}
		}

		return aux_ofertas;
	}

	@Override
	public Oferta buscarOferta(Long id) {
		Oferta oferta = new Oferta();

		for (int i = 0; i < lista.getOfertas().size(); i++) {
			if (lista.getOfertas().get(i).getId() == id) {
				oferta = lista.getOfertas().get(i);
			}
		}

		return oferta;
	}

}
