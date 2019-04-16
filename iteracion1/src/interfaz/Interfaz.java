package interfaz;

import java.awt.BorderLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.UIManager;

import iteracion1.hotelandes.negocio.Habitacion;
import iteracion1.hotelandes.negocio.Hotel;
import iteracion1.hotelandes.negocio.Servicio;
import iteracion1.hotelandes.negocio.Usuario;
public class Interfaz extends JFrame implements ActionListener{

	private Hotel hotel;
	
    private PanelDatos panelDatos;
    private PanelRegistros panelRegistro;
    private PanelRequerimientos panelRequerimientos;

    
    
    public Interfaz() {
    	setTitle("Hotel Andes");
    	setSize(800, 800);
    	setResizable( true );
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	BorderLayout bord = new BorderLayout();
    	// Lo asociamos a la ventana
    	setLayout( bord );
    	
    	
    	panelDatos=new PanelDatos();
    	panelRegistro= new PanelRegistros();
    	panelRequerimientos= new PanelRequerimientos();
    	add(panelDatos, BorderLayout.NORTH);
    	add(panelRegistro,BorderLayout.SOUTH);
    	add(panelRequerimientos,BorderLayout.CENTER);

    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/*
	RF1 - REGISTRAR ROLES DE USUARIOS
	Se registran los roles de usuario definidos en la descripci�n del negocio. Esta operaci�n es realizada por
	el administrador del sistema. Debe incluir todos los roles de usuario indicados en el enunciado.
	*/
	public void registrarRolUsuarios() {
		
	}
	
	
	/*RF2 - REGISTRAR USUARIO
	Los usuarios tienen una identificaci�n (Tipo de documento, n�mero de documento), un nombre, un correo
	electr�nico y su rol respectivo. Esta operaci�n es realizada por el administrador de datos del hotel.
	Considere inicialmente un gerente, un administrador de datos, 2 recepcionistas, 4 empleados y 4 clientes.

	1 Para efectos del curso, no todos los requerimientos descritos ac� deben tener interacci�n con el usuario (interfaz gr�fica
	de usuario). Lea atentamente el enunciado de la iteraci�n para saber a cu�les se les debe desarrollar interfaz gr�fica y
	cu�les se implementan directamente sobre la base de datos utilizando SQL Developer.
	4*/
	
	public void registrarUsuario() {
		
	}
	/*RF3 - REGISTRAR TIPO DE HABITACI�N
	Registra la descripci�n de los tipos de habitaciones de los cuales dispone el hotel con su dotaci�n
	correspondiente. Esta operaci�n es realizada por el administrador de datos del hotel. Considere
	inicialmente por lo menos 3 tipos de habitaciones.
	*/
	
	public void registrarTipoHabitacion() {
		
	}
	/*RF4 - REGISTRAR HABITACI�N
	Registra las instancias de las habitaciones de las cuales dispone el hotel. Esta operaci�n es realizada por
	el administrador de datos del hotel. Considere inicialmente por lo menos 3 habitaciones de cada tipo de
	habitaci�n disponible*/
	
	public void registrarHabitacion() {
		
	}
	/*RF5 - REGISTRAR UN SERVICIO DEL HOTEL
	Registra la descripci�n de los servicios de los cuales dispone el hotel. Esta operaci�n es realizada por el
	administrador de datos del hotel. Considere inicialmente por lo menos 1 servicio de cada uno de los tipos
	de servicio descritos en el enunciado (piscina, spa, bar, � El men� de los bares y restaurantes debe tener
	por lo menos tres productos)*/
	
	public void registrarServicioDeHotel() {
		
	}
	/*RF6 - REGISTRAR UN PLAN DE CONSUMO
	Registra los planes de consumo disponibles en el hotel. Esta operaci�n es realizada por el administrador
	de datos del hotel. Considere los planes descritos en el enunciado y por lo menos uno de promoci�n
	particular.*/
	
	public void registrarPlanDeConsumo() {
		
	}
	/*RF7 - REGISTRAR UNA RESERVA DE ALOJAMIENTO
	Reserva una habitaci�n por un per�odo de tiempo, por parte de un cliente, siempre y cuando est� disponible.
	Esta operaci�n es realizada por un cliente.*/
	
	public void registrarReservaAlojamiento() {
		
	}
	/*RF8 - REGISTRAR UNA RESERVA DE UN SERVICIO DEL HOTEL POR PARTE DE UN CLIENTE
	Reserva la prestaci�n de un servicio por parte de un cliente, siempre y cuando haya disponibilidad. Esta
	operaci�n es realizada por un cliente.*/
	public void registrarReservaServicioPorCliente() {
		
	}
	/*
	RF9 - REGISTRAR LA LLEGADA DE UN CLIENTE AL HOTEL
	Registra la llegada de un cliente al hotel, correspondiente a una reserva ya registrada. Esta operaci�n es
	realizada por un recepcionista del hotel.*/
	public void RegistarLlegadaCLiente() {
		
	}
	
	/*RF10 - REGISTRAR UN CONSUMO DE UN SERVICIO DEL HOTEL POR PARTE DE UN CLIENTE O SUS ACOMPA�ANTES
	Registra un consumo de un servicio por parte de un cliente o sus acompa�antes. Esta operaci�n es
	realizada por un empleado del hotel.*/
	public void RegistrarConsumoPorCliente() {
		
	}
	
	
	/*RF11 - REGISTRAR LA SALIDA DE UN CLIENTE
	Registra la salida de un cliente al hotel, con todo lo que eso implica. Esta operaci�n es realizada por un
	recepcionista del hotel.
*/
	public void registrarSalidaCliente() {
		
	}
	
	
	
	
	/*
	RFC1 - MOSTRAR EL DINERO RECOLECTADO POR SERVICIOS EN CADA HABITACI�N DURANTE UN PERIODO DE
	TIEMPO Y EN EL A�O CORRIDO
	*/
	public double DineroRecolectadoPorHabitacionEnUnPeriodoDeTiempo(Habitacion h, Date inicio,Date fin) {
		double resp=0;
		
		return resp;
		}
	
	/*
	
	RFC2 - MOSTRAR LOS 20 SERVICIOS M�S POPULARES.
	Los que fueron m�s consumidos en un per�odo de tiempo dado.*/
	
	public ArrayList<Servicio> darServiciosMasPopulare(){
		return null;
	}
	/*
	RFC3 - MOSTRAR EL �NDICE DE OCUPACI�N DE CADA UNA DE LAS HABITACIONES DEL HOTEL*/
	public void MostrarIndiceOcupacion() {
		
	}
	
	
	/*RFC4 - MOSTRAR LOS SERVICIOS QUE CUMPLEN CON CIERTA CARACTER�STICA
	5
	Toda la informaci�n del servicio. Las caracter�sticas son, por ejemplo, precio en un cierto rango, fecha de
	consumo en un rango de tiempo, registrados por cierto empleado, son de cierto tipo o de cierta categor�a,
	han sido consumidos m�s de X veces en un rango de fechas.*/
	
	public ArrayList<Servicio> mostrarServicioConCaracteristica(String caracteristica){
		return null;
	}
	
	
	/*RFC5 - MOSTRAR EL CONSUMO EN HOTELANDES POR UN USUARIO DADO, EN UN RANGO DE FECHAS INDICADO.
	Recuerde que un cliente puede alojarse en el hotel cuantas veces quiera.
	*/
	public double darConsumoPorUsuarioEnUnTiempo(Usuario u, Date inicio,Date fin) {
		return 0;
	}
	
	
	public static void main( String[] args )
    {
        try
        {
        	
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
            Interfaz interfaz = new Interfaz( );
            interfaz.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
}
