CREATE DATABASE IF NOT EXISTS rubrica;
USE rubrica;

CREATE TABLE lista_contatti (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cognome VARCHAR(255) NOT NULL,
    indirizzo VARCHAR(255),
    telefono VARCHAR(255),
    eta INT
);