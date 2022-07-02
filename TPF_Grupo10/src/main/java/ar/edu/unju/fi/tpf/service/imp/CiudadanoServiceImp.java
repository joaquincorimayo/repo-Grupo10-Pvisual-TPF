package ar.edu.unju.fi.tpf.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpf.entity.Ciudadano;
import ar.edu.unju.fi.tpf.entity.Usuario;
import ar.edu.unju.fi.tpf.repositorty.ICiudadanoRepository;
import ar.edu.unju.fi.tpf.service.ICiudadanoService;
import ar.edu.unju.fi.tpf.service.IUsuarioService;

/**
 * Implementacion de servicios.
 * 
 * @author JoaquinCorimayo
 * 
 * @author LuisQuispe
 */

@Service
public class CiudadanoServiceImp implements ICiudadanoService {


	Logger logger = LoggerFactory.getLogger(CiudadanoServiceImp.class);

	@Autowired
	private ICiudadanoRepository ciudadanoRepository;
	@Autowired
	private IUsuarioService usuarioService;

	@Override
	public Ciudadano getCiudadano() {
		return new Ciudadano();
	}

	@Override
	public void guardarCiudadano(Ciudadano ciudadano) {

		ciudadano.setEstado(true);
		String pw_enc = ciudadano.getPassword();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		ciudadano.setPassword(bCryptPasswordEncoder.encode(pw_enc));
		ciudadanoRepository.save(ciudadano);

		Usuario usuario = usuarioService.crearUsuario();
		usuario.setUsername(ciudadano.getDni());
		usuario.setPassword(ciudadano.getPassword());
		usuario.setRole("CIUDADANO");
		usuario.setIdActivo(ciudadano.getId());
		usuarioService.guardarUsuario(usuario);
	}

	@Override
	public void modificarCiudadano(Ciudadano ciudadano) {
		Ciudadano ciNuevo = buscarCiudadano(ciudadano.getDni());
		actulizarCiudadano(ciudadano, ciNuevo);
		ciudadanoRepository.save(ciudadano);
	}

	public void actulizarCiudadano(Ciudadano desde, Ciudadano hacia) {
		hacia.setApellido(desde.getApellido());
		hacia.setNombre(desde.getNombre());
		hacia.setEmail(desde.getEmail());
		hacia.setEstadoCivil(desde.getEstadoCivil());
		hacia.setProvincia(desde.getProvincia());
		hacia.setTelefono(desde.getTelefono());
		hacia.setFechaNac(desde.getFechaNac());
	}

	@Override
	public void eliminarCiudadano(String dni) {
		Ciudadano ciudadano = buscarCiudadano(dni);
		ciudadano.setEstado(false);
		ciudadanoRepository.save(ciudadano);
	}

	@Override
	public List<Ciudadano> getListaCiudadano() {
		return ciudadanoRepository.findAll();
	}

	@Override
	public Ciudadano buscarCiudadano(String dni) {
		Ciudadano ciudadano = new Ciudadano();
		for (int i = 0; i < ciudadanoRepository.findAll().size(); i++) {
			if (ciudadanoRepository.findAll().get(i).getDni() == dni)
				;
			ciudadano = ciudadanoRepository.findAll().get(i);
		}
		return ciudadano;
	}

	@Override
	public Ciudadano buscarIdCiudadano(Long id) {
		Optional<Ciudadano> ciuda = ciudadanoRepository.findById(id);
		return ciuda.get();
	}

	@Override
	public List<Ciudadano> getListaCiudadanoProvincia(String provincia) {
		List<Ciudadano> lista = new ArrayList<Ciudadano>();

		for (int i = 0; i < ciudadanoRepository.findAll().size(); i++) {
			if (ciudadanoRepository.findAll().get(i).getProvincia().equals(provincia)) {
				lista.add(ciudadanoRepository.findAll().get(i));
			}
		}

		return lista;
	}

	@Override
	public List<Ciudadano> getListaCiudadanoClave(String clave) {
		List<Ciudadano> lista = new ArrayList<Ciudadano>();
		for (int i = 0; i < ciudadanoRepository.findAll().size(); i++) {
			if (ciudadanoRepository.findAll().get(i).getCurriculum().getExperienciaLaboral().equals(clave)) {
				lista.add(ciudadanoRepository.findAll().get(i));
			}
		}
		return lista;
	}

	@Override
	public List<Ciudadano> getListaCiudadanoProvinciaClave(String provincia, String clave) {
		List<Ciudadano> lista = new ArrayList<Ciudadano>();
		for (int i = 0; i < ciudadanoRepository.findAll().size(); i++) {
			if (ciudadanoRepository.findAll().get(i).getProvincia().equals(provincia)) {
				if (ciudadanoRepository.findAll().get(i).getCurriculum().getExperienciaLaboral().equals(provincia)) {
					lista.add(ciudadanoRepository.findAll().get(i));
				}
			}
		}
		return lista;
	}

	@Override
	public boolean existeCiudadano(String dni) {
		boolean bandera = false;
		for (int i=0; i<ciudadanoRepository.findAll().size();i++) {
			if (ciudadanoRepository.findAll().get(i).getDni().equals(dni)) {
				bandera= true;
			}
		}
		return bandera;
	}

}
