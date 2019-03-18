CREATE TABLE Usuario(
    tipo_documento varchar2(100) NOT NULL,
    numero_documento number(15) NOT NULL,
    nombre varchar2(50) NOT NULL,
    correo varchar(100) UNIQUE NOT NULL,
    rol number(20) NOT NULL,
    id_hotel number(20) NOT NULL,
    PRIMARY KEY(numero_documento),
    FOREIGN KEY(rol) REFERENCES Rol(id),
    FOREIGN KEY(id_hotel) REFERENCES Hotel(id),
    CHECK(numero_documento > 0)
);