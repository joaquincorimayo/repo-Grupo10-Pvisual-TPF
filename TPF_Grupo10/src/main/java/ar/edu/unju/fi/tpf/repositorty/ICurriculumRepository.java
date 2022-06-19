package ar.edu.unju.fi.tpf.repositorty;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.tpf.entity.Curriculum;

public interface ICurriculumRepository extends JpaRepository<Curriculum, Long>{

}