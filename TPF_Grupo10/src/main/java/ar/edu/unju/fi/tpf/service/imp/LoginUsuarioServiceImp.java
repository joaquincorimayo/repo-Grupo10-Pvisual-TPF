package ar.edu.unju.fi.tpf.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpf.entity.Usuario;
import ar.edu.unju.fi.tpf.repositorty.IUsuarioRepository;
import ar.edu.unju.fi.tpf.service.IEmpleadorService;

/**
 * Implementacion de servicios.
 * 
 * @author JoaquinCorimayo
 * 
 * @author LuisQuispe
 */

@Service
public class LoginUsuarioServiceImp implements UserDetailsService {

	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	@Qualifier("EmpleadorService")
	private IEmpleadorService empleadorService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsername(username);
		usuario.setStatus(true);
		usuarioRepository.save(usuario);
		List<GrantedAuthority> tipos = new ArrayList<>();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(usuario.getRole());
		tipos.add(grantedAuthority);
		UserDetails user = (UserDetails) new User(username, usuario.getPassword(), tipos);
		return user;
	}

}
