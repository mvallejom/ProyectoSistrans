package interfaz;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelRegistros extends JPanel {
	
	private JButton btnRegistrarRol;
	private JButton btnRegistrarUsuario;
	private JButton btnRegistrarTipoHabitacion;
	private JButton btnRegistrarHabitacion;
	private JButton btnRegistrarServicio;
	private JButton btnRegistrarPlanConsumo;
	private JButton btnRegistrarReserva;

	
	
	
	
	/*
	RF1 - REGISTRAR ROLES DE USUARIOS
	Se registran los roles de usuario definidos en la descripción del negocio. Esta operación es realizada por
	el administrador del sistema. Debe incluir todos los roles de usuario indicados en el enunciado.
	
	
	RF2 - REGISTRAR USUARIO
	Los usuarios tienen una identificación (Tipo de documento, número de documento), un nombre, un correo
	electrónico y su rol respectivo. Esta operación es realizada por el administrador de datos del hotel.
	Considere inicialmente un gerente, un administrador de datos, 2 recepcionistas, 4 empleados y 4 clientes.

	1 Para efectos del curso, no todos los requerimientos descritos acá deben tener interacción con el usuario (interfaz gráfica
	de usuario). Lea atentamente el enunciado de la iteración para saber a cuáles se les debe desarrollar interfaz gráfica y
	cuáles se implementan directamente sobre la base de datos utilizando SQL Developer.
	4
	
	
	RF3 - REGISTRAR TIPO DE HABITACIÓN
	Registra la descripción de los tipos de habitaciones de los cuales dispone el hotel con su dotación
	correspondiente. Esta operación es realizada por el administrador de datos del hotel. Considere
	inicialmente por lo menos 3 tipos de habitaciones.
	
	
	RF4 - REGISTRAR HABITACIÓN
	Registra las instancias de las habitaciones de las cuales dispone el hotel. Esta operación es realizada por
	el administrador de datos del hotel. Considere inicialmente por lo menos 3 habitaciones de cada tipo de
	habitación disponible
	
	
	RF5 - REGISTRAR UN SERVICIO DEL HOTEL
	Registra la descripción de los servicios de los cuales dispone el hotel. Esta operación es realizada por el
	administrador de datos del hotel. Considere inicialmente por lo menos 1 servicio de cada uno de los tipos
	de servicio descritos en el enunciado (piscina, spa, bar, … El menú de los bares y restaurantes debe tener
	por lo menos tres productos)
	
	
	RF6 - REGISTRAR UN PLAN DE CONSUMO
	Registra los planes de consumo disponibles en el hotel. Esta operación es realizada por el administrador
	de datos del hotel. Considere los planes descritos en el enunciado y por lo menos uno de promoción
	particular.
	
	
	RF7 - REGISTRAR UNA RESERVA DE ALOJAMIENTO
	Reserva una habitación por un período de tiempo, por parte de un cliente, siempre y cuando esté disponible.
	Esta operación es realizada por un cliente.
*/
 public PanelRegistros() {
	 Dimension dim = new Dimension( 400, 200);
	 setPreferredSize( dim );
	 // Define el título del panel
	 TitledBorder bord = BorderFactory.createTitledBorder( "Registro" );
	 setBorder( bord );
	 
	 
	 btnRegistrarRol= new JButton("rol");
		  btnRegistrarTipoHabitacion= new JButton("tipo");
		  btnRegistrarHabitacion= new JButton("habitacion");
		  btnRegistrarServicio= new JButton("servicio");
		  btnRegistrarPlanConsumo= new JButton("plan");
		
		
	 add( btnRegistrarRol);
		add( btnRegistrarTipoHabitacion);
		add( btnRegistrarHabitacion);
		add( btnRegistrarServicio);
		add( btnRegistrarPlanConsumo);
 }}
