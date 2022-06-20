package ar.edu.unju.fi.tpf.service.imp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpf.entity.Empleador;
import ar.edu.unju.fi.tpf.repositorty.IEmpleadorRepository;
import ar.edu.unju.fi.tpf.service.IEmpleadorService;

/**
 * Implementacion de servicios para Empleador.
 * 
 * @author JoaquinCorimayo
 */

@Service("EmpleadorService")
public class EmpleadorServiceImp implements IEmpleadorService {
	
	Logger logger = LoggerFactory.getLogger(EmpleadorServiceImp.class);

	@Autowired
	private IEmpleadorRepository empleadorRepository;

	@Override
	public Empleador crearEmpleador() {
		return new Empleador();
	}

	@Override
	public void guardarEmpleador(Empleador empleador) {
		empleador.setEstado(true);
		empleadorRepository.save(empleador);
	}

	@Override
	public void borrarEmpleador(Long id) {
		Empleador empleadorBorrar = buscarEmpleador(id);
		empleadorBorrar.setEstado(false);
		empleadorRepository.save(empleadorBorrar);
	}

	@Override
	public void actualizarEmpleador(Empleador empleador) {
		Empleador empleadorNuevo = buscarEmpleador(empleador.getId());
		mapearEmpleado(empleador, empleadorNuevo);
		empleadorRepository.save(empleadorNuevo);
	}
	
	public void mapearEmpleado(Empleador desde, Empleador hacia) {
		// OPC del formulario
		hacia.setEmail(desde.getEmail());
	}

	@Override
	public List<Empleador> listarEmpleadores() {
		return empleadorRepository.findAll();
	}

	@Override
	public Empleador buscarEmpleador(Long id) {
		Empleador empleador = new Empleador();

		for (int i = 0; i < empleadorRepository.findAll().size(); i++) {
			if (empleadorRepository.findAll().get(i).getId() == id) {
				empleador = empleadorRepository.findAll().get(i);
			}
		}

		return empleador;
	}

}
