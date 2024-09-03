package br.com.portaledu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
public class Conteudo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TipoConteudo tipo;
	
	
	@Column(length = 100 ,nullable = false)
	private String titulo;
	
	@Column(length = 1000, nullable = false)
	private String url;
	
	@ManyToOne
	@JoinColumn(name = "modulo_id", nullable = false)
	private Modulo modulo;
	
}
