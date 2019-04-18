/* Lista de tipos de habitacion: Habitacion doble */
SELECT *
FROM Habitacion
WHERE tipo_habitacion = 2;

/* Reserva de las habitaciones: cantidad 5. 2 sencillas y 3 dobles */

INSERT INTO ReservaHabitacion(fecha_entrada, fecha_salida, numero_personas, documento_cliente, numero_habitacion, id_convencion)
VALUES ('12/04/2019', '16/04/2019', 1, null, '101', 1);

INSERT INTO ReservaHabitacion(fecha_entrada, fecha_salida, numero_personas, documento_cliente, numero_habitacion, id_convencion)
VALUES ('12/04/2019', '16/04/2019', 1, null, '102', 1);

INSERT INTO ReservaHabitacion(fecha_entrada, fecha_salida, numero_personas, documento_cliente, numero_habitacion, id_convencion)
VALUES ('12/04/2019', '16/04/2019', 2, null, '104', 1);

INSERT INTO ReservaHabitacion(fecha_entrada, fecha_salida, numero_personas, documento_cliente, numero_habitacion, id_convencion)
VALUES ('12/04/2019', '16/04/2019', 2, null, '105', 1);

INSERT INTO ReservaHabitacion(fecha_entrada, fecha_salida, numero_personas, documento_cliente, numero_habitacion, id_convencion)
VALUES ('12/04/2019', '16/04/2019', 2, null, '106', 1);

/* Reserva de los servicios: 8 personas restaurante 13/04/2019 20:00 */

INSERT INTO ReservaServicio
VALUES (1, '13/04/2019 20:00', '13/04/2019 21:00', 8, 6, null, 1);

INSERT INTO ReservaServicio
VALUES (2, '14/04/2019 10:00', '14/04/2019 11:00', 8, 1, null, 1);

INSERT INTO ReservaServicio
VALUES (3, '15/04/2019 20:00', '15/04/2019 23:00', 8, 5, null, 1);

/* Retorna las reservas hechas por la convencion con id 1 */
SELECT *
FROM ReservaHabitacion
WHERE id_convencion = 1;

SELECT *
FROM ReservaServicio
WHERE id_convencion = 1;
