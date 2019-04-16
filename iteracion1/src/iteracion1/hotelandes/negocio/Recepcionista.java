package iteracion1.hotelandes.negocio;

import java.util.ArrayList;
import java.util.List;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Recepcionista extends Usuario
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	private Hotel hotel;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */



	public Recepcionista(String tipoDocumento, long numeroDocumento, String nombre, String correo,Hotel hotel) {
		super(tipoDocumento, numeroDocumento, nombre, correo);
		this.hotel = hotel;
		// TODO Auto-generated constructor stub
	}


	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	//RF 9
	public void checkIn( ReservaHabitacion reservaHabitacion,Habitacion h) {
		h.setClientes(reservaHabitacion.getClientes());
		for (Cliente c:reservaHabitacion.getClientes()) {
			List<Consumo> consumos=new ArrayList();
			c.setConsumos(consumos);
		}
	}

	public boolean checkOut(Cliente c) throws Exception {

		boolean pazYsalvo=false;
		double totalPagar=c.getHabitacion().getCuenta();
		c.pagar(totalPagar);
		if(c.getHabitacion().getCuenta()==0) {
			pazYsalvo=true;		
			}
		else {
			throw new Exception();
		}
		return pazYsalvo;

	}
	
public void generarReservaServicio( String fechaEntrada,String fechaSalida, int horas,Servicio servicio,Cliente c) throws Exception {
		
		if(hotel.servicioDisponible(fechaEntrada, fechaSalida, servicio)==true) {
			ReservaServicio r = new ReservaServicio(fechaEntrada, fechaSalida, c, servicio);
			Consumo m=new Consumo(c.getHabitacion(), servicio.getCosto());
		}
		else {
			throw new Exception();
			}
	}



}

