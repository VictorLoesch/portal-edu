package br.com.portaledu.mapper;

import static org.assertj.core.api.Assertions.assertThat;

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

import br.com.portaledu.dto.ProfessorRecord;
import br.com.portaledu.model.Professor;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class ProfessorMapperteste {
	
	@Mock
	CursoMapper cursoMapper;
	
	@InjectMocks
	ProfessorMapper professorMapper = Mappers.getMapper(ProfessorMapper.class);
	
	private Professor professor;
    private ProfessorRecord professorRecord;

    @BeforeEach
    void setUp() {
        // Setup do objeto Professor
        professor = new Professor();
        professor.setNome("João");
        professor.setEmail("joao@gmail.com");
        professor.setCursos(Collections.emptyList());

        // Setup do objeto ProfessorRecord
        professorRecord = new ProfessorRecord("João", "joao@gmail.com", Collections.emptyList());
    }
	
    @Test
    void deveConverterProfessorParaProfessorRecord() {

        // When
        ProfessorRecord result = professorMapper.toProfessorRecord(professor);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.nome()).isEqualTo(professor.getNome());
        assertThat(result.email()).isEqualTo(professor.getEmail());
        assertThat(result.cursos()).hasSameSizeAs(professor.getCursos());
    }

    @Test
    void deveConverterListaDeProfessoresParaListaDeProfessorRecord() {
        // Given
        List<Professor> professors = List.of(professor);

        // When
        List<ProfessorRecord> result = professorMapper.toListProfessorRecord(professors);

        // Then
        assertThat(result).isNotNull();
        assertThat(result).hasSize(1);
        assertThat(result.get(0).nome()).isEqualTo(professor.getNome());
        assertThat(result.get(0).email()).isEqualTo(professor.getEmail());
    }

    @Test
    void deveConverterProfessorRecordParaProfessor() {
        // When
        Professor result = professorMapper.toProfessor(professorRecord);

        // Then: Verificar que os campos foram corretamente mapeados
        assertThat(result).isNotNull();
        assertThat(result.getNome()).isEqualTo(professorRecord.nome());
        assertThat(result.getEmail()).isEqualTo(professorRecord.email());
    }

    
    @Test
    void deveConverterListaDeProfessorRecordParaListaDeProfessor() {
        // Given
        List<ProfessorRecord> professorRecords = List.of(professorRecord);

        // When
        List<Professor> result = professorMapper.toListProfessors(professorRecords);

        // Then
        assertThat(result).isNotNull();
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getNome()).isEqualTo(professorRecord.nome());
        assertThat(result.get(0).getEmail()).isEqualTo(professorRecord.email());
    }
	
}
