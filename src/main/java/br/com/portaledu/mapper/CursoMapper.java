package br.com.portaledu.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import br.com.portaledu.dto.CursoRecord;
import br.com.portaledu.model.Curso;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = ModuloMapper.class)
public interface CursoMapper {

	CursoRecord toCursoRecord(Curso curso);
	
	List<CursoRecord> toListCursoRecord(List<Curso> cursos);
	
	@InheritInverseConfiguration
	Curso toCurso(CursoRecord cursoRecord);

	@InheritInverseConfiguration
	List<Curso> toListCurso(List<CursoRecord> cursoRecords);

}
