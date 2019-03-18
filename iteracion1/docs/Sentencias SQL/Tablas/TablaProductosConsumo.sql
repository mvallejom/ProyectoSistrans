CREATE TABLE ProductosConsumo(
    id_consumo number(20) NOT NULL,
    id_producto number(20) NOT NULL,
    PRIMARY KEY(id_consumo, id_producto),
    FOREIGN KEY(id_consumo) REFERENCES Consumo(id),
    FOREIGN KEY(id_producto) REFERENCES Producto(id)
);