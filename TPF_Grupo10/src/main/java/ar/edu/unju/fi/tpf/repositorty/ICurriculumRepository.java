package ar.edu.unju.fi.tpf.repositorty;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tpf.entity.Curriculum;

/**
 * 
 * @author JoaquinCorimayo
 * 
 * @author LuisQuispe
 */

@Repository
public interface ICurriculumRepository extends JpaRepository<Curriculum, Long>{
	
}