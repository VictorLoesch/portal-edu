package br.com.portaledu.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import br.com.portaledu.dto.ProfessorRecord;
import br.com.portaledu.model.Professor;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = CursoMapper.class)
public interface ProfessorMapper {
	
	ProfessorRecord toProfessorRecord(Professor professor);
	
	List<ProfessorRecord> toListProfessorRecord(List<Professor> professors);
	
	@InheritInverseConfiguration
	Professor toProfessor(ProfessorRecord professorRecord);

	@InheritInverseConfiguration
	List<Professor> toListProfessors(List<ProfessorRecord> professorRecords);
}
