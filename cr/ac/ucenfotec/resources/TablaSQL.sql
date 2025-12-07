DROP DATABASE IF EXISTS eleccion;
CREATE DATABASE eleccion;
USE eleccion;

CREATE TABLE partido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    siglas VARCHAR(10) NOT NULL UNIQUE
);

CREATE TABLE candidato (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    partido_siglas VARCHAR(10) NOT NULL,
    votos INT DEFAULT 0,
    FOREIGN KEY (partido_siglas) REFERENCES partido(siglas)
);

CREATE TABLE ciudadano (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    cedula VARCHAR(20) NOT NULL UNIQUE,
    yaVoto BOOLEAN DEFAULT FALSE
);

CREATE TABLE voto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ciudadano_cedula VARCHAR(20) NOT NULL,
    candidato_id INT NOT NULL,
    FOREIGN KEY (ciudadano_cedula) REFERENCES ciudadano(cedula),
    FOREIGN KEY (candidato_id) REFERENCES candidato(id)
);