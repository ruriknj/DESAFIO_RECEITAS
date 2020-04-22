-- Scripts para criação do projeto -- banco: HSQLDB

CREATE TABLE profissional (
  id_pro INTEGER IDENTITY PRIMARY KEY,
   nomePro VARCHAR(100) NOT NULL,
   email VARCHAR(100) NOT NULL,
   senhaLog VARCHAR(20) NOT NULL,
);

CREATE TABLE receita (
   id_rec INTEGER IDENTITY PRIMARY KEY,
   nomeRec  VARCHAR(200) NOT NULL,
   ingrediente VARCHAR(200) NOT NULL,
   quantidade VARCHAR(20) NOT NULL,	
   descricao VARCHAR(7000) NOT NULL,
   id_pro INTEGER,
);

ALTER TABLE receita
ADD FOREIGN KEY (ID_PRO) 
REFERENCES PROFISSIONAL(ID_PRO);

