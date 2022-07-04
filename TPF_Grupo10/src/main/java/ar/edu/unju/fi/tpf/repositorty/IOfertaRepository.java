package ar.edu.unju.fi.tpf.repositorty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tpf.entity.Oferta;

/**
 * 
 * @author JoaquinCorimayo
 * 
 * @author LuisQuispe
 */

@Repository
public interface IOfertaRepository extends JpaRepository<Oferta, Long> {
	
	@Query("SELECT o FROM Oferta o WHERE o.empleador.provincia  LIKE %?1%")
	public List<Oferta> findAll(String palabraClave);
	
}
