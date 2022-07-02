package ar.edu.unju.fi.tpf.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpf.entity.Usuario;
import ar.edu.unju.fi.tpf.repositorty.IUsuarioRepository;
import ar.edu.unju.fi.tpf.service.IUsuarioService;

/**
 * Implementacion de servicios.
 * 
 * @author JoaquinCorimayo
 * 
 * @author LuisQuispe
 */

@Service("UsuarioService")
public class UsuarioServiceImp implements IUsuarioService{

	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Override
	public Usuario crearUsuario() {
		return new Usuario();
	}

	@Override
	public void guardarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	@Override
	public void cambiarEstado(Usuario usuario) {
		usuario.setStatus(false);
		usuarioRepository.save(usuario);
	}
	
	@Override
	public Usuario getUsuarioActivo() {
		return usuarioRepository.findByStatus(true);
	}

	@Override
	public Usuario getUsuario(String name) {
		return usuarioRepository.findByUsername(name);
	}

	@Override
	public void cerrarSesionesError() {
		// En caso de error, cerrar sesiones de todos los usuarios.
		for (Usuario usuario : usuarioRepository.findAll()) {
			usuario.setStatus(false);
			usuarioRepository.save(usuario);
		}
	}

}
