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
	Se registran los roles de usuario definidos en la descripci�n del negocio. Esta operaci�n es realizada por
	el administrador del sistema. Debe incluir todos los roles de usuario indicados en el enunciado.
	
	
	RF2 - REGISTRAR USUARIO
	Los usuarios tienen una identificaci�n (Tipo de documento, n�mero de documento), un nombre, un correo
	electr�nico y su rol respectivo. Esta operaci�n es realizada por el administrador de datos del hotel.
	Considere inicialmente un gerente, un administrador de datos, 2 recepcionistas, 4 empleados y 4 clientes.

	1 Para efectos del curso, no todos los requerimientos descritos ac� deben tener interacci�n con el usuario (interfaz gr�fica
	de usuario). Lea atentamente el enunciado de la iteraci�n para saber a cu�les se les debe desarrollar interfaz gr�fica y
	cu�les se implementan directamente sobre la base de datos utilizando SQL Developer.
	4
	
	
	RF3 - REGISTRAR TIPO DE HABITACI�N
	Registra la descripci�n de los tipos de habitaciones de los cuales dispone el hotel con su dotaci�n
	correspondiente. Esta operaci�n es realizada por el administrador de datos del hotel. Considere
	inicialmente por lo menos 3 tipos de habitaciones.
	
	
	RF4 - REGISTRAR HABITACI�N
	Registra las instancias de las habitaciones de las cuales dispone el hotel. Esta operaci�n es realizada por
	el administrador de datos del hotel. Considere inicialmente por lo menos 3 habitaciones de cada tipo de
	habitaci�n disponible
	
	
	RF5 - REGISTRAR UN SERVICIO DEL HOTEL
	Registra la descripci�n de los servicios de los cuales dispone el hotel. Esta operaci�n es realizada por el
	administrador de datos del hotel. Considere inicialmente por lo menos 1 servicio de cada uno de los tipos
	de servicio descritos en el enunciado (piscina, spa, bar, � El men� de los bares y restaurantes debe tener
	por lo menos tres productos)
	
	
	RF6 - REGISTRAR UN PLAN DE CONSUMO
	Registra los planes de consumo disponibles en el hotel. Esta operaci�n es realizada por el administrador
	de datos del hotel. Considere los planes descritos en el enunciado y por lo menos uno de promoci�n
	particular.
	
	
	RF7 - REGISTRAR UNA RESERVA DE ALOJAMIENTO
	Reserva una habitaci�n por un per�odo de tiempo, por parte de un cliente, siempre y cuando est� disponible.
	Esta operaci�n es realizada por un cliente.
*/
 public PanelRegistros() {
	 Dimension dim = new Dimension( 400, 200);
	 setPreferredSize( dim );
	 // Define el t�tulo del panel
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
