DROP DATABASE IF EXISTS avaliado;
CREATE DATABASE avaliado;
USE avaliado;

-- Criação das tabelas

/*CREATE TABLE TipoPessoa(
	id CHAR(1) NOT NULL,
	tipo VARCHAR(20) NOT NULL,
	PRIMARY KEY(id) 
);*/

CREATE TABLE Pessoa(
	matricula INT NOT NULL,
	/*tipoid CHAR(1) NOT NULL,*/
	nome VARCHAR(50) NOT NULL,
	telefone INT,
	email VARCHAR(50) NOT NULL,
	PRIMARY KEY(matricula)/*,
	FOREIGN KEY(tipoid) REFERENCES TipoPessoa(id)*/
);

CREATE TABLE Professor(
	matricula INT NOT NULL,
	didatica_like INT DEFAULT 0,
	didatica_dislike INT DEFAULT 0,
	provas_like INT DEFAULT 0,
	provas_dislike INT DEFAULT 0,
	personalidade_like INT DEFAULT 0,
	personalidade_dislike INT DEFAULT 0,
	PRIMARY KEY(matricula),
	FOREIGN KEY(matricula) REFERENCES Pessoa(matricula)
);

CREATE TABLE Aluno(
	matricula INT NOT NULL,
	periodo INT NOT NULL,
	PRIMARY KEY(matricula),
	FOREIGN KEY(matricula) REFERENCES Pessoa(matricula)
);

CREATE TABLE AvaliacaoAlunoProfessor(
	matriculaAluno INT NOT NULL,
	matriculaProfessor INT NOT NULL,
	didatica BOOLEAN,
	provas BOOLEAN,
	personalidade BOOLEAN,
	data DATE NOT NULL,
	PRIMARY KEY(matriculaAluno, matriculaProfessor),
	FOREIGN KEY(matriculaAluno) REFERENCES Aluno(matricula),
	FOREIGN KEY(matriculaProfessor) REFERENCES Professor(matricula)
);

-- Inserir subtipos de pessoas no sistema
-- INSERT INTO TipoPessoa VALUES (1, "Professor");
-- INSERT INTO TipoPessoa VALUES (2, "Aluno");

-- Inserir professor
INSERT INTO Pessoa VALUES(1111111111, /*1,*/ "Joao", NULL, "joao@email.com");
INSERT INTO Professor VALUES (1111111111, NULL, NULL, NULL, NULL, NULL, NULL);

INSERT INTO Pessoa VALUES(1111111112, /*1,*/ "Maria", NULL, "maria@email.com");
INSERT INTO Professor VALUES (1111111112, NULL, NULL, NULL, NULL, NULL, NULL);

-- Inserir alunos
INSERT INTO Pessoa VALUES(2014044145, /*2,*/ "Carlos Antonio", "999436881", "carlosantonio.o.n@outlook.com");
INSERT INTO Aluno VALUES(2014044145, 5);

INSERT INTO Pessoa VALUES(2013019596, /*2,*/ "Francleide Peixoto", "981538006", "francleidepsimao@gmail.com");
INSERT INTO Aluno VALUES(2013019596, 8);

INSERT INTO Pessoa VALUES(2015044005, /*2,*/ "Jonathan Rocha", "996222783", "jonathan.rocha@msn.com");
INSERT INTO Aluno VALUES(2015044005, 5);

-- Inserir notas dos alunos para o professor 111111111
INSERT INTO AvaliacaoAlunoProfessor VALUES (2014044145, 1111111111, true, false, false, NOW());
INSERT INTO AvaliacaoAlunoProfessor VALUES (2013019596, 1111111111, true, false, true, NOW());
INSERT INTO AvaliacaoAlunoProfessor VALUES (2015044005, 1111111111, true, true, true, NOW());

-- Inserir notas dos alunos para o professor 111111112
INSERT INTO AvaliacaoAlunoProfessor VALUES (2014044145, 1111111112, true, true, true, NOW());

-- Exibir todos os alunos
SELECT * FROM Pessoa JOIN Aluno USING(matricula);

-- Exibir todos os professores antes de alterações
SELECT * FROM Pessoa JOIN Professor USING(matricula);

-- Atualizar notas de professores
DELIMITER $$

DROP PROCEDURE IF EXISTS atualizar_notas $$
CREATE PROCEDURE atualizar_notas(IN m INT)
	BEGIN
		UPDATE Professor SET didatica_like = (SELECT COUNT(*) FROM AvaliacaoAlunoProfessor WHERE didatica=true AND matriculaProfessor=m) WHERE matricula=m;
		UPDATE Professor SET didatica_dislike = (SELECT COUNT(*) FROM AvaliacaoAlunoProfessor WHERE didatica=false AND matriculaProfessor=m) WHERE matricula=m;
		UPDATE Professor SET provas_like = (SELECT COUNT(*) FROM AvaliacaoAlunoProfessor WHERE provas=true AND matriculaProfessor=m) WHERE matricula=m;
		UPDATE Professor SET provas_dislike = (SELECT COUNT(*) FROM AvaliacaoAlunoProfessor WHERE provas=false AND matriculaProfessor=m) WHERE matricula=m;
		UPDATE Professor SET personalidade_like = (SELECT COUNT(*) FROM AvaliacaoAlunoProfessor WHERE personalidade=true AND matriculaProfessor=m) WHERE matricula=m;
		UPDATE Professor SET personalidade_dislike = (SELECT COUNT(*) FROM AvaliacaoAlunoProfessor WHERE personalidade=false AND matriculaProfessor=m) WHERE matricula=m;
		END $$
DELIMITER ;

CALL atualizar_notas(1111111111);
CALL atualizar_notas(1111111112);


-- Exibir professores depois de alterações
SELECT * FROM Pessoa JOIN Professor USING(matricula);







