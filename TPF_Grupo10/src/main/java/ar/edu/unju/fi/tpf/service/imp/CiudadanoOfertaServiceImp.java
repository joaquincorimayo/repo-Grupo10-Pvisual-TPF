package ar.edu.unju.fi.tpf.service.imp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpf.entity.CiudadanoOferta;
import ar.edu.unju.fi.tpf.repositorty.ICiudadanoOfertaRepository;
import ar.edu.unju.fi.tpf.service.ICiudadanoOfertaService;

/**
 * Implementacion de servicios.
 * 
 * @author JoaquinCorimayo
 * 
 * @author LuisQuispe
 */

@Service
public class CiudadanoOfertaServiceImp implements ICiudadanoOfertaService {

	Logger logger = LoggerFactory.getLogger(CiudadanoOfertaServiceImp.class);

	@Autowired
	ICiudadanoOfertaRepository ciudadanoOfertaRepository;

	@Override
	public CiudadanoOferta nuevoCiudadanoOferta() {
		return new CiudadanoOferta();
	}

	@Override
	public void guardarCiudadanoOferta(CiudadanoOferta ciudadanoOferta) {
		ciudadanoOfertaRepository.save(ciudadanoOferta);
	}

	@Override
	public void eliminarCiudadanoOferta(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarCiudadanoOferta(CiudadanoOferta ciudadanoOferta) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CiudadanoOferta> listarCiudadanoOferta() {
		return (List<CiudadanoOferta>) ciudadanoOfertaRepository.findAll();
	}

	@Override
	public CiudadanoOferta buscarCiudadanoOferta(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean verificarPostulacion(Long idUsuario, Long idOferta) {
		boolean bandera = true;

		for (CiudadanoOferta ciof : ciudadanoOfertaRepository.findAll()) {
			if (ciof.getCiudadano().getId() == idUsuario) {
				if (ciof.getOferta().getId() == idOferta) {
					bandera = false;
				}
			}
		}
		return bandera;
	}

}
