DROP DATABASE IF EXISTS avaliado;
CREATE DATABASE avaliado;
USE avaliado;

-- Criação das tabelas

CREATE TABLE TipoPessoa(
	id INT(1) NOT NULL,
	tipo VARCHAR(20) NOT NULL,
	PRIMARY KEY(id) 
);

CREATE TABLE Pessoa(
	matricula INT NOT NULL,
	tipoid INT(1) NOT NULL,
	nome VARCHAR(50) NOT NULL,
	telefone VARCHAR(20),
	email VARCHAR(50) NOT NULL,
	PRIMARY KEY(matricula),
	FOREIGN KEY(tipoid) REFERENCES TipoPessoa(id)
);

CREATE TABLE Usuario(
	matricula INT NOT NULL,
	senha VARCHAR(50) NOT NULL,
	tipoid INT(1) NOT NULL,
	PRIMARY KEY(matricula),
	FOREIGN KEY(matricula) REFERENCES Pessoa(matricula),
	FOREIGN KEY(tipoid) REFERENCES TipoPessoa(id)
);

CREATE TABLE Professor(
	matricula INT NOT NULL,
	notaDidatica INT DEFAULT 0,
	notaProvas INT DEFAULT 0,
	notaPersonalidade INT DEFAULT 0,
	PRIMARY KEY(matricula),
	FOREIGN KEY(matricula) REFERENCES Pessoa(matricula)
);

CREATE TABLE Aluno(
	matricula INT NOT NULL,
	periodo INT NOT NULL,
	PRIMARY KEY(matricula),
	FOREIGN KEY(matricula) REFERENCES Pessoa(matricula)
);

CREATE TABLE Universidade(
	id INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(100),
	sigla VARCHAR(10),
	endereco VARCHAR(100),
	telefone VARCHAR(20),
	notaEstrutura INT DEFAULT 0,
	notaVidaCultural INT DEFAULT 0,
	notaAuxilios INT DEFAULT 0,
	PRIMARY KEY(id)
);

CREATE TABLE Curso(
	id INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(50),
	universidadeID INT NOT NULL,
	notaDificuldade INT DEFAULT 0,
	notaFlexibilidade INT DEFAULT 0,
	notaMercadoDeTrabalho INT DEFAULT 0,
	PRIMARY KEY(id),
	FOREIGN KEY(universidadeID) REFERENCES Universidade(id)
);

CREATE TABLE Disciplina(
	id VARCHAR(20) NOT NULL,
	nome VARCHAR(50),
	cursoID INT NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(cursoID) REFERENCES Curso(id)
);

CREATE TABLE DisciplinaOferta(
	id VARCHAR(20) NOT NULL,
	professorID INT NOT NULL,
	ano INT NOT NULL,
	semestre INT NOT NULL,
	notaRelevancia INT DEFAULT 0,
	notaDificuldade INT DEFAULT 0,
	notaRecomendacao INT DEFAULT 0,
	notaCobranca INT DEFAULT 0,
	PRIMARY KEY(id, professorID, ano, semestre),
	FOREIGN KEY(id) REFERENCES Disciplina(id),
	FOREIGN KEY(professorID) REFERENCES Professor(matricula)
);

CREATE TABLE vinculoAlunoUniversidade(
	universidadeID INT NOT NULL,
	alunoID INT NOT NULL,
	PRIMARY KEY(universidadeID, alunoID),
	FOREIGN KEY(universidadeID) REFERENCES Universidade(id),
	FOREIGN KEY(alunoID) REFERENCES Aluno(matricula)
);

CREATE TABLE vinculoProfessorUniversidade(
	universidadeID INT NOT NULL,
	professorID INT NOT NULL,
	PRIMARY KEY(universidadeID, professorID),
	FOREIGN KEY(universidadeID) REFERENCES Universidade(id),
	FOREIGN KEY(professorID) REFERENCES Professor(matricula)
);

CREATE TABLE vinculoAlunoCurso(
	cursoID INT NOT NULL,
	alunoID INT NOT NULL,
	PRIMARY KEY(cursoID, alunoID),
	FOREIGN KEY(cursoID) REFERENCES Curso(id),
	FOREIGN KEY(alunoID) REFERENCES Aluno(matricula)
);

CREATE TABLE vinculoProfessorCurso(
	cursoID INT NOT NULL,
	professorID INT NOT NULL,
	PRIMARY KEY(cursoID, professorID),
	FOREIGN KEY(cursoID) REFERENCES Curso(id),
	FOREIGN KEY(professorID) REFERENCES Professor(matricula)
);

CREATE TABLE vinculoAlunoDisciplinaOferta(
	disciplinaID VARCHAR(20) NOT NULL,
	professorID INT NOT NULL,
	ano INT NOT NULL,
	semestre INT NOT NULL,
	alunoID INT NOT NULL,
	PRIMARY KEY(disciplinaID, professorID, ano, semestre, alunoID),
	FOREIGN KEY(disciplinaID) REFERENCES Disciplina(id),
	FOREIGN KEY(professorID) REFERENCES Professor(matricula),
	FOREIGN KEY(alunoID) REFERENCES Aluno(matricula)
);

CREATE TABLE AvaliacaoAlunoProfessor(
	matriculaAluno INT NOT NULL,
	matriculaProfessor INT NOT NULL,
	didatica BOOLEAN,
	provas BOOLEAN,
	personalidade BOOLEAN,
	data DATE NOT NULL,
	comentario TEXT,
	PRIMARY KEY(matriculaAluno, matriculaProfessor),
	FOREIGN KEY(matriculaAluno) REFERENCES Aluno(matricula),
	FOREIGN KEY(matriculaProfessor) REFERENCES Professor(matricula)
);

CREATE TABLE AvaliacaoAlunoUniversidade(
	matriculaAluno INT NOT NULL,
	universidadeID INT NOT NULL,
	estrutura BOOLEAN,
	vidaCultural BOOLEAN,
	auxilios BOOLEAN,
	data DATE NOT NULL,
	comentario TEXT,
	PRIMARY KEY(matriculaAluno, universidadeID),
	FOREIGN KEY(matriculaAluno) REFERENCES Aluno(matricula),
	FOREIGN KEY(universidadeID) REFERENCES Universidade(id)
);

CREATE TABLE AvaliacaoProfessorUniversidade(
	matriculaProfessor INT NOT NULL,
	universidadeID INT NOT NULL,
	estrutura BOOLEAN,
	vidaCultural BOOLEAN,
	auxilios BOOLEAN,
	data DATE NOT NULL,
	comentario TEXT,
	PRIMARY KEY(matriculaProfessor, universidadeID),
	FOREIGN KEY(matriculaProfessor) REFERENCES Professor(matricula),
	FOREIGN KEY(universidadeID) REFERENCES Universidade(id)
);

CREATE TABLE AvaliacaoAlunoCurso(
	matriculaAluno INT NOT NULL,
	cursoID INT NOT NULL,
	dificuldade BOOLEAN,
	flexibilidade BOOLEAN,
	mercadoDeTrabalho BOOLEAN,
	data DATE NOT NULL,
	comentario TEXT,
	PRIMARY KEY(matriculaAluno, cursoID),
	FOREIGN KEY(matriculaAluno) REFERENCES Aluno(matricula),
	FOREIGN KEY(cursoID) REFERENCES Curso(id)
);

CREATE TABLE AvaliacaoProfessorCurso(
	matriculaProfessor INT NOT NULL,
	cursoID INT NOT NULL,
	dificuldade BOOLEAN,
	flexibilidade BOOLEAN,
	mercadoDeTrabalho BOOLEAN,
	data DATE NOT NULL,
	comentario TEXT,
	PRIMARY KEY(matriculaProfessor, cursoID),
	FOREIGN KEY(matriculaProfessor) REFERENCES Professor(matricula),
	FOREIGN KEY(cursoID) REFERENCES Curso(id)
);

-- CREATE TABLE AvaliacaoAlunoDisciplina(
-- 	matriculaAluno INT NOT NULL,
-- 	disciplinaID VARCHAR(20) NOT NULL,
-- 	relevancia BOOLEAN,
-- 	dificuldade BOOLEAN,
-- 	ofertaBibliografia BOOLEAN,
-- 	data DATE NOT NULL,
-- 	PRIMARY KEY(matriculaAluno, disciplinaID),
-- 	FOREIGN KEY(matriculaAluno) REFERENCES Aluno(matricula),
-- 	FOREIGN KEY(disciplinaID) REFERENCES Disciplina(id)
-- );

CREATE TABLE AvaliacaoAlunoDisciplinaOferta(
	matriculaAluno INT NOT NULL,
	disciplinaID VARCHAR(20) NOT NULL,
	professorID INT NOT NULL,
	ano INT NOT NULL,
	semestre INT NOT NULL,
	relevancia BOOLEAN,
	dificuldade BOOLEAN,
	recomendacao BOOLEAN,
	cobranca BOOLEAN,
	data DATE NOT NULL,
	comentario TEXT,
	PRIMARY KEY(matriculaAluno, disciplinaID, professorID, ano, semestre),
	FOREIGN KEY(matriculaAluno) REFERENCES Aluno(matricula),
	FOREIGN KEY(disciplinaID) REFERENCES Disciplina(id),
	FOREIGN KEY(professorID) REFERENCES Professor(matricula)
);

-- Inserir subtipos de pessoas no sistema
INSERT INTO TipoPessoa VALUES (0, "Professor");
INSERT INTO TipoPessoa VALUES (1, "Aluno");

-- Inserir professor
INSERT INTO Pessoa VALUES(1111111111, 0, "Joao", NULL, "joao@email.com");
INSERT INTO Usuario VALUES (1111111111, "123", 0);
INSERT INTO Professor VALUES (1111111111, NULL, NULL, NULL);

INSERT INTO Pessoa VALUES(1111111112, 0, "Maria", NULL, "maria@email.com");
INSERT INTO Usuario VALUES (1111111112, "123", 0);
INSERT INTO Professor VALUES (1111111112, NULL, NULL, NULL);

INSERT INTO Pessoa VALUES(1111111113, 0, "Paulo", NULL, "paulo@email.com");
INSERT INTO Usuario VALUES (1111111113, "123", 0);
INSERT INTO Professor VALUES (1111111113, NULL, NULL, NULL);

-- Inserir alunos
INSERT INTO Pessoa VALUES(2014044145, 1, "Carlos Antonio", "84999436881", "carlosantonio.o.n@outlook.com");
INSERT INTO Usuario VALUES (2014044145, "123", 1);
INSERT INTO Aluno VALUES(2014044145, 5);

INSERT INTO Pessoa VALUES(2013019596, 1, "Francleide Peixoto", "84981538006", "francleidepsimao@gmail.com");
INSERT INTO Usuario VALUES (2013019596, "123", 1);
INSERT INTO Aluno VALUES(2013019596, 8);

INSERT INTO Pessoa VALUES(2015044005, 1, "Jonathan Rocha", "84996222783", "jonathan.rocha@msn.com");
INSERT INTO Usuario VALUES (2015044005, "123", 1);
INSERT INTO Aluno VALUES(2015044005, 5);

-- Inserir Universidade
INSERT INTO Universidade VALUES(NULL, "Universidade Federal do Rio Grande do Norte", "UFRN", "Campus Universitário Lagoa Nova, CEP 59078-970, Natal/RN - Brasil", "8433422238", NULL, NULL, NULL);

-- Inserir Curso
INSERT INTO Curso VALUES(NULL, "Tecnologia da Informação", 1, NULL, NULL, NULL);

-- Inserir Disciplina
INSERT INTO Disciplina VALUES("DIM0506", "Projeto Detalhado de Software", 1);
INSERT INTO Disciplina VALUES("DIM0541.0", "Banco de Dados", 1);
INSERT INTO Disciplina VALUES("DIM0501", "Boas Práticas de Programação", 1);
INSERT INTO Disciplina VALUES("DIM0507", "Teste de Software I", 1);

-- Inserir Oferta de Disciplina
INSERT INTO DisciplinaOferta VALUES ("DIM0507", 1111111112, 2017, 1, NULL, NULL, NULL, NULL);
INSERT INTO DisciplinaOferta VALUES ("DIM0501", 1111111113, 2017, 1, NULL, NULL, NULL, NULL);

-- Inserir Alunos em Universidade
INSERT INTO vinculoAlunoUniversidade VALUES (1, 2014044145);
INSERT INTO vinculoAlunoUniversidade VALUES (1, 2013019596);
INSERT INTO vinculoAlunoUniversidade VALUES (1, 2015044005);

-- Inserir Professores em Universidade
INSERT INTO vinculoProfessorUniversidade VALUES (1, 1111111111);
INSERT INTO vinculoProfessorUniversidade VALUES (1, 1111111112);
INSERT INTO vinculoProfessorUniversidade VALUES (1, 1111111113);

-- Inserir Alunos em Curso
INSERT INTO vinculoAlunoCurso VALUES(1, 2014044145);
INSERT INTO vinculoAlunoCurso VALUES(1, 2013019596);
INSERT INTO vinculoAlunoCurso VALUES(1, 2015044005);

-- Inserir Professores em Curso
INSERT INTO vinculoProfessorCurso VALUES (1, 1111111111);
INSERT INTO vinculoProfessorCurso VALUES (1, 1111111112);
INSERT INTO vinculoProfessorCurso VALUES (1, 1111111113);

-- Inserir Aluno em Disciplina
INSERT INTO vinculoAlunoDisciplinaOferta VALUES("DIM0507", 1111111112, 2017, 1, 2014044145);
INSERT INTO vinculoAlunoDisciplinaOferta VALUES("DIM0507", 1111111112, 2017, 1, 2013019596);
INSERT INTO vinculoAlunoDisciplinaOferta VALUES("DIM0507", 1111111112, 2017, 1, 2015044005);

-- Inserir notas dos alunos para o professor 111111111
INSERT INTO AvaliacaoAlunoProfessor VALUES (2014044145, 1111111111, true, false, false, NOW(), NULL);
INSERT INTO AvaliacaoAlunoProfessor VALUES (2013019596, 1111111111, true, false, true, NOW(), NULL);
INSERT INTO AvaliacaoAlunoProfessor VALUES (2015044005, 1111111111, true, true, true, NOW(), NULL);

-- Inserir notas dos alunos para o professor 111111112
INSERT INTO AvaliacaoAlunoProfessor VALUES (2014044145, 1111111112, true, true, true, NOW(), NULL);

-- Inserir notas para a universidade 1
INSERT INTO AvaliacaoAlunoUniversidade VALUES (2014044145, 1, true, true, true, NOW(), NULL);
INSERT INTO AvaliacaoProfessorUniversidade VALUES (1111111111, 1, false, false, false, NOW(), NULL);

-- Inserir notas para o curso 1
INSERT INTO AvaliacaoAlunoCurso VALUES (2014044145, 1, true, true, true, NOW(), NULL);
INSERT INTO AvaliacaoProfessorCurso VALUES (1111111111, 1, false, false, false, NOW(), NULL);

-- Inserir notas para a disciplina teste de software
INSERT INTO AvaliacaoAlunoDisciplinaOferta VALUES (2014044145, "DIM0507", 1111111112, 2017, 1, true, true, true, true, NOW(), NULL);

-- Exibir todos os alunos
SELECT * FROM Pessoa JOIN Aluno USING(matricula);

-- Exibir todos os professores antes de alterações
SELECT * FROM Pessoa JOIN Professor USING(matricula);

-- Atualizar notas de professores
DELIMITER $$

DROP PROCEDURE IF EXISTS atualizar_notas $$
CREATE PROCEDURE atualizar_notas(IN m INT)
	BEGIN
		UPDATE Professor SET notaDidatica = (SELECT COUNT(*) FROM AvaliacaoAlunoProfessor WHERE (didatica=true OR didatica=false) AND matriculaProfessor=m) WHERE matricula=m;
		UPDATE Professor SET notaProvas = (SELECT COUNT(*) FROM AvaliacaoAlunoProfessor WHERE (provas=true OR provas=false) AND matriculaProfessor=m) WHERE matricula=m;
		UPDATE Professor SET notaPersonalidade = (SELECT COUNT(*) FROM AvaliacaoAlunoProfessor WHERE (personalidade=true OR personalidade=false) AND matriculaProfessor=m) WHERE matricula=m;
		END $$
DELIMITER ;

CALL atualizar_notas(1111111111);
CALL atualizar_notas(1111111112);

-- Atualizar notas de universidades
DELIMITER $$

DROP PROCEDURE IF EXISTS atualizar_notas_universidade $$
CREATE PROCEDURE atualizar_notas_universidade(IN i INT)
	BEGIN
		UPDATE Universidade SET notaEstrutura = ((SELECT COUNT(*) FROM AvaliacaoAlunoUniversidade WHERE (estrutura=true OR estrutura=false) AND id=i) + (SELECT COUNT(*) FROM AvaliacaoProfessorUniversidade WHERE (estrutura=true OR estrutura=false) AND id=i)) WHERE id=i;
		UPDATE Universidade SET notaVidaCultural = ((SELECT COUNT(*) FROM AvaliacaoAlunoUniversidade WHERE (vidaCultural=true OR vidaCultural=false) AND id=i) + (SELECT COUNT(*) FROM AvaliacaoProfessorUniversidade WHERE (vidaCultural=true OR vidaCultural=false) AND id=i)) WHERE id=i;
		UPDATE Universidade SET notaAuxilios = ((SELECT COUNT(*) FROM AvaliacaoAlunoUniversidade WHERE (auxilios=true OR auxilios=false) AND id=i) + (SELECT COUNT(*) FROM AvaliacaoProfessorUniversidade WHERE (auxilios=true OR auxilios=false) AND id=i)) WHERE id=i;
		END $$
DELIMITER ;

CALL atualizar_notas_universidade(1);

-- Atualizar notas de cursos
DELIMITER $$

DROP PROCEDURE IF EXISTS atualizar_notas_curso $$
CREATE PROCEDURE atualizar_notas_curso(IN i INT)
	BEGIN
		UPDATE Curso SET notaDificuldade = ((SELECT COUNT(*) FROM AvaliacaoAlunoCurso WHERE (dificuldade=true OR dificuldade=false) AND id=i) + (SELECT COUNT(*) FROM AvaliacaoProfessorCurso WHERE (dificuldade=true OR dificuldade=false) AND id=i)) WHERE id=i;
		UPDATE Curso SET notaFlexibilidade = ((SELECT COUNT(*) FROM AvaliacaoAlunoCurso WHERE (flexibilidade=true OR flexibilidade=false) AND id=i) + (SELECT COUNT(*) FROM AvaliacaoProfessorCurso WHERE (flexibilidade=true OR flexibilidade=false) AND id=i)) WHERE id=i;
		UPDATE Curso SET notaMercadoDeTrabalho = ((SELECT COUNT(*) FROM AvaliacaoAlunoCurso WHERE (mercadoDeTrabalho=true OR mercadoDeTrabalho=false) AND id=i) + (SELECT COUNT(*) FROM AvaliacaoProfessorCurso WHERE (mercadoDeTrabalho=true OR mercadoDeTrabalho=false) AND id=i)) WHERE id=i;
		END $$
DELIMITER ;

CALL atualizar_notas_curso(1);

-- Atualizar notas de disciplinas
DELIMITER $$

DROP PROCEDURE IF EXISTS atualizar_notas_disciplina $$
CREATE PROCEDURE atualizar_notas_disciplina(IN i VARCHAR(20), IN p INT, IN a INT, IN s INT)
	BEGIN
		UPDATE DisciplinaOferta SET notaRelevancia = (SELECT COUNT(*) FROM AvaliacaoAlunoDisciplinaOferta WHERE (relevancia=true OR relevancia=false) AND disciplinaID=i AND professorID=p AND ano=a AND semestre=s) WHERE id=i AND professorID=p AND ano=a AND semestre=s;
		UPDATE DisciplinaOferta SET notaDificuldade = (SELECT COUNT(*) FROM AvaliacaoAlunoDisciplinaOferta WHERE (dificuldade=true OR dificuldade=false) AND disciplinaID=i AND professorID=p AND ano=a AND semestre=s) WHERE id=i AND professorID=p AND ano=a AND semestre=s;
		UPDATE DisciplinaOferta SET notaRecomendacao = (SELECT COUNT(*) FROM AvaliacaoAlunoDisciplinaOferta WHERE (recomendacao=true OR recomendacao=false) AND disciplinaID=i AND professorID=p AND ano=a AND semestre=s) WHERE id=i AND professorID=p AND ano=a AND semestre=s;
		UPDATE DisciplinaOferta SET notaCobranca = (SELECT COUNT(*) FROM AvaliacaoAlunoDisciplinaOferta WHERE (cobranca=true OR cobranca=false) AND disciplinaID=i AND professorID=p AND ano=a AND semestre=s) WHERE id=i AND professorID=p AND ano=a AND semestre=s;
		END $$
DELIMITER ;

CALL atualizar_notas_disciplina("DIM0507", 1111111112, 2017, 1);

-- Exibir professores depois de alterações
SELECT * FROM Pessoa JOIN Professor USING(matricula);

-- Exibir todos as universidades
SELECT * FROM Universidade;

-- Exibir todos os cursos
SELECT * FROM Curso;

-- Exibir todas as Disicplinas
SELECT * FROM Disciplina;

-- Exibir todos as ofertas de disciplinas
SELECT * FROM DisciplinaOferta;









