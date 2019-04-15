package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelRequerimientos extends JPanel implements ActionListener{

	public static final String RFC1A = "RFC1";
	public static final String RFC2A = "RFC2";
	public static final String RFC3A = "RFC3";
	public static final String RFC4A = "RFC4";
	public static final String RFC5A = "RFC5";


	private JButton RFC1;
	private JButton RFC2;
	private JButton RFC3;
	private JButton RFC4;
	private JButton RFC5;
	/*RFC1 - MOSTRAR EL DINERO RECOLECTADO POR SERVICIOS EN CADA HABITACIÓN DURANTE UN PERIODO DE
	TIEMPO Y EN EL AÑO CORRIDO


	RFC2 - MOSTRAR LOS 20 SERVICIOS MÁS POPULARES.
	Los que fueron más consumidos en un período de tiempo dado.


	RFC3 - MOSTRAR EL ÍNDICE DE OCUPACIÓN DE CADA UNA DE LAS HABITACIONES DEL HOTEL


	RFC4 - MOSTRAR LOS SERVICIOS QUE CUMPLEN CON CIERTA CARACTERÍSTICA
	5
	Toda la información del servicio. Las características son, por ejemplo, precio en un cierto rango, fecha de
	consumo en un rango de tiempo, registrados por cierto empleado, son de cierto tipo o de cierta categoría,
	han sido consumidos más de X veces en un rango de fechas.


	RFC5 - MOSTRAR EL CONSUMO EN HOTELANDES POR UN USUARIO DADO, EN UN RANGO DE FECHAS INDICADO.
	Recuerde que un cliente puede alojarse en el hotel cuantas veces quiera.
	REQUERIMIENTOS NO FUNCIONALES
	Los requerimientos no funcionales son:*/
	public PanelRequerimientos() {
		TitledBorder bord = BorderFactory.createTitledBorder( "Requerimientos" );
		setBorder( bord );
		String a="RFC";

		RFC1= new JButton("REQ 1");
		RFC2= new JButton("REQ 2");
		RFC3= new JButton("REQ 3");
		RFC4= new JButton("REQ 4");
		RFC5= new JButton("REQ 5");

		RFC1.setActionCommand( RFC1A );
		RFC2.setActionCommand( RFC2A );
		RFC3.setActionCommand( RFC3A );
		RFC4.setActionCommand( RFC4A );
		RFC5.setActionCommand( RFC5A );

		RFC1.addActionListener( this ); 
		RFC2.addActionListener( this ); 
		RFC3.addActionListener( this ); 
		RFC4.addActionListener( this ); 
		RFC5.addActionListener( this ); 

		add(RFC1);
		add(RFC2);
		add(RFC3);
		add(RFC4);
		add(RFC5);


	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand( );

		if( comando.equals( RFC1A )) {

		}
		if( comando.equals( RFC2A )) {

		}
		if( comando.equals( RFC3A )) {

		}
		if( comando.equals( RFC4A )) {

		}
		if( comando.equals( RFC5A )) {

		}
	}
}
