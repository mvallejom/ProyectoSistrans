/* Eliminar una reserva de habitacion que ya no se va a utilizar: Habitacion 101 */
DELETE FROM ReservaHabitacion
WHERE id_convencion = 1
    AND numero_habitacion = '101';
    
/* Eliminar una reserva de un servicio que ya no se va a utilizar: Servicio de restaurante con id 1*/
DELETE FROM ReservaServicio
WHERE id = '1';

/* Eliminar todas las reservas hechas */
DELETE FROM ReservaHabitacion
WHERE id_convencion = 1;

DELETE FROM ReservaServicio
WHERE id_convencion = 1;