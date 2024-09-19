package br.com.portaledu.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.portaledu.dto.ModuloRecord;
import br.com.portaledu.model.Curso;
import br.com.portaledu.model.Modulo;

@ExtendWith(MockitoExtension.class)
class ModuloMapperTest {


	@Mock
	private ConteudoMapper conteudoMapper;
	
	@InjectMocks
	private ModuloMapper moduloMapper = Mappers.getMapper(ModuloMapper.class);
	
	
	private Modulo modulo;
	
	private ModuloRecord moduloRecord;
	
	@BeforeEach
	void setup() {
		modulo =  new Modulo();
		
		modulo.setTitulo("Spring boot Cloud");
		modulo.setDescricao("Modulo para ensimento de spring boot");
		modulo.setCurso(Curso.builder().titulo("Spring boot Framework").build());
		modulo.setConteudos(Collections.emptyList());
		
		moduloRecord = new ModuloRecord("Spring boot Cloud", 
													"Modulo para ensimento de spring boot", 
													Collections.emptyList(), 
													Curso.builder().titulo("Spring boot Framework").build());
	}
	
	
	
	@Test
	void DeveConverterModuloParaModuloRecord() {
//		Quando converter Modulo para ModuloRecord
		ModuloRecord result = moduloMapper.toModuloRecord(modulo);
		
//		Então os campos devem ser iguais
		assertThat(result).isNotNull();
		assertThat(result.titulo()).isEqualTo(modulo.getTitulo());
		assertThat(result.curso().getTitulo()).isEqualTo(modulo.getCurso().getTitulo());
		assertThat(result.conteudos()).isEmpty();
	}

	
	
	@Test
	void DeveConverterModuloRecordParaModulo() {
//		Quando converter ModuloRecord para Modulo
		Modulo result = moduloMapper.toModulo(moduloRecord);
		
//		Então os campos devem ser iguais
		assertThat(result).isNotNull();
		assertThat(result.getTitulo()).isEqualTo(moduloRecord.titulo());
		assertThat(result.getCurso().getTitulo()).isEqualTo(moduloRecord.curso().getTitulo());
		assertThat(result.getConteudos()).isEmpty();
	}
	
	
	@Test
	void deveConverterListaDeModuloParaModuloRecord() {
//		Given
		List<Modulo> modulos = List.of(modulo);
		
//		When
		List<ModuloRecord> result = moduloMapper.toListModuloRecord(modulos);
		
//		Then
		assertThat(result).isNotNull();
		assertThat(result).hasSize(modulos.size());
		assertThat(result.get(0).titulo()).isEqualTo(modulos.get(0).getTitulo());
		assertThat(result.get(0).descricao()).isEqualTo(modulos.get(0).getDescricao());
	}
	
	
	@Test
	void deveConverterListaDeModuloRecordParaModulo() {
//		Given
		List<ModuloRecord> records = List.of(moduloRecord);
		
//		When
		List<Modulo> result = moduloMapper.toListModulo(records);
		
//		Then
		assertThat(result).isNotNull();
		assertThat(result).hasSize(records.size());
		assertThat(result.get(0).getTitulo()).isEqualTo(records.get(0).titulo());
		assertThat(result.get(0).getDescricao()).isEqualTo(records.get(0).descricao());
	}
	
	
	
	
}
