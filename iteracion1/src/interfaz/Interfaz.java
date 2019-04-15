package interfaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import iteracion1.hotelandes.negocio.Hotel;
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

	
	/*HOTELANDES debe satisfacer los siguientes requerimientos a sus usuarios1
	:
		
	
	RF8 - REGISTRAR UNA RESERVA DE UN SERVICIO DEL HOTEL POR PARTE DE UN CLIENTE
	Reserva la prestación de un servicio por parte de un cliente, siempre y cuando haya disponibilidad. Esta
	operación es realizada por un cliente.
	
	
	RF9 - REGISTRAR LA LLEGADA DE UN CLIENTE AL HOTEL
	Registra la llegada de un cliente al hotel, correspondiente a una reserva ya registrada. Esta operación es
	realizada por un recepcionista del hotel.
	
	
	RF10 - REGISTRAR UN CONSUMO DE UN SERVICIO DEL HOTEL POR PARTE DE UN CLIENTE O SUS ACOMPAÑANTES
	Registra un consumo de un servicio por parte de un cliente o sus acompañantes. Esta operación es
	realizada por un empleado del hotel.
	
	
	RF11 - REGISTRAR LA SALIDA DE UN CLIENTE
	Registra la salida de un cliente al hotel, con todo lo que eso implica. Esta operación es realizada por un
	recepcionista del hotel.
	REQUERIMIENTOS FUNCIONALES DE CONSULTA
	Mostrar estadísticas de uso de los recursos de HOTELANDES, entre las que se encuentran:
	
	
	
	
	RNF1 - PRIVACIDAD
	Los usuarios de HOTELANDES solo pueden manipular y consultar la información que les es propia o a que tengan
	derecho en función de la definición de roles de usuario dada
	
	
	RNF2 - PERSISTENCIA
	La información manipulada por la aplicación debe ser persistente. Recuerde que la información que se requiere
	para resolver un requerimiento funcional puede no caber simultáneamente en memoria principal.
	
	
	RNF3 - CONCURRENCIA
	Los requerimientos pueden ser solicitados de manera concurrente.
	
	
	RNF4 - DISTRIBUCIÓN
	La base de datos de la aplicación está centralizada. 
	
	
	*/
	
	
	
	
	
	
	
	
	
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
