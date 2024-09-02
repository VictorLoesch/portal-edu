package br.com.portaledu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.portaledu.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{

}
