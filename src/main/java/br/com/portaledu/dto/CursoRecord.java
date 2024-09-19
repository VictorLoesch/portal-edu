package br.com.portaledu.dto;

import java.util.List;

public record CursoRecord(String titulo,
						  String descricao,
						  List<ModuloRecord> modulos,
						  ProfessorRecord professor) {

}
