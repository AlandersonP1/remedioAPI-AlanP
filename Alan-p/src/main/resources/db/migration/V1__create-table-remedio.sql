CREATE TABLE remedio (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    via VARCHAR(100) NOT NULL,
    lote VARCHAR(100) NOT NULL,
    quantidade VARCHAR(100) NOT NULL,
    validade int(20) NOT NULL,
    laboratorio VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);
