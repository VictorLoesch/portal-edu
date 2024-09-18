ALTER TABLE conteudo
ADD CONSTRAINT FK_Modulo FOREIGN KEY (modulo_id) REFERENCES modulo (id);

ALTER TABLE modulo
ADD CONSTRAINT FK_Curso FOREIGN KEY (curso_id) REFERENCES curso (id);

ALTER TABLE curso
ADD CONSTRAINT FK_Professor FOREIGN KEY (professor_id) REFERENCES professor (id);

CREATE TABLE curso_aluno (
    curso_id BIGINT NOT NULL,
    aluno_id BIGINT NOT NULL,
    PRIMARY KEY (curso_id, aluno_id),
    FOREIGN KEY (curso_id) REFERENCES curso (id),
    FOREIGN KEY (aluno_id) REFERENCES aluno (id)
);