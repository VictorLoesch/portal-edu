package br.com.portaledu.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;


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

import br.com.portaledu.dto.CursoRecord;
import br.com.portaledu.dto.ProfessorRecord;
import br.com.portaledu.model.Curso;
import br.com.portaledu.model.Professor;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
class CursoMapperTest {

	@Mock
	private ModuloMapper moduloMapper;

	@InjectMocks
	private CursoMapper cursoMapper = Mappers.getMapper(CursoMapper.class);

	private Curso curso;
	private CursoRecord cursoRecord;

	@BeforeEach
	void setUp() {

		// Configurando objeto Curso
		curso = new Curso();
		curso.setTitulo("Curso de Java");
		curso.setDescricao("Curso completo de Java para iniciantes");
		curso.setProfessor(Professor.builder().nome("Prof. João").build());
		curso.setModulos(Collections.emptyList()); 

		// Configurando objeto CursoRecord
		cursoRecord = new CursoRecord("Curso de Java", "Curso completo de Java para iniciantes",
				Collections.emptyList(), new ProfessorRecord("Prof. João", null, null));
	}

	@Test
	void deveConverterCursoParaCursoRecord() {
		// Quando converter Curso para CursoRecord
		CursoRecord result = cursoMapper.toCursoRecord(curso);

		// Então os campos devem ser iguais
		assertThat(result).isNotNull();
		assertThat(result.titulo()).isEqualTo(curso.getTitulo());
		assertThat(result.descricao()).isEqualTo(curso.getDescricao());
		assertThat(result.professor().nome()).isEqualTo(curso.getProfessor().getNome());
		assertThat(result.modulos()).isEmpty();
	}

	@Test
	void deveConverterListaDeCursoParaListaDeCursoRecord() {
		// Dada uma lista de Curso
		List<Curso> cursos = List.of(curso);

		// Quando converter a lista de Curso para CursoRecord
		List<CursoRecord> result = cursoMapper.toListCursoRecord(cursos);

		// Então a lista deve ser mapeada corretamente
		assertThat(result).isNotNull();
		assertThat(result).hasSize(1);
		assertThat(result.get(0).titulo()).isEqualTo(curso.getTitulo());
	}

	@Test
	void deveConverterCursoRecordParaCurso() {
		// Quando converter CursoRecord para Curso
		Curso result = cursoMapper.toCurso(cursoRecord);

		// Então os campos devem ser iguais
		assertThat(result).isNotNull();
		assertThat(result.getTitulo()).isEqualTo(cursoRecord.titulo());
		assertThat(result.getDescricao()).isEqualTo(cursoRecord.descricao());
		assertThat(result.getProfessor().getNome()).isEqualTo(cursoRecord.professor().nome());
		assertThat(result.getModulos()).isEmpty();
	}

	@Test
	void deveConverterListaDeCursoRecordParaListaDeCurso() {
		// Dada uma lista de CursoRecord
		List<CursoRecord> cursoRecords = List.of(cursoRecord);

		// Quando converter a lista de CursoRecord para Curso
		List<Curso> result = cursoMapper.toListCurso(cursoRecords);

		// Então a lista deve ser mapeada corretamente
		assertThat(result).isNotNull();
		assertThat(result).hasSize(1);
		assertThat(result.get(0).getTitulo()).isEqualTo(cursoRecord.titulo());
	}

}
