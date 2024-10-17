

CREATE TABLE ORIENTADOR (

cod_orient INT PRIMARY KEY NOT NULL, 
nome_orient VARCHAR (50) NOT NULL,
tel_orient VARCHAR (15) NOT NULL,
cep_orient VARCHAR (10) NOT NULL,
sexo_orient CHAR (1) NOT NULL, 
dat_nasc_orient DATE NOT NULL,
 
)

GO


CREATE TABLE PROFESSOR (
 
cod_prof INT PRIMARY KEY NOT NULL,
nome_prof VARCHAR (50) NOT NULL,
tel_prof VARCHAR (15) NOT NULL,
cep_prof VARCHAR (10) NOT NULL,
email_prof VARCHAR (50) NOT NULL, 
sexo_prof CHAR (1) NOT NULL, 
dat_nasc_prof DATE NOT NULL

)
 
GO

CREATE TABLE ALUNO (  

rm_aluno INT PRIMARY KEY NOT NULL,
nome_aluno VARCHAR (50) NOT NULL,
cep_aluno VARCHAR (10) NOT NULL, 
email_aluno VARCHAR (50) NOT NULL,
sexo_aluno CHAR (1) NOT NULL,
data_nasc_aluno DATE NOT NULL,
 
)
 
GO
 


CREATE TABLE LAUDO (

cod_laudo INT PRIMARY KEY NOT NULL,
cod_cid VARCHAR (4) NOT NULL,
nome_laudo VARCHAR (50) NOT NULL,
obs_laudo VARCHAR (100) NOT NULL, 
tipo_defic VARCHAR (50) NOT NULL, 
data_laudo DATE NOT NULL,
rm_aluno INT NOT NULL,
cod_prof INT NOT NULL
 

CONSTRAINT FK_ALUNO_LAUDO FOREIGN KEY (rm_aluno) REFERENCES  Aluno (rm_aluno), 


CONSTRAINT FK_PROF_LAUDO FOREIGN KEY (cod_prof) REFERENCES PROFESSOR (cod_prof),
 
)
 
INSERT ORIENTADOR (cod_orient, nome_orient, tel_orient, cep_orient, sexo_orient, dat_nasc_orient) 
VALUES ('644', 'Bernardo', '1198765-4321','06543-210', 'M', '1984-02-09');
 
 
INSERT PROFESSOR (cod_prof, nome_prof, tel_prof, cep_prof, email_prof, sexo_prof, dat_nasc_prof)
VALUES ( '1000' , 'Professor Alan', '11992020520' , '06639-111' , 'professor.a@example.com' , 'M' , '1975-03-15');
 
 
INSERT INTO ALUNO (rm_aluno, nome_aluno, cep_aluno, email_aluno, sexo_aluno, data_nasc_aluno)
VALUES ( '94444' , 'Clarice' , '06847-123' , 'clarice@example.com' , 'F','2008-11-26' );
 
 
INSERT  LAUDO (cod_laudo, cod_cid, nome_laudo, obs_laudo, tipo_defic, data_laudo, rm_aluno, cod_prof) 
VALUES ( '1973', 'CID1', 'Clarice 1', 'Observação 1', 'Deficiência Tipo 1','2024-10-01','94444','1000');

 
 
SELECT * FROM ORIENTADOR


SELECT * FROM PROFESSOR


SELECT * FROM ALUNO


SELECT * FROM LAUDO



 