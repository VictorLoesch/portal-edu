package br.com.portaledu.dto;

import java.util.List;

public record AlunoRecord(String nome, String email, List<CursoRecord> cursos) {	
}
