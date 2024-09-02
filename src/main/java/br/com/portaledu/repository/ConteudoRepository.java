package br.com.portaledu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.portaledu.model.Conteudo;

@Repository
public interface ConteudoRepository extends JpaRepository<Conteudo, Long>{

}
