package ar.edu.unju.fi.tpf.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpf.entity.Empleador;
import ar.edu.unju.fi.tpf.service.IEmpleadorService;
import ar.edu.unju.fi.tpf.util.ListaEmpleadores;

/**
 * Implementacion de servicios para Empleador.
 * 
 * @author JoaquinCorimayo
 */

@Service("EmpleadorService")
public class EmpleadorServiceImp implements IEmpleadorService {

	@Autowired
	private ListaEmpleadores lista;
	// @Autowired
	// private IEmpleadorRepository empleadorRepository;

	@Override
	public Empleador crearEmpleador() {
		return new Empleador();
	}

	@Override
	public void guardarEmpleador(Empleador empleador) {
		empleador.setEstado(true);
		lista.getEmpleadores().add(empleador);
		// REPO
	}

	@Override
	public void borrarEmpleador(Long id) {
		for (int i = 0; i < lista.getEmpleadores().size(); i++) {
			if (lista.getEmpleadores().get(i).getId() == id) {
				lista.getEmpleadores().get(i).setEstado(false);
				// REPO
			}
		}
	}

	@Override
	public void actualizarEmpleador(Empleador empleador) {
		for (int i = 0; i < lista.getEmpleadores().size(); i++) {
			if (lista.getEmpleadores().get(i).getId() == empleador.getId()) {
				lista.getEmpleadores().set(i, empleador);
				// REPO
			}
		}
	}

	@Override
	public List<Empleador> listarEmpleadores() {
		List<Empleador> aux_empleadores = new ArrayList<Empleador>();
		// REPO
		for (int i = 0; i < lista.getEmpleadores().size(); i++) {
			if (lista.getEmpleadores().get(i).isEstado()==true) {
				aux_empleadores.add(lista.getEmpleadores().get(i));
			}
		}

		return aux_empleadores;
	}

	@Override
	public Empleador buscarEmpleador(Long id) {
		Empleador empleador = new Empleador();

		for (int i = 0; i < lista.getEmpleadores().size(); i++) {
			if (lista.getEmpleadores().get(i).getId() == id) {
				empleador = lista.getEmpleadores().get(i);
			}
		}

		return empleador;
	}

}
