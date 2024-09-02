package br.com.portaledu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.portaledu.model.Modulo;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo, Long>{

}
