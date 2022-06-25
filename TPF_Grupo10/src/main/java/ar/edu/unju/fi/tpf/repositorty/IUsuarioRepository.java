package ar.edu.unju.fi.tpf.repositorty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tpf.entity.Usuario;

/**
 * 
 * @author JoaquinCorimayo
 * 
 * @author LuisQuispe
 */

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
	public Usuario findByUsername(String username);
	public Usuario findByStatus(boolean status);
}
