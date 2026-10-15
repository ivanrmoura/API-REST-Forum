CREATE TABLE resposta
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    mensagem     VARCHAR(255)          NOT NULL,
    autor_id     BIGINT                NULL,
    topico_id    BIGINT                NULL,
    data_criacao datetime              NOT NULL,
    solucao      BIT(1)                NOT NULL,
    CONSTRAINT pk_resposta PRIMARY KEY (id)
);

ALTER TABLE resposta
    ADD CONSTRAINT FK_RESPOSTA_ON_AUTOR FOREIGN KEY (autor_id) REFERENCES usuario (id);

ALTER TABLE resposta
    ADD CONSTRAINT FK_RESPOSTA_ON_TOPICO FOREIGN KEY (topico_id) REFERENCES topico (id);