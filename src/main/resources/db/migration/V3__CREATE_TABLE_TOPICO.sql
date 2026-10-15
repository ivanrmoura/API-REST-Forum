CREATE  TABLE topico(
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  titulo VARCHAR(150) NOT NULL,
  mensagem VARCHAR(600) NOT NULL,
  data_criacao datetime  NOT NULL,
  status VARCHAR(30) NOT NULL,
  autor_id BIGINT NOT NULL,
  curso_id BIGINT NOT NULL,
  FOREIGN KEY (autor_id) REFERENCES usuario(id),
  FOREIGN KEY (curso_id) REFERENCES curso(id)
);