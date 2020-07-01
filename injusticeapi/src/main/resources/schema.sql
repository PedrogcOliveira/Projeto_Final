DROP TABLE IF EXISTS personagem;

CREATE TABLE personagem (
		 id_personagem BIGINT AUTO_INCREMENT NOT NULL,
		 nome VARCHAR(255) NULL,
         descricao VARCHAR(500) NULL,
         habilidade VARCHAR(255) NULL,
		 forca INTEGER NULL,
         defesa INTEGER NULL,
		 PRIMARY KEY (id_personagem));