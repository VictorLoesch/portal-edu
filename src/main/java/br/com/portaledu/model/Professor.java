package br.com.portaledu.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Professor extends AbstractUsuario{

	
	@OneToMany(mappedBy = "professor",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Curso> cursos;
	 
}
