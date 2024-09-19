package br.com.portaledu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.portaledu.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	Aluno findByEmail(String email);
	
	
	
	@Modifying
    @Transactional
    @Query("DELETE FROM Aluno a WHERE a.email = ?1")
    void deleteByEmail(String email);
	
}
