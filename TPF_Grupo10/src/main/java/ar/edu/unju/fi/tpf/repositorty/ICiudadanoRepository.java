package ar.edu.unju.fi.tpf.repositorty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.tpf.entity.Ciudadano;

public interface ICiudadanoRepository  extends JpaRepository<Ciudadano, Long>{

	public Ciudadano findByDni(String dni);
	public List<Ciudadano> findByEstado(boolean estado);
	
}