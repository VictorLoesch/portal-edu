package br.com.portaledu.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.portaledu.dto.ConteudoRecord;
import br.com.portaledu.dto.ModuloRecord;
import br.com.portaledu.model.Conteudo;
import br.com.portaledu.model.Modulo;
import br.com.portaledu.model.TipoConteudo;

@ExtendWith(MockitoExtension.class)
class ConteudoMapperTest {


	@InjectMocks
	ConteudoMapper conteudoMapper = Mappers.getMapper(ConteudoMapper.class);
	
	
	private Conteudo conteudo;
	
	private ConteudoRecord conteudoRecord;
	
	@BeforeEach
	void setup() {
//		Configurando objeto Conteudo
		conteudo = new Conteudo();
		conteudo.setTitulo("Teste de coonteudo");
		conteudo.setUrl("url teste");
		conteudo.setTipo(TipoConteudo.VIDEO);
		conteudo.setModulo(Modulo.builder().titulo("Spring Boot").build());
//		Configurando objeto ConteudoRecord
		conteudoRecord = new ConteudoRecord(TipoConteudo.VIDEO, "Teste de coonteudo", "url teste", Modulo.builder().titulo("Spring Boot").build());
		
	}

	@Test
	void deveConverterDeConteudoParaConteudoRecord() {
//		Quando converter Conteudo para ConteudoRecord
		ConteudoRecord result = conteudoMapper.toConteudoRecord(conteudo);
		
//		Então os campos devem ser iguais
		assertThat(result).isNotNull();
		assertThat(result.titulo()).isEqualTo(conteudo.getTitulo());
		assertThat(result.tipo()).isEqualTo(conteudo.getTipo());
		assertThat(result.url()).isEqualTo(conteudo.getUrl());
		assertThat(result.modulo().getTitulo()).isEqualTo(conteudo.getModulo().getTitulo());
	}
	
	
	@Test
	void deveConverterDeConteudoRecordParaConteudo() {
//		Quando converter Conteudo para ConteudoRecord
		Conteudo result = conteudoMapper.toConteudo(conteudoRecord);
		
//		Então os campos devem ser iguais
		assertThat(result).isNotNull();
		assertThat(result.getTitulo()).isEqualTo(conteudoRecord.titulo());
		assertThat(result.getTipo()).isEqualTo(conteudoRecord.tipo());
		assertThat(result.getUrl()).isEqualTo(conteudoRecord.url());
		assertThat(result.getModulo().getTitulo()).isEqualTo(conteudoRecord.modulo().getTitulo());
	}
	
	
	
	@Test
	void deveConverterListaDeConteudoParaConteudoRecord() {
//		Given
		List<Conteudo> conteudos = List.of(conteudo);
		
//		When
		List<ConteudoRecord> result = conteudoMapper.toListConteudoRecord(conteudos);
		
//		Then
		assertThat(result).isNotNull();
		assertThat(result).hasSize(conteudos.size());
		assertThat(result.get(0).titulo()).isEqualTo(conteudos.get(0).getTitulo());
		assertThat(result.get(0).url()).isEqualTo(conteudos.get(0).getUrl());
		assertThat(result.get(0).modulo().getTitulo()).isEqualTo(conteudos.get(0).getModulo().getTitulo());
	}
	
	
	@Test
	void deveConverterListaDeConteudoRecordParaConteudo() {
//		Given
		List<ConteudoRecord> conteudos = List.of(conteudoRecord);
		
//		When
		List<Conteudo> result = conteudoMapper.toListConteudo(conteudos);
		
//		Then
		assertThat(result).isNotNull();
		assertThat(result).hasSize(conteudos.size());
		assertThat(result.get(0).getTitulo()).isEqualTo(conteudos.get(0).titulo());
		assertThat(result.get(0).getUrl()).isEqualTo(conteudos.get(0).url());
		assertThat(result.get(0).getModulo().getTitulo()).isEqualTo(conteudos.get(0).modulo().getTitulo());
	}	
	
	
}
