package br.com.portaledu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.portaledu.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
