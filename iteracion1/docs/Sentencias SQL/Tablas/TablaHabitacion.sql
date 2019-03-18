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