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



INSERT INTO lista_contatti (nome, cognome, indirizzo, telefono, eta, username)
VALUES ('Mario', 'Rossi', 'Via Roma 12, Roma', '+391234567890', 35, 'mario.rossi');


INSERT INTO lista_contatti (nome, cognome, indirizzo, telefono, eta, username)
VALUES ('Luca', 'Bianchi', 'Corso Venezia 11, Milano', '+391234567891', 40, 'lucaB88');


INSERT INTO lista_contatti (nome, cognome, indirizzo, telefono, eta, username)
VALUES ('Giulia', 'Verdi', 'Piazza del Popolo 5, Napoli', '+391234567892', 28, 'giuliaV23');


INSERT INTO lista_contatti (nome, cognome, indirizzo, telefono, eta, username)
VALUES ('Sofia', 'Neri', 'Via Larga 22, Firenze', '+391234567893', 30, 'sofia_neri');





CREATE TABLE users (
    username VARCHAR(30) PRIMARY KEY,
    password VARCHAR(255) NOT NULL
);

