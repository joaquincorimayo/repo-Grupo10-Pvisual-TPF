package ar.edu.unju.fi.tpf.service;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpf.entity.Usuario;

/**
 * Declaracion de servicios para Usuario.
 * 
 * @author JoaquinCorimayo
 * 
 * @author LuisQuispe
 */

@Service
public interface IUsuarioService {
	public Usuario crearUsuario();

	public void guardarUsuario(Usuario usuario);

	public void cambiarEstado(Usuario usuario);

	public Usuario getUsuarioActivo();

	public Usuario getUsuario(String name);
	
	public void cerrarSesionesError();
}
