package br.com.portaledu.dto;

import java.util.List;

import br.com.portaledu.model.Curso;

public record ProfessorRecord(String nome, String email, List<Curso> cursos) {

}
