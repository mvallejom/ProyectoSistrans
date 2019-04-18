/* Salida de un cliente de la convencion */
/* Verificar que la cuenta de las habitaciones de la convencion sean 0 */
SELECT DISTINCT Habitacion.numero, Habitacion.cuenta
FROM Habitacion, Cliente
WHERE Cliente.numero_habitacion = Habitacion.numero
    AND cliente.id_convencion = 1
ORDER BY Habitacion.numero;

/* Verificar que la cuenta de la convencion sea 0 */
SELECT * FROM Convencion;

/* Dar la salida a los clientes */
SELECT * FROM Cliente WHERE id_convencion = 1;

UPDATE Cliente
SET numero_habitacion = null, id_convencion = null
WHERE numero_documento = 23806;

UPDATE Cliente
SET numero_habitacion = null, id_convencion = null
WHERE numero_documento = 78709;

UPDATE Cliente
SET numero_habitacion = null, id_convencion = null
WHERE numero_documento = 81043;

UPDATE Cliente
SET numero_habitacion = null, id_convencion = null
WHERE numero_documento = 62345;

UPDATE Cliente
SET numero_habitacion = null, id_convencion = null
WHERE numero_documento = 90924;

UPDATE Cliente
SET numero_habitacion = null, id_convencion = null
WHERE numero_documento = 55645;

UPDATE Cliente
SET numero_habitacion = null, id_convencion = null
WHERE numero_documento = 81942;

UPDATE Cliente
SET numero_habitacion = null, id_convencion = null
WHERE numero_documento = 1659;

SELECT * FROM Cliente WHERE id_convencion = 1;