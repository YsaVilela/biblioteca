-- Tabela: Endereco
CREATE TABLE TB_ENDERECO (
    ID SERIAL PRIMARY KEY,
    Rua VARCHAR(255) NOT NULL,
    Bairro VARCHAR(255) NOT NULL,
    Numero INT NOT NULL,
    Complemento VARCHAR(255),
    CEP VARCHAR(10) NOT NULL
);

-- Tabela: Leitor
CREATE TABLE TB_Leitor (
    IDCliente SERIAL PRIMARY KEY,
    Nome VARCHAR(255) NOT NULL,
    Email VARCHAR(255) UNIQUE NOT NULL,
    Telefone VARCHAR(30),
	FK_ENDERECO integer not null,
		foreign key (FK_ENDERECO)
		references  TB_ENDERECO(ID), 
	data_nascimento DATE,
    Status BOOLEAN NOT NULL
);

-- Tabela: Autor
CREATE TABLE TB_Autor (
    IDAutor SERIAL PRIMARY KEY,
    Nome VARCHAR(255) NOT NULL,
    data_nascimento DATE,
    Nacionalidade VARCHAR(255)
);

-- Tabela: Livro
CREATE TABLE TB_Livro (
    IDLivro SERIAL PRIMARY KEY,
    Nome VARCHAR(255) NOT NULL,
    Sinopse TEXT,
    Versao VARCHAR(255),
    DataLancamento DATE,
    IDAutor INT REFERENCES TB_Autor(IDAutor),
    Genero VARCHAR(255),
    IndicacaoIdade INT
);

-- Tabela: Exemplar
CREATE TABLE TB_Exemplar (
    IDExemplar SERIAL PRIMARY KEY,
    IDLivro INT NOT NULL REFERENCES TB_Livro(IDLivro),
    EstadoConservacao INT,
    Status VARCHAR(255)
);

-- Tabela: Emprestimo
CREATE TABLE TB_Emprestimo (
    IDLocacao SERIAL PRIMARY KEY,
    IDExemplar INT NOT NULL REFERENCES TB_Exemplar(IDExemplar),
    IDLeitor INT NOT NULL REFERENCES TB_Leitor(IDCliente),
    DataEmprestimo DATE NOT NULL,
    DataPrevistaDevolucao DATE NOT NULL,
    DataDevolucao DATE,
    Status VARCHAR(255) NOT NULL
);

drop table TB_Emprestimo, TB_Exemplar, TB_Livro, TB_Autor, TB_Leitor, TB_Endereco