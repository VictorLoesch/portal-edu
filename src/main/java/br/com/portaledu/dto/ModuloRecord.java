package br.com.portaledu.dto;

import java.util.List;

import br.com.portaledu.model.Conteudo;
import br.com.portaledu.model.Curso;

public record ModuloRecord(String titulo,
							String descrição,
							List<Conteudo> conteudos,
							Curso curso) {

}
