CREATE TABLE Cliente(
    numero_documento number(15) NOT NULL,
    numero_habitacion varchar2(20),
    PRIMARY KEY(numero_documento),
    FOREIGN KEY(numero_documento) REFERENCES Usuario(numero_documento),
    FOREIGN KEY(numero_habitacion) REFERENCES Habitacion(numero),
);