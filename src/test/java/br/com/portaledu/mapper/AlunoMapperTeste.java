package br.com.portaledu.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.portaledu.dto.AlunoRecord;
import br.com.portaledu.model.Aluno;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
class AlunoMapperTeste {

	@Mock
	CursoMapper cursoMapper;
	
	@InjectMocks
	AlunoMapper alunoMapper = Mappers.getMapper(AlunoMapper.class);
	
	private Aluno aluno;
    private AlunoRecord alunoRecord;

    @BeforeEach
    void setUp() {
        // Setup do objeto Aluno
        aluno = new Aluno();
        aluno.setNome("João");
        aluno.setEmail("joao@gmail.com");
        aluno.setCursos(Collections.emptyList());

        // Setup do objeto AlunoRecord
        alunoRecord = new AlunoRecord("João", "joao@gmail.com", Collections.emptyList());
    }
    
    @Test
    void deveConverterAlunoParaAlunoRecord() {

        // When
        AlunoRecord result = alunoMapper.toAlunoRecord(aluno);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.nome()).isEqualTo(aluno.getNome());
        assertThat(result.email()).isEqualTo(aluno.getEmail());
        assertThat(result.cursos()).hasSameSizeAs(aluno.getCursos());
    }

    @Test
    void deveConverterListaDeAlunoParaListaDeAlunoRecord() {
        // Given
        List<Aluno> alunos = List.of(aluno);

        // When
        List<AlunoRecord> result = alunoMapper.toListAlunoRecord(alunos);

        // Then
        assertThat(result).isNotNull();
        assertThat(result).hasSize(1);
        assertThat(result.get(0).nome()).isEqualTo(aluno.getNome());
        assertThat(result.get(0).email()).isEqualTo(aluno.getEmail());
    }

    @Test
    void deveConverterAlunoRecordParaAluno() {
        // When
        Aluno result = alunoMapper.toAluno(alunoRecord);

        // Then: Verificar que os campos foram corretamente mapeados
        assertThat(result).isNotNull();
        assertThat(result.getNome()).isEqualTo(alunoRecord.nome());
        assertThat(result.getEmail()).isEqualTo(alunoRecord.email());
    }

    
    @Test
    void deveConverterListaDeAlunoRecordParaListaDeAluno() {
        // Given
        List<AlunoRecord> alunoRecords = List.of(alunoRecord);

        // When
        List<Aluno> result = alunoMapper.toListAlunos(alunoRecords);

        // Then
        assertThat(result).isNotNull();
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getNome()).isEqualTo(alunoRecord.nome());
        assertThat(result.get(0).getEmail()).isEqualTo(alunoRecord.email());
    }

} 
