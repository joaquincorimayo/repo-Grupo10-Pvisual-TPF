package ar.edu.unju.fi.tpf.service.imp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpf.entity.Empleador;
import ar.edu.unju.fi.tpf.entity.Usuario;
import ar.edu.unju.fi.tpf.repositorty.IEmpleadorRepository;
import ar.edu.unju.fi.tpf.service.IEmpleadorService;
import ar.edu.unju.fi.tpf.service.IUsuarioService;

/**
 * Implementacion de servicios.
 * 
 * @author JoaquinCorimayo
 * 
 * @author LuisQuispe
 */

@Service("EmpleadorService")
public class EmpleadorServiceImp implements IEmpleadorService {

	Logger logger = LoggerFactory.getLogger(EmpleadorServiceImp.class);

	@Autowired
	private IEmpleadorRepository empleadorRepository;

	@Autowired
	private IUsuarioService usuarioService;

	@Override
	public Empleador crearEmpleador() {
		return new Empleador();
	}

	@Override
	public void guardarEmpleador(Empleador empleador) {
		empleador.setEstado(true);
		String pwencod = empleador.getPassword();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		empleador.setPassword(bCryptPasswordEncoder.encode(pwencod));
		empleadorRepository.save(empleador);
		// USUARIO LOGIN
		Usuario usuarioNuevo = usuarioService.crearUsuario();
		usuarioNuevo.setUsername(empleador.getCuit());
		usuarioNuevo.setPassword(empleador.getPassword());
		usuarioNuevo.setRole("EMPLEADOR");
		usuarioNuevo.setIdActivo(empleador.getId());
		usuarioService.guardarUsuario(usuarioNuevo);
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

	public boolean existeEmpleador(String cuit) {
		boolean bandera = false;
		for (int i = 0; i < empleadorRepository.findAll().size(); i++) {
			if (empleadorRepository.findAll().get(i).getCuit().equals(cuit)) {
				bandera = true;
			}
		}
		return bandera;
	}

}
