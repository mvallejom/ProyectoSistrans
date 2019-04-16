CREATE TABLE Hotel(
    id number(20) GENERATED BY DEFAULT AS IDENTITY,
    nombre varchar2(250),
    PRIMARY KEY(id)
);

CREATE TABLE TipoHabitacion(
    id number(20) GENERATED BY DEFAULT AS IDENTITY,
    tipo varchar(50) UNIQUE NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE PlanConsumo (
    id number(20) GENERATED BY DEFAULT AS IDENTITY,
    tipo_plan varchar2(100) NOT NULL,
    descripcion varchar2(300) NOT NULL,
    id_hotel number(20)NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(id_hotel) REFERENCES Hotel(id),
    CHECK(LENGTH(TRIM(tipo_plan)) != 0),
    CHECK(LENGTH(TRIM(descripcion)) != 0)
);

CREATE TABLE Habitacion(
    numero varchar2(20) PRIMARY KEY NOT NULL,
    descripcion varchar2(300) NOT NULL,
    capacidad integer NOT NULL,
    tipo_habitacion number(20) NOT NULL,
    costo_noche number(15) NOT NULL,
    cuenta number(15) NOT NULL,
    id_hotel number(20) NOT NULL,
    plan_consumo number(20),
    FOREIGN KEY(tipo_habitacion) REFERENCES TipoHabitacion(id),
    FOREIGN KEY(id_hotel) REFERENCES Hotel(id),
    FOREIGN KEY(plan_consumo) REFERENCES PlanConsumo(id),
    CHECK(capacidad > 0),
    CHECK(costo_noche > 0),
    CHECK(cuenta >= 0)
);

CREATE TABLE Lugar(
	id number(20) GENERATED BY DEFAULT AS IDENTITY,
	nombre varchar2(100),
	PRIMARY KEY(id)
);

CREATE TABLE Consumo(
    id number(20) GENERATED BY DEFAULT AS IDENTITY,
    lugar number(20) NOT NULL,
    costo_total number(10),
    numero_habitacion varchar2(20) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(lugar) REFERENCES Lugar(id),
    FOREIGN KEY(numero_habitacion) REFERENCES Habitacion(numero),
    CHECK(costo_total >= 0)
);

CREATE TABLE ServicioHotel(
    id number(20) GENERATED BY DEFAULT AS IDENTITY,
    nombre varchar2(100) NOT NULL,
    hora_apertura varchar2(20) NOT NULL,
    hora_cierre varchar2(20) NOT NULL,
    descripcion varchar2(300) NOT NULL,
    capacidad number(6) NOT NULL,
    costo number(10),
    lugar number(20) NOT NULL,
    disponible integer NOT NULL,
    id_hotel number(20) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(lugar) REFERENCES Lugar(id),
    FOREIGN KEY(id_hotel) REFERENCES Hotel(id),
    CHECK(capacidad > 0),
    CHECK(costo >= 0),
    CHECK(disponible >= 0),
    CHECK(disponible <= capacidad)
);

CREATE TABLE Producto(
    id number(20) GENERATED BY DEFAULT AS IDENTITY,
    nombre varchar2(50) NOT NULL,
    costo number(10) NOT NULL,
    id_servicio number(20) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(id_servicio) REFERENCES ServicioHotel(id),
    CHECK(costo > 0)
);

CREATE TABLE ProductosConsumo(
    id_consumo number(20) NOT NULL,
    id_producto number(20) NOT NULL,
    PRIMARY KEY(id_consumo, id_producto),
    FOREIGN KEY(id_consumo) REFERENCES Consumo(id),
    FOREIGN KEY(id_producto) REFERENCES Producto(id)
);

CREATE TABLE InfoConsumo(
    id number(20) GENERATED BY DEFAULT AS IDENTITY,
    cantidad integer NOT NULL,
    id_producto number(20) NOT NULL,
    id_servicio number(20) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(id_producto) REFERENCES Producto(id),
    FOREIGN KEY(id_servicio) REFERENCES ServicioHotel(id),
    CHECK(cantidad > 0)
);

CREATE TABLE Rol(
    id number(20) GENERATED BY DEFAULT AS IDENTITY,
    nombre varchar(50) UNIQUE NOT NULL,
    PRIMARY KEY(id)
);

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

CREATE TABLE Cliente(
    numero_documento number(15) NOT NULL,
    numero_habitacion varchar2(20),
    PRIMARY KEY(numero_documento),
    FOREIGN KEY(numero_documento) REFERENCES Usuario(numero_documento),
    FOREIGN KEY(numero_habitacion) REFERENCES Habitacion(numero)
);

CREATE TABLE ReservaHabitacion(
    id number(20) GENERATED BY DEFAULT AS IDENTITY,
    fecha_entrada varchar2(20) NOT NULL,
    fecha_salida varchar2(20) NOT NULL,
    numero_personas integer NOT NULL,
    documento_cliente number(15) NOT NULL,
    id_hotel number(20) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(documento_cliente) REFERENCES Cliente(numero_documento),
    FOREIGN KEY(id_hotel) REFERENCES Hotel(id),
    CHECK(numero_personas > 0)
);

CREATE TABLE ReservaServicio(
    id number(20) GENERATED BY DEFAULT AS IDENTITY,
    fecha_entrada varchar2(50) NOT NULL,
    fecha_salida varchar2(50) NOT NULL,
    id_servicio number(20) NOT NULL,
    documento_cliente number(15) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(id_servicio) REFERENCES ServicioHotel(id),
    FOREIGN KEY(documento_cliente) REFERENCES Cliente(numero_documento)
);