package br.com.portaledu.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import br.com.portaledu.dto.ModuloRecord;
import br.com.portaledu.model.Modulo;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = ConteudoMapper.class)
public interface ModuloMapper {
	
	
	ModuloRecord toModuloRecord(Modulo modulo);

	
	List<ModuloRecord> toListModuloRecord(List<Modulo> modulo);
	
	@InheritInverseConfiguration
	Modulo toModulo(ModuloRecord moduloRecord);

	@InheritInverseConfiguration
	List<Modulo> toListModulo(List<ModuloRecord> moduloRecords);

	
}
