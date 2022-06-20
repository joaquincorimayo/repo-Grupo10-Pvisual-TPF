package ar.edu.unju.fi.tpf.repositorty;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tpf.entity.Empleador;

/**
 * Declaracion de servicios para Empleador.
 * 
 * @author JoaquinCorimayo
 */

@Repository
public interface IEmpleadorRepository extends JpaRepository<Empleador, Long> {

}
