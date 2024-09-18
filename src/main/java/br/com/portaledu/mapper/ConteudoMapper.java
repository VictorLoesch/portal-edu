package br.com.portaledu.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import br.com.portaledu.dto.ConteudoRecord;
import br.com.portaledu.dto.CursoRecord;
import br.com.portaledu.model.Conteudo;
import br.com.portaledu.model.Curso;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ConteudoMapper {

	@Mapping(target = "tipo", ignore = true)
	ConteudoRecord toCursoRecord(Conteudo conteudo);
	
	@Mapping(target = "tipo", ignore = true)
	List<ConteudoRecord> toListCursoRecord(List<Conteudo> conteudo);
	
	
	@InheritInverseConfiguration
	Curso toCurso(CursoRecord cursoRecord);
	
	@InheritInverseConfiguration
	List<Conteudo> toListCurso(List<ConteudoRecord> conteudoRecords);
	
}
