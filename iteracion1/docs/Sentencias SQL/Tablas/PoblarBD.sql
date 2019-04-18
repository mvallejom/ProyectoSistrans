INSERT INTO Hotel(nombre)
VALUES ('Hotel Andes');

/* TIPO DE HABITACIONES */
INSERT INTO TipoHabitacion
VALUES (1, 'Sencilla');

INSERT INTO TipoHabitacion
VALUES (2, 'Doble');

INSERT INTO TipoHabitacion
VALUES (3, 'Familiar');

/* HABITACIONES */

INSERT INTO Habitacion
VALUES ('101', 'Habitacion sencilla con television y un baño', 1, 1, 100000, 0, 1);

INSERT INTO Habitacion
VALUES ('102', 'Habitacion sencilla con television, radio y un baño', 1, 1, 150000, 0, 1);

INSERT INTO Habitacion
VALUES ('103', 'Habitacion sencilla con television, balcón y un baño', 1, 1, 160000, 0, 1);

INSERT INTO Habitacion
VALUES ('104', 'Habitacion doble con television y un baño', 2, 2, 150000, 0, 1);

INSERT INTO Habitacion
VALUES ('105', 'Habitacion doble con television, radio y un baño', 2, 2, 200000, 0, 1);

INSERT INTO Habitacion
VALUES ('106', 'Habitacion doble con television, balcón y un baño', 2, 2, 210000, 0, 1);

INSERT INTO Habitacion
VALUES ('107', 'Habitacion familiar con television y un baño', 4, 3, 200000, 0, 1);

INSERT INTO Habitacion
VALUES ('108', 'Habitacion familiar con television, radio y un baño', 4, 3, 250000, 0, 1);

INSERT INTO Habitacion
VALUES ('109', 'Habitacion familiar con television, balcón y un baño', 4, 3, 260000, 0, 1);

/* LUGARES */

INSERT INTO Lugar
VALUES (1, 'Spa');

INSERT INTO Lugar
VALUES (2, 'Piscina');

INSERT INTO Lugar
VALUES (3, 'Internet');

INSERT INTO Lugar
VALUES (4, 'Gimnasio');

INSERT INTO Lugar
VALUES (5, 'Bar');

INSERT INTO Lugar
VALUES (6, 'Restaurante');

INSERT INTO Lugar
VALUES (7, 'Supermercado');

INSERT INTO Lugar
VALUES (8, 'Tienda');

INSERT INTO Lugar
VALUES (9, 'Lavanderia');

INSERT INTO Lugar
VALUES (10, 'Prestamo');

/* SERVICIOS */

INSERT INTO ServicioHotel
VALUES (1, 'Spa Andes', '08:00', '20:00', 'Spa del hotel', 10, 10000, 1, 10, 1);

INSERT INTO ServicioHotel
VALUES (2, 'Piscina Andes', '08:00', '20:00', 'Piscina del hotel', 20, 0, 2, 15, 1);

INSERT INTO ServicioHotel
VALUES (3, 'Internet Andes', '00:00', '23:59', 'Internet del hotel', 10000, 0, 3, 3648, 1);

INSERT INTO ServicioHotel
VALUES (4, 'Gimnasio Andes', '6:00', '22:00', 'Gimnasio del hotel', 15, 20000, 4, 10, 1);

INSERT INTO ServicioHotel
VALUES (5, 'Bar Andes', '18:00', '23:00', 'Bar del hotel', 10, 0, 5, 10, 1);

INSERT INTO ServicioHotel
VALUES (6, 'Restaurante Andes', '8:00', '21:00', 'Restaurante del hotel', 10, 0, 6, 10, 1);

INSERT INTO ServicioHotel
VALUES (7, 'Supermercado Andes', '8:00', '20:00', 'Supermercado del hotel', 10, 0, 7, 10, 1);

INSERT INTO ServicioHotel
VALUES (8, 'Tienda Andes', '8:00', '20:00', 'Tienda del hotel', 10, 0, 8, 10, 1);

INSERT INTO ServicioHotel
VALUES (9, 'Lavanderia Andes', '8:00', '20:00', 'Lavanderia del hotel', 10, 25000, 9, 10, 1);

INSERT INTO ServicioHotel
VALUES (10, 'Prestamo Andes', '8:00', '20:00', 'Prestamo del hotel', 35, 0, 10, 34, 1);

/* ROLES */

INSERT INTO Rol
VALUES (1, 'Adminisitrador');

INSERT INTO Rol
VALUES (2, 'Gerente');

INSERT INTO Rol
VALUES (3, 'Recepcionista');

INSERT INTO Rol
VALUES (4, 'Empleado');

INSERT INTO Rol
VALUES (5, 'Cliente');

INSERT INTO Rol
VALUES (6, 'Organizador de Eventos');

/* USUARIOS */

INSERT INTO Usuario
VALUES ('Cédula Ciudadanía', 1234567890, 'Usuario 1', 'usuario1@correo.com', 1, 1);

INSERT INTO Usuario
VALUES ('Cédula Ciudadanía', 0987654321, 'Usuario 2', 'usuario2@correo.com', 2, 1);

INSERT INTO Usuario
VALUES ('Cédula Ciudadanía', 02468, 'Usuario 3', 'usuario3@correo.com', 3, 1);

INSERT INTO Usuario
VALUES ('Cédula Ciudadanía', 13579, 'Usuario 4', 'usuario4@correo.com', 3, 1);

INSERT INTO Usuario
VALUES ('Cédula Ciudadanía', 12356790, 'Usuario 5', 'usuario5@correo.com', 4, 1);

INSERT INTO Usuario
VALUES ('Cédula Ciudadanía', 2346780, 'Usuario 6', 'usuario6@correo.com', 4, 1);

INSERT INTO Usuario
VALUES ('Cédula Ciudadanía', 345789, 'Usuario 7', 'usuario7@correo.com', 4, 1);

INSERT INTO Usuario
VALUES ('Cédula Ciudadanía', 456890, 'Usuario 8', 'usuario8@correo.com', 4, 1);

INSERT INTO Usuario (tipo_documento, numero_documento, nombre, correo, rol, id_hotel) 
VALUES ('Cédula Ciudadanía', 23806, 'Chen Jancik', 'cjancik0@scientificamerican.com', 5, 1);

INSERT INTO Usuario (tipo_documento, numero_documento, nombre, correo, rol, id_hotel)
VALUES ('Cédula Ciudadanía', 78709, 'Stern Biscomb', 'sbiscomb1@wired.com', 5, 1);

INSERT INTO Usuario (tipo_documento, numero_documento, nombre, correo, rol, id_hotel) 
VALUES ('Cédula Ciudadanía', 81043, 'Starla Vynehall', 'svynehall2@wired.com', 5, 1);

INSERT INTO Usuario (tipo_documento, numero_documento, nombre, correo, rol, id_hotel) 
VALUES ('Cédula Ciudadanía', 62345, 'Derward Shanklin', 'dshanklin3@exblog.jp', 5, 1);

INSERT INTO Usuario (tipo_documento, numero_documento, nombre, correo, rol, id_hotel) 
VALUES ('Cédula Ciudadanía', 90924, 'Murry Hickisson', 'mhickisson4@rediff.com', 5, 1);

INSERT INTO Usuario (tipo_documento, numero_documento, nombre, correo, rol, id_hotel) 
VALUES ('Cédula Ciudadanía', 55645, 'Jammie Blase', 'jblase5@senate.gov', 5, 1);

INSERT INTO Usuario (tipo_documento, numero_documento, nombre, correo, rol, id_hotel) 
VALUES ('Cédula Ciudadanía', 81942, 'Grenville Avesque', 'gavesque6@smh.com.au', 5, 1);

INSERT INTO Usuario (tipo_documento, numero_documento, nombre, correo, rol, id_hotel) 
VALUES ('Cédula Ciudadanía', 1659, 'Edouard Derisly', 'ederisly7@php.net', 5, 1);

INSERT INTO Usuario (tipo_documento, numero_documento, nombre, correo, rol, id_hotel) 
VALUES ('Cédula Ciudadanía', 92224, 'Reider Minico', 'rminico8@va.gov', 5, 1);

INSERT INTO Usuario (tipo_documento, numero_documento, nombre, correo, rol, id_hotel) 
VALUES ('Cédula Ciudadanía', 80127, 'Jenna Reppaport', 'jreppaport9@fotki.com', 5, 1);

INSERT INTO Usuario (tipo_documento, numero_documento, nombre, correo, rol, id_hotel) 
VALUES ('Cédula Ciudadanía', 52384, 'Uta Beller', 'ubellera@amazon.de', 5, 1);

INSERT INTO Usuario (tipo_documento, numero_documento, nombre, correo, rol, id_hotel) 
VALUES ('Cédula Ciudadanía', 22051, 'Dredi Littleover', 'dlittleoverb@aboutads.info', 5, 1);

INSERT INTO Usuario (tipo_documento, numero_documento, nombre, correo, rol, id_hotel) 
VALUES ('Cédula Ciudadanía', 56354, 'Sheilah Mairs', 'smairsc@wisc.edu', 5, 1);

INSERT INTO Usuario (tipo_documento, numero_documento, nombre, correo, rol, id_hotel) 
VALUES ('Cédula Ciudadanía', 96255, 'Thorin Thorbon', 'tthorbond@princeton.edu', 5, 1);

INSERT INTO Usuario (tipo_documento, numero_documento, nombre, correo, rol, id_hotel) 
VALUES ('Cédula Ciudadanía', 20798, 'Devan Birch', 'dbirche@marriott.com', 5, 1);

INSERT INTO Usuario (tipo_documento, numero_documento, nombre, correo, rol, id_hotel) 
VALUES ('Cédula Ciudadanía', 87854, 'Cordy Dyne', 'cdynef@is.gd', 5, 1);

INSERT INTO Usuario (tipo_documento, numero_documento, nombre, correo, rol, id_hotel) 
VALUES ('Cédula Ciudadanía', 61322, 'Valida Johantges', 'vjohantgesg@noaa.gov', 5, 1);

INSERT INTO Usuario (tipo_documento, numero_documento, nombre, correo, rol, id_hotel) 
VALUES ('Cédula Ciudadanía', 16796, 'Zollie Murfill', 'zmurfillh@globo.com', 5, 1);

INSERT INTO Usuario (tipo_documento, numero_documento, nombre, correo, rol, id_hotel)
VALUES ('Cédula Ciudadanía', 43935, 'Culley Jeannel', 'cjeanneli@reverbnation.com', 5, 1);

INSERT INTO Usuario (tipo_documento, numero_documento, nombre, correo, rol, id_hotel) 
VALUES ('Cédula Ciudadanía', 38501, 'Libbey Owtram', 'lowtramj@i2i.jp', 5, 1);

INSERT INTO Usuario
VALUES ('Cédula Ciudadanía', 936593, 'Usuario 13', 'usuario13@correo.com', 6, 1);

/* PLANES DE CONSUMO */

INSERT INTO PlanConsumo
VALUES (1, 'Convencion 1', 'Descripcion 1', 1);

/* CONVENCION */

INSERT INTO Convencion
VALUES (1, 0, 1);

/* CLIENTES */

INSERT INTO Cliente
VALUES (23806, null, 1, 1, 0);

INSERT INTO Cliente
VALUES (78709, null, 1, 1, 0);

INSERT INTO Cliente
VALUES (81043, null, 1, 1, 0);

INSERT INTO Cliente
VALUES (62345, null, 1, 1, 0);

INSERT INTO Cliente
VALUES (90924, null, 1, 1, 0);

INSERT INTO Cliente
VALUES (55645, null, 1, 1, 0);

INSERT INTO Cliente
VALUES (81942, null, 1, 1, 0);

INSERT INTO Cliente
VALUES (1659, null, 1, 1, 0);

INSERT INTO Cliente
VALUES (92224, null, null, null, 0);

INSERT INTO Cliente
VALUES (80127, null, null, null, 0);

INSERT INTO Cliente
VALUES (52384, null, null, null, 0);

INSERT INTO Cliente
VALUES (22051, null, null, null, 0);

INSERT INTO Cliente
VALUES (56354, null, null, null, 0);

INSERT INTO Cliente
VALUES (96255, null, null, null, 0);

INSERT INTO Cliente
VALUES (20798, null, null, null, 0);

INSERT INTO Cliente
VALUES (87854, null, null, null, 0);

INSERT INTO Cliente
VALUES (61322, null, null, null, 0);

INSERT INTO Cliente
VALUES (16796, null, null, null, 0);

INSERT INTO Cliente
VALUES (43935, null, null, null, 0);

INSERT INTO Cliente
VALUES (38501, null, null, null, 0);