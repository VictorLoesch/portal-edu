package br.com.portaledu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.portaledu.dto.AlunoRecord;
import br.com.portaledu.mapper.AlunoMapper;
import br.com.portaledu.model.Aluno;
import br.com.portaledu.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private AlunoMapper alunoMapper;
	
	
	public List<AlunoRecord> getListarTodosAlunos(){
		List<Aluno> alunos = alunoRepository.findAll();
		List<AlunoRecord> result = alunoMapper.toListAlunoRecord(alunos);
		return result;
	}

	public AlunoRecord getPesquisaAlunoPorEmail(AlunoRecord alunoRecord) {
		Aluno aluno = alunoRepository.findByEmail(alunoRecord.email());
		AlunoRecord result = alunoMapper.toAlunoRecord(aluno);
		return result;
	}
	
	public AlunoRecord AtualizarAluno(Aluno aluno) {
		Aluno alunoResult = alunoRepository.findByEmail(aluno.getEmail());
		alunoResult.setNome(aluno.getNome());
		alunoResult.setEmail(aluno.getEmail());
		aluno = alunoRepository.save(aluno);
		AlunoRecord result = alunoMapper.toAlunoRecord(aluno);
		return result;
	}
	
	public AlunoRecord salvarAluno(Aluno aluno) {
		aluno = alunoRepository.save(aluno);
		AlunoRecord result = alunoMapper.toAlunoRecord(aluno);
		return result;
	}
	
	
	public void excluirAlunoPorEmail(AlunoRecord aluno) {
		alunoRepository.deleteByEmail(aluno.email());
	}
	
	
	
}
