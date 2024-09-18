package br.com.portaledu.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import br.com.portaledu.dto.AlunoRecord;
import br.com.portaledu.model.Aluno;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = CursoMapper.class)
public interface AlunoMapper {

//	AlunoMapper INSTANCE = Mappers.getMapper(AlunoMapper.class );
	
	
	AlunoRecord toAlunoRecord(Aluno aluno);
	
	List<AlunoRecord> toListAlunoRecord(List<Aluno> alunos);
	
	@InheritInverseConfiguration
	Aluno toAluno(AlunoRecord alunoRecord);

	@InheritInverseConfiguration
	List<Aluno> toListAlunos(List<AlunoRecord> alunoRecords);
}
