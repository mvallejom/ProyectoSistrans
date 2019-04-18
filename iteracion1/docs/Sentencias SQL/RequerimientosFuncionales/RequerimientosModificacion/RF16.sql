/* Se eliminan los servicios y/o habitaciones incluidas en el mantenimiento */
DELETE FROM MantenimientoServicio
WHERE id_mantenimiento = 1;

DELETE FROM MantenimientoHabitacion
WHERE id_mantenimiento = 1;

/* Se elimina el mantenimiento creado */
DELETE FROM Mantenimiento
WHERE id = 1;