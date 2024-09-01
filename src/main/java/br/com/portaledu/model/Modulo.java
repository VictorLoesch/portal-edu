package br.com.portaledu.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@SuperBuilder
public class Modulo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 150,nullable = false)
	private String titulo;
	
	@Column(length = 500)
	private String descrição;
	
	@OneToMany(mappedBy = "modulo", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Conteudo> conteudos;
	
	
	
}
