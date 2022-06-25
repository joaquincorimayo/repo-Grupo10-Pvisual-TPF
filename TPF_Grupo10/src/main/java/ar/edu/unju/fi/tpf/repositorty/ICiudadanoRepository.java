package ar.edu.unju.fi.tpf.repositorty;

import org.springframework.data.jpa.repository.JpaRepository;
import ar.edu.unju.fi.tpf.entity.Ciudadano;

public interface ICiudadanoRepository  extends JpaRepository<Ciudadano, Long>{

//	public Optional<Ciudadano> findByDni(String dni);
//	public List<Ciudadano> findByEstado(boolean estado);
	
}