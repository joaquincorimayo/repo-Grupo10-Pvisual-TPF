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

//@Service("CiudadanoService")
@Service
public class CiudadanoServiceImp implements ICiudadanoService{

	@Autowired
	private ICiudadanoRepository ciudadanoRepository;

	@Override
	public Ciudadano getCiudadano() {
		return new Ciudadano();
	}

	@Override
	public boolean guardarCiudadano(Ciudadano ciudadano) {
		Ciudadano ci=ciudadanoRepository.findByDni(ciudadano.getDni());
		if (ci==null) {
			ciudadano.setEstado(true);
			ciudadanoRepository.save(ciudadano);
		}
		return false;
	}

	@Override
	public void modificarCiudadano(Ciudadano ciudadano) {
		ciudadanoRepository.save(ciudadano);
	}

	@Override
	public void eliminarCiudadano(String dni) {
		Ciudadano ciudadano=buscarCiudadano(dni);
		ciudadano.setEstado(false);
		ciudadanoRepository.save(ciudadano);
	}

	@Override
	public List<Ciudadano> getListaCiudadano() {
		return ciudadanoRepository.findByEstado(true);
	}

	@Override
	public Ciudadano buscarCiudadano(String dni) {
		return ciudadanoRepository.findByDni(dni);
	}
	
	
}
