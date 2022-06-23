package ar.edu.unju.fi.tpf.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpf.entity.Ciudadano;
import ar.edu.unju.fi.tpf.repositorty.ICiudadanoRepository;
import ar.edu.unju.fi.tpf.service.ICiudadanoService;

/**
 * Implementacion de servicios para Ciudadano.
 * 
 * @author JoaquinCorimayo
 * 
 * @author LuisQuispe
 */

@Service
public class CiudadanoServiceImp implements ICiudadanoService{

	@Autowired
	private ICiudadanoRepository ciudadanoRepository;

	@Override
	public Ciudadano getCiudadano() {
		return new Ciudadano();
	}

	@Override
	public void guardarCiudadano(Ciudadano ciudadano) {
		ciudadano.setEstado(true);
		ciudadanoRepository.save(ciudadano);
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
		Ciudadano ciudadano=buscarCiudadano(dni);
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
		for (int i=0; i<ciudadanoRepository.findAll().size();i++) {
			if (ciudadanoRepository.findAll().get(i).getDni()==dni);
				ciudadano = ciudadanoRepository.findAll().get(i);
		}
		return ciudadano;
	}

}
