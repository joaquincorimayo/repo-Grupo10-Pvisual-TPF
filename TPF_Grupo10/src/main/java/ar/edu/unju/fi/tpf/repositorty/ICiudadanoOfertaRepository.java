package ar.edu.unju.fi.tpf.repositorty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tpf.entity.CiudadanoOferta;

/**
 * 
 * @author JoaquinCorimayo
 * @author LuisQuispe
 */

@Repository
public interface ICiudadanoOfertaRepository extends JpaRepository<CiudadanoOferta, Long>{

}
