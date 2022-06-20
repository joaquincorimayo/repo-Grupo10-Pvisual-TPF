package ar.edu.unju.fi.tpf.repositorty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tpf.entity.Oferta;

@Repository
public interface IOfertaRepository extends JpaRepository<Oferta, Long> {
}
